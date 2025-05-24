package ru.practicum.ewmmainservice.core.event.service;

import jakarta.persistence.criteria.Join;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.jpa.domain.Specification;
import ru.practicum.ewmmainservice.core.category.Category;
import ru.practicum.ewmmainservice.core.event.Event;
import ru.practicum.ewmmainservice.core.event.EventState;

public class EventSpecifications {

  public static Specification<Event> hasTitle(String title) {
    return (root, query, cb) ->
        title == null ? null
            : cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
  }

  public static Specification<Event> isPaid(Boolean paid) {
    return (root, query, cb) ->
        paid == null ? null : cb.equal(root.get("paid"), paid);
  }

  public static Specification<Event> inCategories(List<Long> categoryIds) {
    return (root, query, cb) ->
        categoryIds == null ? null : root.get("categoryid").get("id").in(categoryIds);
  }

  public static Specification<Event> dateBetween(LocalDateTime start, LocalDateTime end) {
    return (root, query, cb) -> {
      if (start == null && end == null) {
        return null;
      }
      if (start == null) {
        return cb.lessThanOrEqualTo(root.get("eventDate"), end);
      }
      if (end == null) {
        return cb.greaterThanOrEqualTo(root.get("eventDate"), start);
      }
      return cb.between(root.get("eventDate"), start, end);
    };
  }

  public static Specification<Event> isAvailable(Boolean onlyAvailable) {
    return (root, query, cb) ->
        onlyAvailable == null || !onlyAvailable ? null
            : cb.greaterThan(root.get("availableSeats"), 0);
  }

  public static Specification<Event> withUsers(List<Long> userIds) {
    return (root, query, cb) -> {
      if (userIds == null || userIds.isEmpty() || (userIds.size() == 1 && userIds.get(0) == 0L)) {
        return cb.conjunction(); // no filter
      }
      return root.get("initiatorid").get("id").in(userIds);
    };
  }

  public static Specification<Event> withStates(List<String> states) {
    return (root, query, cb) -> {
      if (states == null || states.isEmpty()) {
        return cb.conjunction(); // no filter
      }
      return root.get("state").in(states);
    };
  }

  public static Specification<Event> withCategories(List<Long> categoryIds) {
    return (root, query, cb) -> {
      if (categoryIds == null || categoryIds.isEmpty() || (categoryIds.size() == 1
          && categoryIds.get(0) == 0L)) {
        return cb.conjunction();
      }

      Join<Event, Category> categoryJoin = root.join("categoryid");
      return categoryJoin.get("id").in(categoryIds);
    };
  }

}
