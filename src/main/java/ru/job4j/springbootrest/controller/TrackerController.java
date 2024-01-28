package ru.job4j.springbootrest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.springbootrest.dto.ItemDtoRequest;
import ru.job4j.springbootrest.dto.ItemDtoResponse;
import ru.job4j.springbootrest.model.Item;
import ru.job4j.springbootrest.service.TrackerService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/item")
public class TrackerController {
    private final TrackerService trackerService;

    @PostMapping
    public ItemDtoResponse save(@RequestBody ItemDtoRequest itemDtoRequest) {
        return trackerService.save(itemDtoRequest);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestParam int id,
                                             @RequestBody Item item) {
        boolean status = trackerService.update(id, item);
        return ResponseEntity.status(status ?
                HttpStatus.OK : HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam int id) {
        trackerService.delete(id);
    }

    @GetMapping("/getById")
    public Item getById(@RequestParam int id) {
        return trackerService.findById(id);
    }

    @GetMapping("/getByName")
    public List<Item> getByName(@RequestParam String name) {
        return trackerService.findByName(name);
    }

    @GetMapping("/getAll")
    public List<Item> getAll() {
        return trackerService.findAll();
    }
}