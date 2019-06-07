package employee;

import employee.model.dao.employee.Employee;
import employee.model.dao.employee.EmployeeDao;
import employee.model.dao.employee.EmployeeDaoImpl;
import org.omg.CORBA.ObjectHelper;

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
        employeeList = dao.query("select max(e.salary),a.city from Employee e join Address a on e.id = a.employee.id group by a.city");
        printListEmp(employeeList);

        System.out.println("-----------OutPut Part B ---------------");
        employeeList = dao.query("select e.name,max(e.salary),a.city from Employee e join Address a on e.id = a.employee.id group by a.city");
        printListEmp(employeeList);


        System.out.println("-----------OutPut Part C ---------------");
        employeeList = dao.query("select e,a from Employee e join Address a on e.id = a.employee.id where a.postalCode = '3030'");
        printListEmp(employeeList);



        System.out.println("-----------OutPut Part D ---------------");
        employeeList = dao.query("select e,a,p from Employee e join Address a on e.id = a.employee.id join PhoneNumber p on a.id = p.address.id where p.telNumber ='02144'");
        printListEmp(employeeList);




    }

    static void printListEmp(List<Employee> employeesList) {
//        employeesList.stream().forEach(employee -> System.out.println());
        for (Object e : employeesList) {
            System.out.println(e);
        }
    }

}
