package com.example.demo.handler;

import com.example.demo.annotation.OrderHandlerType;
import com.example.demo.entity.Order;

/**
 * 移动端订单处理类
 *
 * @author prince Chen
 * @date 2021/8/19 21:32
 * <p>
 * ******* Think twice, code once. *******
 */

@OrderHandlerType(source = "mobile", payMethod = "alipay")
public class MobileOrderHandler implements OrderHandler{
    @Override
    public void handle(Order order) {
        System.out.println("Mobile order handle.... use alipay");
    }
}
