package uestc.zhangkx;

import org.junit.jupiter.api.Test;
import uestc.zhangkx.extension.ExtensionLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 15:38
 */
public class test {
    @Test
    void tt(){
        String fileName = "META-INF/extensions/uestc.zhangkx.registry.ServiceRegistry";
        try {
            Enumeration<URL> urls;
            ClassLoader classLoader = ExtensionLoader.class.getClassLoader();
            System.out.println(classLoader);
            urls = classLoader.getResources(fileName);
            System.out.println(urls);
            if (urls != null) {
                while (urls.hasMoreElements()) {
                    URL resourceUrl = urls.nextElement();
                    System.out.println(resourceUrl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
