package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<Customer> getListCustomer() {
        List<Customer> customerList = iCustomerRepository.getList();
        return customerList;
    }
}
