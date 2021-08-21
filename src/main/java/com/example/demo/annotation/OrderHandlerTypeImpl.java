package com.example.demo.annotation;

import java.lang.annotation.Annotation;
import java.util.Objects;

/**
 * implements of OrderHandleType
 *
 * @author prince Chen
 * @date 2021/8/19 22:49
 * <p>
 * ******* Think twice, code once. *******
 */

public class OrderHandlerTypeImpl implements OrderHandlerType{
    private String source;
    private String payMethod;

    public OrderHandlerTypeImpl(String source, String payMethod) {
        this.source = source;
        this.payMethod = payMethod;
    }

    @Override
    public String source() {
        return source;
    }

    @Override
    public String payMethod() {
        return payMethod;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return OrderHandlerType.class;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderHandlerType)) {
            return false;
        }
        OrderHandlerType that = (OrderHandlerType) o;
        return source.equals(that.source()) && payMethod.equals(that.payMethod());
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += (127 * "source".hashCode()) ^ source.hashCode();
        hashCode += (127 * "payMethod".hashCode()) ^ payMethod.hashCode();
        return hashCode;
    }
}
