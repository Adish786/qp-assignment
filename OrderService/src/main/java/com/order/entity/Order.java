package com.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="Order_Details")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="PRODUCTID")
    private long productId;
    @Column(name="QUANTITY")
    private long quantity;
    @Column(name="ORDER_DATE")
    private Instant orderDate;
    @Column(name ="STATUS")
    private String orderStatus;
    @Column(name="TOTAL_AMOUNT")
    private long amount;

}
