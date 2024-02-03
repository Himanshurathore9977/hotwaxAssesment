package com.hotwaxx.Assesment.service.implement;

import com.hotwaxx.Assesment.entity.OrderHeader;
import com.hotwaxx.Assesment.entity.OrderItem;
import com.hotwaxx.Assesment.repository.OrderItemRepo;
import com.hotwaxx.Assesment.repository.OrderRepo;
import com.hotwaxx.Assesment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderItemRepo orderItem;

    @Override
    public List<OrderHeader> getAllOrderItems() {
        return orderRepo.findAll();
    }

    @Override
    public OrderHeader getOrderItemById(String orderId) throws Exception {
        Optional<OrderHeader> order = orderRepo.findById(orderId);
        if ( order.isPresent() ) {
            OrderHeader order1 = order.get() ;
            String secretKey = "yourSecretKey";
            if (order1.getEncryptedCreditCard() != null) {
                order1.setEncryptedCreditCard(EncryptionUtils.decrypt(order1.getEncryptedCreditCard())) ;
            }
            return order1 ;
        }
        else{
            return null ;
        }

    }

    @Override
    public OrderHeader addOrder(OrderHeader order) {
        try {
            // Check if credit card data is not null before encryption
            String secretKey = "yourSecretKey";
            if (order.getEncryptedCreditCard() != null) {
                order.setEncryptedCreditCard(EncryptionUtils.encrypt(order.getEncryptedCreditCard()));
            }

            // Save the order with encrypted credit card data
            OrderHeader savedOrder = orderRepo.save(order);

            // Ensure the saved order contains decrypted credit card data before returning
            String decryptedCreditCard = EncryptionUtils.decrypt(savedOrder.getEncryptedCreditCard());
            savedOrder.setEncryptedCreditCard(decryptedCreditCard);

            return savedOrder;
        } catch (Exception e) {
            // Handle encryption/decryption exceptions
            e.printStackTrace(); // or log the exception
            return null;
        }
    }

    @Override
    public OrderHeader addItem(String orderId, OrderHeader order) {

        Optional<OrderHeader> foundOrderOptional = orderRepo.findById(orderId);

        if (foundOrderOptional.isPresent()) {
            OrderHeader foundOrder = foundOrderOptional.get();
            List<OrderItem> orderItemList = order.getOrderItems();
            // Set the order for each item and save
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
        // Fetch the existing order from the database
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

            // Repeat the above checks for other fields

            // Save the updated order back to the database
            return orderRepo.save(existingOrder);
        } else {
            // Handle case where the order with the given ID is not found
            return null;
        }
    }



}
