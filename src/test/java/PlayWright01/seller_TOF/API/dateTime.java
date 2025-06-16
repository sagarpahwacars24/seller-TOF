package PlayWright01.seller_TOF.API;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateTime {
	
	public static String[] getFutureDateAndTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        int initialDay = currentDateTime.getDayOfMonth();

        // Add 2 hours
        LocalDateTime futureDateTime = currentDateTime.plusHours(2);

        // Extract values
        int futureDay = futureDateTime.getDayOfMonth();

        // Formatters
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:00:00");

        // Determine future date string
        String futureDate;
        if (futureDay != initialDay) {
            futureDate = futureDateTime.format(dateFormatter);
        } else {
            // If date hasn't changed, keep the initial day but adjust hour
            futureDate = currentDateTime.format(dateFormatter);
        }

        String futureTime = futureDateTime.format(timeFormatter);

        // Print for verification (can be removed in production)
        System.out.println("Future Date (string): " + futureDate);
        System.out.println("Future Time (string): " + futureTime);

        return new String[]{futureDate, futureTime};
    }
}