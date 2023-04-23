package com.thieu.preconfig.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="order_number")
    private String orderNumber;
}
