package com.hotwaxx.Assesment.service.implement;

import com.hotwaxx.Assesment.entity.OrderHeader;
import com.hotwaxx.Assesment.entity.OrderItem;
import com.hotwaxx.Assesment.entity.Party;
import com.hotwaxx.Assesment.repository.OrderItemRepo;
import com.hotwaxx.Assesment.repository.OrderRepo;
import com.hotwaxx.Assesment.repository.PartyRepo;
import com.hotwaxx.Assesment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderItemRepo orderItem;
    @Autowired
    PartyRepo partyRepo ;

    @Override
    public List<OrderHeader> getAllOrderItems() {
        List<OrderHeader> allOrders = orderRepo.findAll();

        for (OrderHeader order : allOrders) {
            if (order.getEncryptedCreditCard() != null) {
                order.setEncryptedCreditCard(getDecryptedValue(order.getEncryptedCreditCard(), 8));
            }
        }
        return allOrders;
    }

    @Override
    public OrderHeader getOrderItemById(String orderId) {
        Optional<OrderHeader> order = orderRepo.findById(orderId);
        if ( order.isPresent() ) {
            OrderHeader order1 = order.get() ;
            if (order1.getEncryptedCreditCard() != null) {
                order1.setEncryptedCreditCard(getDecryptedValue(order1.getEncryptedCreditCard() , 8 )) ;
            }
            return order1 ;
        }
        else{
            return null ;
        }

    }

    @Override
    public OrderHeader addOrder(OrderHeader order) {
        String partyID =  order.getParty_id() ;
        System.out.println(partyID);
        Optional<Party> party  = partyRepo.findById(partyID) ;
        System.out.println(party);
        party.ifPresent(order::setParty) ;
        if(order.getEncryptedCreditCard() != null ){
                order.setEncryptedCreditCard(getEncryptedValue(order.getEncryptedCreditCard() , 8 ));
        }
        OrderHeader savedOrder = orderRepo.save(order);
        return savedOrder;
    }

    @Override
    public OrderHeader addItem(String orderId, OrderHeader order) {

        Optional<OrderHeader> foundOrderOptional = orderRepo.findById(orderId);

        if (foundOrderOptional.isPresent()) {
            OrderHeader foundOrder = foundOrderOptional.get();
            List<OrderItem> orderItemList = order.getOrderItems();
            for (OrderItem item : orderItemList) {
                System.out.println(item);
                item.setOrder(foundOrder);
                orderItem.save(item);
            }
            return foundOrder;

        } else {
            return null;
        }
    }

    public OrderHeader updateOrder(OrderHeader updatedOrder) {
        Optional<OrderHeader> existingOrderOptional = orderRepo.findById(updatedOrder.getOrder_id());

        if (existingOrderOptional.isPresent()) {
            OrderHeader existingOrder = existingOrderOptional.get();

            // Check each field and update if not null
            if (updatedOrder.getOrder_name() != null) {
                existingOrder.setOrder_name(updatedOrder.getOrder_name());
            }

            if (updatedOrder.getParty() != null) {
                existingOrder.setParty(updatedOrder.getParty());
            }

            if (updatedOrder.getPlacedDate() != null) {
                existingOrder.setPlacedDate(updatedOrder.getPlacedDate());
            }

            if (updatedOrder.getApprovedDate() != null) {
                existingOrder.setApprovedDate(updatedOrder.getApprovedDate());
            }

            if (updatedOrder.getStatus_Id() != null) {
                existingOrder.setStatus_Id(updatedOrder.getStatus_Id());
            }

            if (updatedOrder.getCurrencyUomId() != null) {
                existingOrder.setCurrencyUomId(updatedOrder.getCurrencyUomId());
            }

            if (updatedOrder.getProductStoreId() != null) {
                existingOrder.setProductStoreId(updatedOrder.getProductStoreId());
            }

            if (updatedOrder.getSalesChannelEnumId() != null) {
                existingOrder.setSalesChannelEnumId(updatedOrder.getSalesChannelEnumId());
            }

            if (updatedOrder.getGrandTotal() != 0.0) {
                existingOrder.setGrandTotal(updatedOrder.getGrandTotal());
            }

            if (updatedOrder.getCompletedDate() != null) {
                existingOrder.setCompletedDate(updatedOrder.getCompletedDate());
            }
            return orderRepo.save(existingOrder);
        } else {
            return null;
        }
    }


    private static String getDecryptedValue(String encrypt, int secret_key) {
        String decrypted = "";
        for(int i =0; i < encrypt.length();i++) {
            char ch = encrypt.charAt(i);
            ch -= secret_key;
            decrypted = decrypted + ch;
        }
        return decrypted;
    }

    private static String getEncryptedValue(String value, int secret_key) {
        String encrypt = "";
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            ch += secret_key;
            encrypt = encrypt + ch;
        }
        return encrypt;
    }


}
