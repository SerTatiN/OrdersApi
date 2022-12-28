package org.top.ordersapi.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="order_t")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name="client_t", nullable = false)
    private Client client;

    public Order(Integer id) {
        this.id = id;
    }

    public Order(String description, Client client) {
        this.description = description;
        this.client = client;
    }

    public Order() {

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return id + " / " + description+ " / "+ client;
    }
}
