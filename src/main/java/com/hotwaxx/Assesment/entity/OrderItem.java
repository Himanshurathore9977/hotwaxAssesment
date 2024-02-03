package com.hotwaxx.Assesment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotwaxx.Assesment.util.OrderItemId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class OrderItem {

    @Id
    @Column(name = "order_item_seq_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String orderItemSeqId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", updatable = false)
    private OrderHeader order;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", updatable = false)
    private Product product;

    @Column(name = "item_description", length = 255)
    private String itemDescription;

    @Column(name = "quantity", precision = 24, scale = 4)
    private BigDecimal quantity;

    @Column(name = "unit_amount", precision = 24, scale = 4)
    private BigDecimal unitAmount;

    @Column(name = "item_type_enum_id", length = 20)
    private String itemTypeEnumId;

}