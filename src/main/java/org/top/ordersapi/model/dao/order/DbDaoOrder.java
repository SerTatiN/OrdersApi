package org.top.ordersapi.model.dao.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.top.ordersapi.model.entity.Order;
import org.top.ordersapi.model.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class DbDaoOrder implements IDaoOrder {
    @Autowired
    private OrderRepository orderRepository;
   @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return (Optional<Order>) orderRepository.findById(id);
    }

    @Override
    public Order save(Order item) {
        return null;
    }

    @Override
    public Order update(Order item) {
        return null;
    }

    @Override
    public Order delete(Integer id) {
        return null;
    }




}
