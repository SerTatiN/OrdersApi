package org.top.ordersapi.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


//сущность "Продукт"
@Entity
@Table(name="item_t")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false, length=200)
    private String itemName;
    @Column(nullable=false)
    private Long itemArticle;

    @OneToMany(mappedBy="item", cascade = CascadeType.ALL)
    private Set<OrderItems> orderItems;

    //конструктор по умолчанию
    public Item(){
        id = -1;
        itemName = "undefined";
        itemArticle = -1L;
        orderItems = new HashSet<>();
    }

    public Item(Integer id, String name, Long article, OrderItems ordItems){
        this.id = id;
        this.itemName = name;
        this.itemArticle = article;
        this.orderItems.add(ordItems);
    }
    public Item(Integer id, String name, Long article){
        this.id = id;
        this.itemName = name;
        this.itemArticle = article;
        this.orderItems = null;
    }
    public Item(Integer id, String itemName, Long itemArticle, Set<OrderItems> orderItems) {
        this.id = id;
        this.itemName = itemName;
        this.itemArticle = itemArticle;
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemArticle() {
        return itemArticle;
    }

    public void setItemArticle(Long itemArticle) {
        this.itemArticle = itemArticle;
    }

    public Set<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }



    @Override
    public String toString(){
        return id + " / " + itemName + " / " + itemArticle +
                " / " + orderItems;
    }

}
