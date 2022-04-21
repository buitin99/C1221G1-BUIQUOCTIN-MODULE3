package repository.impl;

import model.Customer;
import model.Service;
import repository.BaseRepository;
import repository.IServiceRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ServiceRepository implements IServiceRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public void save(Service service) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("insert into dich_vu (ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,ma_kieu_thue,ma_loai_dich_vu,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang) value (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setDouble(3, service.getCost());
            preparedStatement.setInt(4, service.getPeoples());
            preparedStatement.setInt(5, service.getTypeId());
            preparedStatement.setInt(6, service.getTypeIdService());
            preparedStatement.setString(7, service.getStandard());
            preparedStatement.setString(8, service.getDescribe());
            preparedStatement.setDouble(9, service.getAreaPool());
            preparedStatement.setInt(10, service.getFloor());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Service> getList() {
        List<Service> serviceList = new ArrayList<>();
        // thuc hien truy van tham so
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from dich_vu; ");
            // tro den tung vi tri trong DB
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("ma_dich_vu");
                String name = resultSet.getString("ten_dich_vu");
                Integer area = resultSet.getInt("dien_tich");
                Double cost = resultSet.getDouble("chi_phi_thue");
                Integer peoples = resultSet.getInt("so_nguoi_toi_da");
                Integer typeId = resultSet.getInt("ma_kieu_thue");
                Integer typeIdService = resultSet.getInt("ma_loai_dich_vu");
                String standard = resultSet.getString("tieu_chuan_phong");
                String describe = resultSet.getString("mo_ta_tien_nghi_khac");
                Double areaPool = resultSet.getDouble("dien_tich_ho_boi");
                Integer floor = resultSet.getInt("so_tang");
                serviceList.add(new Service(id, name, area, cost, peoples, typeId,typeIdService,standard,describe,areaPool,floor));
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
        return serviceList;
    }
}
