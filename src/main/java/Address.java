import javax.persistence.*;
import java.security.AlgorithmParameterGenerator;

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
        return "Address{" +
                "id=" + id +
                ", nameOfCity='" + nameOfCity + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                '}';
    }

//    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL,
//    fetch = FetchType.LAZY, optional = false)
//    private Room room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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