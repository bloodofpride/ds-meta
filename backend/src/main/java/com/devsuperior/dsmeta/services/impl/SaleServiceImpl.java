package com.devsuperior.dsmeta.services.impl;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.devsuperior.dsmeta.services.interfa.SaleService;
import com.devsuperior.dsmeta.services.interfa.SmsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;


@Service
public class SaleServiceImpl implements SaleService{
    private SaleRepository saleRepository;
    private SmsService smsService;

    public SaleServiceImpl(SaleRepository saleRepository, SmsService smsService){
        this.saleRepository = saleRepository;
        this.smsService = smsService;
    }

    @Override
    public Page<Sale> findSales(String minDate,String maxDate, Pageable pageable) {
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        return saleRepository.findAllByDataInteval(min, max, pageable);
    }

    @Override
    public void notification(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);

        if(sale.isEmpty()){
            throw new IllegalArgumentException("Venda não encontrada com o id:"+id);
        }

        smsService.sendSms(sale.get());
    }
}
