import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ProductTransaction {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int transcationNumber;
    private Integer Quantity;
    @OneToMany(cascade = {CascadeType.PERSIST})
    List<Product> products = new LinkedList<>();

    public ProductTransaction() {

    }

    public ProductTransaction(Integer quantity) {
        Quantity = quantity;
    }

    public int getTranscationNumber() {
        return transcationNumber;
    }

    public void setTranscationNumber(int transcationNumber) {
        this.transcationNumber = transcationNumber;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public void addProductToTransaction(Product product) {
        products.add(product);
    }
}
