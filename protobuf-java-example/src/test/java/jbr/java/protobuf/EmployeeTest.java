package jbr.java.protobuf;

import junit.framework.Assert;
import junit.framework.TestCase;

public class EmployeeTest extends TestCase {

  public void testEmployee() {
    String name = "Ranjith";
    int id = 100;
    String email = "ranjith@gmail.com";

    EmployeeDetails.Employee employee = EmployeeDetails.Employee.newBuilder()
        .setId(id)
        .setName(name)
        .setEmail(email)
        .build();

    Assert.assertEquals(employee.getName(), name);
    Assert.assertEquals(employee.getId(), id);
    Assert.assertEquals(employee.getEmail(), email);
  }

}
