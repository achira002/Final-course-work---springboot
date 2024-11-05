package com.ijse.pointofsales.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
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
    private Long itemCode;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "itemCode", referencedColumnName = "id")
    private Items item;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locCode")
    private StockLocation location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catID")
    private ItemCategories category;

    @OneToMany(mappedBy = "stock")
    private List<Invoice> invoiceNo;

    private int qty;
}
