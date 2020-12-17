package uestc.zhangkx.registry;


import uestc.zhangkx.extension.SPI;

import java.net.InetSocketAddress;

/**
 * zk发现
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@SPI
public interface ServiceDiscovery {
    /**
     * lookup service by rpcServiceName
     *
     * @param rpcServiceName rpc service name
     * @return service address
     */
    InetSocketAddress lookupService(String rpcServiceName);
}
