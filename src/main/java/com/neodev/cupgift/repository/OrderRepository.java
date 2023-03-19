package com.neodev.cupgift.repository;


import com.neodev.cupgift.model.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Modifying 
    @Transactional  
    @Query(value = "select * from orders where user_id=?1",nativeQuery=true)  
    public List<Order> findbyUserId(int id);
    
}
