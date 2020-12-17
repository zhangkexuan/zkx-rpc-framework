package uestc.zhangkx.entity;

import lombok.*;

/**
 * RPC服务的实体
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:21
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RpcServiceProperties {

    //版本、分组、名字共同得到key
    private String version;
    private String group;
    private String serviceName;

    public String toRpcServiceName() {
        return this.getServiceName() + this.getGroup() + this.getVersion();
    }
}