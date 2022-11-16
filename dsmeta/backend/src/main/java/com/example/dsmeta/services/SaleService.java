package com.example.dsmeta.services;

import com.example.dsmeta.entities.Sale;
import com.example.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    /**
     * Gets All using the Sales Repository
     *
     * @return List of Sales
     */
    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }
}
