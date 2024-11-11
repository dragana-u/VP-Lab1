package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.exceptions.EventNotFoundException;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final LocationService locationService;

    public EventController(EventService eventService, LocationService locationService) {
        this.eventService = eventService;
        this.locationService = locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Event> events = eventService.listAll();
        model.addAttribute("events", events);

        return "listEvents";
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.findEventById(id).orElseThrow(() -> new EventNotFoundException(id));
        eventService.deleteEventById(id);
        return "redirect:/events";
    }

    @GetMapping("/edit-form/{id}")
    public String editEventsPage(@PathVariable Long id, Model model) {
        if (this.eventService.findEventById(id).isPresent()) {
            List<Location> locations = locationService.findAll();
            model.addAttribute("locations", locations);
            model.addAttribute("event", this.eventService.findEventById(id).get());
            return "add-event";
        }
        return "redirect:/events?error=EventNotFound";
    }


    @GetMapping("/add-form")
    public String addEventPage(Model model) {
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        return "add-event";
    }

    @PostMapping("/add")
    public String saveEvent(@RequestParam (required = false) Long eventId,
                            @RequestParam String name,
                            @RequestParam String description,
                            @RequestParam Double popularityScore,
                            @RequestParam Long locationId) {
        this.eventService.updateOrCreateEvent(eventId, name, description, popularityScore, locationId);
        return "redirect:/events";
    }


}
