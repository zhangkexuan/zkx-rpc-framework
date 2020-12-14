package uestc.zhangkx.utils;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 19:18
 */
public class RuntimeUtil {
    /**
     * 获取CPU的核心数
     * @return cpu的核心数
     */
    public static int cpus() {
        return Runtime.getRuntime().availableProcessors();
    }
}
