package uestc.zhangkx.rpc.client;

import uestc.zhangkx.rpc.common.RPCMessage;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 协议层
 */
public class ClientProtocol {
    private String host = "localhost";
    private int port = 8921;

    public ClientProtocol(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 与server建立连接，发送和接收数据
     *
     * @return
     */
    public RPCMessage call(RPCMessage message) throws Exception {
        Socket socket = new Socket(host, port);

        // 向server发送请求
        new ObjectOutputStream(socket.getOutputStream()).writeObject(message);
        socket.shutdownOutput();

        // 获取server的回复
        RPCMessage response = RPCMessage.getMessage(socket.getInputStream());
        socket.close();
        // System.out.println("client socket closed");
        return response;
    }
}
