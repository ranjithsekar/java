package jbr.javaexp.util.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jbr.javaexp.util.Person;

public class ListExampl {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();
    list.add("Apple");
    list.add("Banana");
    list.add("Orange");
    list.add(0, "Pomagranate");
    
    list.forEach(System.out::println);
  }

  public static void exp6() {

    List<Person> persons = new ArrayList<Person>(Arrays.asList(new Person(1, "Ranjith"), new Person(3, "Kabilan"),
        new Person(2, "Bakya"), new Person(4, "Nivedha")));

    String indexes = "3,2";

    List<String> person = Stream.of(indexes.split(","))
        .filter(e -> persons.stream().anyMatch(f -> f.getIndex() == Integer.valueOf(e))).collect(Collectors.toList());

    List<Person> result = persons.stream()
        .filter(e -> Stream.of(indexes.split(",")).anyMatch(f -> e.getIndex() == Integer.valueOf(f)))
        .collect(Collectors.toList());
    System.out.println(person);
    System.out.println(result);
  }

  public static void exp5() {
    String str = "a,b,c";
    List<String> list1 = new ArrayList<>(Arrays.asList(str.split(",")));
    System.out.println(list1);
    List<String> list2 = new ArrayList<>();
    list2.add("a");

    list1.removeAll(list2);
    System.out.println(list1);
  }

  public static void exp1() {
    List<String> list = Arrays.asList("1", null, "3", null, "5");
    System.out.println(list);

  }

  public static void exp2() {
    String str = "ab,bc,cd,_de";
    List<String> list1 = Arrays.asList(str.split(","));
    System.out.println(list1);
    List<String> list2 = list1.stream().filter(e -> e.startsWith("_")).collect(Collectors.toList());
    System.out.println(list2);
    list1.removeAll(list2);
    System.out.println(list1);
  }

  public static void exp3() {
    List<String> origList = Arrays.asList("ab,bc,cd,_de".split(","));
    List<String> std = new ArrayList<>();
    List<String> cf = new ArrayList<>();
    origList.forEach(e -> {
      if (e.startsWith("_")) {
        cf.add(e);
      } else {
        std.add(e);
      }
    });

    System.out.println("std:" + std);
    System.out.println("cf: " + cf);
  }

  public static void exp4() {
    Stream<String> strrr = Stream.of("ab".split(","));

    Map<Object, List<String>> str = strrr.collect(Collectors.groupingBy(e -> e.startsWith("_")));

    System.out.println(str);
    System.out.println(str.get(true));
    System.out.println(str.get(false));
  }
}
