// 在common中
package uestc.zhangkx.rpc.common;

/**
 * 定义客户端和服务器端都通用的计算器类
 */
public interface Calculator {
    /**
     * 这里只定义一个简单的int的加法
     *
     * @param a
     * @param b
     * @return
     */
    int add(int a, int b);
}

