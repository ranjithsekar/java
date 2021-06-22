package jbr.javaexp.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

public class DateParser {

  public static void main(String[] args) throws ParseException {
    String dateStr = "12-SEP-20";
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
    Date date = sdf.parse(dateStr);
    System.out.println(date);
  }

  public static void ex3() {
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
      sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
      System.out.println(sdf.format(new Date()));
    } catch (Exception e) {
    }

  }

  public static void ex2() throws Exception {

    System.out.println(LocalDateTime.now());
    System.out.println(formatDate(new Date(), "yyyy-MM-dd-HH-mm-ss"));
    for (int i = 0; i < 1000000; i++) {
      int c = 10 + 3;
      System.out.println("------");
    }
    System.out.println(formatDate(new Date(), "yyyy-MM-dd-HH-mm-ss"));
    System.out.println(LocalDateTime.now());

  }

  public static void ex1() throws Exception {
    String input = "2019/12/09";
    Date inputDate = new SimpleDateFormat("MM/dd/yyyy").parse(input);
    System.out.println(inputDate);
    // DSate inputDatConv = new
    // SimpleDateFormat("yyyy-MM-dd").format(inputDate);
    String feedDate = new SimpleDateFormat("yyyy/MM/dd").format(inputDate);
  }

  public static String formatDate(Date date, String format) {
    if (date == null) {
      return null;
    }
    DateFormat df = new SimpleDateFormat(format);
    return df.format(date);
  }
}
