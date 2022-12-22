package org.top.ordersapi.model.dao.item;

import org.springframework.stereotype.Service;
import org.top.ordersapi.model.entity.Item;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class PlugDaoItems implements IDaoItem{
//фейковые данные

    private static List<Item> items = Arrays.asList(new Item(1, "Телевизор", 111L),
            new Item(2, "Холодильник", 222L),
            new Item(3, "X-Box", 333L));

    @Override
    public List<Item> findAll(){
        return items;
    }

    @Override
    public Item findById(Integer id) {
        return items.get(id);
    }

    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public Item delete(Integer id) {
        return null;
    }
}
