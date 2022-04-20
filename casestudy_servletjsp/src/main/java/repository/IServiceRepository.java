package repository;
import model.Customer;
import model.Service;
import service.ICrud;

public interface IServiceRepository {
    void save(Service service);
   void updateCustomer(Customer customer);
}
