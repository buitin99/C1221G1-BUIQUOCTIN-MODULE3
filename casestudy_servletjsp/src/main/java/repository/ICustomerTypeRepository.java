package repository;
import model.Customer;
import model.CustomerType;
import java.util.List;

public interface ICustomerTypeRepository{
    List<CustomerType> getList();
    void updateCustomer(Customer customer);
}

