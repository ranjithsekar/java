package com.clv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

  public static void main(String[] args) throws Exception {
    BufferedReader csvReader = new BufferedReader(new FileReader("input-csv/sep16_alerts.csv"));
    String row;
    while ((row = csvReader.readLine()) != null) {
      List<String> data = Arrays.asList(row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
      System.out.println("email: "+data.get(0));
    }
    csvReader.close();
  }
}
