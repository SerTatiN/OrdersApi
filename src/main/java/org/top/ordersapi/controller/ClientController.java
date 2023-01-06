package org.top.ordersapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.top.ordersapi.model.dao.client.IDaoClient;
import org.top.ordersapi.model.dao.order.IDaoOrder;
import org.top.ordersapi.model.entity.Client;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IDaoClient daoClient;
    @Autowired
    private IDaoOrder daoOrder;


    @GetMapping("/all")
    public List<Client> all(){
        return daoClient.findAll();
    }

    @GetMapping("/get")
    public Optional<Client> get(@RequestParam Integer id){
        return (Optional<Client>) daoClient.findById(id);
    }

    @PostMapping("/save")
    public Client save(@RequestParam String name){

        if (name != null) {
            Client client = new Client();
            client.setName(name);
            return daoClient.save(client);
        }
        return null;
    }

    @PostMapping("/update")
    public Client update(@RequestParam Integer id,
                         @RequestParam (required = false) String name,
                         @RequestParam (required = false) Integer orderId){

        if (daoClient.findById(id).isPresent()) {
            System.out.println(id);

            Client client = daoClient.findById(id).get();

            if (name != null) {
                client.setName(name);
            }
            if (orderId != null && daoOrder.findById(orderId).isPresent()) {
                client.getOrders().add(daoOrder.findById(orderId).get());
            }
            return daoClient.update(client);
        }
        return null;
    }

    @GetMapping("/delete")
    public Client delete(@RequestParam Integer id){
        return daoClient.delete(id);
    }

}
