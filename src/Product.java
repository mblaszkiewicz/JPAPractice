import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int dbID;

    private String ProductName;
    private Integer UnitsOnStock;
    @ManyToOne
    @JoinColumn(name = "SUPPLIER_FK")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany
    @JoinColumn(name = "TRANSACTIONS_FK")
    private List<ProductTransaction> productTransactions = new LinkedList<>();



    public Product() {
    }

    public Product(String productName, Integer unitsOnStock) {
        ProductName = productName;
        UnitsOnStock = unitsOnStock;
    }

    public int getDbID() {
        return dbID;
    }

    public String getProductName() {
        return ProductName;
    }

    public Integer getUnitsOnStock() {
        return UnitsOnStock;
    }

    public void setDbID(int dbID) {
        this.dbID = dbID;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setUnitsOnStock(Integer unitsOnStock) {
        UnitsOnStock = unitsOnStock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addTransactionToProduct(ProductTransaction productTransaction){
        productTransactions.add(productTransaction);
    }

}
