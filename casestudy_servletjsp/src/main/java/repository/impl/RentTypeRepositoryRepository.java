package repository.impl;

import model.RentType;
import repository.BaseRepository;
import repository.IRentTypeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepositoryRepository implements IRentTypeRepository {

  private BaseRepository baseRepository = new BaseRepository();

    @Override
    public void save(RentType rentType) {

    }

    @Override
    public List<RentType> getList() {
        List<RentType> rentTypeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from kieu_thue;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("ma_kieu_thue");
                String name = resultSet.getString("ten_kieu_thue");
                rentTypeList.add(new RentType(id, name));
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
        return rentTypeList;
    }
}
