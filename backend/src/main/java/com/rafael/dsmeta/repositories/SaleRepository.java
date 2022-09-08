package com.rafael.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rafael.dsmeta.entities.Sale;

//Component responsible to search a sale, add a sale, delete a sale...
public interface SaleRepository extends JpaRepository<Sale, Long>{
    
}
