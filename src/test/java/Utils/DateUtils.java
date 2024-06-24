package Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;

public class DateUtils {
    private DateUtils() {
        throw new UnsupportedOperationException("Utility Class Do not instantiate");
    }

    public static FutureDateCalculator calculator = no -> {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, no);
        return sdf.format(c.getTime());
    };


    public static ExtractNumberDays extractNumberDays = (input) -> {
        String numberPart = input.substring(0, input.indexOf(" days later")).trim();
        try {
            return Integer.parseInt(numberPart);
        } catch (NumberFormatException e) {
            return -1;
        }
    };


    public static String calculateTravelDate(String input) {
        Integer no = extractNumberDays.extract(input);
        return calculator.calculateFutureDate(no);
    }

}

