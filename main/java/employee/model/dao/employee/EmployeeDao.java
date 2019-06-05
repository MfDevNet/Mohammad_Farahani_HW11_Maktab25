package employee.model.dao.employee;

import org.hibernate.query.Query;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> query(String query);
}
