package uestc.zhangkx.remoting.transport.socket;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uestc.zhangkx.entity.RpcServiceProperties;
import uestc.zhangkx.exception.RpcException;
import uestc.zhangkx.extension.ExtensionLoader;
import uestc.zhangkx.registry.ServiceDiscovery;
import uestc.zhangkx.remoting.dto.RpcRequest;
import uestc.zhangkx.remoting.transport.RpcRequestTransport;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@AllArgsConstructor
@Slf4j
public class SocketRpcClient implements RpcRequestTransport {
    private final ServiceDiscovery serviceDiscovery;

    public SocketRpcClient() {
        this.serviceDiscovery = ExtensionLoader.getExtensionLoader(ServiceDiscovery.class).getExtension("zk");
    }

    @Override
    public Object sendRpcRequest(RpcRequest rpcRequest) {
        // build rpc service name by rpcRequest
        String rpcServiceName = RpcServiceProperties.builder().serviceName(rpcRequest.getInterfaceName())
                .group(rpcRequest.getGroup()).version(rpcRequest.getVersion()).build().toRpcServiceName();
        InetSocketAddress inetSocketAddress = serviceDiscovery.lookupService(rpcServiceName);
        try (Socket socket = new Socket()) {
            socket.connect(inetSocketAddress);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            // Send data to the server through the output stream
            objectOutputStream.writeObject(rpcRequest);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            // Read RpcResponse from the input stream
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RpcException("调用服务失败:", e);
        }
    }
}
