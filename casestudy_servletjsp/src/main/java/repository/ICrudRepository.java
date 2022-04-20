package repository;

import model.Customer;

import java.util.List;

public interface ICrudRepository <E>{
    List<E> getList();
    void save(E e);
    E findById(Integer id);
}
