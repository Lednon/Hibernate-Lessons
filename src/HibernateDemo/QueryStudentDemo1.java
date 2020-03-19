package HibernateDemo;
 
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo1 {
    public static void main(String[] args){
        QueryStudentDemo1 qsd = new QueryStudentDemo1();
        qsd.execute();
    }
    
    public void execute(){
        //create a session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        
        //create a session
        Session session = factory.getCurrentSession();
        
        try{
            //begin transaction
            System.out.println("Beginning transaction.");
            session.beginTransaction();
            
            //query students
            List<Product> theStudents = session.createQuery("from Product p where p.flag = 'Ibeneme5e53a5123e102' and p.rfid = '0000 0000 0000 0000 0000 2200'").list();
            System.out.println(theStudents.size());
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
