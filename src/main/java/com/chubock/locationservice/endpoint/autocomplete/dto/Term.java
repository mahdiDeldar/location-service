package com.chubock.locationservice.endpoint.autocomplete.dto;

import lombok.Data;

@Data
public class Term {

    private int offset;
    private String value;

}
