import javax.persistence.*;

@Entity
@Table(name = "payments")
@NamedQueries({
        @NamedQuery(
                name = "get_all_by_Payments_id",
                query = "select p from Payments p where id = :id"
        )
})
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "invoice_value")
    private String invoice_value;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="course_id")
    private Course course;

    @Override
    public String toString() {
        return "Payments{" +
                "id=" + id +
                ", invoice_value='" + invoice_value + '\'' +
                ", student_payments_id=" + student +
                ", course=" + course +
                '}';
    }



}