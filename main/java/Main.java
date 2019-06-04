import model.connectordb.DbConnector;
import model.dao.address.Address;
import model.dao.address.PhoneNumber;
import model.dao.employee.Employee;
import org.hibernate.Session;

public class Main {


    public static void main(final String[] args) throws Exception {
        final Session session = DbConnector.getSession();

        PhoneNumber phoneNumber1 = new PhoneNumber("02111", "091211");
        PhoneNumber phoneNumber2 = new PhoneNumber("02122", "091222");
        PhoneNumber phoneNumber3 = new PhoneNumber("02133", "091233");
        PhoneNumber phoneNumber4 = new PhoneNumber("02144", "091244");
        PhoneNumber phoneNumber5 = new PhoneNumber("02155", "091255");
        PhoneNumber phoneNumber6 = new PhoneNumber("02166", "091266");

        Address address1 = new Address("tehran", "markaz", "1717", "2727");
        Address address2 = new Address("tehran", "markaz", "1818", "2828");
        Address address3 = new Address("arak", "markaz", "1919", "2929");
        Address address4 = new Address("arak", "markaz", "2020", "3030");


        Employee employee1 = new Employee("mohammad", "123", 250000d);
        Employee employee2 = new Employee("ali", "124", 260000d);
        Employee employee3 = new Employee("reza", "125", 270000d);



        address1.addPhonenumebrList(phoneNumber1);
        address1.addPhonenumebrList(phoneNumber2);
        address2.addPhonenumebrList(phoneNumber3);
        address2.addPhonenumebrList(phoneNumber4);
        address3.addPhonenumebrList(phoneNumber5);
        address4.addPhonenumebrList(phoneNumber6);

        employee1.addAddressList(address1);
        employee2.addAddressList(address2);
        employee3.addAddressList(address3);
        employee3.addAddressList(address4);

        session.beginTransaction();
//        session.save(employee1);
//        session.save(employee2);
//        session.save(employee3);
        session.persist(employee1);
        session.persist(employee2);
        session.persist(employee3);

//        session.getTransaction();
        session.close();

    }
}
