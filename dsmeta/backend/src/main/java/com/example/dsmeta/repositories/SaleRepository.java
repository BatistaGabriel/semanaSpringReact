package com.example.dsmeta.repositories;

import com.example.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    /**
     * Gets all sales based in an informed rage of date by executing the query:
     * <p>
     * "SELECT obj FROM Sale obj
     * <p>
     * <b>WHERE obj.date BETWEEN :min AND :max</b>
     * <p>
     * ORDER BY obj.amount DESC"
     *
     * @param min <b>String</b> containing the minimum date range
     * @param max <b>String</b> containing the maximum date range
     * @return Page of Sales
     */
    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
    Page<Sale> findSalesByDate(LocalDate min, LocalDate max, Pageable pageable);
}
