package AdvancedMappingsOneToOne;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class deleteObjectMain {
    
    public static void main(String[] args){
        
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        
        //Deleting instructor to demonstrate cascade delete on intsructorDetail
        /*try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            
            Instructor instructor = session.get(Instructor.class, 2);
            if(instructor != null){
                session.delete(instructor);
            }
            
            session.getTransaction().commit();
        }finally{
            factory.close();
        }*/
        
        //Deleting instructorDetail to demonstrate cascade delete on intsructor via Biderectional...
        //do this by specifying all cascade types except delete.
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        try{
            int x =2;
            
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, x);
             
            System.out.println("Name: "+instructorDetail.getInstructor().getFirstName());
            
            /*
             *to delete the instructorDetail without deleting the instructor, we have to
             *remove the associated object reference
             *break the bi-directional link
            */
            instructorDetail.getInstructor().setInstructorDetail(null);
            
            session.delete(instructorDetail);
            
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
