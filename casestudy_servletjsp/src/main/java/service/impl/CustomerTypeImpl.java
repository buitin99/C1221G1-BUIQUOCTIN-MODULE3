package service.impl;

import model.CustomerType;
import repository.ICustomerTypeRepository;
import repository.impl.CustomerTypeRepository;
import service.ICustomeTypeService;
import java.util.List;

public class CustomerTypeImpl implements ICustomeTypeService {

    private ICustomerTypeRepository iCustomerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> getListCustomerType() {
        List<CustomerType> customerTypeList = iCustomerTypeRepository.getList();
        return customerTypeList;
    }
}
