package ru.practicum.ewmmainservice.core.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.ewmmainservice.core.participation.ParticipationRequest;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userid", nullable = false)
  private Long id;

  @Size(max = 250)
  @NotNull
  @Column(name = "name", nullable = false, length = 250)
  private String name;

  @Size(max = 254)
  @NotNull
  @Column(name = "email", nullable = false, length = 254)
  private String email;

  @OneToMany(mappedBy = "requesterid")
  private Set<ParticipationRequest> participationRequests = new LinkedHashSet<>();

}
