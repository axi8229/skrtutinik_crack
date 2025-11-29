package com.wdullaer.materialdatetimepicker.time;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.wdullaer.materialdatetimepicker.R$color;
import com.wdullaer.materialdatetimepicker.R$string;
import com.wdullaer.materialdatetimepicker.Utils;
import java.text.DateFormatSymbols;
import java.util.Locale;
import kotlin.KotlinVersion;

/* loaded from: classes3.dex */
public class AmPmCirclesView extends View {
    private boolean mAmDisabled;
    private int mAmOrPm;
    private int mAmOrPmPressed;
    private int mAmPmCircleRadius;
    private float mAmPmCircleRadiusMultiplier;
    private int mAmPmDisabledTextColor;
    private int mAmPmSelectedTextColor;
    private int mAmPmTextColor;
    private int mAmPmYCenter;
    private String mAmText;
    private int mAmXCenter;
    private float mCircleRadiusMultiplier;
    private boolean mDrawValuesReady;
    private boolean mIsInitialized;
    private final Paint mPaint;
    private boolean mPmDisabled;
    private String mPmText;
    private int mPmXCenter;
    private int mSelectedAlpha;
    private int mSelectedColor;
    private int mTouchedColor;
    private int mUnselectedColor;

    public AmPmCirclesView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mIsInitialized = false;
    }

    public void initialize(Context context, Locale locale, TimePickerController timePickerController, int i) {
        if (this.mIsInitialized) {
            Log.e("AmPmCirclesView", "AmPmCirclesView may only be initialized once.");
            return;
        }
        Resources resources = context.getResources();
        if (timePickerController.isThemeDark()) {
            this.mUnselectedColor = ContextCompat.getColor(context, R$color.mdtp_circle_background_dark_theme);
            this.mAmPmTextColor = ContextCompat.getColor(context, R$color.mdtp_white);
            this.mAmPmDisabledTextColor = ContextCompat.getColor(context, R$color.mdtp_date_picker_text_disabled_dark_theme);
            this.mSelectedAlpha = KotlinVersion.MAX_COMPONENT_VALUE;
        } else {
            this.mUnselectedColor = ContextCompat.getColor(context, R$color.mdtp_white);
            this.mAmPmTextColor = ContextCompat.getColor(context, R$color.mdtp_ampm_text_color);
            this.mAmPmDisabledTextColor = ContextCompat.getColor(context, R$color.mdtp_date_picker_text_disabled);
            this.mSelectedAlpha = KotlinVersion.MAX_COMPONENT_VALUE;
        }
        int accentColor = timePickerController.getAccentColor();
        this.mSelectedColor = accentColor;
        this.mTouchedColor = Utils.darkenColor(accentColor);
        this.mAmPmSelectedTextColor = ContextCompat.getColor(context, R$color.mdtp_white);
        this.mPaint.setTypeface(Typeface.create(resources.getString(R$string.mdtp_sans_serif), 0));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mCircleRadiusMultiplier = Float.parseFloat(resources.getString(R$string.mdtp_circle_radius_multiplier));
        this.mAmPmCircleRadiusMultiplier = Float.parseFloat(resources.getString(R$string.mdtp_ampm_circle_radius_multiplier));
        String[] amPmStrings = new DateFormatSymbols(locale).getAmPmStrings();
        this.mAmText = amPmStrings[0];
        this.mPmText = amPmStrings[1];
        this.mAmDisabled = timePickerController.isAmDisabled();
        this.mPmDisabled = timePickerController.isPmDisabled();
        setAmOrPm(i);
        this.mAmOrPmPressed = -1;
        this.mIsInitialized = true;
    }

    public void setAmOrPm(int i) {
        this.mAmOrPm = i;
    }

    public void setAmOrPmPressed(int i) {
        this.mAmOrPmPressed = i;
    }

    public int getIsTouchingAmOrPm(float f, float f2) {
        if (!this.mDrawValuesReady) {
            return -1;
        }
        int i = this.mAmPmYCenter;
        int i2 = (int) ((f2 - i) * (f2 - i));
        int i3 = this.mAmXCenter;
        float f3 = i2;
        if (((int) Math.sqrt(((f - i3) * (f - i3)) + f3)) <= this.mAmPmCircleRadius && !this.mAmDisabled) {
            return 0;
        }
        int i4 = this.mPmXCenter;
        return (((int) Math.sqrt((double) (((f - ((float) i4)) * (f - ((float) i4))) + f3))) > this.mAmPmCircleRadius || this.mPmDisabled) ? -1 : 1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (getWidth() == 0 || !this.mIsInitialized) {
            return;
        }
        if (!this.mDrawValuesReady) {
            int width = getWidth() / 2;
            int height = getHeight() / 2;
            int iMin = (int) (Math.min(width, height) * this.mCircleRadiusMultiplier);
            int i6 = (int) (iMin * this.mAmPmCircleRadiusMultiplier);
            this.mAmPmCircleRadius = i6;
            int i7 = (int) (height + (i6 * 0.75d));
            this.mPaint.setTextSize((i6 * 3) / 4);
            int i8 = this.mAmPmCircleRadius;
            this.mAmPmYCenter = (i7 - (i8 / 2)) + iMin;
            this.mAmXCenter = (width - iMin) + i8;
            this.mPmXCenter = (width + iMin) - i8;
            this.mDrawValuesReady = true;
        }
        int i9 = this.mUnselectedColor;
        int i10 = this.mAmPmTextColor;
        int i11 = this.mAmOrPm;
        if (i11 == 0) {
            i = this.mSelectedColor;
            i3 = this.mSelectedAlpha;
            i4 = 255;
            i5 = i9;
            i2 = i10;
            i10 = this.mAmPmSelectedTextColor;
        } else if (i11 == 1) {
            int i12 = this.mSelectedColor;
            int i13 = this.mSelectedAlpha;
            i2 = this.mAmPmSelectedTextColor;
            i4 = i13;
            i3 = 255;
            i5 = i12;
            i = i9;
        } else {
            i = i9;
            i2 = i10;
            i3 = 255;
            i4 = 255;
            i5 = i;
        }
        int i14 = this.mAmOrPmPressed;
        if (i14 == 0) {
            i = this.mTouchedColor;
            i3 = this.mSelectedAlpha;
        } else if (i14 == 1) {
            i5 = this.mTouchedColor;
            i4 = this.mSelectedAlpha;
        }
        if (this.mAmDisabled) {
            i10 = this.mAmPmDisabledTextColor;
            i = i9;
        }
        if (this.mPmDisabled) {
            i2 = this.mAmPmDisabledTextColor;
        } else {
            i9 = i5;
        }
        this.mPaint.setColor(i);
        this.mPaint.setAlpha(i3);
        canvas.drawCircle(this.mAmXCenter, this.mAmPmYCenter, this.mAmPmCircleRadius, this.mPaint);
        this.mPaint.setColor(i9);
        this.mPaint.setAlpha(i4);
        canvas.drawCircle(this.mPmXCenter, this.mAmPmYCenter, this.mAmPmCircleRadius, this.mPaint);
        this.mPaint.setColor(i10);
        float fDescent = this.mAmPmYCenter - (((int) (this.mPaint.descent() + this.mPaint.ascent())) / 2);
        canvas.drawText(this.mAmText, this.mAmXCenter, fDescent, this.mPaint);
        this.mPaint.setColor(i2);
        canvas.drawText(this.mPmText, this.mPmXCenter, fDescent, this.mPaint);
    }
}
