package uestc.zhangkx.registry;



import uestc.zhangkx.extension.SPI;

import java.net.InetSocketAddress;

/**
 * zk注册
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@SPI
public interface ServiceRegistry {
    /**
     * register service
     *
     * @param rpcServiceName    rpc service name
     * @param inetSocketAddress service address
     */
    void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress);

}
