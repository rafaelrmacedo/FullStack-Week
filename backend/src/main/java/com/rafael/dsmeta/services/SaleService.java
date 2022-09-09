package com.rafael.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.rafael.dsmeta.entities.Sale;
import com.rafael.dsmeta.repositories.SaleRepository;

@Service
//responsible to do bussiness operations with sales 
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){ // use the pageable to get the twelve first sales

        LocalDate today = LocalDate.ofInstant(
            Instant.now() // get the instant date
            , ZoneId.systemDefault() // get the system default zone 
            );

        //convert text to date
        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate); // ? = if / : = else 

        return repository.findSales(min, max, pageable);
    }
    
}
