/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvanceMappingOneToMany;
 
import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="title")
    private String title;
    
    @ManyToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    private Instructor1 instructor;
    
    public Course(String title){ 
        this. title = title;
    }
    
    public Course(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor1 getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor1 instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title=" + title + '}';
    }
}
