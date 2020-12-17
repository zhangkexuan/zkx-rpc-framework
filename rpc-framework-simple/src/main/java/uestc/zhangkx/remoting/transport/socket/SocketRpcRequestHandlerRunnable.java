package uestc.zhangkx.remoting.transport.socket;

import lombok.extern.slf4j.Slf4j;
import uestc.zhangkx.factory.SingletonFactory;
import uestc.zhangkx.handler.RpcRequestHandler;
import uestc.zhangkx.remoting.dto.RpcRequest;
import uestc.zhangkx.remoting.dto.RpcResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@Slf4j
public class SocketRpcRequestHandlerRunnable implements Runnable {
    private final Socket socket;
    private final RpcRequestHandler rpcRequestHandler;


    public SocketRpcRequestHandlerRunnable(Socket socket) {
        this.socket = socket;
        this.rpcRequestHandler = SingletonFactory.getInstance(RpcRequestHandler.class);
    }

    @Override
    public void run() {
        log.info("server handle message from client by thread: [{}]", Thread.currentThread().getName());
        try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            Object result = rpcRequestHandler.handle(rpcRequest);
            objectOutputStream.writeObject(RpcResponse.success(result, rpcRequest.getRequestId()));
            objectOutputStream.flush();
        } catch (IOException | ClassNotFoundException e) {
            log.error("occur exception:", e);
        }
    }

}
