package pl.comarch.camp.it.rest.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.comarch.camp.it.rest.client.model.Book;
import pl.comarch.camp.it.rest.client.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class RestClient implements IRestClient {

    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public Book getData(String imie, String nazwisko, int wiek, int id, String naglowek1, String naglowek2, User user) {
        String uri = "http://localhost:8080/rest/test4/{imie}/{nazwisko}";

        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("imie", imie);
        pathVariables.put("nazwisko", nazwisko);

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("wiek", wiek)
                .queryParam("id", id)
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("naglowek1", naglowek1);
        httpHeaders.add("naglowek2", naglowek2);

        HttpEntity<User> reqest = new HttpEntity<>(user, httpHeaders);

        ResponseEntity<Book> response = this.restTemplate.exchange(uriComponents.toUriString(),
                HttpMethod.POST,
                reqest,
                Book.class,
                pathVariables);

        return response.getBody();
    }
}
