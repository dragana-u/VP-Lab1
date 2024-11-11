package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();

    List<Event> searchEvents(String text);

    List<Event> searchByRating(Double rating);

    Optional<Event> findEventById(Long id);

    boolean deleteEventById(Long id);

    Optional<Event> updateOrCreateEvent(Long eventId,String name, String description, double popularityScore, Long locationId);
}
