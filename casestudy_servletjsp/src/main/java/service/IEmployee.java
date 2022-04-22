package service;

import model.Customer;
import model.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployee {
    List<Employee> getListEmployee();
    Map<String, String> save(Employee employee);
    Employee findById(Integer id);
    void updateEmployee(Employee employee);
    void deleteEmploye(Integer id);
    List<Employee> search(String name, String positions, String divisions);
}
