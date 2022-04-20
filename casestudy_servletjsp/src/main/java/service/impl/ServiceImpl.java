package service.impl;
import model.Customer;
import model.Service;
import repository.impl.ServiceRepository;
import service.IService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements IService {

    private ServiceRepository iserviceRepository = new ServiceRepository();

    @Override
    public List getList() {
        return null;
    }

    @Override
    public Map<String, String> save(Service service) {
        Map<String,String> map = new HashMap<>();
        iserviceRepository.save(service);
        return null;
    }

    @Override
    public Service findById(Integer id) {
        return null;
    }


}
