package com.ijse.pointofsales.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pointofsales.dto.InvoiceRequestDto;
import com.ijse.pointofsales.entity.Invoice;
import com.ijse.pointofsales.entity.ItemStock;
import com.ijse.pointofsales.entity.Items;
import com.ijse.pointofsales.service.InvoiceService;
import com.ijse.pointofsales.service.ItemService;
import com.ijse.pointofsales.service.StockService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return ResponseEntity.ok(invoices);
    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceRequestDto dto) {
        List<Long> itemIds = dto.getItemIds();
        List<Integer> itemQty = dto.getItemQty();

        if (itemIds.size() != itemQty.size()) {
            return ResponseEntity.badRequest().body(null);
        }

        Invoice invoice = new Invoice();
        invoice.setTotalPrice(0.0);

        List<Items> itemsOfInv = new ArrayList<>();

        for (int i = 0; i < itemIds.size(); i++) {
            Long itemId = itemIds.get(i);
            Integer quantity = itemQty.get(i);

            Items item = itemService.getItemById(itemId);
            ItemStock stock = stockService.getStockByItem(itemId);

            if (item != null && stock != null) {
                // add items to the invoice
                itemsOfInv.add(item);
                // calculate total price
                invoice.setTotalPrice(invoice.getTotalPrice() + item.getPrice() * quantity);
                // update the stock
                stock.setQty(stock.getQty() - quantity);
                stockService.updateStock(itemId, stock);
            }
        }

        invoice.setInvoicedItems(itemsOfInv);
        invoiceService.createInvoice(invoice);
        return ResponseEntity.ok(invoice);
    }

    @PutMapping("/{invNo}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long invNo, @RequestBody Invoice invoice) {
        Invoice exiInvoice = invoiceService.getInvoiceById(invNo);

        if (exiInvoice == null) {
            return ResponseEntity.notFound().build();
        } else {
            exiInvoice.setTotalPrice(invoice.getTotalPrice());
            Invoice updatedInvoice = invoiceService.updatInvoice(invNo, exiInvoice);
            return ResponseEntity.ok(updatedInvoice);
        }
    }

}
