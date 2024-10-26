package com.ijse.pointofsales.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column(nullable = false)
    private String name;
    private Double price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private ItemCategories category;

    @JsonIgnore
    @OneToOne(mappedBy = "item")
    private ItemStock stockItem;

    @JsonIgnore
    @ManyToMany(mappedBy = "orderItems")
    private List<Order> orders;

}
