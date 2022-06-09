package com.sparta.springorder.service;

import com.sparta.springorder.dto.RestaurantDto;
import lombok.RequiredArgsConstructor;
import com.sparta.springorder.model.Restaurant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sparta.springorder.repository.RestaurantRepository;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository RestaurantRepository;
    @Transactional
    public Restaurant createRestaurants(RestaurantDto restaurantDto){

        if(restaurantDto.getMinOrderPrice()>100000 || restaurantDto.getMinOrderPrice()<1000 || restaurantDto.getMinOrderPrice()%100 !=0){
            throw new IllegalArgumentException("최소주문 비용을 확인 해주세요");
        }

        if(restaurantDto.getDeliveryFee()<0 || restaurantDto.getDeliveryFee()>10000 || restaurantDto.getDeliveryFee()%500 !=0){
            throw new IllegalArgumentException("배달 비용을 확인 해주세요");
        }
        Restaurant restaurant = new Restaurant(restaurantDto);
        RestaurantRepository.save(restaurant);
        return restaurant;
    }

}
