package uestc.zhangkx.spring;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import uestc.zhangkx.annotation.RpcReference;
import uestc.zhangkx.annotation.RpcService;
import uestc.zhangkx.entity.RpcServiceProperties;
import uestc.zhangkx.extension.ExtensionLoader;
import uestc.zhangkx.factory.SingletonFactory;
import uestc.zhangkx.provider.ServiceProvider;
import uestc.zhangkx.provider.ServiceProviderImpl;
import uestc.zhangkx.proxy.RpcClientProxy;
import uestc.zhangkx.remoting.transport.RpcRequestTransport;

import java.lang.reflect.Field;

/**
 * bean之前调用
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 14:00
 */
@Slf4j
@Component
public class SpringBeanPostProcessor implements BeanPostProcessor {

    private final ServiceProvider serviceProvider;
    private final RpcRequestTransport rpcClient;

    public SpringBeanPostProcessor() {
        this.serviceProvider = SingletonFactory.getInstance(ServiceProviderImpl.class);
        this.rpcClient = ExtensionLoader.getExtensionLoader(RpcRequestTransport.class).getExtension("netty");
    }

    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(RpcService.class)) {
            log.info("[{}] is annotated with  [{}]", bean.getClass().getName(), RpcService.class.getCanonicalName());
            // get RpcService annotation
            RpcService rpcService = bean.getClass().getAnnotation(RpcService.class);
            // build RpcServiceProperties
            RpcServiceProperties rpcServiceProperties = RpcServiceProperties.builder()
                    .group(rpcService.group()).version(rpcService.version()).build();
            serviceProvider.publishService(bean, rpcServiceProperties);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> targetClass = bean.getClass();
        Field[] declaredFields = targetClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            RpcReference rpcReference = declaredField.getAnnotation(RpcReference.class);
            if (rpcReference != null) {
                RpcServiceProperties rpcServiceProperties = RpcServiceProperties.builder()
                        .group(rpcReference.group()).version(rpcReference.version()).build();
                RpcClientProxy rpcClientProxy = new RpcClientProxy(rpcClient, rpcServiceProperties);
                Object clientProxy = rpcClientProxy.getProxy(declaredField.getType());
                declaredField.setAccessible(true);
                try {
                    declaredField.set(bean, clientProxy);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        return bean;
    }
}
