package ru.practicum.ewmmainservice.core.user;

import java.util.List;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.controller.admin.dto.AdminUserFilter;
import ru.practicum.ewmmainservice.core.like.dto.LikeDto;
import ru.practicum.ewmmainservice.core.user.dto.CreateUserDto;
import ru.practicum.ewmmainservice.core.user.dto.UpdateUserDto;
import ru.practicum.ewmmainservice.core.user.dto.UserDto;

public interface UserService {

  UserDto create(CreateUserDto createUserDto);

  UserDto update(Long userId, UpdateUserDto updateUserDto);

  void delete(Long categoryId);

  List<UserDto> getList();

  List<UserDto> getList(AdminUserFilter filter);

  List<LikeDto> getUserLikes(Long userId, Paging paging);
}
