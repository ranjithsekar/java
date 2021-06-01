package jbr.javaexp.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileRead {

  public static void main(String[] args) throws IOException {
    File folder = new File("input");
    File[] files = folder.listFiles();
    for(int i=0; i< files.length; i++) {
      System.out.println(files[i].getAbsolutePath());
    }
    
  }
  
  public void ex1() throws IOException {

    Stream<Path> paths = Files.list(Paths.get("input"));
    paths.forEach(e -> {
      System.out.println(e.toAbsolutePath());
    });
    paths.close();
  
  }
}
