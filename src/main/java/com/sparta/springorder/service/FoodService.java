package com.sparta.springorder.service;

import com.sparta.springorder.dto.FoodDto;
import com.sparta.springorder.model.Food;
import com.sparta.springorder.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public void createFood(Long id, List<FoodDto> foodDtoList) {
        List<Food> foodList = foodRepository.findAllByRestaurantId(id);

        for (int i = 0; i < foodList.size(); i++) {
            for (int j = i + 1; j < foodDtoList.size(); j++) {
                // 등록 할 메뉴와 기존 메뉴의 이름이 같을 때 에러 발생
                if (foodList.get(i).getName().equals(foodDtoList.get(j-1).getName())) {
                    throw new IllegalArgumentException("이미 등록된 메뉴 입니다");
                    // 중복 된 메뉴가 있을 때 에러 발생
                }
                if (foodDtoList.get(i).getName().equals(foodDtoList.get(j).getName())) {
                    throw new IllegalArgumentException("같은 메뉴가 존재 합니다");
                }
            }
        }

        for (FoodDto foodDto : foodDtoList) {
            int foodMinCheck = foodDto.getPrice();
            Food food = new Food(id, foodDto);

            // 음식 가격이 100원 미만 이거나 100,000원 이상일 때 에러 발생
            if (foodMinCheck < 100 || foodMinCheck > 1000000|| foodMinCheck % 100 != 0) {
                throw new IllegalArgumentException("음식 가격을 확인 해주세요");

            }

            foodRepository.save(food);
        }
    }

}
