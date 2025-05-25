package ru.practicum.ewmmainservice.core.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>,
    JpaSpecificationExecutor<User> {

}
