package uestc.zhangkx.annotation;

import org.springframework.context.annotation.Import;
import uestc.zhangkx.spring.CustomScannerRegistrar;

import java.lang.annotation.*;

/**
 * 扫描自定义注解
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 19:27
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(CustomScannerRegistrar.class)
@Documented
public @interface RpcScan {

    String[] basePackage();

}
