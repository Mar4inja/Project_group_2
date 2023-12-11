package shop.domain.interfaces;

import java.util.List;

public interface Cart {

    int getId();

    List<Product> getProducts();

    boolean addProduct(Product product);

    boolean removeProductById(int id);

    void totalClear();

    double getTotalPrice();

    double getAveragePrice();

}
