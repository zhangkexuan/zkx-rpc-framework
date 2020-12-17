package uestc.zhangkx.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:24
 */
@AllArgsConstructor
@Getter
public enum CompressTypeEnum {

    GZIP((byte) 0x01, "gzip");

    private final byte code;
    private final String name;

    public static String getName(byte code) {
        for (CompressTypeEnum c : CompressTypeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}
