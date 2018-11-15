package hibernate;

import javax.persistence.*;


@Entity
@Table(name = "login")
@NamedQueries({
        @NamedQuery(
                name = "get_password_by_Login_username",
                query = "select l from Login l where username = :username"
        ),
        @NamedQuery(
                name = "get_id_by_Login_username",
                query = "select l from Login l where username = :username"
        ),
        @NamedQuery(
                name = "check_if_username_exist",
                query = "select l from Login l where username = :username"
        ),
        @NamedQuery(
                name= "change_password_by_id",
                query = "update Login l set l.password = :password where l.id = :id"
        )
})
public class Login  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
