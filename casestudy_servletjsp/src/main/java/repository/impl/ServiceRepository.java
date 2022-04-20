package repository.impl;

import model.Customer;
import model.Service;
import repository.BaseRepository;
import repository.IServiceRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ServiceRepository implements IServiceRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public void save(Service service) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("insert into dich_vu (ma_dich_vu,ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,ma_kieu_thue,ma_loai_dich_vu,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang) value (?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getName());
            preparedStatement.setInt(3, service.getArea());
            preparedStatement.setDouble(4, service.getCost());
            preparedStatement.setInt(5, service.getPeoples());
            preparedStatement.setInt(6, service.getTypeIdService());
            preparedStatement.setInt(7, service.getTypeIdService());
            preparedStatement.setString(8, service.getStandard());
            preparedStatement.setString(9, service.getDescribe());
            preparedStatement.setDouble(10, service.getAreaPool());
            preparedStatement.setInt(11, service.getFloor());
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
    public void updateCustomer(Customer customer) {
        PreparedStatement preparedStatement = null;

    }
}
