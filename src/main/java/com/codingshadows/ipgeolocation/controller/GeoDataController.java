package com.codingshadows.ipgeolocation.controller;

import com.codingshadows.ipgeolocation.service.GeoDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.Map;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class GeoDataController {
    private final GeoDataService geoDataService;

    @GetMapping("get/{ip}")
    public Map getGeoData(@PathVariable @Pattern(regexp = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$") String ip) throws JsonProcessingException {
        if (ip == null || ip.equals("null"))
            return null;
        return new ObjectMapper().readValue(geoDataService.getGeoData(ip).toString(), Map.class);
    }
}
