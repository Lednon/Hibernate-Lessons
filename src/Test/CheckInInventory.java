package Test;

import javax.persistence.*;

@Entity
@Table(name="checkin_tags")
public class CheckInInventory {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int count;
    
    @Column(name="tag_id")
    private String EPCValue; 
    
    public CheckInInventory(String EPC){
        this.EPCValue = EPC; 
    }

    public int getEPCCount() {
        return count;
    }

    public void setEPCCount(int EPCCount) {
        this.count = EPCCount;
    }
    
    public String getEPCValue() {
        return EPCValue;
    }

    public void setEPCValue(String EPCValue) {
        this.EPCValue = EPCValue;
    }
}
