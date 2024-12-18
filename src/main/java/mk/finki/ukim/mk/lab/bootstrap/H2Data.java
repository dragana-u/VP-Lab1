package mk.finki.ukim.mk.lab.bootstrap;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class H2Data implements CommandLineRunner {
    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    @Override
    public void run(String... args) {
        if (locationRepository.count() == 0) {
            List<Location> locations = new ArrayList<>();
            locations.add(new Location("Location1", "Address1", "Capacity1", "Description1"));
            locations.add(new Location("Location2", "Address2", "Capacity2", "Description2"));
            locations.add(new Location("Location3", "Address3", "Capacity3", "Description3"));

            locationRepository.saveAll(locations);

            List<Event> events = new ArrayList<>();
            events.add(new Event("Event1test", "Desc1", 4.6, locations.get(0)));
            events.add(new Event("Event2", "Desc2", 4.2, locations.get(1)));
            events.add(new Event("Event3", "Desc3", 3.9, locations.get(2)));

            eventRepository.saveAll(events);
        }
    }
}