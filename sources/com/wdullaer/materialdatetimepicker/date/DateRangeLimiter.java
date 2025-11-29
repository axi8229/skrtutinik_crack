package com.wdullaer.materialdatetimepicker.date;

import android.os.Parcelable;
import java.util.Calendar;

/* loaded from: classes3.dex */
public interface DateRangeLimiter extends Parcelable {
    Calendar getEndDate();

    Calendar getStartDate();

    boolean isOutOfRange(int i, int i2, int i3);

    Calendar setToNearestDate(Calendar calendar);

    default int getMinYear() {
        return getStartDate().get(1);
    }

    default int getMaxYear() {
        return getEndDate().get(1);
    }
}
