package ru.practicum.ewmmainservice.common;

import java.util.List;

public interface CRUDService<T, CreateDto, UpdateDto, EntityDto> {

  EntityDto create(CreateDto createDto);

  EntityDto update(T id, UpdateDto updateDto);

  void delete(T id);

  List<EntityDto> getList();

  EntityDto getById(T id);
}
