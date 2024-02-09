package com.hotwaxx.Assesment.controller;

import com.hotwaxx.Assesment.entity.OrderHeader;
import com.hotwaxx.Assesment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService ;


    @GetMapping
    public List<OrderHeader> getAllOrderItems() {
        return orderService.getAllOrderItems();
    }

    @GetMapping("/{orderId}")
    public OrderHeader getOrderItemById(@PathVariable String orderId) throws Exception {
        return orderService.getOrderItemById(orderId);
    }

    @PostMapping()
    public OrderHeader addOrder(@RequestBody OrderHeader orderItem ) throws Exception {
        return orderService.addOrder(orderItem);
    }

    @PostMapping("/addItem/{orderId}")
    public OrderHeader addItem(@PathVariable String orderId  , @RequestBody OrderHeader orderHeader ){
        OrderHeader orderss = orderService.addItem( orderId , orderHeader) ;
        return orderss ;
    }

    @PutMapping("/{orderId}")
    public OrderHeader updateOrder(@PathVariable String orderId, @RequestBody OrderHeader updatedOrder) {
        updatedOrder.setOrder_id(orderId);
        OrderHeader result = orderService.updateOrder(updatedOrder);
        return  result ;
    }


}
