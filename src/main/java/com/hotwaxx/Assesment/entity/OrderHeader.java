package com.hotwaxx.Assesment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
public class OrderHeader {

    @Id
    @Column(name = "order_id", nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String order_id;


    @Column(name = "ORDER_NAME" , length = 255 , nullable = false )
    private String order_name ;

    @JsonIgnore
    @ManyToOne
    private Party party ;

    @Column
    private String party_id ;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems ;

    @Column(name = "PLACED_DATE" , nullable = false )
    private Date placedDate ;

    @Column(name = "APPROVED_DATE")
    private  Date approvedDate ;

    @Column(name = "STATUS_ID" , length =  40 )
    private String status_Id = "OrderPlaced" ;

    @Column(name = "CURRENCY_UOM_ID" , length =  40)
    private  String currencyUomId  = "USD";

    @Column(name = "PRODUCT_STORE_ID" , length = 40)
    private String productStoreId ;

    @Column(name ="SALES_CHANNEL_ENUM_ID" , length = 40 )
    private String salesChannelEnumId ;

    @Column(name = "GRAND_TOTAL" , columnDefinition = "decimal(24,4) default null ")
    private double grandTotal = 0.0  ;

    @Column(name = "COMPLETED_DATE" )
    private Date completedDate ;


        @Column(name = "credit_card")
        private String encryptedCreditCard;


    }
