package com.wdullaer.materialdatetimepicker.time;

import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.wdullaer.materialdatetimepicker.time.Timepoint;

/* loaded from: classes3.dex */
interface TimePickerController {
    int getAccentColor();

    TimePickerDialog.Version getVersion();

    boolean is24HourMode();

    boolean isAmDisabled();

    boolean isOutOfRange(Timepoint timepoint, int i);

    boolean isPmDisabled();

    boolean isThemeDark();

    Timepoint roundToNearest(Timepoint timepoint, Timepoint.TYPE type);

    void tryVibrate();
}
