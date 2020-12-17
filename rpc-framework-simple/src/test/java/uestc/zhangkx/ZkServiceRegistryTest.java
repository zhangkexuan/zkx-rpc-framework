package uestc.zhangkx;


import org.junit.jupiter.api.Test;
import uestc.zhangkx.extension.ExtensionLoader;
import uestc.zhangkx.registry.ServiceDiscovery;
import uestc.zhangkx.registry.ServiceRegistry;
import uestc.zhangkx.registry.zk.ZkServiceDiscovery;
import uestc.zhangkx.registry.zk.ZkServiceRegistry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Enumeration;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author shuang.kou
 * @createTime 2020年05月31日 16:25:00
 */
class ZkServiceRegistryTest {

    @Test
    void should_register_service_successful_and_lookup_service_by_service_name() {
        ServiceRegistry zkServiceRegistry = new ZkServiceRegistry();
        InetSocketAddress givenInetSocketAddress = new InetSocketAddress("192.168.0.253", 9333);
        zkServiceRegistry.registerService("github.javaguide.registry.zk.ZkServiceRegistry", givenInetSocketAddress);
        ServiceDiscovery zkServiceDiscovery = new ZkServiceDiscovery();
        InetSocketAddress acquiredInetSocketAddress = zkServiceDiscovery.lookupService("uestc.zhangkx.registry.zk.ZkServiceRegistry");
        assertEquals(givenInetSocketAddress.toString(), acquiredInetSocketAddress.toString());
    }
    @Test
    void tt(){
        String fileName = "META-INF/extensions/uestc.zhangkx.registry.ServiceRegistry";
        /*try {
            Enumeration<URL> urls;
            ClassLoader classLoader = ExtensionLoader.class.getClassLoader();
            urls = classLoader.getResources(fileName);
            if (urls != null) {
                while (urls.hasMoreElements()) {
                    URL resourceUrl = urls.nextElement();
                    System.out.println(resourceUrl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            int b;
            try {
                while((b= fileInputStream.read())!=-1){
                    System.out.println((char) b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
