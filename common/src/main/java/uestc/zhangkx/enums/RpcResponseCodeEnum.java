package uestc.zhangkx.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * RPC响应
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 16:11
 */
@AllArgsConstructor
@Getter
@ToString
public enum RpcResponseCodeEnum {

    /**
     * 响应成功
     */
    SUCCESS(200, "The remote call is successful"),
    /**
     * 响应失败
     */
    FAIL(500, "The remote call is fail");

    private final int code;
    private final String message;

}
