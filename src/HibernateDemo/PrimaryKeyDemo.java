package HibernateDemo;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        
        //create session
        Session session = factory.getCurrentSession();
        
        try{
            //create new student
            Student student1 = new Student("Otto", "Bassey", "ottobassey@gmail.com");
            Student student2 = new Student("Jerry", "Bassey", "jerrybassey@gmail.com");
            Student student3 = new Student("Emily", "Bassey", "emilybassey@gmail.com");
        
            //begin transaction
            session.beginTransaction();
            
            //save student to db
            session.save(student1);
            session.save(student2);
            session.save(student3);
            
            //comit transaction
            session.getTransaction().commit();
        }finally{
            factory.close();
        }
    }
}
