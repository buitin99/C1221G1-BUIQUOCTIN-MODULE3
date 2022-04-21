package service.impl;

import model.ServiceType;
import repository.BaseRepository;
import repository.IServiceRepository;
import repository.IServiceTypeRepository;
import repository.impl.ServiceRepository;
import repository.impl.ServiceTypeRepository;
import service.IServiceType;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ServiceTypeImpl implements IServiceType {

    private ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepository();
    private IServiceTypeRepository iServiceRepository = new ServiceTypeRepository();

    @Override
    public List<ServiceType> getList() {
        List<ServiceType> serviceTypeList = serviceTypeRepository.getList();
        return serviceTypeList;
    }

    @Override
    public Map<String, String> save(ServiceType serviceType) {
        return null;
    }

    @Override
    public ServiceType findById(Integer id) {
        return null;
    }
}
