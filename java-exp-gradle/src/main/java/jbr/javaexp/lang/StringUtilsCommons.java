package jbr.javaexp.lang;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsCommons {

  public static void main(String[] args) {
    removeFirstAndLast();
  }
  
  public static void removeFirstAndLast() {
    String str = "\"ranjith \"sekar\"";
    str = StringUtils.removeStart(str, "\"");
    str = StringUtils.removeEnd(str, "\"");
    System.out.println(str);
    
    String str2 = "\"this is \"java program\"";
    str2 = str2.replaceAll("\"|\"", "");
    System.out.println(str2);
  }
  
  public static void ex4() {
    String str = "((1 AND 2));";
    if (str.endsWith(";")) str = StringUtils.removeEnd(str, ";");
    str = str.replaceFirst("\\(", "");
    str = StringUtils.removeEnd(str, ")");
    System.out.println(str);
  }

  public static void ex3() {
    String name = "ranjith";
    System.out.println(StringUtils.capitalize(name.toLowerCase()));

    // ex2();
  }

  public static void ex0() {
    String st = "ab,ls,cd";
    System.out
        .println(Stream.of(st.split(",")).filter(e -> !e.equalsIgnoreCase("ls")).collect(Collectors.joining(",")));

  }

  public static void ex1() {
    String str = "US9932708B2 Process for manufacturing a composite article comprising cellulose pulp fibers and a thermoplastic matrix";
    String pn = str.split(" ")[0];
    System.out.println(pn);
    String title = str.replace(pn + " ", "");
    System.out.println(title);
  }

  public static void ex2() {
    String[] arr = new String[] { "1008407680", "1008407458", "1008407483" };
    String out = "(" + Arrays.asList(arr).stream().map(e -> "'" + e + "'").collect(Collectors.joining(",")) + ")";
    System.out.println(out);
  }
}
