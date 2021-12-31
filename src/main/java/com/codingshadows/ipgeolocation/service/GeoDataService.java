package com.codingshadows.ipgeolocation.service;

import com.codingshadows.ipgeolocation.data.GeoCacheData;
import com.codingshadows.romanabac.model.GeoCache;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class GeoDataService {
    public void removeExpiredGeoData() {
        GeoCacheData.ipData.entrySet().removeIf(entry -> entry.getValue().getSaveTime().isBefore(TimeService.getCurrentLocalDate().minusDays(1)));
    }

    public Object getGeoData(String remoteIP) {
        if (remoteIP == null)
            return null;
        if (GeoCacheData.ipData.containsKey(remoteIP))
            return GeoCacheData.ipData.get(remoteIP).getGeoData();

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
            return json;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
