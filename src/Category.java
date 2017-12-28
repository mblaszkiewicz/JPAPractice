import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int categoryID;
    String name;
    @OneToMany
    @JoinColumn(name = "Category_FK")
    List<Product> products = new LinkedList<>();

    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProductToCategory(Product product) {
        products.add(product);
    }
}
