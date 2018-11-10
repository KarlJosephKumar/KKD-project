package hibernate;

import javax.persistence.*;

@Entity
@Table(name = "session")
@NamedQueries({
        @NamedQuery(
                name = "get_session_by_id",
                query = "select s from Session s where id = :id"
        ),
        @NamedQuery(
                name = "add_session",
                query = "insert into Session (session_key, user_id) values (:session_key, :user_id)"
        ),
        @NamedQuery(
                name = "delete_session",
                query = "delete Session s from s where s.session_key = :session_key"
        )
})
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "session_key")
    private String session_key;

    @OneToOne(cascade = CascadeType.ALL)
    private Login user_id;

    @Override
    public String toString() {
        return "hibernate.Session{" +
                "id=" + id +
                ", session_key='" + session_key + '\'' +
                ", login=" + user_id.getId() +
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

    public void setUser_id(Login user_id) {
        this.user_id = user_id;
    }

}
