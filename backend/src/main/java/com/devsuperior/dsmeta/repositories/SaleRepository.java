package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query(value = "SELECT s from Sale s " +
            "WHERE s.date BETWEEN :min AND :max " +
            "ORDER BY s.amount DESC")
    Page<Sale> findAllByDataInteval(LocalDate min, LocalDate max, Pageable pageable);

}
