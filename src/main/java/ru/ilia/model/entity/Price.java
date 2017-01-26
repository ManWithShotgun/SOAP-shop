package ru.ilia.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by ILIA on 26.01.2017.
 */
@Entity
@Table(name="prices")
public class Price {
    @Id
    @Column(name="id_price")
    @GeneratedValue
    private long id;
    @Min(0)
    private int price;

    public Price() {
    }

    public Price(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
