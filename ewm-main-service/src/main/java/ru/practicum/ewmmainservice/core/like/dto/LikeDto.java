package ru.practicum.ewmmainservice.core.like.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.ewmmainservice.core.like.EntityTypeEnum;
import ru.practicum.ewmmainservice.core.like.Like;

/**
 * DTO for {@link Like}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {

  private Long id;
  private EntityTypeEnum entityType;
  private Long entityId;
  private Long value;
  private Instant createdAt;
  private Long userId;
  private String message;
  private Instant updatedAt;
  private EntityData entity;

}
