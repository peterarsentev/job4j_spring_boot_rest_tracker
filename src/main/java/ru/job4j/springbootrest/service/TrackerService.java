package ru.job4j.springbootrest.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.springbootrest.dto.ItemDtoRequest;
import ru.job4j.springbootrest.dto.ItemDtoResponse;
import ru.job4j.springbootrest.mappers.ItemMapper;
import ru.job4j.springbootrest.model.Item;
import ru.job4j.springbootrest.repository.ItemRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TrackerService {
    private final ItemRepository repository;
    private final ItemMapper itemMapper;

    public ItemDtoResponse save(ItemDtoRequest dtoRequest) {
        Item item = itemMapper.getItemFromDtoRequest(dtoRequest);
        repository.save(item);
        return itemMapper.getDtoResponse(item);
    }

    public boolean update(int id, Item item) {
        boolean result = repository.existsById(id);
        if (result) {
            item.setId(id);
            repository.save(item);
        }
        return result;
    }

    public void delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    public Item findById(int id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Item> findByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }

    public List<Item> findAll() {
        return (List<Item>) repository.findAll();
    }
}
