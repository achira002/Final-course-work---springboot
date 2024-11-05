package com.ijse.pointofsales.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceRequestDto {
    private List<Long> itemIds;
    private List<Integer> itemQty;
}
