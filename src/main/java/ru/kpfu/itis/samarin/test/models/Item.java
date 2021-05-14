package ru.kpfu.itis.samarin.test.models;

import ru.kpfu.itis.samarin.annotation.Column;
import ru.kpfu.itis.samarin.annotation.FetchType;
import ru.kpfu.itis.samarin.annotation.ManyToOne;
import ru.kpfu.itis.samarin.annotation.Table;

@Table(name = "item")
public class Item {

    @Column(name = "item_id", primaryKey = true)
    private int id;

    @ManyToOne(foreignKey = "seller_id", fetchType = FetchType.LAZY)
    private Customer seller;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getSeller() {
        return seller;
    }

    public void setSeller(Customer seller) {
        this.seller = seller;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", seller=" + seller +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (getClass() != o.getClass() && getClass() != o.getClass().getSuperclass())) return false;

        Item item = (Item) o;

        return id == item.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
