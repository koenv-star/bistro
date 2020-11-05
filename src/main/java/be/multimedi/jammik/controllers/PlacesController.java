package be.multimedi.jammik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/places")
@CrossOrigin
public class PlacesController {

    private final RestTemplate restTemplate;

    @Autowired
    public PlacesController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String API_VLAANDEREN_BASE_URL = "https://api.basisregisters.vlaanderen.be/v1";
    HttpHeaders headers = new HttpHeaders();

    @GetMapping(produces= { MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Object[]> getPlaces() {
        headers.set("Access-Control-Allow-Origin", "*");
        headers.set("Access-Control-Allow-Method", "GET");
        headers.set("x-api-key", "950f3581-139e-45e4-bca3-18b006335d71");
        HttpEntity<Object[]> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(API_VLAANDEREN_BASE_URL + "/gemeenten?limit=500", HttpMethod.GET, entity, Object[].class);
    }
}