import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "nationality")
    private Date nationality;


    @OneToMany(mappedBy = "student_id")
    private List student_payments;
    private List student_groups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getNationality() {
        return nationality;
    }

    public void setNationality(Date nationality) {
        this.nationality = nationality;
    }

    public List getStudents() {
        return student_payments;
    }

    public void setStudents(List student_payments) {
        this.student_payments = student_payments;
    }

    public List getStudent_groups() {
        return student_groups;
    }

    public void setStudent_groups(List student_groups) {
        this.student_groups = student_groups;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", nationality=" + nationality +
                ", student_payments=" + student_payments +
                ", student_groups=" + student_groups +
                '}';
    }
}
