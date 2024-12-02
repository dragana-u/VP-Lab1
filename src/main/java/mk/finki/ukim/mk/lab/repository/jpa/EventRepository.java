package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findEventById(Long id);
    List<Event> findAllByPopularityScore(double popularityScore);
    List<Event> findAllByDescription(String description);
    List<Event> findAllByLocation_Id(Long locationId);
}
