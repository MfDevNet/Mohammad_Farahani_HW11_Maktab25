package model.dao.address;

import model.dao.employee.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String city;

    @Column
    private String state;

    @Column(name = "postaladdress")
    private String postalAddress;

    @Column(name = "postalcode")
    private String postalCode;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "address")
    private List<PhoneNumber> phoneNumberList;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH}
            , fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",unique = true,nullable = false)
    private Employee employee;

// constructor

    public Address(String city, String state, String postalAddress, String postalCode) {
        this.city = city;
        this.state = state;
        this.postalAddress = postalAddress;
        this.postalCode = postalCode;
    }

    public Address() {
    }


// setter and getter


    public void addPhonenumebrList(PhoneNumber phoneNumber) {
        if (phoneNumberList == null) {
            phoneNumberList = new ArrayList<>();
        }
        phoneNumberList.add(phoneNumber);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<PhoneNumber> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(List<PhoneNumber> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
