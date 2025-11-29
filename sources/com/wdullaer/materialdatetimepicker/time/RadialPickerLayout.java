package com.wdullaer.materialdatetimepicker.time;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.wdullaer.materialdatetimepicker.R$color;
import com.wdullaer.materialdatetimepicker.time.RadialTextsView;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.wdullaer.materialdatetimepicker.time.Timepoint;
import java.util.Calendar;
import java.util.Locale;
import org.pjsip.pjsua2.pjsip_transport_type_e;

/* loaded from: classes3.dex */
public class RadialPickerLayout extends FrameLayout implements View.OnTouchListener {
    private final int TAP_TIMEOUT;
    private final int TOUCH_SLOP;
    private AccessibilityManager mAccessibilityManager;
    private AmPmCirclesView mAmPmCirclesView;
    private CircleView mCircleView;
    private TimePickerController mController;
    private int mCurrentItemShowing;
    private Timepoint mCurrentTime;
    private boolean mDoingMove;
    private boolean mDoingTouch;
    private int mDownDegrees;
    private float mDownX;
    private float mDownY;
    private View mGrayBox;
    private Handler mHandler;
    private RadialSelectorView mHourRadialSelectorView;
    private RadialTextsView mHourRadialTextsView;
    private boolean mInputEnabled;
    private boolean mIs24HourMode;
    private int mIsTouchingAmOrPm;
    private Timepoint mLastValueSelected;
    private OnValueSelectedListener mListener;
    private RadialSelectorView mMinuteRadialSelectorView;
    private RadialTextsView mMinuteRadialTextsView;
    private RadialSelectorView mSecondRadialSelectorView;
    private RadialTextsView mSecondRadialTextsView;
    private int[] mSnapPrefer30sMap;
    private boolean mTimeInitialized;
    private AnimatorSet mTransition;

    public interface OnValueSelectedListener {
        void advancePicker(int i);

        void enablePicker();

        void onValueSelected(Timepoint timepoint);
    }

