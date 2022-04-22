package repository.impl;

import model.Employee;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.awt.print.PrinterGraphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EmployeeRepository implements IEmployeeRepository {

    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Employee> getList() {
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from nhan_vien;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("ma_nhan_vien");
                String name = resultSet.getString("ho_ten");
                String dateOfBirth = resultSet.getString("ngay_sinh");
                String idCard = resultSet.getString("so_cmnd");
                Double salary = resultSet.getDouble("luong");
                String phone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                Integer positionId = resultSet.getInt("ma_vi_tri");
                Integer educationDegreeId = resultSet.getInt("ma_trinh_do");
                Integer divisionId = resultSet.getInt("ma_bo_phan");
                employeeList.add(new Employee(id, name, dateOfBirth, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return employeeList;
    }

    @Override
    public List<Employee> search(String name, String positions, String divisions) {
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select* from nhan_vien where ho_ten like ? and ma_vi_tri like ? and ma_bo_phan like ?;");
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2,"%" + positions + "%");
            preparedStatement.setString(3,"%" + divisions + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("ma_nhan_vien");
                String nameE = resultSet.getString("ho_ten");
                String date = resultSet.getString("ngay_sinh");
                String idCard = resultSet.getString("so_cmnd");
                Double salary = resultSet.getDouble("luong");
                String phone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                Integer position = resultSet.getInt("ma_vi_tri");
                Integer education = resultSet.getInt("ma_trinh_do");
                Integer division = resultSet.getInt("ma_bo_phan");
                employeeList.add(new Employee(id, nameE,date,idCard,salary,phone,email,address,position,education,division));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("insert into nhan_vien (ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) value (?,?,?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1,employee.getName());
                preparedStatement.setString(2,employee.getDateOfBirth());
                preparedStatement.setString(3,employee.getIdCard());
                preparedStatement.setDouble(4,employee.getSalary());
                preparedStatement.setString(5,employee.getPhone());
                preparedStatement.setString(6,employee.getEmail());
                preparedStatement.setString(7,employee.getAddress());
                preparedStatement.setInt(8,employee.getPositionId());
                preparedStatement.setInt(9,employee.getEducationDegreeId());
                preparedStatement.setInt(10,employee.getDivisionId());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
    }

    @Override
    public void updateCustomer(Employee employee) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("update nhan_vien set ho_ten = ?, ngay_sinh = ?, so_cmnd = ?, luong = ?, so_dien_thoai = ?, email = ?, dia_chi = ?, ma_vi_tri = ?, ma_trinh_do = ?, ma_bo_phan = ? where ma_nhan_vien = ?;");
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2,employee.getDateOfBirth());
            preparedStatement.setString(3,employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhone());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setInt(8,employee.getPositionId());
            preparedStatement.setInt(9,employee.getEducationDegreeId());
            preparedStatement.setInt(10,employee.getDivisionId());
            preparedStatement.setInt(11,employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from nhan_vien where ma_nhan_vien = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer idE = resultSet.getInt("ma_nhan_vien");
                String name = resultSet.getString("ho_ten");
                String date = resultSet.getString("ngay_sinh");
                String idCard = resultSet.getString("so_cmnd");
                Double salary = resultSet.getDouble("luong");
                String phone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                Integer position = resultSet.getInt("ma_vi_tri");
                Integer education = resultSet.getInt("ma_trinh_do");
                Integer division = resultSet.getInt("ma_bo_phan");
                employee = new Employee(idE,name,date,idCard,salary,phone,email,address,position,education,division);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = baseRepository.getConnectionJavaToDB();
            preparedStatement = connection.prepareStatement("delete from nhan_vien where ma_nhan_vien = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
