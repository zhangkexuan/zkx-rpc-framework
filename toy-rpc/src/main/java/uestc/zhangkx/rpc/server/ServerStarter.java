package uestc.zhangkx.rpc.server;

import uestc.zhangkx.rpc.common.Calculator;

public class ServerStarter {

    public static void main(String[] args) throws Exception {
        RPCServer server = new RPCServer();

        // 注册解析bean
        server.registerBean(Calculator.class.getName(), CalculatorImpl.class);

        // 启动服务器
        server.start();
    }
}
