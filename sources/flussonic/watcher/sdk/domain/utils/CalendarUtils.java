package flussonic.watcher.sdk.domain.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class CalendarUtils {
    public static String toString(long seconds, String pattern) {
        return new SimpleDateFormat(pattern).format(Long.valueOf(seconds * 1000));
    }

    public static long toSeconds(Calendar calendar) {
        return calendar.getTimeInMillis() / 1000;
    }

    public static Calendar calendar(long seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(seconds * 1000);
        return calendar;
    }

    public static boolean equals(Calendar calendar1, Calendar calendar2) {
        return calendar1.get(1) == calendar2.get(1) && calendar1.get(6) == calendar2.get(6);
    }
}
