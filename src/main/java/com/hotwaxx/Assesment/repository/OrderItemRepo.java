package com.hotwaxx.Assesment.repository;

import com.hotwaxx.Assesment.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo  extends JpaRepository<OrderItem,String> {

//    List<OrderItem> findByOrderId(String id);

}
