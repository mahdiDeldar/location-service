package com.chubock.locationservice.model;

import com.chubock.locationservice.entity.Country;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CountryModel extends LocationModel {

    private String iso;
    private String capital;
    private String currencyCode;
    private String phone;

    void fill(Country country) {
        super.fill(country);
        setIso(country.getIso());
        setCapital(country.getCapital());
        setCurrencyCode(country.getCurrencyCode());
        setPhone(country.getPhone());
    }

    public static CountryModel of (Country country) {
        CountryModel model = new CountryModel();
        model.fill(country);
        return model;
    }
}

