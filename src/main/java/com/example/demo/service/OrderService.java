package com.example.demo.service;

import com.example.demo.annotation.OrderHandlerType;
import com.example.demo.annotation.OrderHandlerTypeImpl;
import com.example.demo.entity.Order;
import com.example.demo.handler.OrderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 订单service，可以根据不同的订单类型选择不同的订单处理方式
 *
 * @author prince Chen
 * @date 2021/8/19 21:34
 * <p>
 * ******* Think twice, code once. *******
 */
@Service
public class OrderService {
    // 方案一
    //private Map<String, OrderHandler> orderHandlerMap;

    // 方案二
    /**
     * 订单类型与订单处理器的映射关系
     */
    private Map<OrderHandlerType, OrderHandler> orderHandlerMap;

    @Autowired
    public void setOrderHandlerMap(List<OrderHandler> orderHandlers) {
        // 方案一：支付方式与对应的OrderHandler进行映射 "pc": pcOrderHandlers
        // 如果需求变了，PC端微信支付与PC端支付宝支付处理逻辑不同了，这种就有问题了
        /*orderHandlerMap = orderHandlers.stream()
                .collect(Collectors.toMap(
                        orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class).source(),
                        orderHandler -> orderHandler
                        ));*/

        // 方案二：OrderHandlerType与对应的OrderHandler进行映射
        orderHandlerMap = orderHandlers.stream()
                .collect(Collectors.toMap(
                        orderHandler -> AnnotationUtils.findAnnotation(orderHandler.getClass(), OrderHandlerType.class),
                        orderHandler -> orderHandler
                ));
        System.out.println(orderHandlerMap);
    }

    public void orderService(Order order) {
        // ...
        // 方案一
        //OrderHandler orderHandler = orderHandlerMap.get(order.getSource());
        //orderHandler.handle(order);

        // 方案二
        OrderHandlerType handlerType = new OrderHandlerTypeImpl(order.getSource(), order.getPayMethod());
        OrderHandler orderHandler = orderHandlerMap.get(handlerType);

        if (!Objects.isNull(orderHandler)) {
            orderHandler.handle(order);
        }
        // ...

    }
}
