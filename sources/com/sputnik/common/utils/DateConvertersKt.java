package com.sputnik.common.utils;

import com.sputnik.common.entities.localization.CommonDates;
import com.sputnik.common.entities.localization.CommonLocale;
import com.sputnik.common.entities.localization.NamingSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateConverters.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"getSecondsInString", "", "valueInt", "", "locales", "Lcom/sputnik/common/entities/localization/CommonLocale;", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DateConvertersKt {
    public static final String getSecondsInString(long j, CommonLocale locales) {
        NamingSet seconds;
        NamingSet seconds2;
        NamingSet seconds3;
        NamingSet seconds4;
        Intrinsics.checkNotNullParameter(locales, "locales");
        long jAbs = Math.abs(j) % 100;
        long j2 = jAbs % 10;
        String many = null;
        if (11 <= jAbs && jAbs < 20) {
            CommonDates dates = locales.getDates();
            if (dates != null && (seconds4 = dates.getSeconds()) != null) {
                many = seconds4.getMany();
            }
            return String.valueOf(many);
        }
        if (2 <= j2 && j2 < 5) {
            CommonDates dates2 = locales.getDates();
            if (dates2 != null && (seconds3 = dates2.getSeconds()) != null) {
                many = seconds3.getFew();
            }
            return String.valueOf(many);
        }
        if (j2 == 1) {
            CommonDates dates3 = locales.getDates();
            if (dates3 != null && (seconds2 = dates3.getSeconds()) != null) {
                many = seconds2.getSingle();
            }
            return String.valueOf(many);
        }
        CommonDates dates4 = locales.getDates();
        if (dates4 != null && (seconds = dates4.getSeconds()) != null) {
            many = seconds.getMany();
        }
        return String.valueOf(many);
    }
}
