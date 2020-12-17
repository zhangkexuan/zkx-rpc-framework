package uestc.zhangkx.annotation;


import org.springframework.context.annotation.Import;
import uestc.zhangkx.spring.CustomScannerRegistrar;

import java.lang.annotation.*;

/**
 * RPC扫描
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:40
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(CustomScannerRegistrar.class)
@Documented
public @interface RpcScan {

    String[] basePackage();

}
