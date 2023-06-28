package com.example.corejava8.function;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class Order {

    private Long id;

    private String orderNo;

    private BigDecimal orderPrice;

    private String email;
}
