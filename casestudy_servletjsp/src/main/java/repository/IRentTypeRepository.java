package repository;
import model.RentType;

import java.util.List;

public interface IRentTypeRepository {
    void save(RentType rentType);
    List<RentType> getList();
}
