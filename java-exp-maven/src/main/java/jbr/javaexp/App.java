package jbr.javaexp;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class App {
  static {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hhmmss");
    System.setProperty("current.date", dateFormat.format(new Date()));
  }

  public void loadfile() {
    System.out.println(System.getProperty("current.date"));
  }

  public static void main(String[] args) throws Exception {
    Map<String, String> map = new HashMap<>();
    map.put("a", "first");
    map.put("a", "last");
    map.put("a", "last1");

    System.out.println(map.entrySet()
        .size());
    System.out.println(map.get("a"));
    map.entrySet()
        .forEach(e ->
          {
            System.out.println(e.getKey() + e.getValue());
          });

    System.out.println(System.getProperty("current.date"));
  }

  public void exp1() throws Exception {
    List<String> products = new ArrayList<>();

    for (int i = 1; i < 20000; i++) {
      String str = "INSERT INTO springjdbc.product VALUES('" + i + "','name" + i + "','category" + i + "','description"
          + i + "','price" + i + "');";
      products.add(str);
    }
    Files.write(Paths.get("test.sql"), products);

  }
}
