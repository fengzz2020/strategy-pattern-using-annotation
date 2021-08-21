package com.example.demo.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * 订单的类型，由订单来源 + 订单支付方式决定
 * <p>
 * 注解本质是一个接口 继承自Annotation接口
 * 注解的动态代理实现关键：AnnotationInvocationHandler
 * <p>
 * @author prince Chen
 * @date 2021/8/19 21:25
 * <p>
 * ******* Think twice, code once. *******
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface OrderHandlerType {
    /**
     * 订单来源，PC、mobile，etcd.
     * @return source of order
     */
    String source();

    /**
     * 订单支付方式, wechat, alipay, etcd.
     * @return pay method of order
     */
    String payMethod();
}
