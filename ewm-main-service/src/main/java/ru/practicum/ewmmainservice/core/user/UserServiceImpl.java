package ru.practicum.ewmmainservice.core.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.controller.Paging;
import ru.practicum.ewmmainservice.controller.admin.dto.AdminUserFilter;
import ru.practicum.ewmmainservice.core.exceptions.ConflictException;
import ru.practicum.ewmmainservice.core.exceptions.NotFoundException;
import ru.practicum.ewmmainservice.core.like.dto.LikeDto;
import ru.practicum.ewmmainservice.core.like.service.LikeService;
import ru.practicum.ewmmainservice.core.user.dto.CreateUserDto;
import ru.practicum.ewmmainservice.core.user.dto.UpdateUserDto;
import ru.practicum.ewmmainservice.core.user.dto.UserDto;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper mapper;
  private final LikeService likeService;

  @Override
  public UserDto create(CreateUserDto createUserDto) {

    User user = mapper.toEntity(createUserDto);

    try {
      User createdUser = userRepository.save(user);

      return mapper.toDto(createdUser);
    } catch (DataIntegrityViolationException e) {
      throw new ConflictException("Integrity constraint has been violated", e.getMessage());
    }
  }

  @Override
  public UserDto update(Long userId, UpdateUserDto updateUserDto) {

    userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));

    User userToUpdate = mapper.toEntity(updateUserDto);
    userToUpdate.setId(userId);

    User updatedCategory = userRepository.save(userToUpdate);

    return mapper.toDto(updatedCategory);
  }

  @Override
  public void delete(Long categoryId) {

    userRepository.findById(categoryId)
        .orElseThrow(() -> new NotFoundException("User not found"));

    userRepository.deleteById(categoryId);
  }

  @Override
  public List<UserDto> getList() {
    return userRepository.findAll().stream().map(mapper::toDto).toList();
  }

  @Override
  public List<UserDto> getList(AdminUserFilter filter) {
    Specification<User> spec = Specification.where(
        UserSpecifications.inIds(filter.getIds())
    );

    Pageable pageable = filter.toPageable();

    return userRepository.findAll(spec, pageable)
        .stream().map(mapper::toDto).toList();
  }

  @Override
  public List<LikeDto> getUserLikes(Long userId, Paging paging) {
    return likeService.getUserLikes(userId, paging);
  }
}
