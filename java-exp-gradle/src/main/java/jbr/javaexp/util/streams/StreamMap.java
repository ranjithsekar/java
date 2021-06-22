package jbr.javaexp.util.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

  public static void main(String[] args) {
    exp6();
  }

  public static void exp6() {

    Map<String, String> map = new TreeMap<>();
    map.put("1", "one");
    map.put("2", "two");
    map.put("3", "three");
    map.put("4", "four");
    map.put("5", "five");
    map.put("6", "six");
    map.put("7", "seven");

    Map<String, String> result = map.entrySet().stream().limit(5)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, TreeMap::new));

    result.forEach((k, v) -> System.out.println(v));
  }

  public static void exp5() {
    List<String> fruits = Arrays.asList("Apple", "Banana", "Grapes", "Tiger");
    List<String> animals = Arrays.asList("Lion", "Elephant", "Tiger");

    Map<String, List<String>> map = new HashMap<>();
    map.put("fruits", fruits);
    map.put("animals", animals);

    List<String> result = new ArrayList<>();
    map.entrySet().forEach(e -> result.addAll(e.getValue()));
    System.out.println(result.stream().distinct().collect(Collectors.toList()));

  }

  public static void streamReverse() {
    List<Fruit> fruitsObj = Arrays.asList(new Fruit("Apple", 100), new Fruit("Banana", 200), new Fruit("Grapes", 300),
        new Fruit("Orange", 400));
    List<Fruit> fruitsObjUnOrdered = Arrays.asList(new Fruit("Apple", 100), new Fruit("Banana", 200),
        new Fruit("Orange", 400), new Fruit("Grapes", 300));

    String names = fruitsObj.stream().map(e -> e.getName()).collect(Collectors.joining("/"));
    System.out.println(names);
    String namesR = fruitsObj.stream().sorted(Comparator.comparing(Fruit::hashCode).reversed()).map(e -> e.getName())
        .collect(Collectors.joining("/"));
    System.out.println(namesR);
  }

  public static void exp2() {
    boolean contains = Stream.of(new String[] { "ti", "wr", "pn", "pd" }).anyMatch("wr"::equalsIgnoreCase);
    // System.out.println(contains);

    String[] str = new String[] { "name=ranjith" };
    Map<String, String> map = Stream.of(str).map(e -> e.split("=")).collect(Collectors.toMap(a -> a[0], a -> a[1]));
    map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));

  }

  public static void exp1() {

    List<String> fruits = Arrays.asList("Apple", "Orange", "Grapes", "Banana");

    List<Fruit> fruitsObj = Arrays.asList(new Fruit("Apple", 100), new Fruit("Orange", 200));

    List<String> modified = fruitsObj.stream().map(e -> e.getName()).collect(Collectors.toList());

    System.out.println(modified);

  }

  public static void exp3() {
    String val = "firstname=ranjith,lastname=sekar";
    Map<Object, Object> str = Arrays.asList(val.split(",")).stream().map(e -> e.split("="))
        .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1], (k, v) -> k));
    System.out.println();

  }

  public static void exp4() {
    List<String> cf = Arrays.asList("_ab", "_bc", "_cd");
    Map<String, String> cfNames = new HashMap<>();
    cfNames.put("_ab", "AB");
    cfNames.put("_bc", "BC");
    cfNames.put("_cd", "CD");
    cfNames.put("_ef", "EF");

    String out = cf.stream().map(e -> cfNames.get(e)).collect(Collectors.joining(","));
    System.out.println(out);
  }
}

class Fruit {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  private int price;

  public Fruit() {

  }

  public Fruit(String name, int price) {
    this.name = name;
    this.price = price;
  }
}
