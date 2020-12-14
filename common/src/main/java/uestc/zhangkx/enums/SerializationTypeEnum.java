package uestc.zhangkx.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

/**
 * 序列化列表
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 16:13
 */
@AllArgsConstructor
@Getter
public enum SerializationTypeEnum {

    /**
     * Kyro的序列方式
     */
    KYRO((byte) 0x01, "kyro"),
    /**
     * protostuff的序列方式
     */
    PROTOSTUFF((byte) 0x02, "protostuff");;

    private final byte code;
    private final String name;

    /**
     * 通过code得到name
     * @param code
     * @return name
     */
    public static @Nullable String getName(byte code) {
        for (SerializationTypeEnum c : SerializationTypeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}
