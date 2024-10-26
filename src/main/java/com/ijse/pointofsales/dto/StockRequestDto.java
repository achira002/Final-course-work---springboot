package com.ijse.pointofsales.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockRequestDto {
    @Column(nullable = false)
    private Long locCode;
    @Column(nullable = false)
    private Long itemCode;
    @Column(nullable = false)
    private Long catId;
    
    private int qty;
}
