package service.impl;

import model.User;
import repository.impl.UserDAO;
import service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {

    private UserDAO userDAO = new UserDAO();

    @Override
    public void insertUser(User user) throws SQLException {
        userDAO.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userDAO.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userDAO.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }

    @Override
    public List<User> search(String country) {
        return userDAO.search(country);
    }
}
