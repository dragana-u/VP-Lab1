package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.repository.inMemory.InMemoryEventBookingRepository;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    private final InMemoryEventBookingRepository inMemoryEventBookingRepository;

    public EventBookingServiceImpl(InMemoryEventBookingRepository inMemoryEventBookingRepository) {
        this.inMemoryEventBookingRepository = inMemoryEventBookingRepository;
    }

    @Override
    public EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        return inMemoryEventBookingRepository.save(new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets));
    }

    @Override
    public List<EventBooking> findAll() {
        return inMemoryEventBookingRepository.findAll();
    }

    @Override
    public Optional<EventBooking> findById(Long id) {
        return inMemoryEventBookingRepository.findById(id);
    }

    @Override
    public List<EventBooking> byUser(String attendeeName) {
        return inMemoryEventBookingRepository.byUser(attendeeName);
    }

    @Override
    public List<EventBooking> findByEvent(String eventName) {
        return inMemoryEventBookingRepository.findByEvent(eventName);
    }
}
