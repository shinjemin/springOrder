package com.sparta.springorder.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private int totalPrice;

    @OneToMany(cascade = CascadeType.ALL) // 매핑 당하는 쪽
    @JoinColumn(name = "Order_id") // order_id 조인
    private List<OrderResponse> foods;

}