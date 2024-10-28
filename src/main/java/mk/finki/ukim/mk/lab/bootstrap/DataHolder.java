package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = null;
    public static List<EventBooking> eventBookings = null;

    @PostConstruct
    public void init(){
        events = new ArrayList<>();
        events.add(new Event("Event1test", "Desc1", 4.6));
        events.add(new Event("Event2", "Desc2", 4.2));
        events.add(new Event("Event3", "Desc3", 3.9));
        events.add(new Event("Event4", "Desc4", 3.5));
        events.add(new Event("Event5", "Desc5", 2.3));
        events.add(new Event("Event6", "Desc6test", 2.0));
        events.add(new Event("Event7", "Desc7", 1.9));
        events.add(new Event("Event8", "Desc8", 1.3));
        events.add(new Event("Event9", "Desc9", 0.5));
        events.add(new Event("Event10", "Desc10", 5.0));

        eventBookings = new ArrayList<>();
        eventBookings.add(new EventBooking("Event1test", "Attendee1", "Address1", 3L));
    }
}
