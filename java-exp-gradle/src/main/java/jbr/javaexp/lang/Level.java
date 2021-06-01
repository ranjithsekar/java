package jbr.javaexp.lang;

public enum Level {

  STANDARD(1, "Standard"), ENHANCED(2, "Enhanced");

  int level;
  String name;

  Level(int level, String name) {
    this.level = level;
    this.name = name;
  }

  public int getLevel() {
    return this.level;
  }

  public String getName() {
    return this.name;
  }

  public static Level getEnumByLevel(int level) {
    Level levelValue = null;

    for (Level wrAccess : Level.values()) {
      if (level == wrAccess.getLevel()) {
        levelValue = wrAccess;
        break;
      }
    }
    return levelValue;
  }

}
