package jbr.javaex.util.list;

import java.util.ArrayList;
import java.util.List;

public class ListObjectSort {

  public static void main(String[] args) {
    // getAddressList().forEach(System.out::println);
    //getAddressList().stream().sorted((e1, e2) -> e1.getCity().compareTo(e2.getCity())).forEach(System.out::println);
    getAddressList().stream().sorted((e1, e2) -> e1.getState().compareTo(e2.getState())).forEach(System.out::println);
  }

  private static List<Address> getAddressList() {
    List<Address> list = new ArrayList<>();
    list.add(new Address("Chennai", "Tamilnadu"));
    list.add(new Address("Arni", "Tamilnadu"));
    list.add(new Address("Vellore", "Tamilnadu"));
    list.add(new Address("Bellari", "Andra"));
    list.add(new Address("Karnool", "Andra"));
    list.add(new Address("Malapuzha", "Kerala"));

    return list;
  }
}
