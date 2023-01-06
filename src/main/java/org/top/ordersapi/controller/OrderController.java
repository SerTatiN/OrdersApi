package org.top.ordersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.top.ordersapi.model.dao.client.IDaoClient;
import org.top.ordersapi.model.dao.order.IDaoOrder;
import org.top.ordersapi.model.dao.orderItems.IDaoOrderItems;
import org.top.ordersapi.model.entity.Order;
import org.top.ordersapi.model.repository.OrderItemsRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IDaoOrder daoOrder;
    @Autowired
    private IDaoClient daoClient;
    @Autowired
    private IDaoOrderItems daoOrderItems;

    @GetMapping("/all")
    public List<Order> all(){
        return daoOrder.findAll();
    }
    @GetMapping("/get")
    public Optional<Order> get(@RequestParam Integer id){
        return (Optional<Order>) daoOrder.findById(id);
    }

    @PostMapping("/save")
    public Order save(@RequestParam String description,
                      @RequestParam Integer clientId,
                      @RequestParam (required = false) Integer ordItemsId){

        Order order = new Order();
        order.setDescription(description);

        if (clientId != null && daoClient.findById(clientId).isPresent()) {
          order.setClient(daoClient.findById(clientId).get());
        };

//        System.out.println(daoOrderItems.findById(clientId).isPresent());
//        if (daoOrderItems.findById(ordItemsId).isPresent()){
//            order.addOrderItem(daoOrderItems.findById(ordItemsId).get());
//        }
        return daoOrder.save(order);    }

    // существующий заказ передается существующему клиенту (без проверки такому же клиенту передает)
    @PostMapping("/update")
    public Order update(@RequestParam Integer id,
                        @RequestParam (required = false) Integer clientId) {
     //   Order order = new Order();
        if (id != null && daoOrder.findById(id).isPresent()){
            Order order = daoOrder.findById(id).get();
            System.out.println(daoClient.findById(clientId).isPresent());
            if (clientId !=null && daoClient.findById(clientId).isPresent()) {
                order.setClient(daoClient.findById(clientId).get());
                return daoOrder.update(order);
            }
        }
        return null;
    }

    @GetMapping("/delete")
    public Order delete(@RequestParam Integer id){
        return daoOrder.delete(id);
    }


}
