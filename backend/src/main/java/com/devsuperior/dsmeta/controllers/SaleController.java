package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {
    private SaleService saleService;

    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<Page<Sale>> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                                Pageable pageable){
        return ResponseEntity.ok().body(saleService.findSales(minDate, maxDate, pageable));
    }
}