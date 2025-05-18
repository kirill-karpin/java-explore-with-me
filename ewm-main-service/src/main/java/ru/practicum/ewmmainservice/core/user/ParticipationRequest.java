package ru.practicum.ewmmainservice.core.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.ewmmainservice.core.event.Event;

@Getter
@Setter
@Entity
@Table(name = "participation_requests")
public class ParticipationRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "requestid", nullable = false)
  private Long id;

  @NotNull
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "eventid", nullable = false)
  private Event eventid;

  @NotNull
  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "requesterid", nullable = false)
  private User requesterid;

  @NotNull
  @Column(name = "created", nullable = false)
  private Instant created;

  @Size(max = 50)
  @NotNull
  @Column(name = "status", nullable = false, length = 50)
  private String status;

}
