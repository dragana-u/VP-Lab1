package mk.finki.ukim.mk.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.inMemory.InMemoryLocationRepository;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final InMemoryLocationRepository inMemoryLocationRepository;
    private final LocationRepository locationRepository;

    @Override
    public List<Location> findAll() {
//        return inMemoryLocationRepository.findAll();
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
//        return inMemoryLocationRepository.findById(id);
        return locationRepository.findById(id);
    }


}
