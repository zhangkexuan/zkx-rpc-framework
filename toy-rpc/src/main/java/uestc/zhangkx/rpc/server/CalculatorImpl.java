package uestc.zhangkx.rpc.server;


import uestc.zhangkx.rpc.common.Calculator;

/**
 * server实现层
 * 在server端定义计算器的具体实现
 */
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}

