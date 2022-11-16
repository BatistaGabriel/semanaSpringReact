package com.example.dsmeta.controllers;

import com.example.dsmeta.entities.Sale;
import com.example.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    /**
     * [HTTP GET]
     * <p>
     * API route to find all the sales
     *
     * @return List of Sales
     */
    @GetMapping
    public List<Sale> findAllSales() {
        return saleService.findAllSales();
    }
}
