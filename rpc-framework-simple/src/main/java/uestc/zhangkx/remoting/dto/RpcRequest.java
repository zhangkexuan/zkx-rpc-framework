package uestc.zhangkx.remoting.dto;

import lombok.*;
import uestc.zhangkx.entity.RpcServiceProperties;

import java.io.Serializable;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class RpcRequest implements Serializable {
    private static final long serialVersionUID = 1905122041950251207L;
    private String requestId;
    private String interfaceName;
    private String methodName;
    private Object[] parameters;
    private Class<?>[] paramTypes;
    private String version;
    private String group;

    public RpcServiceProperties toRpcProperties() {
        return RpcServiceProperties.builder().serviceName(this.getInterfaceName())
                .version(this.getVersion())
                .group(this.getGroup()).build();
    }
}
