package com.example.demo.handler;

import com.example.demo.entity.Order;

/**
 * 订单处理器接口，不同的订单类型可以提供不同的接口实现
 *
 * @author prince Chen
 * @date 2021/8/19 21:25
 * <p>
 * ******* Think twice, code once. *******
 */

public interface OrderHandler {
    /**
     * handle order.
     * @param order order object
     */
    void handle(Order order);
}
