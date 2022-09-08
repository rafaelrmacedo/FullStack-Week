package com.rafael.dsmeta.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.dsmeta.entities.Sale;
import com.rafael.dsmeta.repositories.SaleRepository;

@Service
//responsible to do bussiness operations with sales 
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public List <Sale> findSales(){
        return repository.findAll();
    }
    
}
