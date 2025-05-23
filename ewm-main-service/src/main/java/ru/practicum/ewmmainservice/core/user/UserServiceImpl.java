package ru.practicum.ewmmainservice.core.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.ewmmainservice.core.exceptions.NotFoundException;
import ru.practicum.ewmmainservice.core.user.dto.CreateUserRequest;
import ru.practicum.ewmmainservice.core.user.dto.UpdateUserRequest;
import ru.practicum.ewmmainservice.core.user.dto.UserResponse;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper mapper;

  @Override
  public UserResponse create(CreateUserRequest createUserRequest) {

    User user = mapper.toEntity(createUserRequest);
    User createdUser = userRepository.save(user);

    return mapper.toDto(createdUser);
  }

  @Override
  public UserResponse update(Long userId, UpdateUserRequest updateUserRequest) {

    userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));

    User userToUpdate = mapper.toEntity(updateUserRequest);
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
  public List<UserResponse> getList() {
    return userRepository.findAll().stream().map(mapper::toDto).toList();
  }
}
