import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier extends Company {
//    private String bankAccountNumber;
//
//    public String getBankAccountNumber() {
//        return bankAccountNumber;
//    }
//
//    public void setBankAccountNumber(String bankAccountNumber) {
//        this.bankAccountNumber = bankAccountNumber;
//    }
        @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int dbID;
    private String CompanyName;
    @OneToMany
    @JoinColumn(name = "SUPPLIER_FK")
    private Set<Product> products = new HashSet<>();
//    @Embedded
//    private Address address;
    @Column(table = "ADDRESS_TBL")
    private String city;
    @Column(table = "ADDRESS_TBL")
    private String street;
    @Column(table = "ADDRESS_TBL")
    private String postalcode;
    @Column(table = "ADDRESS_TBL")
    private String country;

    public Supplier() {

    }

    public Supplier(String companyName, String street, String city) {
        CompanyName = companyName;
    }

    public int getDbID() {
        return dbID;
    }

    public void setDbID(int dbID) {
        this.dbID = dbID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
