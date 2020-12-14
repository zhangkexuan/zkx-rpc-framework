package uestc.zhangkx.compress;

import uestc.zhangkx.extension.SPI;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 20:40
 */
@SPI
public interface Compress {

    /**
     * 压缩
     * @param bytes
     * @return
     */
    byte[] compress(byte[] bytes);

    /**
     * 解压
     * @param bytes
     * @return
     */
    byte[] decompress(byte[] bytes);
}
