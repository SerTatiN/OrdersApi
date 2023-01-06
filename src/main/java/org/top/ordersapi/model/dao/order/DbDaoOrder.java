package org.top.ordersapi.model.dao.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.ordersapi.model.entity.Order;
import org.top.ordersapi.model.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
@Service
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
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
       return orderRepository.save(order);
    }

    @Override
    public Order delete(Integer id) {
        if (orderRepository.findById(id).isPresent()) {
            Order order = orderRepository.findById(id).get();
            orderRepository.deleteById(id);
            return order;
        }
       return null;
    }




}
