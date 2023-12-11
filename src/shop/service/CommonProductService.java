package shop.service;

import shop.domain.interfaces.Product;
import shop.repositories.interfaces.ProductRepository;
import shop.service.interfaces.ProductService;

import java.util.List;
import java.util.stream.Collectors;

public class CommonProductService implements ProductService {

    private ProductRepository repository;  // give access to repo

    public CommonProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addProduct(String name, double price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be null");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price can't be negative");
        }
        repository.addProduct(name, price);
    }

    @Override
    public List<Product> getAllActiveProducts() {
        return repository.getAllProducts()
                .stream()
                .filter(x -> x.isActiv())
                .collect(Collectors.toList());
    }

    @Override
    public void removeProduct(int id) {
        repository.removeProduct(id);
    }
}
