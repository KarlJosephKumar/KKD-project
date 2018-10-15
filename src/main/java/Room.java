import javax.persistence.*;

@Entity
@Table(name = "room")
@NamedQueries({
        @NamedQuery(
                name = "get_all_by_id",
                query = "select r from Room r where id = :id"
        )
})
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "max_size")
    private int roomCapacity;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @Override
    public String toString() {
        return "Room: " +
                "id: " + id +
                ", address: " + address +
                ", roomCapacity: " + roomCapacity;
    }

    public void room(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }
}
