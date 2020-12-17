
import uestc.zhangkx.entity.RpcServiceProperties;
import uestc.zhangkx.proxy.RpcClientProxy;
import uestc.zhangkx.remoting.transport.RpcRequestTransport;
import uestc.zhangkx.remoting.transport.socket.SocketRpcClient;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 18:13
 */
public class SocketClientMain {
    public static void main(String[] args) {
        RpcRequestTransport rpcRequestTransport = new SocketRpcClient();
        RpcServiceProperties rpcServiceProperties = RpcServiceProperties.builder()
                .group("test2").version("version2").build();
        RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcRequestTransport, rpcServiceProperties);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        String hello = helloService.hello(new Hello("111", "222"));
        System.out.println(hello);
    }
}
