package jbr.outofmemoryerror;

import java.util.HashMap;
import java.util.Map;

public class OutOfMemoryErrorDemo {

  private static Map<String, OutOfMemoryErrorDemo> oom = new HashMap<>();
  private static String sampleData = "OUTOFMEMORYERRORWILLHAPPENIFTHESIZEREACHESMORE";

  public static void main(String[] args) {
    System.out.println("Starting..........");

    try {
      for (int i = 0; i < 100000000; i++) {
        String data = sampleData + i;
        oom.put(data, new OutOfMemoryErrorDemo());

        if (false) {
          try {
            Thread.sleep(1);
          } catch (Exception e) {
          }
        }
      }
    } catch (Exception e) {
    }

    System.out.println("Ending........");
  }
}
