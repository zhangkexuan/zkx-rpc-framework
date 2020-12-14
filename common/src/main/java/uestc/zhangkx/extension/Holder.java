package uestc.zhangkx.extension;

/**
 * 扩展Holder
 *
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 16:20
 */
public class Holder<T> {

    private volatile T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}
