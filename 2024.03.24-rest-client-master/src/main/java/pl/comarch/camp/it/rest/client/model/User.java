package pl.comarch.camp.it.rest.client.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private Role role;
    private final Set<Position> cart = new HashSet<>();
    private Set<Order> orders = new HashSet<>();

    public User(int id, String login, String password, String name, String surname, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public User(int id) {
        this.id = id;
    }

    public double total() {
        double sum = this.cart.stream()
                .mapToDouble(p -> p.getBook().getPrice().doubleValue() * p.getQuantity())
                .sum();
        return ((int) (sum * 100))/100.0;
    }

    public enum Role {
        USER,
        ADMIN
    }
}
