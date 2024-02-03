package com.hotwaxx.Assesment.service;


import com.hotwaxx.Assesment.entity.OrderHeader;

import java.util.List;

public interface OrderService {
    List<OrderHeader> getAllOrderItems();

    OrderHeader getOrderItemById(String orderId) throws Exception;
//
    OrderHeader addOrder(OrderHeader order) throws Exception;

    OrderHeader addItem( String orderId , OrderHeader order ) ;

    public OrderHeader updateOrder(OrderHeader updatedOrder) ;
//
//    void deleteOrderItem(String orderId, String orderItemSeqId);
//
//    ResponseItem addItem(AddOrderDto orderRequest);
//
//    OrderHeader updateOrder(OrderHeader updatedOrder);
}