package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GeneralHelpers {

    public static String GetCurrentRandomizedDateTimeEmail() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        LocalDateTime now = LocalDateTime.now();

        Random random = new Random();

        return dtf.format(now) + random.nextInt(1000000) + "@mail.com";
    }
}
