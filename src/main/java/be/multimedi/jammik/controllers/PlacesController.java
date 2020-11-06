package be.multimedi.jammik.controllers;

import be.multimedi.jammik.entities.Adres;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Gemaakt door Jan
 */
@RestController
@RequestMapping("/places")
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

    @GetMapping(path="/zipcode", params={"community"}, produces="application/json")
    public ResponseEntity<Object> getZipcodeByCommunity(@RequestParam("community") String community) {
        return restTemplate.exchange(API_VLAANDEREN_BASE_URL + "/postinfo?gemeentenaam=" + community, HttpMethod.GET, entity, Object.class);
    }

    @GetMapping(path="/streets", params={"community"}, produces="application/json")
    public ResponseEntity<Object> getStreetsByCommunity(@RequestParam("community") String community) {
        return restTemplate.exchange(API_VLAANDEREN_BASE_URL + "/straatnamen?gemeentenaam=" + community + "&limit=10000", HttpMethod.GET, entity, Object.class);
    }

    @GetMapping(path="/numbers", params={"zipcode", "street"})
    public ResponseEntity<Object> getBusNumbersByStreet(@RequestParam("zipcode") String zipcode, @RequestParam("street") String street) {
        return restTemplate.exchange(API_VLAANDEREN_BASE_URL + "/adressen?postcode=" + zipcode + "&straatnaam=" + street, HttpMethod.GET, entity, Object.class);
    }
}