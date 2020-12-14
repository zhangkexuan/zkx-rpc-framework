package uestc.zhangkx.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Rpc的各项配置
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 15:55
 */
@Getter
@AllArgsConstructor
public enum RpcConfigEnum {

    /**
     * rpc配置位置
     */
    PRC_CONFIG_PATH("rpc.properties"),
    /**
     * ZK配置地址
     */
    ZK_ADDRESS("rpc.zookeeper.address");

    private final String propertyValue;
}
