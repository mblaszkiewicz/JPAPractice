import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateProductJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDatabaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();

        Product product1 = new Product("Product 1", 12);
        Product product2 = new Product("Product 2", 19);
        Product product3 = new Product("Product 2", 1);
        Product product4 = new Product("Product 4", 20);
        Category categoryOdd = new Category("Odd Products");
        Category categoryEven = new Category("Even Products");
//        Supplier supplier1 = new Supplier("Supplier 1", "Procurement Street 1", "Krakow");
//        Supplier supplier2 = new Supplier("Supplier 2", "Procurement Avenue 2", "Berlin");
//
//        product1.setSupplier(supplier1);
//        product2.setSupplier(supplier1);
//        product3.setSupplier(supplier2);
//        product4.setSupplier(supplier2);

        product1.setCategory(categoryOdd);
        product2.setCategory(categoryEven);
        product3.setCategory(categoryOdd);
        product4.setCategory(categoryEven);

        categoryOdd.addProductToCategory(product1);
        categoryOdd.addProductToCategory(product3);

        categoryEven.addProductToCategory(product2);
        categoryEven.addProductToCategory(product4);

//        supplier1.addProduct(product1);
//        supplier1.addProduct(product2);
//
//        supplier2.addProduct(product3);
//        supplier2.addProduct(product4);

        ProductTransaction productTransaction1 = new ProductTransaction(12);
        productTransaction1.addProductToTransaction(product1);
        productTransaction1.addProductToTransaction(product2);
        productTransaction1.addProductToTransaction(product4);

        product1.addTransactionToProduct(productTransaction1);
        product2.addTransactionToProduct(productTransaction1);
        product4.addTransactionToProduct(productTransaction1);

        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(product4);
        em.persist(categoryEven);
        em.persist(categoryOdd);
//        em.persist(supplier1);
//        em.persist(supplier2);
        em.persist(productTransaction1);
        etx.commit();
        em.close();

    }
}
