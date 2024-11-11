package mk.finki.ukim.mk.lab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EventBookingNotFoundException extends RuntimeException {
    public EventBookingNotFoundException(Long id) {
        super(String.format("EventBooking with id %d was not found", id));
    }
}
