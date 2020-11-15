package be.multimedi.jammik.tools;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 * Gemaakt door Jan
 */
public class DateTimeTool {

    public static boolean checkTimeFormatting(Time time) {
        return time.toString().matches("[\\d]{2}:[\\d]{2}");
    }

    public static boolean checkDateTimeFormatting(LocalDateTime ldt) {
        return ldt.toString().matches("[\\d]{4}-[\\d]{2}-[\\d]{2}T[\\d]{2}:[\\d]{2}");
    }
}
