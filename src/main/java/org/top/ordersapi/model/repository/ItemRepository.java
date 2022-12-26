package org.top.ordersapi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.ordersapi.model.entity.Item;

//JPA_репозиторий для работы с сущностью Item
public interface ItemRepository extends CrudRepository<Item,Integer> {


}
