package jbr.protobuf;

import greetings.GreetingsOuterClass.Greetings;
import junit.framework.Assert;
import junit.framework.TestCase;

public class AppTest extends TestCase {

	public void testApp() {
		String name = "ranjith";
		String greet = "Hello";
		Greetings greetings = Greetings.newBuilder().setName(name).setGreet(greet).build();
		System.out.println(greetings.getGreet() + " " + greetings.getName());
		Assert.assertEquals(greetings.getName(), name);
		Assert.assertEquals(greetings.getGreet(), greet);
	}

}
