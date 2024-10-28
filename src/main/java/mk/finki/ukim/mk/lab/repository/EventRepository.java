package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {

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
}
