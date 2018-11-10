package hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity(name = "JoinTableStudentClass")
@Table(name= "class")

@NamedQueries({
        @NamedQuery(
                name = "get_all_by_Class_id",
                query = "select r from GroupClass r where id = :id"
        )
})

public class GroupClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Schedule schedule;

    @OneToOne(cascade = CascadeType.ALL)
    private Room room;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_finish")
    private Date dateFinish;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;



    @Override
    public String toString() {
        return "hibernate.GroupClass{" +
                "id=" + id +
                ", schedule=" + schedule +
                ", room=" + room +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", course_id=" + course +
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

    public Course getCourse_id() {
        return course;
    }

    public void setCourse_id(Course course_id) {
        this.course = course;
    }
}
