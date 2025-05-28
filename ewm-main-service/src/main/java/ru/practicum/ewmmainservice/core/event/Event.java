package ru.practicum.ewmmainservice.core.event;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Formula;
import ru.practicum.ewmmainservice.core.category.Category;
import ru.practicum.ewmmainservice.core.compilation.Compilation;
import ru.practicum.ewmmainservice.core.participation.ParticipationRequest;
import ru.practicum.ewmmainservice.core.user.User;

@Getter
@Setter
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "eventid", nullable = false)
  private Long id;

  @Size(max = 2000)
  @NotNull
  @Column(name = "annotation", nullable = false, length = 2000)
  private String annotation;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "categoryid", nullable = false)
  private Category categoryid;

  @NotNull
  @Column(name = "created_on", nullable = false)
  private Instant createdOn;

  @Column(name = "published_on")
  private Instant publishedOn;

  @Size(max = 7000)
  @NotNull
  @Column(name = "description", nullable = false, length = 7000)
  private String description;

  @NotNull
  @Column(name = "event_date", nullable = false)
  private Instant eventDate;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "initiatorid", nullable = false)
  private User initiatorid;

  @NotNull
  @Column(name = "paid", nullable = false)
  private Boolean paid = false;

  @Column(name = "participant_limit")
  private Integer participantLimit;

  @NotNull
  @Column(name = "state", nullable = false, length = 50)
  private String state;

  @Column(name = "request_moderation")
  private Boolean requestModeration;

  @Size(max = 120)
  @NotNull
  @Column(name = "title", nullable = false, length = 120)
  private String title;

  @NotNull
  @Column(name = "lat", nullable = false)
  private Double lat;

  @NotNull
  @Column(name = "lon", nullable = false)
  private Double lon;

  @ManyToMany
  private Set<Compilation> compilations = new LinkedHashSet<>();

  @OneToMany(mappedBy = "eventid")
  private Set<ParticipationRequest> participationRequests = new LinkedHashSet<>();

  @ColumnDefault("0")
  @Column(name = "views")
  private Long views;

  @Formula("(SELECT COUNT(pr.requestid) FROM participation_requests pr "
      + "WHERE pr.eventid = eventid AND pr.status = '3')")
  private Integer confirmedRequests;

  public boolean isPublished() {
    return state.equals(EventState.PUBLISHED.name());
  }

}
