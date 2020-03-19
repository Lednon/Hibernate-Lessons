package AdvancedMappingsOneToOne;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    
    public static void main(String[] args){
        
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        //Unidiretional example (savding instuctorDtail by setting the instructorDetail object in the instructor)
        try{
            Instructor instructor = new Instructor("Emma", "Bassey", "emmabaseey@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("emma43", "bet9ja");
            
            instructor.setInstructorDetail(instructorDetail);

            
            session.beginTransaction();

            session.save(instructor);
            session.getTransaction().commit();
        }catch(Exception ex){
            //catching an exception enables the app to handle session leeks in an event
            //of an exception occuring. Therefore the session has to be closed here.
            session.close();
            ex.printStackTrace();
        }finally{
            factory.close();
        }
        
        //Bidirectional example (loading instructor from the instructor detail)
        /*Session session = factory.getCurrentSession();
        session.beginTransaction();
        try{
            int x =4;
            
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, x);
             
            System.out.println("Name: "+instructorDetail.getInstructor().getFirstName());
            
            session.getTransaction().commit();
        }catch(Exception ex){
            //catching an exception enables the app to handle session leeks in an event
            //of an exception occuring. Therefore the session has to be closed here.
            session.close();
            ex.printStackTrace();
        }finally{
            factory.close();
        }*/
    }
}
