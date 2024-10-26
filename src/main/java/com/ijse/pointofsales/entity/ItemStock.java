package com.ijse.pointofsales.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// @IdClass(ItemStockId.class)
public class ItemStock {

    // private Items item;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemCode", referencedColumnName = "id")
    private Items item;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locCode")
    private StockLocation location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catID")
    private ItemCategories category;
    private int qty;
}
