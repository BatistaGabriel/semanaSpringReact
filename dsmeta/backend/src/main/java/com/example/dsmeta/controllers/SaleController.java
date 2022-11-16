package com.example.dsmeta.controllers;

import com.example.dsmeta.entities.Sale;
import com.example.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

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
}
