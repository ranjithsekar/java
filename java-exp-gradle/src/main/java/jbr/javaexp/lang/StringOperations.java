package jbr.javaexp.lang;

import org.apache.commons.lang3.StringUtils;

public class StringOperations {

  public static void main(String[] args) {
    
    String str = "watched record plus";
    System.out.println(str.contains(" "));
    
  }

  public static void exp1() {
    String separator = "\\";
    String value = "a\\Main\\text.txt";
    value = StringUtils.remove(value, "\\" + "Main");
    String[] arrValues = value.split("\\\\");
    for (String s : arrValues) {
      System.out.println(s);
    }

  }
}
