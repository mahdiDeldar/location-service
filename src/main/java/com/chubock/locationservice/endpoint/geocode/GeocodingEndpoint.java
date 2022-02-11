package com.chubock.locationservice.endpoint.geocode;

import com.chubock.locationservice.endpoint.geocode.dto.Response;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class GeocodingEndpoint {

    private final String apiKey;

    private final GeocodingFeignClient geocodingFeignClient;

    public GeocodingEndpoint(@Value("${endpoints.google.apiKey}") String apiKey, GeocodingFeignClient geocodingFeignClient) {
        this.apiKey = apiKey;
        this.geocodingFeignClient = geocodingFeignClient;
    }

    public Response geocode(String address) {
        return geocodingFeignClient.geocode(apiKey, encode(address));
    }

    public Response geocode(String address, Double lat, Double lon) {

        return geocodingFeignClient.geocode(apiKey, encode(address), lat + "," + lon + "|" + lat + "," + lon);
    }

    public Response reverseGeocode(Double lat, Double lon) {
        return geocodingFeignClient.reverseGeocode(apiKey, lat + "," + lon);
    }

    public Response placeGeocode(String placeId) {
        return geocodingFeignClient.placeGeocode(apiKey, placeId);
    }

    @SneakyThrows
    private String encode(String address) {
        return URLEncoder.encode(address, StandardCharsets.UTF_8.toString());
    }
}
