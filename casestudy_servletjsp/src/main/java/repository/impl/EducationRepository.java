package repository.impl;

import model.EducateDegree;
import repository.BaseRepository;
import repository.IEducation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationRepository implements IEducation {

    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<EducateDegree> getList() {
        List<EducateDegree> educateDegreeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = this.baseRepository.getConnectionJavaToDB().prepareStatement("select * from trinh_do;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("ma_trinh_do");
                String name = resultSet.getString("ten_trinh_do");
                educateDegreeList.add(new EducateDegree(id, name));
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
        return educateDegreeList;
    }
}
