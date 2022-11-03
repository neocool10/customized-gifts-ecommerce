package com.virtusa.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.virtusa.springapp.model.Delivery;

@Component
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{

}
