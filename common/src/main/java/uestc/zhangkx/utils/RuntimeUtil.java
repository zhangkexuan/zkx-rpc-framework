package uestc.zhangkx.utils;

/**
 * 运行时工具类
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:32
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
