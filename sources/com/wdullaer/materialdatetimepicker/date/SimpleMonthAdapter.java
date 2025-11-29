package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;

/* loaded from: classes3.dex */
public class SimpleMonthAdapter extends MonthAdapter {
    public SimpleMonthAdapter(DatePickerController datePickerController) {
        super(datePickerController);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.MonthAdapter
    public MonthView createMonthView(Context context) {
        return new SimpleMonthView(context, null, this.mController);
    }
}
