package repository;

import java.util.List;

public interface ICrudRepository<E> {
    List<E> getList();
    void save(E e);
    boolean update (E e);;
    boolean delete(int id);

}
