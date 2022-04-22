package repository.impl;
import model.Division;
import repository.BaseRepository;
import repository.IDivisionRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {

    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Division> getList() {
        List<Division> divisionList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from bo_phan;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("ma_bo_phan");
                String name = resultSet.getString("ten_bo_phan");
                divisionList.add(new Division(id, name));
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
        return divisionList;
    }
}
