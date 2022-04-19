package service;

import model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> getListCustomer();
    Map<String, String> save(Customer customer);
    List<Customer> search(String name, String phone, String typeId);
}
