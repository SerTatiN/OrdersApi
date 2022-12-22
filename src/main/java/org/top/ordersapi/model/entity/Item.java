package org.top.ordersapi.model.entity;

//сущность "Продукт"
public class Item {
    private Integer id;
    private String itemName;
    private Long itemArticle;

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
