package com.chubock.locationservice.endpoint.autocomplete.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Response {

    private String status;
    @JsonProperty("info_messages")
    private List<String> infoMessages;
    private List<Prediction> predictions;


}
