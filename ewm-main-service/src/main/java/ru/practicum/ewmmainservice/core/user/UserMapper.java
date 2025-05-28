package ru.practicum.ewmmainservice.core.user;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.ewmmainservice.core.user.dto.CreateUserDto;
import ru.practicum.ewmmainservice.core.user.dto.UpdateUserDto;
import ru.practicum.ewmmainservice.core.user.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDto toDto(User user);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "participationRequests", ignore = true)
  User toEntity(CreateUserDto userRequest);

  @Mapping(target = "participationRequests", ignore = true)
  User toEntity(UpdateUserDto userRequest);

}
