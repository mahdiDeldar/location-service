package com.chubock.locationservice.endpoint.geocode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Place {

    @JsonProperty("place_id")
    private String placeId;
    @JsonProperty("address_components")
    private List<AddressComponent> addressComponents = new ArrayList<>();
    @JsonProperty("formatted_address")
    private String formattedAddress;
    private Geometry geometry;
    private List<String> types = new ArrayList<>();
    @JsonProperty("plus_code")
    private PlusCode plusCode;

}
