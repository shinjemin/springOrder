package com.sparta.springorder.controller;

import com.sparta.springorder.dto.OrderResponseDto;
import com.sparta.springorder.model.OrderResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderController {

    @PostMapping("/order/request")
    public OrderResponse Order(@RequestBody OrderResponseDto orderResponseDto){
        return new OrderResponse();
    }

    @GetMapping("/orders")
    public OrderResponse showOrder(){
        return new OrderResponse();
    }

}
