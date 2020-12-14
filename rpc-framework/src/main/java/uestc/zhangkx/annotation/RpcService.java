package uestc.zhangkx.annotation;

import java.lang.annotation.*;

/**
 * RPC服务注解，在服务实现类上标记
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 20:38
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface RpcService {

    String version() default "";

    String group() default "";
}
