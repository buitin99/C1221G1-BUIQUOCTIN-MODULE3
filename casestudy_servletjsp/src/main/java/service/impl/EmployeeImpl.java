package service.impl;
import model.Employee;
import repository.impl.EmployeeRepository;
import service.IEmployee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImpl implements IEmployee {

    private EmployeeRepository employeeRepository = new EmployeeRepository();



    @Override
    public List<Employee> getListEmployee() {
        List<Employee> employeeList = employeeRepository.getList();
        return employeeList;
    }

    @Override
    public Map<String, String> save(Employee employee) {
        Map<String, String> map = new HashMap<>();
        employeeRepository.save(employee);
        return map;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = employeeRepository.findById(id);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateCustomer(employee);
    }
}
