package com.vtxlab.app;

import java.nio.file.ClosedFileSystemException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.vtxlab.model.customer.Customer;
import com.vtxlab.model.customer.SortById;
import com.vtxlab.model.customer.SortByName;
import com.vtxlab.model.product.Product;
import com.vtxlab.model.product.SortByPdColor;




public class Week5 {

  public static Comparator <Customer> getSorting(int type) {
    if (type == 1) {
      return new SortByName();
    }
  
    return new SortById();
  
  }

  public static void main(String[] args) {

    System.out.println("Hello");
    Customer customer = new Customer();
    customer.setName("Sunny");
    System.out.println(customer);

    //Chapter 4 (Week5)
    Customer customer1 = new Customer(1, "Alex", LocalDate.of(2010, 1, 1));
    Customer customer2 = new Customer(1, "Benny", LocalDate.of(2000, 1, 15));
    Customer customer3 = new Customer(1, "V", LocalDate.of(2022, 9, 15));
    Customer customer4 = new Customer(1, "Carl", LocalDate.of(2022, 1, 15));
    Customer customer5 = new Customer(1, "Cat", LocalDate.of(2022, 9, 15));
    Customer customer6 = new Customer(1, "Man", LocalDate.of(2009, 9, 15));


    List<Customer> customers = new ArrayList<>();
    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);
    customers.add(customer4);
    customers.add(customer5);
    customers.add(customer6);

    System.out.println("Comparable: ");
    System.out.println("\nBefore Sorting" + customers);
    Collections.sort(customers);
    System.out.println("\nAfter Sorting" + customers);

    System.out.println("Comparator: ");
    System.out.println("Before Sorting " + customers);

    int type =2; 
    Collections.sort(customers, getSorting(type));
    System.out.println("After Sorting: " + customers);

    //Lambda
    Comparator<Customer> sortByName = (s1 , s2) -> s1.getName().compareTo(s2.getName()); 
    Comparator<Customer> sortByJoinDate = (s1, s2) -> s1.getJoinDate().compareTo(s2.getJoinDate());
    Comparator<Customer> sortById = (s1,s2) -> Integer.compare(s1.getId(),s2.getId());

    Collections.sort(customers,sortById.thenComparing(sortByName).thenComparing(sortByJoinDate));

    //Product list

    Product product1 = new Product(2, "Product 1", "Blue");
    Product product2 = new Product(3, "Product 2", "YELLOW");
    Product product3 = new Product(1, "Product 3", "PINK");

    List<Product> product = new ArrayList<>();
    product.add(product1);
    product.add(product2);
    product.add(product3);

    Comparator <Product> sortByColor = (p1, p2) ->  {
      if("YELLOW".equals(p2.getColor()) && !"YELLOW".equals(p1.getColor()))
        return 1;
      
      if("YELLOW".equals(p2.getColor()) && "YELLOW".equals(p1.getColor()))
        return 0;
      
      if(!"YELLOW".equals(p2.getColor()) && "YELLOW".equals(p1.getColor()))
        return -1;
      
      return p1.getColor().compareTo(p2.getColor());

    };

    System.out.println("\nBefore Sorting : " + product );
    Collections.sort(product, new SortByPdColor());
    Collections.sort(product, sortByColor);
    System.out.println("\nAfter Sorting : " + product);

    //Collections.sort(customers,
    //sortById.thenComparing(SortByName).thenComparing(sortByJoinDate)


}
}