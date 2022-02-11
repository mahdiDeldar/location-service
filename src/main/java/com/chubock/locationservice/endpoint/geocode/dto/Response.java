package com.chubock.locationservice.endpoint.geocode.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Response {
    private List<Place> results = new ArrayList<>();
    private String status;
    @JsonProperty("plus_code")
    private PlusCode plusCode;
}
