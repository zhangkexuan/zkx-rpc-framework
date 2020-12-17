package uestc.zhangkx.remoting.transport.socket;

import lombok.extern.slf4j.Slf4j;
import uestc.zhangkx.config.CustomShutdownHook;
import uestc.zhangkx.entity.RpcServiceProperties;
import uestc.zhangkx.factory.SingletonFactory;
import uestc.zhangkx.provider.ServiceProvider;
import uestc.zhangkx.provider.ServiceProviderImpl;
import uestc.zhangkx.utils.concurrent.threadpool.ThreadPoolFactoryUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

import static uestc.zhangkx.remoting.transport.netty.server.NettyRpcServer.PORT;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@Slf4j
public class SocketRpcServer {

    private final ExecutorService threadPool;
    private final ServiceProvider serviceProvider;


    public SocketRpcServer() {
        threadPool = ThreadPoolFactoryUtils.createCustomThreadPoolIfAbsent("socket-server-rpc-pool");
        serviceProvider = SingletonFactory.getInstance(ServiceProviderImpl.class);
    }

    public void registerService(Object service) {
        serviceProvider.publishService(service);
    }

    public void registerService(Object service, RpcServiceProperties rpcServiceProperties) {
        serviceProvider.publishService(service, rpcServiceProperties);
    }

    public void start() {
        try (ServerSocket server = new ServerSocket()) {
            String host = InetAddress.getLocalHost().getHostAddress();
            server.bind(new InetSocketAddress(host, PORT));
            CustomShutdownHook.getCustomShutdownHook().clearAll();
            Socket socket;
            while ((socket = server.accept()) != null) {
                log.info("client connected [{}]", socket.getInetAddress());
                threadPool.execute(new SocketRpcRequestHandlerRunnable(socket));
            }
            threadPool.shutdown();
        } catch (IOException e) {
            log.error("occur IOException:", e);
        }
    }

}
