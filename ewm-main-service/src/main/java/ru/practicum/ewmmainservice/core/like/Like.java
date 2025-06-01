package ru.practicum.ewmmainservice.core.like;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "likes")
public class Like {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "likeId", nullable = false)
  private Long id;

  @Column(name = "entityType", length = Integer.MAX_VALUE)
  private String entityType;

  @Column(name = "entityId")
  private Long entityId;

  @Column(name = "val")
  private Long value;

  @Column(name = "createdAt")
  private Instant createdAt;

  @Column(name = "userId")
  private Long userId;

  @Column(name = "message", length = Integer.MAX_VALUE)
  private String message;

  @Column(name = "updatedAt")
  private Instant updatedAt;

}
