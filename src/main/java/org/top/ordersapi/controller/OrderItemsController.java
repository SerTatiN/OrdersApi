package org.top.ordersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.top.ordersapi.model.dao.item.IDaoItem;
import org.top.ordersapi.model.dao.order.IDaoOrder;
import org.top.ordersapi.model.dao.orderItems.IDaoOrderItems;
import org.top.ordersapi.model.entity.Order;
import org.top.ordersapi.model.entity.OrderItems;

import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orditem")
public class OrderItemsController {

    @Autowired
    private IDaoOrderItems daoOrderItems;
    @Autowired
    private IDaoOrder daoOrder;
    @Autowired
    private IDaoItem daoItem;

    @GetMapping("/all")
    public List<OrderItems> all(){
        return (List<OrderItems>)daoOrderItems.findAll();
    }

    @GetMapping("/get")
    public Optional<OrderItems> get(@RequestParam Integer id){
        return (Optional<OrderItems>) daoOrderItems.findById(id);
    }
    @PostMapping("/save")
    public OrderItems save(@RequestParam Integer quantity, @RequestParam Integer idItem,
                           @RequestParam Integer idOrder){

        if (quantity != null && idItem != null && idOrder != null){
            if (daoItem.findById(idItem).isPresent() && daoOrder.findById(idOrder).isPresent()){
                OrderItems orderItem = new OrderItems();
                orderItem.setQuantity(quantity);
                orderItem.setItem(daoItem.findById(idItem).get());
                orderItem.setOrder(daoOrder.findById(idOrder).get());

                return daoOrderItems.save(orderItem);
            }
        }
        return null;
    }
    @PostMapping("/update")
    public OrderItems update(@RequestParam Integer id,
                             @RequestParam (required = false) Integer quantity,
                             @RequestParam (required = false) Integer idItem,
                             @RequestParam (required = false) Integer idOrder){
        if (id != null && daoOrderItems.findById(id).isPresent()) {
            OrderItems orderItems = daoOrderItems.findById(id).get();
            if (quantity != null) {
                orderItems.setQuantity(quantity);
            }
            if (idItem != null && daoItem.findById(idItem).isPresent()) {
                orderItems.setItem(daoItem.findById(idItem).get());
            }
            if (idOrder != null && daoOrder.findById(idOrder).isPresent()){
                orderItems.setOrder(daoOrder.findById(idOrder).get());
            }
            return daoOrderItems.save(orderItems);
        }
        return null;
    }

    @GetMapping("/delete")
    public OrderItems delete(@RequestParam Integer id){
        return daoOrderItems.delete(id);
    }

}
