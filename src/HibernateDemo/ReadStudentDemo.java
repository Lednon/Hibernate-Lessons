package HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
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
            Student student = new Student("Ibrahim", "Aliyu", "ibrahimaliyu@yahoo.com");
            
            //begin transaction
            System.out.println("Beginning transaction.");
            session.beginTransaction();
            
            //save student
            System.out.println("Saving student-"+student);
            session.save(student);
            
            //commit transaction
            System.out.println("Closing transaction.");
            session.getTransaction().commit();
            System.out.println("student added into id: "+student.getId());
            
            
            //new code
            System.out.println("retrieving student with id: "+student.getId());
            //begin transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            
            //retrieve student from id
            Student obj = session.get(Student.class, student.getId());
            System.out.println("retrievd "+obj.toString());
            
            //commit transaction
            session.getTransaction().commit();
            
        }finally{
            System.out.println("Closing factory.");
            factory.close();
        }
    }
}
