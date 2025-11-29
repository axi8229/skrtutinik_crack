package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

/* loaded from: classes3.dex */
public class SimpleMonthView extends MonthView {
    public SimpleMonthView(Context context, AttributeSet attributeSet, DatePickerController datePickerController) {
        super(context, attributeSet, datePickerController);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.MonthView
    public void drawMonthDay(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (this.mSelectedDay == i3) {
            canvas.drawCircle(i4, i5 - (MonthView.MINI_DAY_NUMBER_TEXT_SIZE / 3), MonthView.DAY_SELECTED_CIRCLE_SIZE, this.mSelectedCirclePaint);
        }
        if (isHighlighted(i, i2, i3) && this.mSelectedDay != i3) {
            canvas.drawCircle(i4, (MonthView.MINI_DAY_NUMBER_TEXT_SIZE + i5) - MonthView.DAY_HIGHLIGHT_CIRCLE_MARGIN, MonthView.DAY_HIGHLIGHT_CIRCLE_SIZE, this.mSelectedCirclePaint);
            this.mMonthNumPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        } else {
            this.mMonthNumPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        }
        if (this.mController.isOutOfRange(i, i2, i3)) {
            this.mMonthNumPaint.setColor(this.mDisabledDayTextColor);
        } else if (this.mSelectedDay == i3) {
            this.mMonthNumPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            this.mMonthNumPaint.setColor(this.mSelectedDayTextColor);
        } else if (this.mHasToday && this.mToday == i3) {
            this.mMonthNumPaint.setColor(this.mTodayNumberColor);
        } else {
            this.mMonthNumPaint.setColor(isHighlighted(i, i2, i3) ? this.mHighlightedDayTextColor : this.mDayTextColor);
        }
        canvas.drawText(String.format(this.mController.getLocale(), "%d", Integer.valueOf(i3)), i4, i5, this.mMonthNumPaint);
    }
}
