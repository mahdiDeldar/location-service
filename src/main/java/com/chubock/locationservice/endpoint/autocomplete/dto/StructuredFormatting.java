package com.chubock.locationservice.endpoint.autocomplete.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StructuredFormatting {

    @JsonProperty("main_text")
    private String mainText;

    @JsonProperty("main_text_matched_substrings")
    private List<Substring> mainTextMatchedSubstrings;

    @JsonProperty("secondary_text")
    private String secondaryText;
}
