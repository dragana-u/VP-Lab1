package mk.finki.ukim.mk.lab.repository.inMemory;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.exceptions.LocationNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryEventRepository {

    private final InMemoryLocationRepository inMemoryLocationRepository;

    public InMemoryEventRepository(InMemoryLocationRepository inMemoryLocationRepository) {
        this.inMemoryLocationRepository = inMemoryLocationRepository;
    }

    public List<Event> findAll(){
        return DataHolder.events;
    }

    public List<Event> searchEvents(String text){
        return DataHolder.events
                .stream()
                .filter(e -> e.getName().toLowerCase().contains(text.toLowerCase()) || e.getDescription().toLowerCase().contains(text.toLowerCase()))
                .toList();
    }

    public List<Event> searchByRating(Double rating) {
        return DataHolder.events
                .stream()
                .filter(e -> e.getPopularityScore() >= rating)
                .toList();
    }

    public Optional<Event> findEventById(Long id) {
        return DataHolder.events
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public boolean deleteEvent(Long id) {
        return DataHolder.events.removeIf(e -> e.getId().equals(id));
    }

    public Optional<Event> fillInEventPropertiesAndSave(Event event, String name, String description, double popularityScore, Long locationId){
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(inMemoryLocationRepository.findById(locationId).orElseThrow(() -> new LocationNotFoundException(locationId)));
        DataHolder.events.removeIf(e -> e.getId().equals(event.getId()));
        DataHolder.events.add(event);
        return Optional.of(event);
    }

    public Optional<Event> updateOrCreateEvent(Long eventId,String name, String description, double popularityScore,Long locationId) {
        if (name == null || description == null || popularityScore < 0 || locationId == null){
            throw new IllegalArgumentException();
        }
        Optional<Event> event = DataHolder.events.stream()
                .filter(e -> e.getId().equals(eventId))
                .findFirst();
        return fillInEventPropertiesAndSave(event.orElseGet(Event::new), name, description, popularityScore, locationId);
    }

}
