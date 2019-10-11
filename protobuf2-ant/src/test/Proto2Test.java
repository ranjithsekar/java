package test;

import jbr.proto.Proto2Example;

public class Proto2Test {

	public static void main(String[] args) {
		Proto2Example.sample sample = Proto2Example.sample.newBuilder().setName("Ranjith").setAddress("Chennai")
				.build();
		
		System.out.println(sample.getName() + " " + sample.getAddress());
	}
}
