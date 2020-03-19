package AdvanceMappingOneToMany;
  
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    
    public static void main(String[] args){
        
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor1.class)
                .addAnnotatedClass(InstructorDetail1.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        //creating courses and saving into the database
        /*try{
            int id = 3;
            Instructor1 instructor = session.get(Instructor1.class, id); 
            
            Course course1 = new Course("Java beginners");
            Course course2 = new Course("c++ beginners");
            
            instructor.addCourse(course1);
            instructor.addCourse(course2);

            session.save(course1);
            session.save(course2);
            
            session.getTransaction().commit();
        }catch(Exception ex){
            //catching an exception enables the app to handle session leeks in an event
            //of an exception occuring. Therefore the session has to be closed here.
            session.close();
            ex.printStackTrace();
        }finally{
            factory.close();
        }*/
        
        //retrieving instructor courses
        try{
            int id = 3;
            Instructor1 instructor = session.get(Instructor1.class, id); 
            
            System.out.println("Name: "+instructor.getFirstName());
            System.out.println("Courses: "+instructor.getCourses());
            
            session.getTransaction().commit();
        }catch(Exception ex){
            //catching an exception enables the app to handle session leeks in an event
            //of an exception occuring. Therefore the session has to be closed here.
            session.close();
            ex.printStackTrace();
        }finally{
            factory.close();
        }
    }
}
