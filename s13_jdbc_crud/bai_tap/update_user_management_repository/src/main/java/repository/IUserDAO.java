package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO extends ICrudRepository{
    void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;
    void sortByName();
}
