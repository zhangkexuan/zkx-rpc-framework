package uestc.zhangkx.loadbalance;

import java.util.List;

/**
 * 负载均衡抽象类
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:43
 */
public abstract class AbstractLoadBalance implements LoadBalance {
    @Override
    public String selectServiceAddress(List<String> serviceAddresses, String rpcServiceName) {
        if (serviceAddresses == null || serviceAddresses.size() == 0) {
            return null;
        }
        if (serviceAddresses.size() == 1) {
            return serviceAddresses.get(0);
        }
        return doSelect(serviceAddresses, rpcServiceName);
    }

    protected abstract String doSelect(List<String> serviceAddresses, String rpcServiceName);

}
