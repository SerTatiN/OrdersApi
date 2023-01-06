package org.top.ordersapi.model.dao.orderItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.ordersapi.model.entity.OrderItems;
import org.top.ordersapi.model.repository.OrderItemsRepository;

import java.util.List;
import java.util.Optional;
@Service
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
    public OrderItems save(OrderItems orderItem) {
        return orderItemsRepository.save(orderItem);
    }

    @Override
    public OrderItems update(OrderItems orderItem) {

        return orderItemsRepository.save(orderItem);
    }

    @Override
    public OrderItems delete(Integer id) {
        if (orderItemsRepository.findById(id).isPresent()) {
            OrderItems orderItem = orderItemsRepository.findById(id).get();
            orderItemsRepository.deleteById(id);
            return orderItem;
        }
        return null;
    }
}
