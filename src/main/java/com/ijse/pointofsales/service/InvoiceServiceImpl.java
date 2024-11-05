package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.Invoice;
import com.ijse.pointofsales.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(Long invNo) {
        return invoiceRepository.findById(invNo).orElse(null);
    }

    @Override
    public Invoice updatInvoice(Long invNo, Invoice invoice) {
        Invoice existingInvoice = invoiceRepository.findById(invNo).orElse(null);

        existingInvoice.setTotalPrice(invoice.getTotalPrice());
        return invoiceRepository.save(existingInvoice);

    }

}
