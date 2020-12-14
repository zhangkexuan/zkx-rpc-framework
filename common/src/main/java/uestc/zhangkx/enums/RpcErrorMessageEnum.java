package uestc.zhangkx.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * RPC错误码
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 16:09
 */
@Getter
@ToString
@AllArgsConstructor
public enum RpcErrorMessageEnum {

    /**
     * 客户端连接服务端失败
     */
    CLIENT_CONNECT_SERVER_FAILURE("客户端连接服务端失败"),
    /**
     * 服务调用失败
     */
    SERVICE_INVOCATION_FAILURE("服务调用失败"),
    /**
     * 没有找到指定的服务
     */
    SERVICE_CAN_NOT_BE_FOUND("没有找到指定的服务"),
    /**
     * 注册的服务没有实现任何接口
     */
    SERVICE_NOT_IMPLEMENT_ANY_INTERFACE("注册的服务没有实现任何接口"),
    /**
     * 返回结果错误！请求和返回的相应不匹配
     */
    REQUEST_NOT_MATCH_RESPONSE("返回结果错误！请求和返回的相应不匹配");

    private final String message;
}
