package repository;
import model.Service;
import model.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {
    void save(ServiceType serviceType);
    List<ServiceType> getList();
}
