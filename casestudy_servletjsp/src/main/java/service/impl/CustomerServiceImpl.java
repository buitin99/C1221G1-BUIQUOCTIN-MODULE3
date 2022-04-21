package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {

    private ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<Customer> getListCustomer() {
        List<Customer> customerList = iCustomerRepository.getList();
        return customerList;
    }

    @Override
    public Map<String, String> save(Customer customer) {
        Map<String,String> map = new HashMap<>();
        iCustomerRepository.save(customer);
        return map;
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = iCustomerRepository.findById(id);
        return customer;
    }

    @Override
    public List<Customer> search(String name, String phone, String typeId) {
        return iCustomerRepository.search(name,phone,typeId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        iCustomerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        iCustomerRepository.deleteCustomer(id);
    }


    @Override
    public List getList() {
        return null;
    }

}
