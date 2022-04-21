package service.impl;

import model.RentType;
import repository.impl.RentTypeRepositoryRepository;
import service.IRentType;

import java.util.List;
import java.util.Map;

public class RentTypeImpl implements IRentType {

    private RentTypeRepositoryRepository repository = new RentTypeRepositoryRepository();

    @Override
    public List<RentType> getList() {
        List<RentType> rentTypeList = repository.getList();
        return rentTypeList;
    }

    @Override
    public Map<String, String> save(RentType rentType) {
        return null;
    }

    @Override
    public RentType findById(Integer id) {
        return null;
    }
}
