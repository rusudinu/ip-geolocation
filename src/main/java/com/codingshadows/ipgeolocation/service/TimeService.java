package com.codingshadows.ipgeolocation.service;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class TimeService {
    public static ZonedDateTime getCurrentLocalDate() {
        return ZonedDateTime.now(ZoneId.of("Europe/Bucharest"));
    }
}
