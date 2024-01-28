package ru.job4j.springbootrest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.springbootrest.dto.ItemDtoRequest;
import ru.job4j.springbootrest.dto.ItemDtoResponse;
import ru.job4j.springbootrest.model.Item;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDtoRequest detDtoRequest(Item item);
    @Mapping(target = "id", constant = "0")
    Item getItemFromDtoRequest(ItemDtoRequest itemDtoRequest);
    ItemDtoResponse getDtoResponse(Item item);
    @Mapping(target = "id", constant = "0")
    Item detEntity(ItemDtoRequest dto);
}
