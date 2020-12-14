package uestc.zhangkx.entity;

import lombok.*;

/**
 * TODO:根据名字应该是服务器端的pojo？？？？
 *
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 15:48
 */
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RpcServiceProperties {

    /**
     * service的版本
     */
    private String version;

    /**
     * 当接口具有多个实现类时，按组区分
     */
    private String group;

    /**
     * service的名字
     */
    private String serviceName;

    public String toRpcServiceName(){
        return this.getServiceName() + this.getGroup() + this.getVersion();
    }


}
