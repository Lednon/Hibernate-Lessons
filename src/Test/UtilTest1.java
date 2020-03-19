package Test; 

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class UtilTest1 {
    public static void main(String[] args){
        ObservableList<Product> obj = FXCollections.observableArrayList();
        ObservableList<Product> obj1 = FXCollections.observableArrayList();
        
        Product p = new Product("","","","rice","0000 0000 0000 0000 0000 2198",0,"");
        Product p1 = new Product("","","","garri","0000 0000 0000 0000 0000 2200",0,"");
        
        obj.add(p);
        obj.add(p1);
        
        obj1.add(new Product("","","","rice","0000 0000 0000 0000 0000 2198",0,""));
        obj1.add(p1);
         
        
        if(obj.contains(obj1.get(0))){
            System.out.println("yes");
        }else{
            System.out.println("No");
        }
    }
}
