package uestc.zhangkx.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:24
 */
@AllArgsConstructor
@Getter
@ToString
public enum RpcResponseCodeEnum {

    SUCCESS(200, "The remote call is successful"),
    FAIL(500, "The remote call is fail");
    private final int code;

    private final String message;

}
