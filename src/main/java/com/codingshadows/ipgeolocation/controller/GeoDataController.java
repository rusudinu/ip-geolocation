package com.codingshadows.ipgeolocation.controller;

import com.codingshadows.ipgeolocation.service.GeoDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class GeoDataController {
    private final GeoDataService geoDataService;

    @GetMapping("get/{ip}")
    public Map getGeoData(@PathVariable String ip) throws JsonProcessingException {
        return new ObjectMapper().readValue(geoDataService.getGeoData(ip).toString(), Map.class);
    }
}