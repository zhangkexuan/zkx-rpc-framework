package uestc.zhangkx.rpc.client;
import uestc.zhangkx.rpc.common.Calculator;
import java.util.Random;

public class ClientTest {

    // 应用层
    public static void main(String[] args) throws Exception {
        RPCBeanFactory<Calculator> factory = new RPCBeanFactory<Calculator>("localhost", 8921, Calculator.class);

        Calculator cal = factory.getObject();

        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                Random random = new Random(System.currentTimeMillis());
                int a = random.nextInt(20);
                int b = random.nextInt(20);

                // 直接像调用本地方法一样调用远程方法
                System.out.println("" + a + " + " + b + " = " + cal.add(a, b));

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        };

        // 开启多线程调用试试
        for (int i = 0; i < 5; i++) new Thread(r).start();
    }
}
