package com.clv.cipamig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class CipaAlertCsvGenerator {

  public static void main(String[] args) throws Exception {
    List<String> cipaAlerts = new ArrayList<String>();
    String fileName = "Phase 1-III Searches ALL 20200627";
    Stream<Path> files = Files.walk(Paths.get(fileName));
    List<String> quotedQueriesFile = new ArrayList<>();

    Map<String, CipaAlert> emails = getEmails();

    files.forEach(e -> {
      if (Files.isRegularFile(e)) {
        try {
          List<String> content = Files.readAllLines(e);
          String query = "", alertName = "", location = "", ownerEmail = "", subscribers = "", categories = "";

          boolean queryHasDoubtQuote = false;
          for (int i = 1; i < content.size(); i++) {
            if (content.get(i).endsWith(";")) {
              query = query + content.get(i);
              break;
            } else {
              query = query + content.get(i);
            }
            if (query.contains("\"")) {
              queryHasDoubtQuote = true;
              quotedQueriesFile.add(e.getFileName().toString());
              break;
            }
          }

          if (!queryHasDoubtQuote) {
            for (int i = 1; i < content.size(); i++) {
              if (content.get(i).startsWith("AlertName - "))
                alertName = StringUtils.removeStart(content.get(i), "AlertName - ");

              if (content.get(i).startsWith("Location - .corporateProfiles/"))
                location = StringUtils.removeStart(content.get(i), "Location - .corporateProfiles/");

              CipaAlert cipaAlert = emails.get(alertName.trim());
              if (null != cipaAlert) {
                ownerEmail = cipaAlert.getOwner();
                subscribers = cipaAlert.getSubscribers();
              }

              if (content.get(i).startsWith("Categories - "))
                categories = StringUtils.removeStart(content.get(i), "Categories - ");
            }
            String alert = ownerEmail + "," + alertName.trim() + ",\"" + query + "\"," + subscribers + "," + location
                + "," + categories;
            System.out.println(alert);
            cipaAlerts.add(alert);
          }
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    });
    // cipaAlerts.forEach(System.out::println);
    Files.write(Paths.get(fileName + ".csv"), cipaAlerts);
    Files.write(Paths.get(fileName + "-quote-files.txt"), quotedQueriesFile);
    files.close();
  }

  public static Map<String, CipaAlert> getEmails() throws Exception {
    Map<String, CipaAlert> emails = new HashMap<>();

    BufferedReader alertReader = new BufferedReader(new FileReader("alert-emails.csv"));
    String alertLine;

    while ((alertLine = alertReader.readLine()) != null) {
      List<String> alertData = Arrays.asList(alertLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1));
      String alertName = alertData.get(0).trim();
      String owner = alertData.get(1).trim();
      String subscribers = alertData.get(2).trim();
      emails.put(alertName, new CipaAlert(alertName, owner, subscribers));
    }
    alertReader.close();

    return emails;
  }
}
