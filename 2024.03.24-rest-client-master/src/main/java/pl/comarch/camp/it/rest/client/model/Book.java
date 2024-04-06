package pl.comarch.camp.it.rest.client.model;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;
    private BigDecimal price;
    private int quantity;
    private User creator;

    public Book(int id, String title, String author, String isbn, double price, int quantity, User creator) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = new BigDecimal(price);
        this.quantity = quantity;
        this.creator = creator;
    }

    public Book(int id, String title, String author, String isbn, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = new BigDecimal(price);
        this.quantity = quantity;
    }

    public Book(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = new BigDecimal(price);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
