package pl.comarch.camp.it.rest.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private LocalDateTime date;
    private Status status;
    private BigDecimal total;
    private User user;
    private final Set<Position> positions = new HashSet<>();

    public Order(int id, LocalDateTime date, Status status, double total, User user) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.total = new BigDecimal(total);
        this.user = user;
    }

    public Order(int id) {
        this.id = id;
    }

    public String getFormattedDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return this.date.format(dateTimeFormatter);
    }

    public double getTotal() {
        return this.total.doubleValue();
    }

    public void setTotal(double total) {
        this.total = new BigDecimal(total);
    }

    public enum Status {
        NEW,
        PAID,
        SENT,
        DONE
    }
}
