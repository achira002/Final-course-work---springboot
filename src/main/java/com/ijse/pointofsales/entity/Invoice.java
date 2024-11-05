package com.ijse.pointofsales.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invNo;
    private LocalDateTime invoiceDate;

    @PrePersist
    protected void onCreate() {
        this.invoiceDate = LocalDateTime.now();
    }

    @ManyToMany
    @JoinTable(name = "Invoiced_Items", joinColumns = @JoinColumn(name = "invNo"), inverseJoinColumns = @JoinColumn(name = "itemCode"))
    private List<Items> invoicedItems;

    @ManyToOne
    @JoinColumn(name = "itemCode")
    private ItemStock stock;

    private Double totalPrice;

}
