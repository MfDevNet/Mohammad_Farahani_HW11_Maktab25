package employee.model.dao.employee;

import employee.model.dao.address.Address;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "emcode")
    private String emCode;

    @Column(name = "salary")
    private Double salary;

    @OneToMany(cascade =CascadeType.ALL,
//            {CascadeType.MERGE
//                    , CascadeType.DETACH,
//                    CascadeType.PERSIST,
//                    CascadeType.REFRESH},
            fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Address> addressList;

    // construct

    public Employee(String name, String emCode, Double salary) {
        this.name = name;
        this.emCode = emCode;
        this.salary = salary;
    }

    public Employee() {
    }

    //setter and getter

    public void addAddressList(Address address) {
        if (addressList == null) {
            addressList = new ArrayList<>();

        }
        addressList.add(address);

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmCode() {
        return emCode;
    }

    public void setEmCode(String emCode) {
        this.emCode = emCode;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Address> getAddress() {
        return addressList;
    }

    public void setAddress(List<Address> address) {
        this.addressList = address;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", emCode='" + emCode + '\'' +
                ", salary=" + salary +
                ", addressList=" + addressList;
    }
}

