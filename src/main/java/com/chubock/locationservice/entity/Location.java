package com.chubock.locationservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LOCATIONS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Location {

    @Id
    private Long id;
    private String name;
    private String asciiName;
    private String alternateNames;
    private Double latitude;
    private Double longitude;
    private String featureClass;
    private String featureCode;
    private String countryCode;
    private String cc2;
    @Column(name = "admin1_code")
    private String admin1Code;
    @Column(name = "admin2_code")
    private String admin2Code;
    @Column(name = "admin3_code")
    private String admin3Code;
    @Column(name = "admin4_code")
    private String admin4Code;
    private Long population;
    private String elevation;
    private String dem;
    private String timezone;
    private String modificationDate;

}
