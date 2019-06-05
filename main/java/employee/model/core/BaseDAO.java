package employee.model.core;

import employee.model.dao.employee.Employee;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<E extends Serializable> {
    E update(E e);

    E read(Serializable id);

    void delete(Serializable id);


    void create(E e);
}
