package ru.practicum.statserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.statserver.model.Hit;

public interface HitRepository extends JpaRepository<Hit, Long>, HitRepositoryCustom {

}
