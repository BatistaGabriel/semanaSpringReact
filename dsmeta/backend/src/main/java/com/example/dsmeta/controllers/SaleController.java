package com.example.dsmeta.controllers;

import com.example.dsmeta.entities.Sale;
import com.example.dsmeta.services.SaleService;
import com.example.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private SmsService smsService;

    /**
     * [HTTP GET]
     * <p>
     * API route to find sales per date
     *
     * @param minDate <b>String</b> containing the minimum date range
     * @param maxDate <b>String</b> containing the maximum date range
     * @return Page of Sales
     */
    @GetMapping
    public Page<Sale> findAllSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return saleService.findAllSales(minDate, maxDate, pageable);
    }

    /**
     * [HTTP GET]
     * <p>
     * API route to notify a sale via SMS
     */
    @GetMapping("/{id}/notification")
    public void notifyViaSms(@PathVariable Long id) {
        smsService.sendSms(id);
    }
}
