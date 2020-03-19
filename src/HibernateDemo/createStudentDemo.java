
package HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class createStudentDemo {
    
    public static void main(String[] args){
        
        //create a session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        
        //create a session
        Session session = factory.getCurrentSession();
        
        try{
            //create new student
            System.out.println("Creating new Student");
            Student student = new Student("Ayo", "Damilola", "demirichards@yahoo.com");
            Student student1 = new Student("Ugo", "Eze", "demirichards@yahoo.com");
            
            //begin transaction
            System.out.println("Beginning transaction.");
            session.beginTransaction();
            
            //save student
            System.out.println("Saving student.");
            session.save(student);
            session.save(student1);
            
            //commit transaction
            System.out.println("Closing transaction.");
            session.getTransaction().commit();
            
        }finally{
            System.out.println("Closing factory.");
            factory.close();
        }
    }
}
