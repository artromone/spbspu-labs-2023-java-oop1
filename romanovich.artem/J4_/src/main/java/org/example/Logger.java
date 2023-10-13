package org.example;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Logger {

  public static final int LEVEL_DEBUG = 1;
  public static final int LEVEL_ERROR = 2;

  private static final String MSG_DEBUG = "DEBUG";
  private static final String MSG_ERROR = "ERROR";

  private static final Map<Integer, String> levelNames = new HashMap<>();

  static {
    levelNames.put(LEVEL_DEBUG, MSG_DEBUG);
    levelNames.put(LEVEL_ERROR, MSG_ERROR);
  }

  public static void log(String message, int level) {
    String label = levelNames.getOrDefault(level, "INFO ");
    printLog(message, MSG_ERROR);
  }

  public static void debug(String message) {
    printLog(message, MSG_DEBUG);
  }

  public static void error(String message) {
    printLog(message, MSG_ERROR);
  }

  private static void printLog(String message, String level) {
    Calendar cal = Calendar.getInstance();
    System.out.println(cal.getTime() + " [" + level + "] " + message);
  }
}
