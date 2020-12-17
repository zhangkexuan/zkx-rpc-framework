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
public enum SerializationTypeEnum {

    KYRO((byte) 0x01, "kyro"),
    PROTOSTUFF((byte) 0x02, "protostuff");;

    private final byte code;
    private final String name;

    public static String getName(byte code) {
        for (SerializationTypeEnum c : SerializationTypeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}
