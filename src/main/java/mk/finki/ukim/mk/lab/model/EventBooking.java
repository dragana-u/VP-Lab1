package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class EventBooking {
    Long id;
    String eventName;
    String attendeeName;
    String attendeeAddress;
    Long numberOfTickets;

    public EventBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        this.id = (long) (Math.random() * 1000);
        this.eventName = eventName;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }
}
