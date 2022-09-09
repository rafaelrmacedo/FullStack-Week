package com.rafael.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rafael.dsmeta.entities.Sale;
import com.rafael.dsmeta.services.SaleService;
import com.rafael.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;
    @Autowired
    private SmsService smsService;

    @GetMapping
    //here we received the data as text, after we convert it to data
    public Page<Sale> findSales(
        //parameter name when it'll be called
        @RequestParam(value = "minDate", defaultValue = "") String minDate, 
        @RequestParam(value = "max  Date", defaultValue = "") String maxDate, 
        Pageable pageable) {
        return service.findSales(minDate, maxDate, pageable);
    }

    @RequestMapping("/{id}/notification")
    public void Notify(@PathVariable Long id){
        smsService.sendSms(id);
    }

}
