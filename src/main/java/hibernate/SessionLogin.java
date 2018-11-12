package hibernate;

import javax.persistence.*;

@Entity
@Table(name = "session_login")
@NamedQueries({
        @NamedQuery(
                name = "get_session_login_by_id",
                query = "select a from hibernate.SessionLogin a where id = :id"
)
})

public class SessionLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "session_id")
    @OneToOne
    private Session sessionId;

    @JoinColumn(name = "login_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Login loginId;

    @Override
    public String toString() {
        return "SessionLogin{" +
                "id=" + id +
                ", sessionId=" + sessionId +
                ", loginId=" + loginId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Session getSessionId() {
        return sessionId;
    }

    public void setSessionId(Session sessionId) {
        this.sessionId = sessionId;
    }

    public Login getLoginId() {
        return loginId;
    }

    public void setLoginId(Login loginId) {
        this.loginId = loginId;
    }
}

