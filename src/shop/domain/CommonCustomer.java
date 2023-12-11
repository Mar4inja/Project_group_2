package shop.domain;

import shop.domain.interfaces.Cart;
import shop.domain.interfaces.Customer;

import java.util.Objects;

public class CommonCustomer implements Customer {
    private int id;
    private boolean isActiv;
    private String name;
    private Cart cart;

    public CommonCustomer(String name, Cart cart, int id) {
        this.id = id;
        this.name = name;
        this.cart = cart;
        this.isActiv = true;

    }

    public CommonCustomer(String name, int id) {
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
    public Cart getCart() {
        return cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonCustomer that = (CommonCustomer) o;
        return id == that.id && isActiv == that.isActiv && Objects.equals(name, that.name) && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActiv, name, cart);
    }

    @Override
    public String toString() {
        return String.format("Customer : ID - %d, name - %s, is active - %s, in cart -%s.", id, name, isActiv ? "Yes" : "No", cart);
    }

}
