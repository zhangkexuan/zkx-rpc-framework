package uestc.zhangkx.loadbalance.loadbalancer;

import uestc.zhangkx.loadbalance.AbstractLoadBalance;

import java.util.List;

/**
 * 轮询
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/18 15:52
 */
public class PollingLoadBalance extends AbstractLoadBalance {

    static int count;
    public PollingLoadBalance() {
        count++;
    }

    @Override
    protected String doSelect(List<String> serviceAddresses, String rpcServiceName) {
        return serviceAddresses.get(count%(serviceAddresses.size()));
    }
}
