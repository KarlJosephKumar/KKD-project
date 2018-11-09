package hibernate;

import javax.persistence.*;

@Entity
@Table(name = "login")
@NamedQueries({
        @NamedQuery(
                name = "get_password_by_Login_username",
                query = "select l.password from Login l where username = :username"
        ),
        @NamedQuery(
                name = "get_id_by_Login_username",
                query = "select l.id from Login l where username = :username"
        )
})
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private int password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
