package uestc.zhangkx.rpc.server;

import uestc.zhangkx.rpc.common.RPCMessage;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RPCServer {
    /**
     * 定义服务器端监听的地址和端口
     */
    private int port = 8921;

    /**
     * 定义被注册进来的处理消息的bean
     * key=bean-name  value=bean-object
     * bean就是接口的Impl具体实现
     */
    private Map<String, Object> register_unseril_classes = new HashMap<>();

    public RPCServer() {
    }

    public RPCServer(int port) {
        this.port = port;
    }

    /**
     * 服务器协议层，负责请求接收、序列化和反序列化等
     */
    public void start() throws Exception {
        ServerSocket server = new ServerSocket(port);
        while (true) {
            System.out.println("waiting for message...");
            Socket socket = server.accept(); // 监听等待消息
            try {
                InputStream inputStream = socket.getInputStream(); // 获取到消息后取得输入流
                RPCMessage message = RPCMessage.getMessage(inputStream); // 消息发送使用Java的序列化方法

                if (!register_unseril_classes.containsKey(message.getClassName())) {
                    System.out.println("未知对象：message.getClassName()");
                    throw new Exception("未知对象：message.getClassName()");
                }

                // 利用反射机制来实现方法调用
                RPCMessage response = processMessage(message);

                // 将返回结果写回
                new ObjectOutputStream(socket.getOutputStream()).writeObject(response);
            } catch (Exception e) {
                e.printStackTrace();
                RPCMessage response = new RPCMessage();
                response.setValue("error:" + e.getMessage());
                new ObjectOutputStream(socket.getOutputStream()).writeObject(response);
            }
        }
    }

    /**
     * 服务器转发层，负责寻找处理器并执行具体的业务实现
     */
    private RPCMessage processMessage(RPCMessage message) throws Exception {
        // 利用反射机制来实现方法调用
        Object bean = register_unseril_classes.get(message.getClassName());
        Method method = bean.getClass().getMethod(message.getMethodName(), message.getParamTypes());
        RPCMessage response = new RPCMessage();
        response.setClassName(message.getClassName());
        response.setValue(method.invoke(bean, message.getParamValues()));

        return response;
    }

    /**
     * 注册bean
     *
     * @param beanName
     * @param clazz
     */
    public void registerBean(String beanName, Class<?> clazz) {
        if (beanName == null || clazz == null) return;
        try {
            if (register_unseril_classes.containsKey(beanName)) throw new Exception("bean name existed");
            register_unseril_classes.put(beanName, clazz.getConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
