package uestc.zhangkx.compress;


import uestc.zhangkx.extension.SPI;

/**
 * 压缩接口
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:45
 */
@SPI
public interface Compress {

    byte[] compress(byte[] bytes);


    byte[] decompress(byte[] bytes);
}
