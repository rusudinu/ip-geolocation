package com.codingshadows.ipgeolocation.controller;

import com.codingshadows.ipgeolocation.service.GeoDataService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class GeoDataController {
    private final GeoDataService geoDataService;

    @GetMapping("get/{ip}")
    public Object getGeoData(@PathVariable String ip) {
        return geoDataService.getGeoData(ip);
    }
}