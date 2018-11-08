import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_value")
    private String invoice_value;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;

//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="course_id")
//    //private Course course;

    @Override
    public String toString() {
        return "Payments{" +
                "id=" + id +
                ", invoice_value='" + invoice_value + '\'' +
                ", student_payments_id=" + student +
                //", course=" + course +
                '}';
    }



}