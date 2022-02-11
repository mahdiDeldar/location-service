package com.chubock.locationservice.endpoint.geocode;

import com.chubock.locationservice.endpoint.geocode.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "geocode", url = "${endpoints.google.baseUrl}")
public interface GeocodingFeignClient {

    @GetMapping("/geocode/json")
    Response geocode(@RequestParam("key") String apiKey, @RequestParam("address") String address);

    @GetMapping("/geocode/json")
    Response geocode(@RequestParam("key") String apiKey,
                   @RequestParam("address") String address,
                   @RequestParam("bounds") String bounds);

    @GetMapping("/geocode/json")
    Response reverseGeocode(@RequestParam("key") String apiKey,
                   @RequestParam("latlng") String latlng);

    @GetMapping("/geocode/json")
    Response placeGeocode(@RequestParam("key") String apiKey,
                            @RequestParam("place_id") String placeId);

}
