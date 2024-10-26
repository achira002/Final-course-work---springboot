package com.ijse.pointofsales.service;


import java.util.List;

import com.ijse.pointofsales.entity.StockLocation;

public interface LocationService {
    List<StockLocation> getAllLocations();

    StockLocation createLocation(StockLocation Location);

    StockLocation getLocationById(Long id);

    StockLocation updateLocation(Long id, StockLocation locations);

    void deleteLocation(Long id);
}
