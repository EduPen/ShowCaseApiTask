package Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class commonMethods {

    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now().minusHours(2);
        return dtf.format(now);
    }


    public static String getCurrentEpochTime() {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        return String.valueOf(currentTimestamp);
    }

    public static boolean validateDateFormat(String date) {
        try {
            SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parseDate = dtf.parse(date);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
