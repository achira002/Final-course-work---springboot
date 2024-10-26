package com.ijse.pointofsales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pointofsales.entity.StockLocation;
import com.ijse.pointofsales.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<StockLocation> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public StockLocation createLocation(StockLocation locations) {
        return locationRepository.save(locations);
    }

    @Override
    public StockLocation getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public StockLocation updateLocation(Long id, StockLocation locations) {
        StockLocation exisistingLoc = locationRepository.findById(id).orElse(null);

        if (exisistingLoc == null) {
            return null;
        } else {
            exisistingLoc.setName(locations.getName());
            return locationRepository.save(exisistingLoc);
        }
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }

}
