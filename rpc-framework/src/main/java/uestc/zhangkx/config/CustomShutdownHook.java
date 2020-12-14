package uestc.zhangkx.config;

import lombok.extern.slf4j.Slf4j;
import uestc.zhangkx.utils.concurrent.threadpool.ThreadPoolFactoryUtils;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 关闭服务器后，注销所有的服务;
 * 主要是关闭线程池、清理zk中注册的数据
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 22:23
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
