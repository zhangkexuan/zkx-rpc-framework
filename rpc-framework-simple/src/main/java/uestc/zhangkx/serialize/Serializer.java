package uestc.zhangkx.serialize;


import uestc.zhangkx.extension.SPI;

/**
 * 序列化接口——字节数组与对象实体
 * TODO:现在利用对象池（Object Pooling）技术，对序列化/反序列化类进行池化处理
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:54
 */
@SPI
public interface Serializer {

    /**
     * 序列化
     *
     * @param obj 要序列化的对象
     * @return 字节数组
     */
    byte[] serialize(Object obj);

    /**
     * 反序列化
     *
     * @param bytes 序列化后的字节数组
     * @param clazz 目标类
     * @param <T>   类的类型。
     * @return 反序列化的对象
     */
    <T> T deserialize(byte[] bytes, Class<T> clazz);
}
