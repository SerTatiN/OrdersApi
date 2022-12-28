package org.top.ordersapi.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="client_t")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false, length = 200)
    private String name;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private Set<Order> orders;

    public Client() {
    }

    public Client(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(String name, Set<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return id + " / " + name+ " / " +  orders.toString();
    }

}
