package org.top.ordersapi.model.dao.item;

import org.springframework.stereotype.Service;
import org.top.ordersapi.model.entity.Item;

import java.util.List;

//dao-интерфейс для сущности item

public interface IDaoItem {
    List<Item> findAll(); // получить все объекты
    Item findById(Integer id);      // получить объект по id
    Item save(Item item);  //сохранить
    Item update(Item item); // обновление
    Item delete(Integer id); //удалить объект




}
