package org.top.ordersapi.model.dao;

//import org.top.ordersapi.model.entity.E;

import java.util.List;
import java.util.Optional;

public interface  IDaoBase<E> {
    List<E> findAll(); // получить все объекты
    Optional<E> findById(Integer id);      // получить объект по id
    E save(E item);  //сохранить
    E update(E item); // обновление
    E delete(Integer id); //удалить объект
}
