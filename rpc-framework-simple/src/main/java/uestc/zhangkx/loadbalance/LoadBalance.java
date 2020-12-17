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
     * @param serviceAddresses 服务列表
     * @param rpcServiceName rpc服务名
     * @return 目标服务地址
     */
    String selectServiceAddress(List<String> serviceAddresses, String rpcServiceName);
}
