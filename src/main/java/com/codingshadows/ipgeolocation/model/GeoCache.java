package com.codingshadows.ipgeolocation.model;

import lombok.Builder;
import lombok.Data;
import org.json.JSONObject;

import java.time.ZonedDateTime;

@Data
@Builder
public class GeoCache {
    private final JSONObject geoData;
    private final ZonedDateTime saveTime;
    private final String ip;
}
