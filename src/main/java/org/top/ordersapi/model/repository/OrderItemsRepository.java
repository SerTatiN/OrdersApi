package org.top.ordersapi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.ordersapi.model.entity.OrderItems;

public interface OrderItemsRepository extends CrudRepository<OrderItems,Integer> {
}
