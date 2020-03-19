package AdvanceMappingOneToMany;
  
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class deleteObjectMain {
    
    public static void main(String[] args){
        
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor1.class)
                .addAnnotatedClass(InstructorDetail1.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
         
        
        //Deleting icourses
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        try{
            int x =2;
            
            Course course = session.get(Course.class, x);
             
            System.out.println("Courses to delete: "+ course.getTitle());
            
            session.delete(course);
            
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
