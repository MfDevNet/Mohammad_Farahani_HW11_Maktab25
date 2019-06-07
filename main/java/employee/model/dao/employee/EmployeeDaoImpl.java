package employee.model.dao.employee;

import employee.model.connectordb.DbConnector;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeDaoImpl  implements EmployeeDao{

    @Override
    public List<Employee> query(String query) {
        Session session= DbConnector.getSession();
        List<Employee> employees=session.createQuery(query).list();
        return employees;
    }
}
