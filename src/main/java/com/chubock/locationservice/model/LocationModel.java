package com.chubock.locationservice.model;

import com.chubock.locationservice.entity.Location;
import lombok.Data;

@Data
public class LocationModel {

    private String name;
    private Double latitude;
    private Double longitude;
    private String countryCode;
    private String provinceCode;

    void fill(Location location) {
        setName(location.getAsciiName());
        setLatitude(location.getLatitude());
        setLongitude(location.getLongitude());
        setCountryCode(location.getCountryCode());
        setProvinceCode(location.getAdmin1Code());
    }

    public static LocationModel of(Location location) {
        LocationModel model = new LocationModel();
        model.fill(location);
        return model;
    }

}
