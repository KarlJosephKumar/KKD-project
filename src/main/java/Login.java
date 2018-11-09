import javax.persistence.*;

@Entity
@Table(name = "login")
@NamedQueries({
        @NamedQuery(
                name = "get_all_by_Login_id",
                query = "select l.password from Login l where username = :username"
        )
})
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String nameOfCity;

    @Column(name = "password")
    private int streetNumber;

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

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
