package com.sparta.springorder.controller;

import com.sparta.springorder.dto.RestaurantDto;
import lombok.RequiredArgsConstructor;
import com.sparta.springorder.model.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sparta.springorder.repository.RestaurantRepository;
import com.sparta.springorder.service.RestaurantService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantRepository.findAll();
    }

    @PostMapping("/restaurant/register")
    public Restaurant createRestaurants(@RequestBody RestaurantDto restaurantDto){
        return restaurantService.createRestaurants(restaurantDto);
    }
}
