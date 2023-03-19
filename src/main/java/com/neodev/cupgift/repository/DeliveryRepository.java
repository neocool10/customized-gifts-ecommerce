package com.neodev.cupgift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.neodev.cupgift.model.Delivery;

@Component
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{

}
