package employee.model.dao.address;

import javax.persistence.*;

    @Entity
    @Table(name = "phonenmber")
    public class PhoneNumber {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "telnumber")
        private String telNumber;

        @Column(name = "mobnumber")
        private String mobNumber;

        @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
        @JoinColumn(name = "address",unique = true,nullable = false)
        private Address address;

        // constructor


        public PhoneNumber(String telNumber, String mobNumber) {
            this.telNumber = telNumber;
            this.mobNumber = mobNumber;
        }

        public PhoneNumber() {
        }

        // setter and getter


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTelNumber() {
            return telNumber;
        }

        public void setTelNumber(String telNumber) {
            this.telNumber = telNumber;
        }

        public String getMobNumber() {
            return mobNumber;
        }

        public void setMobNumber(String mobNumber) {
            this.mobNumber = mobNumber;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }
