package com.ijse.pointofsales.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private List<Long> itemIds;
}
