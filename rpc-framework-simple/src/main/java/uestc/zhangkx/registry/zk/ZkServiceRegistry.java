package uestc.zhangkx.registry.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import uestc.zhangkx.registry.ServiceRegistry;
import uestc.zhangkx.registry.zk.util.CuratorUtils;

import java.net.InetSocketAddress;

/**
 * zk注册
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@Slf4j
public class ZkServiceRegistry implements ServiceRegistry {

    @Override
    public void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress) {
        String servicePath = CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + rpcServiceName + inetSocketAddress.toString();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        CuratorUtils.createPersistentNode(zkClient, servicePath);
    }
}
