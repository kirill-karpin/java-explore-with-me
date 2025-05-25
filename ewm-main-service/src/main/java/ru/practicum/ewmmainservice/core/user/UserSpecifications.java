package ru.practicum.ewmmainservice.core.user;

import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

  public static Specification<User> inIds(List<Long> ids) {
    return (root, query, cb) ->
        ids == null ? null : root.get("id").in(ids);
  }
}
