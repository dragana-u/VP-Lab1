package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.repository.EventBookingRepository;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    private final EventBookingRepository eventBookingRepository;

    public EventBookingServiceImpl(EventBookingRepository eventBookingRepository) {
        this.eventBookingRepository = eventBookingRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        return eventBookingRepository.save(new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets));
    }

    @Override
    public List<EventBooking> findAll() {
        return eventBookingRepository.findAll();
    }

    @Override
    public Optional<EventBooking> findById(Long id) {
        return eventBookingRepository.findById(id);
    }

    @Override
    public List<EventBooking> byUser(String attendeeName) {
        return eventBookingRepository.byUser(attendeeName);
    }
}
