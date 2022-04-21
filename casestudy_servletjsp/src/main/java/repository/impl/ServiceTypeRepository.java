package repository.impl;

import model.ServiceType;
import repository.BaseRepository;
import repository.IServiceTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceTypeRepository implements IServiceTypeRepository {

  private BaseRepository baseRepository = new BaseRepository();
    @Override
    public void save(ServiceType serviceType) {

    }

    @Override
    public List<ServiceType> getList() {
        List<ServiceType> serviceTypesList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from loai_dich_vu;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("ma_loai_dich_vu");
                String name = resultSet.getString("ten_loai_dich_vu");
                serviceTypesList.add(new ServiceType(id,name));
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
        return serviceTypesList;
    }
}
