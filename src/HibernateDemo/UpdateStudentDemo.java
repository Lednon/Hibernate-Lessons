package HibernateDemo;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {
    public static void main(String[] args){
        
        //create a session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        
        //create a session
        Session session = factory.getCurrentSession();
        int studentID = 2;
        try{
            //begin transaction
            System.out.println("Beginning transaction.");
            session.beginTransaction();
            
            System.out.println("updating Student at: "+studentID);
            Student student = session.get(Student.class, studentID);
            
            student.setFirstName("GageBug");
            System.out.println("student updated");
            
            //commit transaction
            System.out.println("Closing transaction.");
            session.getTransaction().commit();
            
            
            System.out.println("Beginning transaction.");
            session = factory.getCurrentSession();
            session.beginTransaction();
            
            session.createQuery("UPDATE Student set email = 'dabbigoaa@mook.com'").executeUpdate();
            System.out.println("student email updated");
            
            //commit transaction
            System.out.println("Closing transaction.");
            session.getTransaction().commit();
            
        }finally{
            System.out.println("Closing factory.");
            factory.close();
        }
    }
}
