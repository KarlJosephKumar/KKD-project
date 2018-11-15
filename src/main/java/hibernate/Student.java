package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "student")
@NamedQueries({
        @NamedQuery(
                name = "get_all_by_Student_id",
                query = "select s from Student s where id = :id"
        ),
        @NamedQuery(
                name= "get list of students",
                query = "select s from Student s"
        )
})
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "nationality")
    private String nationality;

    @JoinColumn(name = "login_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Login login_id;

    @ManyToMany(mappedBy = "student")
    private List<Payments> payments;
    @ManyToMany
    @JoinTable(
            name = "student_class",
            joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id",
 referencedColumnName = "id" )}
    )
    private List <GroupClass> groupClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void listPayments(List<Payments> payments) {
        this.payments = payments;
    }

    public List<GroupClass> getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(List<GroupClass> groupClass) {
        this.groupClass = groupClass;
    }

    public Login getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Login login_id) {
        this.login_id = login_id;
    }

    @Override
    public String toString() {
        return "hibernate.Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", nationality=" + nationality +
                '}';
    }
}
