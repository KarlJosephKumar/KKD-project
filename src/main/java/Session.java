import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "session")
@NamedQueries({
        @NamedQuery(
                name = "get_session_by_id",
                query = "select s from Session s where id = :id"
        )
})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "session_key")
    private String session_key;

    @OneToMany(cascade = CascadeType.ALL)
    private Login login;

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", session_key='" + session_key + '\'' +
                ", login=" + login +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
