import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity(name = "JoinTableStudentClass")
@Table(name= "class")

@NamedQueries({
        @NamedQuery(
                name = "get_all_by_id",
                query = "select r from Room r where id = :id"
        )
})

public class Class implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;

    @OneToOne(cascade = CascadeType.ALL)
    private Room room;

    //@Column(name = "date_start")
    private Date dateStart;

   // @Column(name = "date_finish")
    private Date dateFinish;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classes")
    private Set<Course> course_id;



    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", schedule=" + schedule +
                ", room=" + room +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", course_id=" + course_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Set<Course> getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Set<Course> course_id) {
        this.course_id = course_id;
    }
}
