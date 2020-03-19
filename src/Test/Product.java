package Test;
 
import javax.persistence.*;

@Entity
@Table(name="itemlist")
public class Product {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private int Id;
    
    @Column(name="BATCH_ID")
    private String batchId;
    
    @Column(name="BATCH_NAME")
    private String batchName;
    
    @Column(name="PROD_ID")
    private String productId;
    
    @Column(name="PROD_NAME")
    private String productName;
    
    @Column(name="RFID")
    private String rfid;
    
    @Column(name="STATUS")
    private int status;

    @Column(name="FLAG")
    private String flag;
    
    public Product(){}

    public Product(String batchId, String batchName, String productId, String productName, String rfid, int status, String flag) {
        this.batchId = batchId;
        this.batchName = batchName;
        this.productId = productId;
        this.productName = productName;
        this.rfid = rfid;
        this.status = status;
        this.flag = flag;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    
}
