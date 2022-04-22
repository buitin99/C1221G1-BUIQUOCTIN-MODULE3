package service.impl;
import model.Division;
import repository.impl.DivisionRepository;
import service.IDivision;

import java.util.List;

public class DivisionImpl implements IDivision {

    private DivisionRepository divisionRepository = new DivisionRepository();

    @Override
    public List<Division> getListDivision() {
        List<Division> divisionList = divisionRepository.getList();
        return divisionList;
    }
}
