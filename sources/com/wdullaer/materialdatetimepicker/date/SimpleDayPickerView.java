package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;

/* loaded from: classes3.dex */
public class SimpleDayPickerView extends DayPickerView {
    public SimpleDayPickerView(Context context, DatePickerController datePickerController) {
        super(context, datePickerController);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DayPickerView
    public MonthAdapter createMonthAdapter(DatePickerController datePickerController) {
        return new SimpleMonthAdapter(datePickerController);
    }
}
