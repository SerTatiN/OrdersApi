package org.top.ordersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.top.ordersapi.model.dao.order.IDaoOrder;
import org.top.ordersapi.model.entity.Order;
import org.top.ordersapi.model.repository.OrderItemsRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
   // @Autowired
    private IDaoOrder daoOrder;

    @GetMapping("/all")
    public List<Order> all(){
        return daoOrder.findAll();
    }
    @GetMapping("/get")
    public Optional<Order> get(@RequestParam Integer id){
        return (Optional<Order>) daoOrder.findById(id);
    }




}
