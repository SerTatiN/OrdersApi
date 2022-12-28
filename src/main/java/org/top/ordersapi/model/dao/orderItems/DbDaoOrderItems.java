package org.top.ordersapi.model.dao.orderItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.top.ordersapi.model.entity.OrderItems;
import org.top.ordersapi.model.repository.OrderItemsRepository;

import java.util.List;
import java.util.Optional;

public class DbDaoOrderItems implements IDaoOrderItems{
    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Override
    public List<OrderItems> findAll() {
        return (List<OrderItems>) orderItemsRepository.findAll();
    }

    @Override
    public Optional<OrderItems> findById(Integer id) {
        return (Optional<OrderItems>) orderItemsRepository.findById(id);
    }

    @Override
    public OrderItems save(OrderItems item) {
        return null;
    }

    @Override
    public OrderItems update(OrderItems item) {
        return null;
    }

    @Override
    public OrderItems delete(Integer id) {
        return null;
    }
}
