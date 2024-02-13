package Methods.PunchTasks.microTasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class userDate {
    public static String sqlDate() {
        LocalDate currentDate = LocalDate.now();

        // Format the date as per your requirement
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String sqlDate = currentDate.format(formatter);

        return sqlDate;


    }
}
