package ru.practicum.ewmmainservice.core.like.service;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.practicum.ewmmainservice.core.like.Like;
import ru.practicum.ewmmainservice.core.like.dto.CreateLikeDto;
import ru.practicum.ewmmainservice.core.like.dto.LikeDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface LikeMapper {

  Like toEntity(CreateLikeDto createLikeDto);

  LikeDto toDto(Like like);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Like partialUpdate(
      CreateLikeDto createLikeDto, @MappingTarget Like like);
}
