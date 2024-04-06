package pl.comarch.camp.it.rest.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Position {
    private int id;
    private Book book;
    private int quantity;

    public void incrementQuantity() {
        this.quantity++;
    }
}
