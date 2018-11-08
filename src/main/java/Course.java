import javax.persistence.*;

@Entity
@Table(name = "course")
@NamedQueries({
        @NamedQuery(
                name = "get_all_by_Course_id",
                query = "select s from Course s where id = 1"
        )
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "topic")
    private String topic;

    @Column(name = "level")
    private String level;

    @ManyToOne
    private Class classes;


    @Override
    public String toString() {
        return "Course: " +
                "id: " + id +
                ", name: " + name +
                ", topic: " + topic +
                ", level: " + level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


}
