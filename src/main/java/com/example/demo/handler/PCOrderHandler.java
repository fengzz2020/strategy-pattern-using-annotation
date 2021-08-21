package com.example.demo.handler;

import com.example.demo.annotation.OrderHandlerType;
import com.example.demo.entity.Order;

/**
 * PC 端订单处理方式
 *
 * @author prince Chen
 * @date 2021/8/19 21:33
 * <p>
 * ******* Think twice, code once. *******
 */

@OrderHandlerType(source = "pc", payMethod = "wechat")
public class PCOrderHandler implements OrderHandler{
    @Override
    public void handle(Order order) {
        System.out.println("PC order handle... use wechat");
    }
}