    public RadialPickerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsTouchingAmOrPm = -1;
        this.mHandler = new Handler();
        setOnTouchListener(this);
        this.TOUCH_SLOP = ViewConfiguration.get(context).getScaledTouchSlop();
        this.TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        this.mDoingMove = false;
        CircleView circleView = new CircleView(context);
        this.mCircleView = circleView;
        addView(circleView);
        AmPmCirclesView amPmCirclesView = new AmPmCirclesView(context);
        this.mAmPmCirclesView = amPmCirclesView;
        addView(amPmCirclesView);
        RadialSelectorView radialSelectorView = new RadialSelectorView(context);
        this.mHourRadialSelectorView = radialSelectorView;
        addView(radialSelectorView);
        RadialSelectorView radialSelectorView2 = new RadialSelectorView(context);
        this.mMinuteRadialSelectorView = radialSelectorView2;
        addView(radialSelectorView2);
        RadialSelectorView radialSelectorView3 = new RadialSelectorView(context);
        this.mSecondRadialSelectorView = radialSelectorView3;
        addView(radialSelectorView3);
        RadialTextsView radialTextsView = new RadialTextsView(context);
        this.mHourRadialTextsView = radialTextsView;
        addView(radialTextsView);
        RadialTextsView radialTextsView2 = new RadialTextsView(context);
        this.mMinuteRadialTextsView = radialTextsView2;
        addView(radialTextsView2);
        RadialTextsView radialTextsView3 = new RadialTextsView(context);
        this.mSecondRadialTextsView = radialTextsView3;
        addView(radialTextsView3);
        preparePrefer30sMap();
        this.mLastValueSelected = null;
        this.mInputEnabled = true;
        View view = new View(context);
        this.mGrayBox = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mGrayBox.setBackgroundColor(ContextCompat.getColor(context, R$color.mdtp_transparent_black));
        this.mGrayBox.setVisibility(4);
        addView(this.mGrayBox);
        this.mAccessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.mTimeInitialized = false;
    }

    public void setOnValueSelectedListener(OnValueSelectedListener onValueSelectedListener) {
        this.mListener = onValueSelectedListener;
    }

    public void initialize(Context context, Locale locale, TimePickerController timePickerController, Timepoint timepoint, boolean z) {
        String[] strArr;
        int[] iArr;
        String str;
        int i = 0;
        if (this.mTimeInitialized) {
            Log.e("RadialPickerLayout", "Time has already been initialized.");
            return;
        }
        this.mController = timePickerController;
        this.mIs24HourMode = this.mAccessibilityManager.isTouchExplorationEnabled() || z;
        this.mCircleView.initialize(context, this.mController);
        this.mCircleView.invalidate();
        if (!this.mIs24HourMode && this.mController.getVersion() == TimePickerDialog.Version.VERSION_1) {
            this.mAmPmCirclesView.initialize(context, locale, this.mController, !timepoint.isAM() ? 1 : 0);
            this.mAmPmCirclesView.invalidate();
        }
        RadialTextsView.SelectionValidator selectionValidator = new RadialTextsView.SelectionValidator() { // from class: com.wdullaer.materialdatetimepicker.time.RadialPickerLayout$$ExternalSyntheticLambda2
            @Override // com.wdullaer.materialdatetimepicker.time.RadialTextsView.SelectionValidator
            public final boolean isValidSelection(int i2) {
                return this.f$0.lambda$initialize$0(i2);
            }
        };
        RadialTextsView.SelectionValidator selectionValidator2 = new RadialTextsView.SelectionValidator() { // from class: com.wdullaer.materialdatetimepicker.time.RadialPickerLayout$$ExternalSyntheticLambda3
            @Override // com.wdullaer.materialdatetimepicker.time.RadialTextsView.SelectionValidator
            public final boolean isValidSelection(int i2) {
                return this.f$0.lambda$initialize$1(i2);
            }
        };
        RadialTextsView.SelectionValidator selectionValidator3 = new RadialTextsView.SelectionValidator() { // from class: com.wdullaer.materialdatetimepicker.time.RadialPickerLayout$$ExternalSyntheticLambda4
            @Override // com.wdullaer.materialdatetimepicker.time.RadialTextsView.SelectionValidator
            public final boolean isValidSelection(int i2) {
                return this.f$0.lambda$initialize$2(i2);
            }
        };
        int[] iArr2 = {12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] iArr3 = {0, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] iArr4 = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
        int[] iArr5 = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
        String[] strArr2 = new String[12];
        String[] strArr3 = new String[12];
        String[] strArr4 = new String[12];
        String[] strArr5 = new String[12];
        for (int i2 = 12; i < i2; i2 = 12) {
            if (!z) {
                iArr = iArr3;
                str = String.format(locale, "%d", Integer.valueOf(iArr2[i]));
            } else {
                iArr = iArr3;
                str = String.format(locale, "%02d", Integer.valueOf(iArr3[i]));
            }
            strArr2[i] = str;
            strArr3[i] = String.format(locale, "%d", Integer.valueOf(iArr2[i]));
            strArr4[i] = String.format(locale, "%02d", Integer.valueOf(iArr4[i]));
            strArr5[i] = String.format(locale, "%02d", Integer.valueOf(iArr5[i]));
            i++;
            iArr3 = iArr;
        }
        if (this.mController.getVersion() == TimePickerDialog.Version.VERSION_2) {
            strArr = strArr3;
        } else {
            strArr = strArr2;
            strArr2 = strArr3;
        }
        this.mHourRadialTextsView.initialize(context, strArr, z ? strArr2 : null, this.mController, selectionValidator3, true);
        RadialTextsView radialTextsView = this.mHourRadialTextsView;
        int hour = timepoint.getHour();
        if (!z) {
            hour = iArr2[hour % 12];
        }
        radialTextsView.setSelection(hour);
        this.mHourRadialTextsView.invalidate();
        this.mMinuteRadialTextsView.initialize(context, strArr4, null, this.mController, selectionValidator2, false);
        this.mMinuteRadialTextsView.setSelection(timepoint.getMinute());
        this.mMinuteRadialTextsView.invalidate();
        this.mSecondRadialTextsView.initialize(context, strArr5, null, this.mController, selectionValidator, false);
        this.mSecondRadialTextsView.setSelection(timepoint.getSecond());
        this.mSecondRadialTextsView.invalidate();
        this.mCurrentTime = timepoint;
        this.mHourRadialSelectorView.initialize(context, this.mController, z, true, (timepoint.getHour() % 12) * 30, isHourInnerCircle(timepoint.getHour()));
        this.mMinuteRadialSelectorView.initialize(context, this.mController, false, false, timepoint.getMinute() * 6, false);
        this.mSecondRadialSelectorView.initialize(context, this.mController, false, false, timepoint.getSecond() * 6, false);
        this.mTimeInitialized = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initialize$0(int i) {
        return !this.mController.isOutOfRange(new Timepoint(this.mCurrentTime.getHour(), this.mCurrentTime.getMinute(), i), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initialize$1(int i) {
        return !this.mController.isOutOfRange(new Timepoint(this.mCurrentTime.getHour(), i, this.mCurrentTime.getSecond()), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initialize$2(int i) {
        Timepoint timepoint = new Timepoint(i, this.mCurrentTime.getMinute(), this.mCurrentTime.getSecond());
        if (!this.mIs24HourMode && getIsCurrentlyAmOrPm() == 1) {
            timepoint.setPM();
        }
        if (!this.mIs24HourMode && getIsCurrentlyAmOrPm() == 0) {
            timepoint.setAM();
        }
        return !this.mController.isOutOfRange(timepoint, 0);
    }

    public void setTime(Timepoint timepoint) {
        setItem(0, timepoint);
    }

    private void setItem(int i, Timepoint timepoint) {
        Timepoint timepointRoundToValidTime = roundToValidTime(timepoint, i);
        this.mCurrentTime = timepointRoundToValidTime;
        reselectSelector(timepointRoundToValidTime, false, i);
    }

    private boolean isHourInnerCircle(int i) {
        boolean z = i <= 12 && i != 0;
        if (this.mController.getVersion() != TimePickerDialog.Version.VERSION_1) {
            z = !z;
        }
        return this.mIs24HourMode && z;
    }

    public int getHours() {
        return this.mCurrentTime.getHour();
    }

    public int getMinutes() {
        return this.mCurrentTime.getMinute();
    }

    public int getSeconds() {
        return this.mCurrentTime.getSecond();
    }

    public Timepoint getTime() {
        return this.mCurrentTime;
    }

    private int getCurrentlyShowingValue() {
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            return this.mCurrentTime.getHour();
        }
        if (currentItemShowing == 1) {
            return this.mCurrentTime.getMinute();
        }
        if (currentItemShowing != 2) {
            return -1;
        }
        return this.mCurrentTime.getSecond();
    }

    public int getIsCurrentlyAmOrPm() {
        if (this.mCurrentTime.isAM()) {
            return 0;
        }
        return this.mCurrentTime.isPM() ? 1 : -1;
    }

    public void setAmOrPm(int i) {
        this.mAmPmCirclesView.setAmOrPm(i);
        this.mAmPmCirclesView.invalidate();
        Timepoint timepoint = new Timepoint(this.mCurrentTime);
        if (i == 0) {
            timepoint.setAM();
        } else if (i == 1) {
            timepoint.setPM();
        }
        Timepoint timepointRoundToValidTime = roundToValidTime(timepoint, 0);
        reselectSelector(timepointRoundToValidTime, false, 0);
        this.mCurrentTime = timepointRoundToValidTime;
        this.mListener.onValueSelected(timepointRoundToValidTime);
    }

    private void preparePrefer30sMap() {
        this.mSnapPrefer30sMap = new int[361];
        int i = 1;
        int i2 = 8;
        int i3 = 0;
        for (int i4 = 0; i4 < 361; i4++) {
            this.mSnapPrefer30sMap[i4] = i3;
            if (i == i2) {
                i3 += 6;
                if (i3 == 360) {
                    i2 = 7;
                } else {
                    i2 = i3 % 30 == 0 ? 14 : 4;
                }
                i = 1;
            } else {
                i++;
            }
        }
    }

    private int snapPrefer30s(int i) {
        int[] iArr = this.mSnapPrefer30sMap;
        if (iArr == null) {
            return -1;
        }
        return iArr[i];
    }

    private static int snapOnly30s(int i, int i2) {
        int i3 = (i / 30) * 30;
        int i4 = i3 + 30;
        if (i2 != 1) {
            if (i2 == -1) {
                return i == i3 ? i3 - 30 : i3;
            }
            if (i - i3 < i4 - i) {
                return i3;
            }
        }
        return i4;
    }

    private Timepoint roundToValidTime(Timepoint timepoint, int i) {
        if (i == 0) {
            return this.mController.roundToNearest(timepoint, null);
        }
        if (i == 1) {
            return this.mController.roundToNearest(timepoint, Timepoint.TYPE.HOUR);
        }
        return this.mController.roundToNearest(timepoint, Timepoint.TYPE.MINUTE);
    }

    private void reselectSelector(Timepoint timepoint, boolean z, int i) {
        if (i == 0) {
            int hour = timepoint.getHour();
            boolean zIsHourInnerCircle = isHourInnerCircle(hour);
            int i2 = hour % 12;
            int i3 = (i2 * 360) / 12;
            boolean z2 = this.mIs24HourMode;
            if (!z2) {
                hour = i2;
            }
            if (!z2 && hour == 0) {
                hour += 12;
            }
            this.mHourRadialSelectorView.setSelection(i3, zIsHourInnerCircle, z);
            this.mHourRadialTextsView.setSelection(hour);
            if (timepoint.getMinute() != this.mCurrentTime.getMinute()) {
                this.mMinuteRadialSelectorView.setSelection(timepoint.getMinute() * 6, zIsHourInnerCircle, z);
                this.mMinuteRadialTextsView.setSelection(timepoint.getMinute());
            }
            if (timepoint.getSecond() != this.mCurrentTime.getSecond()) {
                this.mSecondRadialSelectorView.setSelection(timepoint.getSecond() * 6, zIsHourInnerCircle, z);
                this.mSecondRadialTextsView.setSelection(timepoint.getSecond());
            }
        } else if (i == 1) {
            this.mMinuteRadialSelectorView.setSelection(timepoint.getMinute() * 6, false, z);
            this.mMinuteRadialTextsView.setSelection(timepoint.getMinute());
            if (timepoint.getSecond() != this.mCurrentTime.getSecond()) {
                this.mSecondRadialSelectorView.setSelection(timepoint.getSecond() * 6, false, z);
                this.mSecondRadialTextsView.setSelection(timepoint.getSecond());
            }
        } else if (i == 2) {
            this.mSecondRadialSelectorView.setSelection(timepoint.getSecond() * 6, false, z);
            this.mSecondRadialTextsView.setSelection(timepoint.getSecond());
        }
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            this.mHourRadialSelectorView.invalidate();
            this.mHourRadialTextsView.invalidate();
        } else if (currentItemShowing == 1) {
            this.mMinuteRadialSelectorView.invalidate();
            this.mMinuteRadialTextsView.invalidate();
        } else {
            if (currentItemShowing != 2) {
                return;
            }
            this.mSecondRadialSelectorView.invalidate();
            this.mSecondRadialTextsView.invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.wdullaer.materialdatetimepicker.time.Timepoint getTimeFromDegrees(int r7, boolean r8, boolean r9) {
        /*
            r6 = this;
            r0 = -1
            if (r7 != r0) goto L5
            r7 = 0
            return r7
        L5:
            int r0 = r6.getCurrentItemShowing()
            r1 = 2
            r2 = 0
            r3 = 1
            if (r9 != 0) goto L17
            if (r0 == r3) goto L12
            if (r0 != r1) goto L17
        L12:
            int r7 = r6.snapPrefer30s(r7)
            goto L1b
        L17:
            int r7 = snapOnly30s(r7, r2)
        L1b:
            if (r0 == 0) goto L1f
            r9 = 6
            goto L21
        L1f:
            r9 = 30
        L21:
            r4 = 360(0x168, float:5.04E-43)
            if (r0 != 0) goto L38
            boolean r5 = r6.mIs24HourMode
            if (r5 == 0) goto L35
            if (r7 != 0) goto L2f
            if (r8 == 0) goto L2f
        L2d:
            r7 = r4
            goto L3f
        L2f:
            if (r7 != r4) goto L3f
            if (r8 != 0) goto L3f
        L33:
            r7 = r2
            goto L3f
        L35:
            if (r7 != 0) goto L3f
            goto L2d
        L38:
            if (r7 != r4) goto L3f
            if (r0 == r3) goto L33
            if (r0 != r1) goto L3f
            goto L33
        L3f:
            int r9 = r7 / r9
            if (r0 != 0) goto L4d
            boolean r5 = r6.mIs24HourMode
            if (r5 == 0) goto L4d
            if (r8 != 0) goto L4d
            if (r7 == 0) goto L4d
            int r9 = r9 + 12
        L4d:
            if (r0 != 0) goto L61
            com.wdullaer.materialdatetimepicker.time.TimePickerController r8 = r6.mController
            com.wdullaer.materialdatetimepicker.time.TimePickerDialog$Version r8 = r8.getVersion()
            com.wdullaer.materialdatetimepicker.time.TimePickerDialog$Version r5 = com.wdullaer.materialdatetimepicker.time.TimePickerDialog.Version.VERSION_1
            if (r8 == r5) goto L61
            boolean r8 = r6.mIs24HourMode
            if (r8 == 0) goto L61
            int r9 = r9 + 12
            int r9 = r9 % 24
        L61:
            if (r0 == 0) goto L8e
            if (r0 == r3) goto L7c
            if (r0 == r1) goto L6a
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = r6.mCurrentTime
            goto Lbb
        L6a:
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = new com.wdullaer.materialdatetimepicker.time.Timepoint
            com.wdullaer.materialdatetimepicker.time.Timepoint r8 = r6.mCurrentTime
            int r8 = r8.getHour()
            com.wdullaer.materialdatetimepicker.time.Timepoint r0 = r6.mCurrentTime
            int r0 = r0.getMinute()
            r7.<init>(r8, r0, r9)
            goto Lbb
        L7c:
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = new com.wdullaer.materialdatetimepicker.time.Timepoint
            com.wdullaer.materialdatetimepicker.time.Timepoint r8 = r6.mCurrentTime
            int r8 = r8.getHour()
            com.wdullaer.materialdatetimepicker.time.Timepoint r0 = r6.mCurrentTime
            int r0 = r0.getSecond()
            r7.<init>(r8, r9, r0)
            goto Lbb
        L8e:
            boolean r8 = r6.mIs24HourMode
            if (r8 != 0) goto L9c
            int r8 = r6.getIsCurrentlyAmOrPm()
            if (r8 != r3) goto L9c
            if (r7 == r4) goto L9c
            int r9 = r9 + 12
        L9c:
            boolean r8 = r6.mIs24HourMode
            if (r8 != 0) goto La9
            int r8 = r6.getIsCurrentlyAmOrPm()
            if (r8 != 0) goto La9
            if (r7 != r4) goto La9
            goto Laa
        La9:
            r2 = r9
        Laa:
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = new com.wdullaer.materialdatetimepicker.time.Timepoint
            com.wdullaer.materialdatetimepicker.time.Timepoint r8 = r6.mCurrentTime
            int r8 = r8.getMinute()
            com.wdullaer.materialdatetimepicker.time.Timepoint r9 = r6.mCurrentTime
            int r9 = r9.getSecond()
            r7.<init>(r2, r8, r9)
        Lbb:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.getTimeFromDegrees(int, boolean, boolean):com.wdullaer.materialdatetimepicker.time.Timepoint");
    }

    private int getDegreesFromCoords(float f, float f2, boolean z, Boolean[] boolArr) {
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            return this.mHourRadialSelectorView.getDegreesFromCoords(f, f2, z, boolArr);
        }
        if (currentItemShowing == 1) {
            return this.mMinuteRadialSelectorView.getDegreesFromCoords(f, f2, z, boolArr);
        }
        if (currentItemShowing != 2) {
            return -1;
        }
        return this.mSecondRadialSelectorView.getDegreesFromCoords(f, f2, z, boolArr);
    }

    public int getCurrentItemShowing() {
        int i = this.mCurrentItemShowing;
        if (i == 0 || i == 1 || i == 2) {
            return i;
        }
        Log.e("RadialPickerLayout", "Current item showing was unfortunately set to " + this.mCurrentItemShowing);
        return -1;
    }

    public void setCurrentItemShowing(int i, boolean z) {
        if (i != 0 && i != 1 && i != 2) {
            Log.e("RadialPickerLayout", "TimePicker does not support view at index " + i);
            return;
        }
        int currentItemShowing = getCurrentItemShowing();
        this.mCurrentItemShowing = i;
        reselectSelector(getTime(), true, i);
        if (z && i != currentItemShowing) {
            ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[4];
            if (i == 1 && currentItemShowing == 0) {
                objectAnimatorArr[0] = this.mHourRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[1] = this.mHourRadialSelectorView.getDisappearAnimator();
                objectAnimatorArr[2] = this.mMinuteRadialTextsView.getReappearAnimator();
                objectAnimatorArr[3] = this.mMinuteRadialSelectorView.getReappearAnimator();
            } else if (i == 0 && currentItemShowing == 1) {
                objectAnimatorArr[0] = this.mHourRadialTextsView.getReappearAnimator();
                objectAnimatorArr[1] = this.mHourRadialSelectorView.getReappearAnimator();
                objectAnimatorArr[2] = this.mMinuteRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[3] = this.mMinuteRadialSelectorView.getDisappearAnimator();
            } else if (i == 1 && currentItemShowing == 2) {
                objectAnimatorArr[0] = this.mSecondRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[1] = this.mSecondRadialSelectorView.getDisappearAnimator();
                objectAnimatorArr[2] = this.mMinuteRadialTextsView.getReappearAnimator();
                objectAnimatorArr[3] = this.mMinuteRadialSelectorView.getReappearAnimator();
            } else if (i == 0 && currentItemShowing == 2) {
                objectAnimatorArr[0] = this.mSecondRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[1] = this.mSecondRadialSelectorView.getDisappearAnimator();
                objectAnimatorArr[2] = this.mHourRadialTextsView.getReappearAnimator();
                objectAnimatorArr[3] = this.mHourRadialSelectorView.getReappearAnimator();
            } else if (i == 2 && currentItemShowing == 1) {
                objectAnimatorArr[0] = this.mSecondRadialTextsView.getReappearAnimator();
                objectAnimatorArr[1] = this.mSecondRadialSelectorView.getReappearAnimator();
                objectAnimatorArr[2] = this.mMinuteRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[3] = this.mMinuteRadialSelectorView.getDisappearAnimator();
            } else if (i == 2 && currentItemShowing == 0) {
                objectAnimatorArr[0] = this.mSecondRadialTextsView.getReappearAnimator();
                objectAnimatorArr[1] = this.mSecondRadialSelectorView.getReappearAnimator();
                objectAnimatorArr[2] = this.mHourRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[3] = this.mHourRadialSelectorView.getDisappearAnimator();
            }
            if (objectAnimatorArr[0] != null && objectAnimatorArr[1] != null && objectAnimatorArr[2] != null && objectAnimatorArr[3] != null) {
                AnimatorSet animatorSet = this.mTransition;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.mTransition.end();
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.mTransition = animatorSet2;
                animatorSet2.playTogether(objectAnimatorArr);
                this.mTransition.start();
                return;
            }
            transitionWithoutAnimation(i);
            return;
        }
        transitionWithoutAnimation(i);
    }

    private void transitionWithoutAnimation(int i) {
        int i2 = i == 0 ? 1 : 0;
        int i3 = i == 1 ? 1 : 0;
        int i4 = i == 2 ? 1 : 0;
        float f = i2;
        this.mHourRadialTextsView.setAlpha(f);
        this.mHourRadialSelectorView.setAlpha(f);
        float f2 = i3;
        this.mMinuteRadialTextsView.setAlpha(f2);
        this.mMinuteRadialSelectorView.setAlpha(f2);
        float f3 = i4;
        this.mSecondRadialTextsView.setAlpha(f3);
        this.mSecondRadialSelectorView.setAlpha(f3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouch$3() {
        this.mAmPmCirclesView.setAmOrPmPressed(this.mIsTouchingAmOrPm);
        this.mAmPmCirclesView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouch$4(Boolean[] boolArr) {
        this.mDoingMove = true;
        Timepoint timeFromDegrees = getTimeFromDegrees(this.mDownDegrees, boolArr[0].booleanValue(), false);
        this.mLastValueSelected = timeFromDegrees;
        Timepoint timepointRoundToValidTime = roundToValidTime(timeFromDegrees, getCurrentItemShowing());
        this.mLastValueSelected = timepointRoundToValidTime;
        reselectSelector(timepointRoundToValidTime, true, getCurrentItemShowing());
        this.mListener.onValueSelected(this.mLastValueSelected);
    }

    public boolean trySettingInputEnabled(boolean z) {
        if (this.mDoingTouch && !z) {
            return false;
        }
        this.mInputEnabled = z;
        this.mGrayBox.setVisibility(z ? 4 : 0);
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.getText().clear();
            Calendar calendar = Calendar.getInstance();
            calendar.set(10, getHours());
            calendar.set(12, getMinutes());
            calendar.set(13, getSeconds());
            accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), calendar.getTimeInMillis(), this.mIs24HourMode ? pjsip_transport_type_e.PJSIP_TRANSPORT_UDP6 : 1));
            return true;
        }
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        int i2;
        int i3;
        Timepoint timepoint;
        Timepoint timepoint2;
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        int i4 = 0;
        int i5 = i == 4096 ? 1 : i == 8192 ? -1 : 0;
        if (i5 == 0) {
            return false;
        }
        int currentlyShowingValue = getCurrentlyShowingValue();
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            currentlyShowingValue %= 12;
            i2 = 30;
        } else {
            i2 = 6;
            if (currentItemShowing != 1 && currentItemShowing != 2) {
                i2 = 0;
            }
        }
        int iSnapOnly30s = snapOnly30s(currentlyShowingValue * i2, i5) / i2;
        if (currentItemShowing != 0) {
            i3 = 55;
        } else if (this.mIs24HourMode) {
            i3 = 23;
        } else {
            i3 = 12;
            i4 = 1;
        }
        if (iSnapOnly30s > i3) {
            iSnapOnly30s = i4;
        } else if (iSnapOnly30s < i4) {
            iSnapOnly30s = i3;
        }
        if (currentItemShowing == 0) {
            timepoint = new Timepoint(iSnapOnly30s, this.mCurrentTime.getMinute(), this.mCurrentTime.getSecond());
        } else if (currentItemShowing == 1) {
            timepoint = new Timepoint(this.mCurrentTime.getHour(), iSnapOnly30s, this.mCurrentTime.getSecond());
        } else if (currentItemShowing == 2) {
            timepoint = new Timepoint(this.mCurrentTime.getHour(), this.mCurrentTime.getMinute(), iSnapOnly30s);
        } else {
            timepoint2 = this.mCurrentTime;
            setItem(currentItemShowing, timepoint2);
            this.mListener.onValueSelected(timepoint2);
            return true;
        }
        timepoint2 = timepoint;
        setItem(currentItemShowing, timepoint2);
        this.mListener.onValueSelected(timepoint2);
        return true;
    }
}
