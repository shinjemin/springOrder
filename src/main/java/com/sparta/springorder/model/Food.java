package com.sparta.springorder.model;

import com.sparta.springorder.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    public Food(Long restaurantId,FoodDto foodDto){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurantId = restaurantId;
    }

}
