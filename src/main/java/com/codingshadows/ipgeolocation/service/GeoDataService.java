package com.codingshadows.ipgeolocation.service;

import com.codingshadows.ipgeolocation.data.GeoCacheData;
import com.codingshadows.ipgeolocation.model.GeoCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@Slf4j
@RequiredArgsConstructor
public class GeoDataService {
    public void removeExpiredGeoData() {
        GeoCacheData.ipData.entrySet().removeIf(entry -> entry.getValue().getSaveTime().isBefore(TimeService.getCurrentLocalDate().minusDays(1)));
    }

    public Object getGeoData(String remoteIP) {
        if (remoteIP == null) {
            log.warn("remoteIP was null");
            return null;
        }
        if (GeoCacheData.ipData.containsKey(remoteIP)) {
            log.info("remoteIP was found in cache for remoteIP: " + remoteIP);
            return GeoCacheData.ipData.get(remoteIP).getGeoData();
        }
        log.info("remoteIP was not found in cache, requesting from remote");
        String url = "http://www.geoplugin.net/json.gp?ip=" + remoteIP;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder locationResponse = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                locationResponse.append(inputLine);
            }
            in.close();
            JSONObject json = new JSONObject(locationResponse.toString());
            GeoCacheData.ipData.put(remoteIP, GeoCache.builder().geoData(json).saveTime(TimeService.getCurrentLocalDate()).ip(remoteIP).build());
            log.info("found and parsed data for remoteIP: " + remoteIP);
            return json;
        } catch (IOException e) {
            log.warn("request failed");
            e.printStackTrace();
            return null;
        }
    }
}
