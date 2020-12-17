package uestc.zhangkx.loadbalance.loadbalancer;


import uestc.zhangkx.loadbalance.AbstractLoadBalance;

import java.util.List;
import java.util.Random;

/**
 * 随机
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:43
 */
public class RandomLoadBalance extends AbstractLoadBalance {
    @Override
    protected String doSelect(List<String> serviceAddresses, String rpcServiceName) {
        Random random = new Random();
        return serviceAddresses.get(random.nextInt(serviceAddresses.size()));
    }
}
