package jbr.javaex.util.streams;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Collectors {

  public static void main(String[] args) {
    List<Person> person = Arrays.asList(new Person("Ranjith", "33"), new Person("Kabilan", "6"));

    String age = person.stream().filter(e -> e.getName().equalsIgnoreCase("Ranjith")).map(e -> e.getAge()).findFirst()
        .get();
    System.out.println(age);
  }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Person {
  private String name;
  private String age;
}