package com.yandex.metrica.billing_interface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class c {
    private static final Pattern c = Pattern.compile("P(\\d+)(\\S+)");
    public final int a;
    public final a b;

    public enum a {
        TIME_UNIT_UNKNOWN,
        DAY,
        WEEK,
        MONTH,
        YEAR
    }

    public c(int i, a aVar) {
        this.a = i;
        this.b = aVar;
    }

    public static c a(String str) {
        Matcher matcher = c.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        if (strGroup == null || strGroup2 == null) {
            return null;
        }
        try {
            int i = Integer.parseInt(strGroup);
            char cCharAt = strGroup2.charAt(0);
            return new c(i, cCharAt != 'D' ? cCharAt != 'M' ? cCharAt != 'W' ? cCharAt != 'Y' ? a.TIME_UNIT_UNKNOWN : a.YEAR : a.WEEK : a.MONTH : a.DAY);
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b == cVar.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Period{number=" + this.a + "timeUnit=" + this.b + "}";
    }
}
