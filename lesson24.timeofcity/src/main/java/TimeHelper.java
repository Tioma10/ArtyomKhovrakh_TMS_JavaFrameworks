import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeHelper {
    public static String getCurrentTime(String city, String zoneId) {
        ZoneId zone = ZoneId.of(zoneId);
        ZonedDateTime now = ZonedDateTime.now(zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Current time in " + city + ": " + now.format(formatter);
    }
}