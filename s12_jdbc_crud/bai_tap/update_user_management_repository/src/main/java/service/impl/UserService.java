package service.impl;

import model.User;
import repository.impl.UserDAO;
import service.IUserService;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<User> sort() {
        return userDAO.sortByName();
    }

    @Override
    public boolean remove(Integer id) {
        return userDAO.removeSP(id);
    }

    @Override
    public List<User> getList() {
        return userDAO.getListSP();
    }

    @Override
    public Map<String, String> update(User user) {
        Map<String, String> map = new HashMap<>();
        if (map.isEmpty()){
            boolean check = userDAO.updateSP(user);
            if (!check){
                map.put("message","can not update!");
            }
        }
        return map;
    }
}
