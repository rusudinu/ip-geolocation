package com.codingshadows.ipgeolocation.scheduled;

import com.codingshadows.ipgeolocation.service.GeoDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeoData {
    private final GeoDataService geoDataService;

    @Scheduled(cron = "0 0 * * * *")
    public void removeExpiredGeoData() {
        geoDataService.removeExpiredGeoData();
    }
}
