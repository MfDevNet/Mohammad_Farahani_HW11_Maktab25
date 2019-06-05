package employee;

import employee.model.dao.employee.Employee;
import employee.model.dao.employee.EmployeeDao;
import employee.model.dao.employee.EmployeeDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class QueryRunner {


    public static void main(String[] args) {

        EmployeeDao dao = new EmployeeDaoImpl();
        List<Employee> employeeList = new ArrayList<>();
        System.out.println("-----------All Employee---------------");
        employeeList = dao.query("from Employee");
        printListEmp(employeeList);

        System.out.println("-----------OutPut Part A ---------------");
        employeeList = dao.query("select max(e.salary) from Employee e join Address a on e.id = a.employee.id group by a.city");
        printListEmp(employeeList);

        System.out.println("-----------OutPut Part B ---------------");
        employeeList = dao.query("select e.max(e.salary) from Employee e join Address a on e.id = a.employee.id group by a.city");
        printListEmp(employeeList);



    }

    static void printListEmp(List<Employee> employeesList) {
//        employeesList.stream().forEach(employee -> System.out.println());
        for (Employee e : employeesList) {
            System.out.println(e.getSalary());
        }
    }

}
