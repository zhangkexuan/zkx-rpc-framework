import uestc.zhangkx.entity.RpcServiceProperties;
import uestc.zhangkx.remoting.transport.socket.SocketRpcServer;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 18:13
 */
public class SocketServerMain {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        SocketRpcServer socketRpcServer = new SocketRpcServer();
        RpcServiceProperties rpcServiceProperties = RpcServiceProperties.builder()
                .group("test2").version("version2").build();
        socketRpcServer.registerService(helloService, rpcServiceProperties);
        socketRpcServer.start();
    }
}
