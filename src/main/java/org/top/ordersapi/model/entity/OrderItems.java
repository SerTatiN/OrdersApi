package org.top.ordersapi.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="orderItem_t")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "item_id",nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;


    @Column(nullable = false)
    private Integer quantity;

    public OrderItems() {
    }

    public OrderItems(Item item, Order order, Integer quantity) {
        this.item = item;
        this.order = order;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
