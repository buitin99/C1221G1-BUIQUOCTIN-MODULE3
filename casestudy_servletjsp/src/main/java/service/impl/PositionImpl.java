package service.impl;
import model.Position;
import repository.impl.PositionRepository;
import service.IPosition;
import java.util.List;

public class PositionImpl implements IPosition {

    private PositionRepository positionRepository = new PositionRepository();

    @Override
    public List<Position> getListPosition() {
        List<Position> positionList = positionRepository.getList();
        return positionList;
    }
}
