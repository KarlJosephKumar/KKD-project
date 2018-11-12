package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "session")
@NamedQueries({
        @NamedQuery(
                name = "get_session_by_id",
                query = "select s from Session s where id = :id"
        ),
        @NamedQuery(
                name = "get_session_by_key",
                query = "select s from Session s where session_key = :session_key"
        ),
        @NamedQuery(
                name = "get_session_by_user",
                query = "select s from Session s where user = :user"
        )
})
public class Session  {

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "session_key")
    private String session_key;

    @JoinTable
    @OneToMany
    private Set<Login> user;

    public Session(String session_key) {
        this.session_key = session_key;
    }

    public Session() {
    }


    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", session_key='" + session_key + '\'' +
                ", user=" + user +
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Login> getUser() {
        return user;
    }

    public void setUser(Set<Login> user) {
        this.user = user;
    }
}
