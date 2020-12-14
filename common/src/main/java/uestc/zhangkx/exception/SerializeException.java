package uestc.zhangkx.exception;

/**
 * 序列化异常
 *
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 16:20
 */
public class SerializeException extends RuntimeException {
    public SerializeException(String message) {
        super(message);
    }
}
