package org.top.ordersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.top.ordersapi.model.dao.client.IDaoClient;
import org.top.ordersapi.model.dao.order.IDaoOrder;
import org.top.ordersapi.model.entity.Client;
import org.top.ordersapi.model.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IDaoClient daoClient;
  //  private IDaoOrder daoOrder;


    @GetMapping("/all")
    public List<Client> all(){
        return daoClient.findAll();
    }

    @GetMapping("/get")
    public Optional<Client> get(@RequestParam Integer id){
        return (Optional<Client>) daoClient.findById(id);
    }

//    @PostMapping("/save")
//    public Client save(@RequestParam String name, @RequestParam Integer ordersId){
//       // Set<Order> orders = daoOrder.findById(ordersId).get();
//        Client client =new Client(name,);
//
//        return daoClient.save(client);
//    }



}
