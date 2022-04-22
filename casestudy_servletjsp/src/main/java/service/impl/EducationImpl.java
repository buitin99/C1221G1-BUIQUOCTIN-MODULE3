package service.impl;

import model.EducateDegree;
import repository.impl.EducationRepository;
import service.IEducation;

import java.util.List;

public class EducationImpl implements IEducation {

    private EducationRepository educationRepository = new EducationRepository();
    @Override
    public List<EducateDegree> getListEducation() {
        List<EducateDegree> educateDegreeList = educationRepository.getList();
        return educateDegreeList;
    }
}
