package ru.practicum.ewmmainservice.core.participation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.ewmmainservice.core.event.EventMapper;

@Mapper(componentModel = "spring", uses = {EventMapper.class})
public interface ParticipationRequestMapper {

  @Mapping(target = "event", source = "eventid.id")
  @Mapping(target = "requester", source = "requesterid.id")
  ParticipationRequestDto toDto(ParticipationRequest participationRequest);

  /*@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  ParticipationRequest partialUpdate(
      ParticipationRequestDto participationRequestDto,
      @MappingTarget ParticipationRequest participationRequest);*/
}
