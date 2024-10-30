package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.EventBooking;

import java.util.List;

public interface EventBookingService{
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets);

    List<EventBooking> findAll();

    List<EventBooking> byUser(String attendeeName);
}
