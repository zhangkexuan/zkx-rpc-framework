package uestc.zhangkx.rpc.client;

import uestc.zhangkx.rpc.common.RPCMessage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 调用层，在该层中调用对象
 * 代理动态对象
 */
public class RPCBeanFactory<T> implements InvocationHandler {
    /**
     * 定义服务器端监听的地址和端口
     */
    private String host = "localhost";
    private int port = 8921;
    private ClientProtocol protocol;
    private T object;
    private Class<T> clazz;

    public RPCBeanFactory(String host, int port, Class<T> interfaceClass) {
        this.host = host;
        this.port = port;
        this.protocol = new ClientProtocol(host, port);
        this.clazz = interfaceClass;
        this.object = (T) Proxy.newProxyInstance(RPCBeanFactory.class.getClassLoader(), new Class[]{interfaceClass}, this);
    }

    /**
     * 负责使用JDK动态代理来生成对象
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 序列化数据并通过协议层调用
        RPCMessage message = new RPCMessage();
        message.setClassName(this.clazz.getName());
        message.setMethodName(method.getName());
        message.setParamTypes(method.getParameterTypes());
        message.setParamValues(args);

        RPCMessage response = protocol.call(message);
        return response.getValue();
    }

    /**
     * 获取可被调用的对象
     *
     * @return
     * @throws Exception
     */
    public T getObject() throws Exception {
        return this.object;
    }
}
