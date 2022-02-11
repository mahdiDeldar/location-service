package com.chubock.locationservice.rest;

import com.chubock.locationservice.endpoint.geocode.dto.Response;
import com.chubock.locationservice.model.CountryModel;
import com.chubock.locationservice.model.LocationModel;
import com.chubock.locationservice.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LocationRestController {

    private final LocationService locationService;

    public LocationRestController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/countries")
    @Operation(summary = "Get countries")
    public List<CountryModel> getCountries() {
        return locationService.getAllCountries();
    }

    @GetMapping("/countries/{code}/provinces")
    @Operation(summary = "Get provinces of a country")
    public List<LocationModel> getCountries(@PathVariable("code") String code) {
        return locationService.getCountryProvinces(code);
    }

    @GetMapping("/countries/{countryCode}/provinces/{code}/cities")
    @Operation(summary = "Get cities of a province")
    public List<LocationModel> getProvinceCities(@PathVariable("countryCode") String countryCode,
                                                 @PathVariable("code") String code,
                                                 @RequestParam(value = "name", defaultValue = "", required = false) String name) {

        return locationService.getProvinceCities(countryCode, code, name);

    }
}
