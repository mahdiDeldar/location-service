package com.chubock.locationservice.endpoint.geocode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Geometry {
    private Rectangle bounds;
    private Point location;
    @JsonProperty("location_type")
    private String locationType;
    private Rectangle viewport;
}
