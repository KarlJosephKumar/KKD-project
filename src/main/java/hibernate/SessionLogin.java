package hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "session_login")
@NamedQueries({
        @NamedQuery(
                name = "get_session_login_by_sessionId",
                query = "select a from hibernate.SessionLogin a where sessionId.session_key = :sessionKey"
)
})

public class SessionLogin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "session_id")
    @OneToOne
    private Session sessionId;

    @JoinColumn(name = "login_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Login loginId;

    @Override
    public String toString() {
        return "SessionLogin{" +
                ", sessionId=" + sessionId +
                ", loginId=" + loginId +
                '}';
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

