package org.top.ordersapi.model.entity;

import jakarta.persistence.*;

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
    private Set<OrderItems> orserItems;
    //конструктор по умолчанию
    public Item(){
        id = -1;
        itemName = "undefined";
        itemArticle = -1L;
    }

    public Item(Integer id, String name, Long article){
        this.id = id;
        this.itemName = name;
        this.itemArticle = article;
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

    @Override
    public String toString(){
        return id + " / " + itemName + " / " + itemArticle;
    }

}
