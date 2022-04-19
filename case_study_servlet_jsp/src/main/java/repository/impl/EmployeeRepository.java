package repository.impl;

import repository.IEmployeeRepository;

import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    @Override
    public List getList() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
