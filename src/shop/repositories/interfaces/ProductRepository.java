package shop.repositories.interfaces;

import shop.domain.interfaces.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();
    void addProduct(String name, double price);

    void removeProduct (int id);

}
