package com.chubock.locationservice.endpoint.autocomplete;

import com.chubock.locationservice.endpoint.autocomplete.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "autocomplete", url = "${endpoints.google.baseUrl}")
public interface AutoCompleteFeignClient {

    @GetMapping("/place/autocomplete/json")
    Response autocomplete(@RequestParam("key") String apiKey,
                     @RequestParam("input") String input,
                     @RequestParam("types") String types,
                     @RequestParam("components") String component,
                     @RequestParam("location") String location,
                     @RequestParam("radius") Integer radius,
                     @RequestParam("sessiontoken") String sessionToken);

}
