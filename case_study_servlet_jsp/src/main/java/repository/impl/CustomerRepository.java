package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();


    @Override
    public List<Customer> getList() {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
            try {
                preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from khach_hang");
                ResultSet resultSet = preparedStatement.executeQuery();
                Customer customer;
                while (resultSet.next()){
                    customer = new Customer();
                    customer.setId(resultSet.getInt("ma_khach_hang"));
                    customer.setCustomerTypeId(resultSet.getInt("ma_loai_khach_hang"));
                    customer.setName(resultSet.getString("ho_va_ten"));
                    customer.setDateOfBirth(resultSet.getDate("ngay_sinh"));
                    customer.setGender(resultSet.getBoolean("gioi_tinh"));
                    customer.setId_card(resultSet.getString("so_cmnd"));
                    customer.setPhone(resultSet.getString("so_dien_thoai"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setAddress(resultSet.getString("dia_chi"));
                    customerList.add(customer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        return customerList;
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
