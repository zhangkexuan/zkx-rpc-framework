package uestc.zhangkx.provider;

import uestc.zhangkx.entity.RpcServiceProperties;

/**
 * 本地注册与发布
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/16 16:02
 */
public interface ServiceProvider {
    void addService(Object service, Class<?> serviceClass, RpcServiceProperties rpcServiceProperties);

    Object getService(RpcServiceProperties rpcServiceProperties);

    void publishService(Object service, RpcServiceProperties rpcServiceProperties);

    void publishService(Object service);
}
