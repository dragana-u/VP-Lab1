package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = null;
    public static List<EventBooking> eventBookings = null;
    public static List<Location> locations = null;

    @PostConstruct
    public void init(){
        locations = new ArrayList<>();
        locations.add(new Location("Location1", "Address1", "Capacity1", "Description1"));
        locations.add(new Location("Location2", "Address2", "Capacity2", "Description2"));
        locations.add(new Location("Location3", "Address3", "Capacity3", "Description3"));
        locations.add(new Location("Location4", "Address4", "Capacity4", "Description4"));
        locations.add(new Location("Location5", "Address5", "Capacity5", "Description5"));

        events = new ArrayList<>();
        events.add(new Event("Event1test", "Desc1", 4.6, locations.get(0)));
        events.add(new Event("Event2", "Desc2", 4.2, locations.get(1)));
        events.add(new Event("Event3", "Desc3", 3.9, locations.get(2)));
        events.add(new Event("Event4", "Desc4", 3.5, locations.get(3)));
        events.add(new Event("Event5", "Desc5", 2.3, locations.get(4)));
        events.add(new Event("Event6", "Desc6test", 2.0, locations.get(0)));
        events.add(new Event("Event7", "Desc7", 1.9, locations.get(1)));
        events.add(new Event("Event8", "Desc8", 1.3, locations.get(2)));
        events.add(new Event("Event9", "Desc9", 0.5, locations.get(3)));
        events.add(new Event("Event10", "Desc10", 5.0, locations.get(4)));

        eventBookings = new ArrayList<>();
        eventBookings.add(new EventBooking("Event1test", "Attendee1", "Address1", 3L));
    }
}
