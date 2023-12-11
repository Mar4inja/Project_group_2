package shop.domain.interfaces;

public interface Customer {

    int getId();
    boolean isActiv();
    String getName();
    Cart getCart();
}
