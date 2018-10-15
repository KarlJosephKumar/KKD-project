import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city")
    private String nameOfCity;

    private String street;

    @Column(name = "number")
    private int streetNumber;

    @Override
    public String toString() {
        return "Address: " +
                "id: " + id +
                ", nameOfCity: " + nameOfCity +
                ", street: " + street  +
                ", streetNumber: " + streetNumber;
    }

    public int getId() {
        return id;
    }

    public String getNameOfCity() {
        return nameOfCity;
    }

    public void setNameOfCity(String nameOfCity) {
        this.nameOfCity = nameOfCity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
