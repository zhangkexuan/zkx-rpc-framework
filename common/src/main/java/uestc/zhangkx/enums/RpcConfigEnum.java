package uestc.zhangkx.enums;
/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:24
 */
public enum RpcConfigEnum {

    RPC_CONFIG_PATH("rpc.properties"),
    ZK_ADDRESS("rpc.zookeeper.address");

    private final String propertyValue;


    RpcConfigEnum(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

}
