package uestc.zhangkx.annotation;

import java.lang.annotation.*;

/**
 * RPC参考注释，自动装配服务实现类
 * @author zhangkx
 * @version 1.0
 * @date 2020/12/14 19:22
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface RpcReference {

    /**
     * service的版本
     * @return version
     */
    String version() default "";

    /**
     * service的group
     * @return group
     */
    String group() default "";
}
