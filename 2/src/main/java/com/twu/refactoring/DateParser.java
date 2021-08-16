package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    //TODO: DELETE comments
    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    //TODO: SOLUTION 1: use Enum for (YEAR, MONTH, DATE, HOUR, MINUTE)

    //TODO: SOLUTION 2: extract to different sub-class of (MonthParser, TimeParser, etc) and parent class BaseParser.
    // In BaseParser, you can have base methods:
    // parseValue: parse values
    // checkLimit: check characters limitation
    // parseToInt: check if value can be parsed to integer
    // getPartOfDateOrTime: get date or time value
    public Date parse() {

        int year = parse(0, 4, "Year string is less than 4 characters", "Year is not an integer", 2000, 2012, "Year cannot be less than 2000 or more than 2012");
        int month = parse(5, 7, "Month string is less than 2 characters", "Month is not an integer", 1, 12, "Month cannot be less than 1 or more than 12");
        int date = parse(8, 10, "Date string is less than 2 characters", "Date is not an integer", 1, 31, "Date cannot be less than 1 or more than 31");

        int hour,minute;
        if (dateAndTimeString.charAt(11) == 'Z') {
            hour = 0;
            minute = 0;
        } else {
            hour = parse(11, 13, "Hour string is less than 2 characters", "Hour is not an integer", 0, 23, "Hour cannot be less than 0 or more than 23");
            minute = parse(14,16,"Minute string is less than 2 characters","Minute is not an integer",0,59,"Minute cannot be less than 0 or more than 59");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private int parse(int startIndex, int endIndex, String indexOutOfExceptionMessage, String numberFormatExceptionMessage, int startValidValue, int endValidValue, String invalidMessage) {
        int value;
        try {
            String yearString = dateAndTimeString.substring(startIndex, endIndex);
            value = Integer.parseInt(yearString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(indexOutOfExceptionMessage);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(numberFormatExceptionMessage);
        }
        if (value < startValidValue || value > endValidValue)
            throw new IllegalArgumentException(invalidMessage);
        return value;
    }
}
