package jbr.javaexp.lang;

public class EnumLevelTest {

  public static void main(String[] args) {
    System.out.println(Level.STANDARD.getName());
    System.out.println(Level.getEnumByLevel(1).name());
  }
}
