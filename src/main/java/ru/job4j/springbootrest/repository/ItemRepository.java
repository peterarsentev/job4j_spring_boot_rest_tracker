package ru.job4j.springbootrest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.springbootrest.model.Item;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    List<Item> findByNameIgnoreCase(String name);
}