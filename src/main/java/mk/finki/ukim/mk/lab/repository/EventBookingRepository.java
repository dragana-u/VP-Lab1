package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EventBookingRepository {

    public List<EventBooking> findAll(){
        return DataHolder.eventBookings;
    }

    public EventBooking save(EventBooking eventBooking){
        DataHolder.eventBookings.add(eventBooking);
        return eventBooking;
    }

    public List<EventBooking> byUser(String attendeeName) {
        return DataHolder.eventBookings.stream().filter(r -> r.getAttendeeName().equals(attendeeName)).toList();
    }

    public Optional<EventBooking> findById(Long id) {
        return DataHolder.eventBookings.stream().filter(b -> b.getId().equals(id)).findFirst();
    }
}
