package jbr.java.protobuf;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ProductTest extends TestCase {

  public void testProdut() {
    int id = 1000;
    String name = "Dell Vostro";
    int price = 50000;

    ProductDetails.Product employee = ProductDetails.Product.newBuilder()
        .setId(id)
        .setName(name)
        .setPrice(price)
        .build();

    Assert.assertEquals(employee.getName(), name);
    Assert.assertEquals(employee.getId(), id);
    Assert.assertEquals(employee.getPrice(), price);
  }

}
