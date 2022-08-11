package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date dateWithDaysDifference(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    public static String formattedDate(Date data) {
        DateFormat format = new SimpleDateFormat("ddMMYYYY");
        return format.format(data);
    }


}
