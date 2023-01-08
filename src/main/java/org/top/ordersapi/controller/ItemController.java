package org.top.ordersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.top.ordersapi.model.dao.item.IDaoItem;
import org.top.ordersapi.model.dao.orderItems.IDaoOrderItems;
import org.top.ordersapi.model.entity.Item;

import java.util.List;
import java.util.Optional;

//контроллер для работы с товарами
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IDaoItem daoItem;
    @Autowired
    private IDaoOrderItems daoOrderItems;

    @GetMapping("/all")
    public List<Item> all(){
        System.out.println();
        return daoItem.findAll();
    }
    @GetMapping("/get")
    public Optional<Item> get(@RequestParam Integer id){
        System.out.println(daoItem.findById(id));
        return daoItem.findById(id);
    }

    @PostMapping("/save")
    public Item save(@RequestParam String iName, @RequestParam Long iArticle,
                     @RequestParam (required = false) Integer price){

        if (iName != null) {
            Item item = new Item();
            item.setItemName(iName);
            if (iArticle != null) {
                item.setItemArticle(iArticle);
            }
            if (price != null) {
                item.setPrice(price);
            }
            return daoItem.save(item);
        }
        return null;
    }

    @PostMapping("/update")
    public Item update(@RequestParam Integer id, @RequestParam (required = false) String iName,
                       @RequestParam (required = false) Long iArticle,
                       @RequestParam (required = false) Integer price){

        if (daoItem.findById(id).isPresent()) {
            Item item = daoItem.findById(id).get();

            if (iName != null) {
                item.setItemName(iName);
            }
            if (iArticle != null) {
                item.setItemArticle(iArticle);
            }
            if (price != null) {
                item.setPrice(price);
            }
            return daoItem.update(item);
        }
        return null;
    }

    @GetMapping("/delete")
    public Item delete (@RequestParam Integer id){

        return  daoItem.delete(id);
    }

    @GetMapping("/ping")
    public String ping() {
        return "item pong";
    }
}
