package shop.service.interfaces;

import shop.domain.interfaces.Product;

import java.util.List;

public interface ProductService  {

    void addProduct(String name, double price);
    List<Product> getAllActiveProducts();

    void removeProduct(int id);
}
