package org.top.ordersapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

//Сущность "Заказ"
@Entity
@Table(name="order_t")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String description;

    @ManyToOne   //много заказов - один клиент
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    //один заказ - много заказ-товаров, ссылающихся на него
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItems> orderItems; //= new HashSet<>();

    public Order() {
        id = -1;
        description = "nodesc";
        client = null;
        orderItems = new HashSet<>();
    }
    public Order(String description, Client client) {
        this.description = description;
        this.client = client;
    }

    public Order(Integer id, String description, Client client, Set<OrderItems> orderItems) {
        this.id = id;
        this.description = description;
        this.client = client;
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }


    @Override
    public String toString() {
        return id + " / " + description+ " / "+ client+
                " / " + orderItems;
    }
}
