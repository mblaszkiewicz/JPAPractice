import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class CreateProduct {
    private static SessionFactory sessionFactory = null;

    private static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nazwa produktu: ");
        String productName = scanner.nextLine();
        System.out.print("Stan magazynowy: ");
        Integer quantity = scanner.nextInt();
        scanner.close();

        Product product = new Product(productName, quantity);
        Supplier supplier = new Supplier("Dostawca1", "ul. Aab 123", "Krakow");
        supplier.addProduct(product);
        product.setSupplier(supplier);

        Product product1 = new Product("Product 1", 12);
        Product product2 = new Product("Product 2", 19);
        Product product3 = new Product("Product 2", 1);
        Product product4 = new Product("Product 4", 20);
        Category categoryOdd = new Category("Odd Products");
        Category categoryEven = new Category("Even Products");
        Supplier supplier1 = new Supplier("Supplier 1", "Procurement Street 1", "Krakow");
        Supplier supplier2 = new Supplier("Supplier 2", "Procurement Avenue 2", "Berlin");

        product1.setSupplier(supplier1);
        product2.setSupplier(supplier1);
        product3.setSupplier(supplier2);
        product4.setSupplier(supplier2);

        product1.setCategory(categoryOdd);
        product2.setCategory(categoryEven);
        product3.setCategory(categoryOdd);
        product4.setCategory(categoryEven);

        categoryOdd.addProductToCategory(product1);
        categoryOdd.addProductToCategory(product3);

        categoryEven.addProductToCategory(product2);
        categoryEven.addProductToCategory(product4);

        supplier1.addProduct(product1);
        supplier1.addProduct(product2);

        supplier2.addProduct(product3);
        supplier2.addProduct(product4);
//
        ProductTransaction transaction1 = new ProductTransaction(12);
        transaction1.addProductToTransaction(product1);
        transaction1.addProductToTransaction(product2);
        transaction1.addProductToTransaction(product4);
//
        product1.addTransactionToProduct(transaction1);
        product2.addTransactionToProduct(transaction1);
        product3.addTransactionToProduct(transaction1);

        sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //session.save(product1);
        //session.save(product2);
        //session.save(product3);
        session.save(product4);
//        session.save(supplier1);
//        session.save(supplier2);
//        session.save(categoryEven);
//        session.save(categoryOdd);
        session.save(transaction1);
        transaction.commit();
        session.close();
    }

    public void createSupplier() {
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
    }
}
