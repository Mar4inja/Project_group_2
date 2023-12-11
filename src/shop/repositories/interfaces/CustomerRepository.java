package shop.repositories.interfaces;

import shop.domain.interfaces.Product;

import java.util.List;

public interface CustomerRepository {

    List<Product> getAllCustomers();
    void addCustomer(String name, int id);


}
