package java8;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {

	public static void main(String[] args) {
		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		
        ZonedDateTime currentDateTimeInIndia = ZonedDateTime.of(LocalDateTime.now(), zoneId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        String formattedDateTime = currentDateTimeInIndia.format(formatter);


        System.out.println("Current Date and Time in India: " + formattedDateTime);
	}

}
