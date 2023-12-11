package shop.repositories;

import shop.domain.CommonCustomer;
import shop.domain.CommonProduct;
import shop.domain.interfaces.Customer;
import shop.domain.interfaces.Product;
import shop.repositories.interfaces.CustomerRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonCustomerRepository implements CustomerRepository {

    private Map<Integer, Customer> customers = new HashMap<>();
    private int currentId;

    public  CommonCustomerRepository(){

    }
    @Override
    public List<Product> getAllCustomers() {
        return null;
    }

    @Override
    public void addCustomer(String name, int id) {
        CommonCustomer customer = new CommonCustomer(name, id);
        customer.setId(++currentId);
        customers.put(currentId, customer);
    }
}
