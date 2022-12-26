package org.top.ordersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.top.ordersapi.model.dao.item.IDaoItem;
import org.top.ordersapi.model.entity.Item;

import java.util.List;
import java.util.Optional;

//контроллер для работы с товарами
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IDaoItem daoItem;

    @GetMapping("/all")
    public List<Item> all(){
        return daoItem.findAll();
    }
    @GetMapping("/get")
    public Optional<Item> get(@RequestParam Integer id){
        return daoItem.findById(id);
    }

    @PostMapping("/save")
    public Item save(@RequestParam String iName, @RequestParam Long iArticle){
        Item item = new Item();
        item.setItemName(iName);
        item.setItemArticle(iArticle);
        return daoItem.save(item);
    }

//    @PostMapping("/update")
//    public Item update(@RequestParam Integer id, @RequestParam String iName, @RequestParam Long iArticle){
//        Item item=null;
//        if (!(daoItem.findById(id).isPresent())) {
//
//        }
//
//
//        return daoItem.update(item);
//    }

    @GetMapping("/ping")
    public String ping() {
        return "item pong";
    }
}
