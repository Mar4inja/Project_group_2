package shop.controllers;

import shop.domain.interfaces.Product;
import shop.service.interfaces.ProductService;


import java.util.List;
import java.util.Scanner;

public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public void addProduct() {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите наименование продукта:");
            String name = scanner.nextLine();

            System.out.println("Введите цену продукта:");
            double price = Double.parseDouble(scanner.nextLine());

            service.addProduct(name, price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAllProducts() {
        return service.getAllActiveProducts();
    }
    public void  removeProduct(int id){
        service.removeProduct(id);
    }

}