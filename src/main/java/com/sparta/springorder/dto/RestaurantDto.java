package com.sparta.springorder.dto;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public class RestaurantDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
