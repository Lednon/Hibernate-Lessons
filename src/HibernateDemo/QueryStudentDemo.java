package HibernateDemo;
 
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {
    public static void main(String[] args){
        QueryStudentDemo qsd = new QueryStudentDemo();
        qsd.execute();
    }
    
    public void execute(){
        //create a session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        
        //create a session
        Session session = factory.getCurrentSession();
        
        try{
            //begin transaction
            System.out.println("Beginning transaction.");
            session.beginTransaction();
            
            //query students
            List<Student> theStudents = session.createQuery("from Student").list();
            System.out.println("All students in the database!");
            displayStudent(theStudents);
             
            //USING PREDICTAE
            //query student lastName = 'bassey'
            theStudents = session.createQuery("from Student s where s.lastName = 'bassey'").list();
            System.out.println("Students with last name Bassey!");
            displayStudent(theStudents);
            
            //USING OR PREDICTAE
            //query student lastName and firstName
            theStudents = session.createQuery("from Student s where s.lastName = 'Ali' OR s.firstName = 'Emily'").list();
            System.out.println("Students with last name Ali and first name Emily !");
            displayStudent(theStudents);
            
            //USING OR LIEK CLAUSE
            //query student email'
            theStudents = session.createQuery("from Student s where s.email LIKE '%flickr.com'").list();
            System.out.println("Students with email LIKE %flickr.com!");
            displayStudent(theStudents);
            
            //commit transaction
            System.out.println("Closing transaction.");
            session.getTransaction().commit(); 
            
        }finally{
            System.out.println("Closing factory.");
            factory.close();
        }
    }
    
    public void displayStudent(List<Student> theStudents){
        for(Student obj: theStudents){
                System.out.println("- "+obj);
            }
    }
}
