package uestc.zhangkx.annotation;


import java.lang.annotation.*;

/**
 * RPC服务，在impl上标记
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:40
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface RpcService {

    /**
     * Service version, default value is empty string
     */
    String version() default "";

    /**
     * Service group, default value is empty string
     */
    String group() default "";

}
