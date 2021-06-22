package jbr.javaexp.util.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.ListUtils;

public class ListSplit {

  public static void main(String[] args) {
    List<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    List<List<String>> lists = ListUtils.partition(numbers, 3);
    lists.forEach(System.out::println);
  }
}
