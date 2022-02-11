package com.chubock.locationservice.endpoint.autocomplete;

import com.chubock.locationservice.endpoint.autocomplete.dto.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AutoCompleteEndpoint {

    private static final Integer RADIUS = 10000;
    private final String apiKey;

    private final AutoCompleteFeignClient autoCompleteFeignClient;

    public AutoCompleteEndpoint(@Value("${endpoints.google.apiKey}") String apiKey,
                                AutoCompleteFeignClient autoCompleteFeignClient) {
        this.apiKey = apiKey;
        this.autoCompleteFeignClient = autoCompleteFeignClient;
    }

    public Response get(String input, String types, String country, Double lat, Double lon, String sessionToken) {
        return autoCompleteFeignClient.autocomplete(apiKey, input, types, getCountryComponent(country), getLocation(lat, lon), RADIUS, sessionToken);
    }

    public Response countries(String input, Double lat, Double lon, String sessionToken) {

        Response response = autoCompleteFeignClient
                .autocomplete(apiKey, input, "(regions)", null, getLocation(lat, lon), RADIUS, sessionToken);

        response.getPredictions()
                .removeIf(prediction -> !prediction.getTypes().contains("country"));

        return response;
    }

    public Response provinces(String input, String country, Double lat, Double lon, String sessionToken) {

        Response response = autoCompleteFeignClient
                .autocomplete(apiKey, input, "(regions)", getCountryComponent(country), getLocation(lat, lon), RADIUS, sessionToken);

        response.getPredictions()
                .removeIf(prediction -> prediction.getTypes().contains("country"));

        return response;

    }

    public Response cities(String input, String country, Double lat, Double lon, String sessionToken) {
        return autoCompleteFeignClient.autocomplete(apiKey, input, "(cities)", getCountryComponent(country), getLocation(lat, lon), RADIUS, sessionToken);
    }

    public Response address(String input, String country, Double lat, Double lon, String sessionToken) {
        return autoCompleteFeignClient.autocomplete(apiKey, input, "address", getCountryComponent(country), getLocation(lat, lon), RADIUS, sessionToken);
    }

    private String getCountryComponent(String countryShortName) {
        if (countryShortName == null)
            return null;
        return "country:" + countryShortName;
    }

    private String getLocation(Double lat, Double lon) {
        if (lat == null || lon == null)
            return null;
        return lat + "%2C" + lon;
    }
}
