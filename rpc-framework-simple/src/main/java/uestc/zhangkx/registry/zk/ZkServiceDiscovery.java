package uestc.zhangkx.registry.zk;


import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import uestc.zhangkx.enums.RpcErrorMessageEnum;
import uestc.zhangkx.exception.RpcException;
import uestc.zhangkx.extension.ExtensionLoader;
import uestc.zhangkx.loadbalance.LoadBalance;
import uestc.zhangkx.registry.ServiceDiscovery;
import uestc.zhangkx.registry.zk.util.CuratorUtils;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * zk发现
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@Slf4j
public class ZkServiceDiscovery implements ServiceDiscovery {
    private final LoadBalance loadBalance;

    public ZkServiceDiscovery() {
        this.loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("loadBalance");
    }

    @Override
    public InetSocketAddress lookupService(String rpcServiceName) {
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient, rpcServiceName);
        if (serviceUrlList == null || serviceUrlList.size() == 0) {
            throw new RpcException(RpcErrorMessageEnum.SERVICE_CAN_NOT_BE_FOUND, rpcServiceName);
        }
        // load balancing
        String targetServiceUrl = loadBalance.selectServiceAddress(serviceUrlList, rpcServiceName);
        log.info("Successfully found the service address:[{}]", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, port);
    }
}
