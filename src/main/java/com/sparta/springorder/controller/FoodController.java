package com.sparta.springorder.controller;

import com.sparta.springorder.dto.FoodDto;
import com.sparta.springorder.dto.RestaurantDto;
import com.sparta.springorder.model.Food;
import com.sparta.springorder.repository.FoodRepository;
import com.sparta.springorder.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodRepository foodRepository;
    private final FoodService foodService;

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFood(@PathVariable Long restaurantId){
        return foodRepository.findAllByRestaurantId(restaurantId);
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createFood(@PathVariable Long restaurantId,@RequestBody List<FoodDto> foodDtoList){
            foodService.createFood(restaurantId,foodDtoList);
    }
}
