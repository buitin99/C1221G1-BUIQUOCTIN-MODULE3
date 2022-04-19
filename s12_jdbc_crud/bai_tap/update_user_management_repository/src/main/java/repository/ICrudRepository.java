package repository;

import model.User;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> search(String country);
    List<E> getListSP();
    boolean updateSP (User user);
    boolean removeSP(Integer id);
}
