package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository extends ICrudRepository{
    List<Customer> getList();
}
