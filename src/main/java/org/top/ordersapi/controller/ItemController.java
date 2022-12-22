package org.top.ordersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.top.ordersapi.model.dao.item.IDaoItem;
import org.top.ordersapi.model.entity.Item;

import java.util.List;

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
    @GetMapping("/fbid")
    public Item all(Integer id){
        return daoItem.findById(id);
    }

    @GetMapping("/ping")
    public String ping() {
        return "item pong";
    }
}
