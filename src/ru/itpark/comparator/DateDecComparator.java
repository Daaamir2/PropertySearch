package ru.itpark.comparator;

import ru.itpark.domain.House;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class DateDecComparator implements Comparator<House> {
    @Override
    public int compare(House o1, House o2) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Calendar dateO1 = new GregorianCalendar();
        Calendar dateO2 = new GregorianCalendar();
        try {
            dateO1.setTime(format.parse(o1.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            dateO2.setTime(format.parse(o2.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long result = dateO1.getTimeInMillis() - dateO2.getTimeInMillis();
        if (result > 0) {
            return 1;
        } else if (result == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
