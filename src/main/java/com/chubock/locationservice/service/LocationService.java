package com.chubock.locationservice.service;

import com.chubock.locationservice.endpoint.geocode.GeocodingEndpoint;
import com.chubock.locationservice.endpoint.geocode.dto.Response;
import com.chubock.locationservice.model.CountryModel;
import com.chubock.locationservice.model.LocationModel;
import com.chubock.locationservice.repository.CountryRepository;
import com.chubock.locationservice.repository.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private static final String PROVINCE_FEATURE_CODE = "ADM1";

    private final CountryRepository countryRepository;
    private final LocationRepository locationRepository;

    private final GeocodingEndpoint geocodingEndpoint;

    public LocationService(
            CountryRepository countryRepository,
            LocationRepository locationRepository,
            GeocodingEndpoint geocodingEndpoint) {

        this.countryRepository = countryRepository;
        this.locationRepository = locationRepository;
        this.geocodingEndpoint = geocodingEndpoint;

    }

    @Transactional
    public List<CountryModel> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(CountryModel::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<LocationModel> getCountryProvinces(String countryCode) {
        return locationRepository.findByFeatureCodeAndCountryCode(PROVINCE_FEATURE_CODE, countryCode)
                .stream()
                .map(LocationModel::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<LocationModel> getProvinceCities(String countryCode, String provinceCode, String name) {
        return locationRepository.searchCities(countryCode, provinceCode, name)
                .stream()
                .map(LocationModel::of)
                .collect(Collectors.toList());
    }

    public Response placeGeocode(String placeId) {
        return geocodingEndpoint.placeGeocode(placeId);
    }


    public Response geocode(String address) {
        return geocodingEndpoint.geocode(address);
    }

    public Response geocode(String address, Double lat, Double lon) {
        return geocodingEndpoint.geocode(address, lat, lon);
    }

    public Response reverseGeocode(Double lat, Double lon) {
        return geocodingEndpoint.reverseGeocode(lat, lon);
    }



}
