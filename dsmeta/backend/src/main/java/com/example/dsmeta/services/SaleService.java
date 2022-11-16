package com.example.dsmeta.services;

import com.example.dsmeta.entities.Sale;
import com.example.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    /**
     * Gets sales per date using the Sales Repository
     *
     * @param minDate <b>String</b> containing the minimum date range
     * @param maxDate <b>String</b> containing the maximum date range
     * @return Page of Sales
     */
    public Page<Sale> findAllSales(
            String minDate,
            String maxDate,
            Pageable pageable) {
        /**
         * Getting today's date to use it in a forward validation
         */
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        /**
         * Using a ternary validation to check if the informed date is not empty
         * in case of an empty date we use the defined content of the today variable.
         *
         * Notice that in the minDate case, we are going to consider the last year
         * date as the minimum date for our range.
         */
        LocalDate min = minDate.isEmpty() ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.isEmpty() ? today : LocalDate.parse(maxDate);

        return saleRepository.findSalesByDate(min, max, pageable);
    }
}
