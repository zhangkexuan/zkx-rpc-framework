package uestc.zhangkx.exception;

import uestc.zhangkx.enums.RpcErrorMessageEnum;

/**
 * Rpc的异常信息
 *
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 16:15
 */
public class RpcException extends RuntimeException {
    public RpcException(RpcErrorMessageEnum rpcErrorMessageEnum, String detail) {
        super(rpcErrorMessageEnum.getMessage() + ":" + detail);
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcException(RpcErrorMessageEnum rpcErrorMessageEnum) {
        super(rpcErrorMessageEnum.getMessage());
    }
}
