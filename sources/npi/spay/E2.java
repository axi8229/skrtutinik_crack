package npi.spay;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class E2 {
    public static final Locale a = new Locale("RU");

    public static String a() {
        Date time = Calendar.getInstance().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getInstance().time");
        StringBuilder sb = new StringBuilder(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", a).format(time));
        sb.insert(sb.length() - 2, ":");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }
}
