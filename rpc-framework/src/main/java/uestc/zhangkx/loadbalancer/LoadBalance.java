package uestc.zhangkx.loadbalancer;

import java.util.List;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 22:43
 */
public interface LoadBalance {

    /**
     * 从现有服务地址列表中选择一个
     * @param serviceAddresses –服务地址列表
     * @param rpcServiceName -rpc提供的服务名
     * @return 目标服务地址
     */
    String selectServiceAddress(List<String> serviceAddresses,String rpcServiceName);
}
