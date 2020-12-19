package uestc.zhangkx.loadbalance.loadbalancer;

import org.junit.jupiter.api.Test;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/18 15:44
 */
class BalanceTest {

    @Test
    void testRR(){
        for (int i = 0; i < 10; i++) {
            new NomalClass();
            System.gc();
        }
        NomalClass nomalClass = new NomalClass();
        System.out.println(nomalClass.count);
    }


}
class NomalClass{
    static int count = 0;

    public NomalClass() {
        count++;
    }
}