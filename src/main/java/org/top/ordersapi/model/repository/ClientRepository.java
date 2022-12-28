package org.top.ordersapi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.top.ordersapi.model.entity.Client;

public interface ClientRepository extends CrudRepository<Client,Integer> {

}
