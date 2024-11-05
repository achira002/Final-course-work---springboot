package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.Invoice;

@Service
public interface InvoiceService {
    List<Invoice> getAllInvoices();

    Invoice createInvoice(Invoice invoice);

    Invoice getInvoiceById(Long invNo);

    Invoice updatInvoice(Long invNo, Invoice invoice);
}
