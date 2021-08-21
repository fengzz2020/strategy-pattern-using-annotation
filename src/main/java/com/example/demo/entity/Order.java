package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * order entity
 *
 * @author prince Chen
 * @date 2021/8/19 21:05
 *
 * ******* Think twice, code once. *******
 */

@Data
public class Order {
    /**
     * 订单来源
     */
    private String source;

    /**
     * 支付方式
     */
    private String payMethod;

    /**
     * 订单编号
     */
    private String code;

    /**
     * 订单金额
     */
    private BigDecimal amount;
}
