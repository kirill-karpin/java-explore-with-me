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
  @Column(name = "likeid", nullable = false)
  private Long id;

  @Column(name = "entitytype", length = Integer.MAX_VALUE)
  private String entityType;

  @Column(name = "entityid")
  private Long entityId;

  @Column(name = "value")
  private Long value;

  @Column(name = "createdat")
  private Instant createdAt;

  @Column(name = "userid")
  private Long userId;

  @Column(name = "message", length = Integer.MAX_VALUE)
  private String message;

  @Column(name = "updatedat")
  private Instant updatedAt;

}
