package com.ijse.pointofsales.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    // @Column(nullable = false)
    private String categoryName;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Items> item;

    @JsonIgnore
    @OneToOne(mappedBy = "category")
    private ItemStock stock;

    // @ManyToOne
    // @JoinColumn(name = "categoryId")
    // private StockLocation location;


}
