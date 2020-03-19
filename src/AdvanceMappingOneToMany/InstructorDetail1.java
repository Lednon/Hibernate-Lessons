
package AdvanceMappingOneToMany;
 
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail1 {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="youtube_channel")
    private String channel;
    
    @Column(name="hobby")
    private String hobby;
    
    @OneToOne(mappedBy = "instructorDetail1", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor1 instructor;
    
    public InstructorDetail1(String channel, String hobby){
        this.channel = channel;
        this.hobby = hobby;
    }

    public InstructorDetail1(){
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor1 getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor1 instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" + "id=" + id + ", channel=" + channel + ", hobby=" + hobby + '}';
    }
    
    
}