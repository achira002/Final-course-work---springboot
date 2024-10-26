package com.ijse.pointofsales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pointofsales.entity.StockLocation;
import com.ijse.pointofsales.service.LocationService;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "*")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<StockLocation>> getAllLocations() {
        List<StockLocation> location = locationService.getAllLocations();
        return ResponseEntity.ok(location);
    }

    @PostMapping
    public ResponseEntity<StockLocation> createLocations(@RequestBody StockLocation locations) {
        StockLocation location = locationService.createLocation(locations);
        return ResponseEntity.ok(location);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockLocation> getLocationById(@PathVariable Long id) {
        StockLocation location = locationService.getLocationById(id);
        if (location != null) {
            return ResponseEntity.ok(location);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockLocation> updateLocation(@PathVariable Long id, @RequestBody StockLocation locations) {
        StockLocation createdLocation = locationService.updateLocation(id, locations);
        if (createdLocation != null) {
            return ResponseEntity.ok(createdLocation);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }

}
