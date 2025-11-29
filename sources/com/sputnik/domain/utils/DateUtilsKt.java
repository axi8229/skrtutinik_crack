package com.sputnik.domain.utils;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: DateUtils.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\u001a\u0019\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0019\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\t\u0010\b\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\u0003\u001a\u0011\u0010\r\u001a\u00020\u0000*\u00020\u0006¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "localeTag", "toDMYFormat", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "toDMYDigitsFormat", "toDMMYFormat", "", "toNanoFormat", "(Ljava/lang/String;)J", "toNanoDateFormat", "toTimeFormat", "(Ljava/lang/String;)Ljava/lang/String;", "toDMYTimeFormat", "toTime", "(J)Ljava/lang/String;", CrashHianalyticsData.TIME, "pattern", "convertMillisToTime", "(JLjava/lang/String;)Ljava/lang/String;", "domain"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DateUtilsKt {
    public static final String toDMYFormat(String str, String localeTag) throws ParseException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(localeTag, "localeTag");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy", Locale.forLanguageTag(localeTag));
        Date date = simpleDateFormat.parse(str);
        Intrinsics.checkNotNull(date);
        String str2 = simpleDateFormat2.format(date);
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static final String toDMYDigitsFormat(String str, String localeTag) throws ParseException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(localeTag, "localeTag");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd.MM, HH:mm", Locale.forLanguageTag(localeTag));
        Date date = simpleDateFormat.parse(str);
        Intrinsics.checkNotNull(date);
        String str2 = simpleDateFormat2.format(date);
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static final String toDMMYFormat(String str, String localeTag) throws ParseException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(localeTag, "localeTag");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMMM yyyy", Locale.forLanguageTag(localeTag));
        Date date = simpleDateFormat.parse(str);
        Intrinsics.checkNotNull(date);
        String str2 = simpleDateFormat2.format(date);
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static final long toNanoFormat(String str) throws ParseException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ").parse(str);
        if (date != null) {
            return date.getTime();
        }
        return 0L;
    }

    public static final long toNanoDateFormat(String str) throws ParseException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy");
        Date date = simpleDateFormat2.parse(simpleDateFormat2.format(simpleDateFormat.parse(str)));
        if (date != null) {
            return date.getTime();
        }
        return 0L;
    }

    public static final String toTimeFormat(String str) throws ParseException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");
        Date date = simpleDateFormat.parse(str);
        Intrinsics.checkNotNull(date);
        String str2 = simpleDateFormat2.format(date);
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static final String toDMYTimeFormat(String str, String localeTag) throws ParseException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(localeTag, "localeTag");
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZZ").parse(str);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.forLanguageTag(localeTag));
        Intrinsics.checkNotNull(date);
        String str2 = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static final String toTime(long j) {
        long j2 = j / 1000;
        long j3 = 3600;
        long j4 = j2 / j3;
        long j5 = 60;
        long j6 = (j2 % j3) / j5;
        long j7 = j2 % j5;
        if (j4 == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j6), Long.valueOf(j7)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            return str;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String str2 = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j4), Long.valueOf(j6), Long.valueOf(j7)}, 3));
        Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
        return str2;
    }

    public static final String convertMillisToTime(long j, String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        String str = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
