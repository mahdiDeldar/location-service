package com.chubock.locationservice.rest;

import com.chubock.locationservice.endpoint.geocode.GeocodingEndpoint;
import com.chubock.locationservice.endpoint.geocode.dto.Response;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/geocode")
public class GeocodeRestController {

    private final GeocodingEndpoint geocodingEndpoint;

    public GeocodeRestController(GeocodingEndpoint geocodingEndpoint) {
        this.geocodingEndpoint = geocodingEndpoint;
    }


    @GetMapping
    @Operation(summary = "Get geocoding info of an address")
    public Response geocode(@RequestParam(name = "address") String address,
                            @RequestParam(name = "lat", required = false) Double lat,
                            @RequestParam(name = "lon", required = false) Double lon) {

        if (lat != null && lon != null)
            return geocodingEndpoint.geocode(address, lat, lon);
        return geocodingEndpoint.geocode(address);

    }

    @GetMapping("reverse")
    @Operation(summary = "Get address info from latitude and longitude")
    public Response geocode(@RequestParam(name = "lat") Double lat,
                            @RequestParam(name = "lon") Double lon) {

        return geocodingEndpoint.reverseGeocode(lat, lon);

    }

    @GetMapping("place")
    @Operation(summary = "Get geocoding info of a place id")
    public Response placeGeocode(@RequestParam(name = "place_id") String placeId) {
        return geocodingEndpoint.placeGeocode(placeId);
    }

}
