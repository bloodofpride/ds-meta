package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImp implements SaleService{
    private SaleRepository saleRepository;

    public SaleServiceImp(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> findSales() {
        return saleRepository.findAll();
    }
}
