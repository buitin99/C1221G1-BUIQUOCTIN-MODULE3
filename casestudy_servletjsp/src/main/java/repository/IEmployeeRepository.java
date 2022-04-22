package repository;
import model.Employee;
import java.util.List;

public interface IEmployeeRepository {
    List<Employee> getList();
    List<Employee> search(String name, String positions, String divisions);
    void save(Employee employee);
    void updateCustomer(Employee employee);
    Employee findById(Integer id);
    void deleteEmployee(Integer id);
}
