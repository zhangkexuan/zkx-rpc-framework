package uestc.zhangkx.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 单例工厂
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/16 15:48
 */
public class SingletonFactory {
    private static Map<String, Object> FACTORY = new ConcurrentHashMap<>();

    public SingletonFactory() {
    }

    public static <T> T getInstance(Class<T> clazz){
        String key = clazz.toString();
        Object instance = FACTORY.get(key);
        if (instance == null){
            synchronized (SingletonFactory.class){
                instance = FACTORY.get(key);
                if (instance==null){
                    try {
                        instance=clazz.getDeclaredConstructor().newInstance();
                        FACTORY.put(key,instance);
                    } catch (IllegalAccessException | InstantiationException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    } catch (NoSuchMethodException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return clazz.cast(instance);
    }
}
