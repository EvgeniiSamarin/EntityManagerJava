package ru.kpfu.itis.samarin.test.models;

import ru.kpfu.itis.samarin.annotation.Column;
import ru.kpfu.itis.samarin.annotation.FetchType;
import ru.kpfu.itis.samarin.annotation.ManyToOne;
import ru.kpfu.itis.samarin.annotation.Table;

@Table(name = "receipt")
public class Receipt {

    @Column(name = "receipt_id", primaryKey = true)
    private int id;

    @ManyToOne(foreignKey = "purchaser_id", fetchType = FetchType.LAZY)
    private Customer purchaser;

    @ManyToOne(foreignKey = "item_id", fetchType = FetchType.LAZY)
    private Item item;

    @Column(name = "amount")
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(Customer purchaser) {
        this.purchaser = purchaser;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", purchaser=" + purchaser +
                ", item=" + item +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || (getClass() != o.getClass() && getClass() != o.getClass().getSuperclass())) return false;

        Receipt receipt = (Receipt) o;

        return id == receipt.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
