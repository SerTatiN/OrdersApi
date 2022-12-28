package org.top.ordersapi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.ordersapi.model.entity.Order;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
