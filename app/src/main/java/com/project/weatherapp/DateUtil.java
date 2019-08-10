package com.project.weatherapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

  private final static String DATE_FORMAT = "yyyy-MM-dd";

  public static String getDayFromDate(String dateString) {

    Date date = null;
    try {
      date = new SimpleDateFormat(DATE_FORMAT).parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);

  }
}
