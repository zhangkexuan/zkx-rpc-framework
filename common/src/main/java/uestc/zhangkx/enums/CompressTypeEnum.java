package uestc.zhangkx.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

/**
 * 压缩类型
 *
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 16:00
 */
@Getter
@AllArgsConstructor
public enum CompressTypeEnum {

    /**
     * 通过GZIP进行压缩
     */
    GZIP((byte) 0x01, "gzip");

    private final byte code;
    private final String name;

    /**
     * 通过code得到名字
     * @param code
     * @return name
     */
    public static @Nullable String getName(byte code){
        CompressTypeEnum[] values = CompressTypeEnum.values();
        for (CompressTypeEnum value : values) {
            if (value.getCode() == code){
                return value.name;
            }
        }
        return null;
    }
}
