package ru.practicum.ewmmainservice.core.like.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.ewmmainservice.core.like.EntityTypeEnum;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLikeDto {

  @NotNull
  private EntityTypeEnum entityType;
  @NotNull
  private Long entityId;
  @NotNull
  private Long value;
  @NotNull
  private Long userId;
  private Instant createdAt = Instant.now();
  private Instant updatedAt = Instant.now();
  @Nullable
  private String message;

}
