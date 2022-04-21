package repository;
import model.Service;
import java.util.List;

public interface IServiceRepository {
    void save(Service service);
    List<Service> getList();
}
