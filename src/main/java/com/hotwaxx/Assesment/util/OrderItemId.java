package com.hotwaxx.Assesment.util;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemId implements Serializable {

    @Column(name = "order_id", length = 20)
    private String orderId;

    @Column(name = "order_item_seq_id", length = 20)
    private String orderItemSeqId;

    // Constructors, getters, and setters

    // You can generate the getters and setters using your IDE or manually.

    // Override equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemId that = (OrderItemId) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(orderItemSeqId, that.orderItemSeqId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderItemSeqId);
    }
}

