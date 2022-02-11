package com.chubock.locationservice.rest;


import com.chubock.locationservice.endpoint.autocomplete.AutoCompleteEndpoint;
import com.chubock.locationservice.endpoint.autocomplete.dto.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/autocomplete")
public class AutoCompleteRestController {

    private final AutoCompleteEndpoint autoCompleteEndpoint;

    public AutoCompleteRestController(AutoCompleteEndpoint autoCompleteEndpoint) {
        this.autoCompleteEndpoint = autoCompleteEndpoint;
    }

    @GetMapping
    public Response get(@RequestParam("input") String input,
                                 @RequestParam(value = "types", required = false) String types,
                                 @RequestParam(value = "country", required = false) String country,
                                 @RequestParam(value = "lat", required = false) Double lat,
                                 @RequestParam(value = "lon", required = false) Double lon,
                                 @RequestParam(value = "session_token", required = false) String sessionToken) {

        return autoCompleteEndpoint.get(input, types, country, lat, lon, sessionToken);

    }

    @GetMapping("/countries")
    public Response getCountries(@RequestParam("input") String input,
                                 @RequestParam(value = "lat", required = false) Double lat,
                                 @RequestParam(value = "lon", required = false) Double lon,
                                 @RequestParam(value = "session_token", required = false) String sessionToken) {

        return autoCompleteEndpoint.countries(input, lat, lon, sessionToken);

    }

    @GetMapping("/provinces")
    public Response getProvinces(@RequestParam("input") String input,
                                 @RequestParam(value = "country", required = false) String country,
                                 @RequestParam(value = "lat", required = false) Double lat,
                                 @RequestParam(value = "lon", required = false) Double lon,
                                 @RequestParam(value = "session_token", required = false) String sessionToken) {

        return autoCompleteEndpoint.provinces(input, country, lat, lon, sessionToken);

    }

    @GetMapping("/cities")
    public Response getCities(@RequestParam("input") String input,
                              @RequestParam(value = "country", required = false) String country,
                              @RequestParam(value = "lat", required = false) Double lat,
                              @RequestParam(value = "lon", required = false) Double lon,
                              @RequestParam(value = "session_token", required = false) String sessionToken) {

        return autoCompleteEndpoint.cities(input, country, lat, lon, sessionToken);

    }

    @GetMapping("/addresses")
    public Response getAddress(@RequestParam("input") String input,
                               @RequestParam(value = "country", required = false) String country,
                               @RequestParam(value = "lat", required = false) Double lat,
                               @RequestParam(value = "lon", required = false) Double lon,
                               @RequestParam(value = "session_token", required = false) String sessionToken) {

        return autoCompleteEndpoint.address(input, country, lat, lon, sessionToken);

    }
}
