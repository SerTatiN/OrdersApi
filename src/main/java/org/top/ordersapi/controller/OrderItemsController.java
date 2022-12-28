package org.top.ordersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.top.ordersapi.model.dao.orderItems.IDaoOrderItems;
import org.top.ordersapi.model.entity.OrderItems;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orditem")
public class OrderItemsController {

    //@Autowired
    private IDaoOrderItems daoOrderItems;

    @GetMapping("/all")
    public List<OrderItems> all(){
        return (List<OrderItems>)daoOrderItems.findAll();
    }

    @GetMapping("/get")
    public Optional<OrderItems> get(@RequestParam Integer id){
        return (Optional<OrderItems>) daoOrderItems.findById(id);
    }

}
