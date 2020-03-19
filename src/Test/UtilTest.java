package Test; 

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class UtilTest {
    
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(CheckInInventory.class)
                .buildSessionFactory();
        Session session ;
        //create a session
        
        Product p1 = new Product("","","","class1","0000 0000 0000 0000 0000 2103",0,"Ibeneme5e53a5123e102");
        Product p2 = new Product("","","","class2","0000 0000 0000 0000 0000 2200",0,"Ibeneme5e53a5123e102");
        Product p3 = new Product("","","","class3","0000 0000 0000 0000 0000 2107",0,"Ibeneme5e53a5123e102");
        Product p4 = new Product("","","","class4","0000 0000 0000 0000 0000 2104",0,"Ibeneme5e53a5123e102");
        Product p5 = new Product("","","","class5","0000 0000 0000 0000 0000 2105",0,"Ibeneme5e53a5123e102"); 
         
            session = factory.getCurrentSession();
            try{    
                System.out.println("Start");
                
                session.beginTransaction(); 
                session.save(p1); 
                session.save(p2); 
                session.save(p3); 
                session.save(p4);  
                session.save(p5);  
                

                session.getTransaction().commit(); 
                System.out.println("End");

            }catch(Exception e){
                session.close();
                e.printStackTrace();
            } 
       
        System.out.println("Closing factory.");
        factory.close();
    }
}
