package com.wdullaer.materialdatetimepicker.time;

import android.os.Parcelable;
import com.wdullaer.materialdatetimepicker.time.Timepoint;

/* loaded from: classes3.dex */
public interface TimepointLimiter extends Parcelable {
    boolean isAmDisabled();

    boolean isOutOfRange(Timepoint timepoint, int i, Timepoint.TYPE type);

    boolean isPmDisabled();

    Timepoint roundToNearest(Timepoint timepoint, Timepoint.TYPE type, Timepoint.TYPE type2);
}
