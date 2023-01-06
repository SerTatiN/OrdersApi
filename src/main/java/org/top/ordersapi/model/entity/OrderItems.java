package org.top.ordersapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

//Сущность "Заказ-товара"

@Entity
@Table(name="order_item_t")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne //много заказ-товаров - один товар
    @JoinColumn(name= "item_id", nullable = false)
    private Item item;

    @ManyToOne // много заказ-товаров - один заказ (несколько товарных позиций )
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


    public OrderItems() {
        id = -1;
        quantity = 0;
        item = null;
        order = null;
    }

    public OrderItems(Integer id, Integer quantity, Item item, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.item = item;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    @JsonIgnore
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }


    @Override
    public String toString() {
        return id + " /" + + quantity + " / " + item + " / " + order;
    }
}
