package com.chubock.locationservice.endpoint.geocode.dto;

import lombok.Data;

@Data
public class Rectangle {
    private Point northeast;
    private Point southwest;
}
