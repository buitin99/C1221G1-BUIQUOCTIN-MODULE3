package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository extends ICrudRepository<Customer>{
    List<Customer> getList();
     List<Customer> search(String name, String phone, String typeId);
    void save(Customer customer);
}
