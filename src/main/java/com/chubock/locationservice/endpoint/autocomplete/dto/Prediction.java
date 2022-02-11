package com.chubock.locationservice.endpoint.autocomplete.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Prediction {

    private String description;

    @JsonProperty("distance_meters")
    private Long distanceMeters;

    @JsonProperty("matches_substrings")
    private Substring matchedSubstrings;

    @JsonProperty("place_id")
    private String placeId;
    private String reference;

    @JsonProperty("structured_formatting")
    private StructuredFormatting structuredFormatting;

    private List<Term> terms;
    private List<String> types;




}
