package uestc.zhangkx.config;

import lombok.extern.slf4j.Slf4j;
import uestc.zhangkx.registry.zk.util.CuratorUtils;
import uestc.zhangkx.remoting.transport.netty.server.NettyRpcServer;
import uestc.zhangkx.utils.concurrent.threadpool.ThreadPoolFactoryUtils;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 服务器关闭后资源注销的钩子函数
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:43
 */
@Slf4j
public class CustomShutdownHook {
    private static final CustomShutdownHook CUSTOM_SHUTDOWN_HOOK = new CustomShutdownHook();

    public static CustomShutdownHook getCustomShutdownHook() {
        return CUSTOM_SHUTDOWN_HOOK;
    }

    public void clearAll() {
        log.info("addShutdownHook for clearAll");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), NettyRpcServer.PORT);
                CuratorUtils.clearRegistry(CuratorUtils.getZkClient(), inetSocketAddress);
            } catch (UnknownHostException ignored) {
            }
            ThreadPoolFactoryUtils.shutDownAllThreadPool();
        }));
    }
}
