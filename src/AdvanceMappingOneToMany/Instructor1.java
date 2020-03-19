package AdvanceMappingOneToMany;
  
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="instructor")
public class Instructor1 {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email")
    private String email;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail1 instructorDetail1;
    
    //mapped by instructor in the course class
    @OneToMany(mappedBy = "instructor", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Course> courses;
     

    public Instructor1(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public void addCourse(Course tempCourse){
        if(courses == null){
            courses = new ArrayList<>();
        }
        
        courses.add(tempCourse);
        
        tempCourse.setInstructor(this);
    }
    
    public Instructor1(){
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail1 getInstructorDetail1() {
        return instructorDetail1;
    }

    public void setInstructorDetail1(InstructorDetail1 instructorDetail1) {
        this.instructorDetail1 = instructorDetail1;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
