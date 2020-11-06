package be.multimedi.jammik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
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
    HttpEntity<Object> entity = new HttpEntity<>(headers);

    @GetMapping(produces="application/json")
    public ResponseEntity<Object> getPlaces() {
        return restTemplate.exchange(API_VLAANDEREN_BASE_URL + "/gemeenten?limit=500", HttpMethod.GET, entity, Object.class);
    }

    @GetMapping(path="/{community}", produces="application/json")
    public ResponseEntity<Object> getZipcodeByCommunity(@PathVariable("community") String community) {
        return restTemplate.exchange(API_VLAANDEREN_BASE_URL + "/postinfo?gemeentenaam=" + community, HttpMethod.GET, entity, Object.class);
    }

}