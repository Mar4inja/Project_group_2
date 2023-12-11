package shop.domain;

import shop.domain.interfaces.Product;

import java.util.Objects;

public class CommonProduct implements Product {

    private int id;
    private boolean isActiv;
    private String name;
    private double price;

    public CommonProduct(String name, double price) {
        this.name = name;
        this.price = price;
        this.isActiv = true;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;

    }

    public boolean isActiv() {
        return isActiv;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonProduct that = (CommonProduct) o;
        return id == that.id && isActiv == that.isActiv && Double.compare(price, that.price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActiv, name, price);
    }

    @Override
    public String toString() {
        return String.format("Product: ID - %d, name - %s, price - %.2f, is active? - %s.",  id, name, price, isActiv ? "Yes" : "No");
    }
}
