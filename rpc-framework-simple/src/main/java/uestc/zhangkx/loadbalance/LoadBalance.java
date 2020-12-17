package uestc.zhangkx.loadbalance;


import uestc.zhangkx.extension.SPI;

import java.util.List;

/**
 * 负载均衡接口
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:43
 */
@SPI
public interface LoadBalance {
    /**
     * Choose one from the list of existing service addresses list
     *
     * @param serviceAddresses Service address list
     * @return target service address
     */
    String selectServiceAddress(List<String> serviceAddresses, String rpcServiceName);
}
