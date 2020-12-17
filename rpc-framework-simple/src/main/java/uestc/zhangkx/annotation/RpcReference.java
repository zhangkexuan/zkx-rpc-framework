package uestc.zhangkx.annotation;


import java.lang.annotation.*;

/**
 * RPC自动装配
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/17 13:40
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
public @interface RpcReference {

    /**
     * Service version, default value is empty string
     */
    String version() default "";

    /**
     * Service group, default value is empty string
     */
    String group() default "";

}
