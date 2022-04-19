package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> getListCustomer() {
        List<Customer> customerList = customerRepository.getList();
        return customerList;
    }
}
