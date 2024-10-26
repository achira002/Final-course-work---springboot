package com.ijse.pointofsales.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequestDto {
    private String name;
    private Double price;
    private String description;
    private Long categoryId;
    private String categoryName;
    // private Long stock;
}
