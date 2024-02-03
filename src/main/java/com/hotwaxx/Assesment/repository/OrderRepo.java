package com.hotwaxx.Assesment.repository;


import com.hotwaxx.Assesment.entity.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<OrderHeader, String > {

}
