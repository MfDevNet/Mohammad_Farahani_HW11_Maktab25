package employee.model;

import employee.model.connectordb.DbConnector;
import employee.model.dao.address.Address;
import employee.model.dao.address.PhoneNumber;
import employee.model.dao.employee.Employee;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class Main {


    public static void main(final String[] args) throws Exception {
        final Session session = DbConnector.getSession();

//        PhoneNumber phoneNumber1 = new PhoneNumber("02111", "091211");
//        PhoneNumber phoneNumber2 = new PhoneNumber("02122", "091222");
//        PhoneNumber phoneNumber3 = new PhoneNumber("02133", "091233");
//        PhoneNumber phoneNumber4 = new PhoneNumber("02144", "091244");
//        PhoneNumber phoneNumber5 = new PhoneNumber("02155", "091255");
//        PhoneNumber phoneNumber6 = new PhoneNumber("02166", "091266");
//
//        Address address1 = new Address("tehran", "markaz", "1717", "2121");
//        Address address2 = new Address("tehran", "markaz", "1717", "2222");
//        Address address3 = new Address("arak", "markaz", "1919", "2323");
//        Address address4 = new Address("arak", "markaz", "1919", "2424");
//        Address address5 = new Address("ahvaz", "markaz", "1515", "2525");
//        Address address6 = new Address("ahvaz", "markaz", "1515", "2626");
//
//
//        Employee employee1 = new Employee("mohammad", "123", 250000d);
//        Employee employee2 = new Employee("ali", "124", 260000d);
//        Employee employee3 = new Employee("reza", "125", 270000d);
//        Employee employee4 = new Employee("davod", "126", 280000d);
//        Employee employee5 = new Employee("hamed", "127", 290000d);
//        Employee employee6 = new Employee("ahmad", "128", 300000d);
//
//
//
//        address1.addPhonenumebrList(phoneNumber1);
//        address1.addPhonenumebrList(phoneNumber2);
//        address2.addPhonenumebrList(phoneNumber3);
//        address2.addPhonenumebrList(phoneNumber4);
//        address3.addPhonenumebrList(phoneNumber5);
//        address4.addPhonenumebrList(phoneNumber6);
//        address5.addPhonenumebrList(phoneNumber6);
//        address6.addPhonenumebrList(phoneNumber6);
//
//        address1.setEmployee(employee1);
//        address2.setEmployee(employee2);
//        address3.setEmployee(employee3);
//        address4.setEmployee(employee4);
//        address5.setEmployee(employee5);
//        address6.setEmployee(employee6);
//
//        employee1.addAddressList(address1);
//        employee2.addAddressList(address2);
//        employee3.addAddressList(address3);
//        employee4.addAddressList(address4);
//        employee5.addAddressList(address5);
//        employee6.addAddressList(address6);
//
//        phoneNumber1.setAddress(address1);
//        phoneNumber2.setAddress(address2);
//        phoneNumber3.setAddress(address3);
//        phoneNumber4.setAddress(address4);
//        phoneNumber5.setAddress(address5);
//        phoneNumber6.setAddress(address5);
//
//        session.persist(phoneNumber1);
//        session.persist(phoneNumber2);
//        session.persist(phoneNumber3);
//        session.persist(phoneNumber4);
//        session.persist(phoneNumber5);
//        session.persist(phoneNumber6);
//
//        session.persist(address1);
//        session.persist(address2);
//        session.persist(address3);
//        session.persist(address4);
//        session.persist(address5);
//        session.persist(address6);
//
//        session.beginTransaction();
//
//
//        session.persist(employee1);
//        session.persist(employee2);
//        session.persist(employee3);
//        session.persist(employee4);
//        session.persist(employee5);
//        session.persist(employee6);
//
//        session.getTransaction().commit();

        List<Employee> employees = session.createQuery(
                "select e.name,max(e.salary) from Employee e join Address a on e.id = a.employee.id group by a.city").list();
        //select employee.name,max(employee.salary),a.city from employee join
        // address a on employee.id = a.employee_id group by a.city

        System.out.println(employees);
        session.close();

    }
}
