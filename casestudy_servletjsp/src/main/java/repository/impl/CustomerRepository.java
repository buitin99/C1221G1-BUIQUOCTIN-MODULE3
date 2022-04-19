package repository.impl;

import model.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
            while (resultSet.next()){
                Integer id = resultSet.getInt("ma_khach_hang");
                Integer idType = resultSet.getInt("ma_loai_khach");
                String name = resultSet.getString("ho_va_ten");
                Date dateOfBirth = resultSet.getDate("ngay_sinh");
                Integer gender = resultSet.getInt("gioi_tinh");
                String id_card = resultSet.getString("so_cmnd");
                String phone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                customerList.add(new Customer(id,idType,name,dateOfBirth,gender,id_card,phone,email,address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }
}
