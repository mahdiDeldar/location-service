package com.chubock.locationservice.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "COUNTRIES", schema = "location_service")
public class Country extends Location {

    private String iso;
    private String iso3;
    private String isoNumeric;
    private String fips;
    private String capital;
    private String continent;
    private String tld;
    private String currencyCode;
    private String currencyName;
    private String phone;
    private String postalCodeFormat;
    private String postalCodeRegex;
    private String languages;
    private String neighbours;
    private String equivalentFipsCode;

}
