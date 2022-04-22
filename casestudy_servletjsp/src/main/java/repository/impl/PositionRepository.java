package repository.impl;

import model.Position;
import repository.BaseRepository;
import repository.IPositionRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PositionRepository implements IPositionRepository {

    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Position> getList() {
        List<Position> positionList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from vi_tri;");
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("ma_vi_tri");
                String name = resultSet.getString("ten_vi_tri");
                positionList.add(new Position(id,name));
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
        return positionList;
    }
}
