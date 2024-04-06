package pl.comarch.camp.it.rest.client;

import pl.comarch.camp.it.rest.client.model.Book;
import pl.comarch.camp.it.rest.client.model.User;

public interface IRestClient {
    Book getData(String imie, String nazwisko, int wiek, int id,
                 String naglowek1, String naglowek2, User user);
}
