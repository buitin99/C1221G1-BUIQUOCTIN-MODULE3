package service;

import model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IUserService {
    void insertUser(User user) throws SQLException;
    User selectUser(int id);
    List<User> selectAllUsers();
    boolean deleteUser(int id) throws SQLException;
    boolean updateUser(User user) throws SQLException;
    List<User> search(String country);
    List<User> sort();
    boolean remove(Integer id);
    List<User> getList();
    Map<String, String> update(User user);
}
