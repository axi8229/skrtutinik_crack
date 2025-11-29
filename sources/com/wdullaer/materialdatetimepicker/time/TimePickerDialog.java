package com.wdullaer.materialdatetimepicker.time;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.wdullaer.materialdatetimepicker.HapticFeedbackController;
import com.wdullaer.materialdatetimepicker.R$color;
import com.wdullaer.materialdatetimepicker.R$font;
import com.wdullaer.materialdatetimepicker.R$id;
import com.wdullaer.materialdatetimepicker.R$layout;
import com.wdullaer.materialdatetimepicker.R$string;
import com.wdullaer.materialdatetimepicker.Utils;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.Timepoint;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TimePickerDialog extends AppCompatDialogFragment implements RadialPickerLayout.OnValueSelectedListener, TimePickerController {
    private boolean mAllowAutoAdvance;
    private int mAmKeyCode;
    private View mAmPmLayout;
    private String mAmText;
    private TextView mAmTextView;
    private OnTimeSetListener mCallback;
    private Button mCancelButton;
    private int mCancelResid;
    private String mCancelString;
    private DefaultTimepointLimiter mDefaultLimiter;
    private String mDeletedKeyFormat;
    private boolean mDismissOnPause;
    private String mDoublePlaceholderText;
    private boolean mEnableMinutes;
    private boolean mEnableSeconds;
    private HapticFeedbackController mHapticFeedbackController;
    private String mHourPickerDescription;
    private TextView mHourSpaceView;
    private TextView mHourView;
    private boolean mInKbMode;
    private Timepoint mInitialTime;
    private boolean mIs24HourMode;
    private Node mLegalTimesTree;
    private TimepointLimiter mLimiter;
    private Locale mLocale;
    private String mMinutePickerDescription;
    private TextView mMinuteSpaceView;
    private TextView mMinuteView;
    private Button mOkButton;
    private int mOkResid;
    private String mOkString;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private char mPlaceholderText;
    private int mPmKeyCode;
    private String mPmText;
    private TextView mPmTextView;
    private String mSecondPickerDescription;
    private TextView mSecondSpaceView;
    private TextView mSecondView;
    private String mSelectHours;
    private String mSelectMinutes;
    private String mSelectSeconds;
    private int mSelectedColor;
    private boolean mThemeDark;
    private boolean mThemeDarkChanged;
    private RadialPickerLayout mTimePicker;
    private String mTitle;
    private ArrayList<Integer> mTypedTimes;
    private int mUnselectedColor;
    private Version mVersion;
    private boolean mVibrate;
    private Integer mAccentColor = null;
    private Integer mOkColor = null;
    private Integer mCancelColor = null;

    public interface OnTimeSetListener {
        void onTimeSet(TimePickerDialog timePickerDialog, int i, int i2, int i3);
    }

    public enum Version {
        VERSION_1,
        VERSION_2
    }

    private static int getValFromKeyCode(int i) {
        switch (i) {
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 2;
            case 10:
                return 3;
            case 11:
                return 4;
            case 12:
                return 5;
            case 13:
                return 6;
            case 14:
                return 7;
            case 15:
                return 8;
            case 16:
                return 9;
            default:
                return -1;
        }
    }

    public TimePickerDialog() {
        DefaultTimepointLimiter defaultTimepointLimiter = new DefaultTimepointLimiter();
        this.mDefaultLimiter = defaultTimepointLimiter;
        this.mLimiter = defaultTimepointLimiter;
        this.mLocale = Locale.getDefault();
    }

    public static TimePickerDialog newInstance(OnTimeSetListener onTimeSetListener, int i, int i2, int i3, boolean z) {
        TimePickerDialog timePickerDialog = new TimePickerDialog();
        timePickerDialog.initialize(onTimeSetListener, i, i2, i3, z);
        return timePickerDialog;
    }

    public static TimePickerDialog newInstance(OnTimeSetListener onTimeSetListener, int i, int i2, boolean z) {
        return newInstance(onTimeSetListener, i, i2, 0, z);
    }

    public void initialize(OnTimeSetListener onTimeSetListener, int i, int i2, int i3, boolean z) {
        this.mCallback = onTimeSetListener;
        this.mInitialTime = new Timepoint(i, i2, i3);
        this.mIs24HourMode = z;
        this.mInKbMode = false;
        this.mTitle = "";
        this.mThemeDark = false;
        this.mThemeDarkChanged = false;
        this.mVibrate = true;
        this.mDismissOnPause = false;
        this.mEnableSeconds = false;
        this.mEnableMinutes = true;
        this.mOkResid = R$string.mdtp_ok;
        this.mCancelResid = R$string.mdtp_cancel;
        this.mVersion = Version.VERSION_2;
        this.mTimePicker = null;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public boolean isThemeDark() {
        return this.mThemeDark;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public boolean is24HourMode() {
        return this.mIs24HourMode;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public int getAccentColor() {
        return this.mAccentColor.intValue();
    }

    public void vibrate(boolean z) {
        this.mVibrate = z;
    }

    public void setMinTime(int i, int i2, int i3) {
        setMinTime(new Timepoint(i, i2, i3));
    }

    public void setMinTime(Timepoint timepoint) {
        this.mDefaultLimiter.setMinTime(timepoint);
    }

    public void setMaxTime(int i, int i2, int i3) {
        setMaxTime(new Timepoint(i, i2, i3));
    }

    public void setMaxTime(Timepoint timepoint) {
        this.mDefaultLimiter.setMaxTime(timepoint);
    }

    public void setVersion(Version version) {
        this.mVersion = version;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public Version getVersion() {
        return this.mVersion;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
        if (bundle != null && bundle.containsKey("initial_time") && bundle.containsKey("is_24_hour_view")) {
            this.mInitialTime = (Timepoint) bundle.getParcelable("initial_time");
            this.mIs24HourMode = bundle.getBoolean("is_24_hour_view");
            this.mInKbMode = bundle.getBoolean("in_kb_mode");
            this.mTitle = bundle.getString("dialog_title");
            this.mThemeDark = bundle.getBoolean("theme_dark");
            this.mThemeDarkChanged = bundle.getBoolean("theme_dark_changed");
            if (bundle.containsKey("accent")) {
                this.mAccentColor = Integer.valueOf(bundle.getInt("accent"));
            }
            this.mVibrate = bundle.getBoolean("vibrate");
            this.mDismissOnPause = bundle.getBoolean("dismiss");
            this.mEnableSeconds = bundle.getBoolean("enable_seconds");
            this.mEnableMinutes = bundle.getBoolean("enable_minutes");
            this.mOkResid = bundle.getInt("ok_resid");
            this.mOkString = bundle.getString("ok_string");
            if (bundle.containsKey("ok_color")) {
                this.mOkColor = Integer.valueOf(bundle.getInt("ok_color"));
            }
            if (this.mOkColor.intValue() == Integer.MAX_VALUE) {
                this.mOkColor = null;
            }
            this.mCancelResid = bundle.getInt("cancel_resid");
            this.mCancelString = bundle.getString("cancel_string");
            if (bundle.containsKey("cancel_color")) {
                this.mCancelColor = Integer.valueOf(bundle.getInt("cancel_color"));
            }
            this.mVersion = (Version) bundle.getSerializable("version");
            this.mLimiter = (TimepointLimiter) bundle.getParcelable("timepoint_limiter");
            this.mLocale = (Locale) bundle.getSerializable("locale");
            TimepointLimiter timepointLimiter = this.mLimiter;
            this.mDefaultLimiter = timepointLimiter instanceof DefaultTimepointLimiter ? (DefaultTimepointLimiter) timepointLimiter : new DefaultTimepointLimiter();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.mVersion == Version.VERSION_1 ? R$layout.mdtp_time_picker_dialog : R$layout.mdtp_time_picker_dialog_v2, viewGroup, false);
        KeyboardListener keyboardListener = new KeyboardListener();
        int i = R$id.mdtp_time_picker_dialog;
        viewInflate.findViewById(i).setOnKeyListener(keyboardListener);
        if (this.mAccentColor == null) {
            this.mAccentColor = Integer.valueOf(Utils.getAccentColorFromThemeIfAvailable(getActivity()));
        }
        if (!this.mThemeDarkChanged) {
            this.mThemeDark = Utils.isDarkTheme(getActivity(), this.mThemeDark);
        }
        Resources resources = getResources();
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        this.mHourPickerDescription = resources.getString(R$string.mdtp_hour_picker_description);
        this.mSelectHours = resources.getString(R$string.mdtp_select_hours);
        this.mMinutePickerDescription = resources.getString(R$string.mdtp_minute_picker_description);
        this.mSelectMinutes = resources.getString(R$string.mdtp_select_minutes);
        this.mSecondPickerDescription = resources.getString(R$string.mdtp_second_picker_description);
        this.mSelectSeconds = resources.getString(R$string.mdtp_select_seconds);
        this.mSelectedColor = ContextCompat.getColor(fragmentActivityRequireActivity, R$color.mdtp_white);
        this.mUnselectedColor = ContextCompat.getColor(fragmentActivityRequireActivity, R$color.mdtp_accent_color_focused);
        TextView textView = (TextView) viewInflate.findViewById(R$id.mdtp_hours);
        this.mHourView = textView;
        textView.setOnKeyListener(keyboardListener);
        int i2 = R$id.mdtp_hour_space;
        this.mHourSpaceView = (TextView) viewInflate.findViewById(i2);
        int i3 = R$id.mdtp_minutes_space;
        this.mMinuteSpaceView = (TextView) viewInflate.findViewById(i3);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.mdtp_minutes);
        this.mMinuteView = textView2;
        textView2.setOnKeyListener(keyboardListener);
        int i4 = R$id.mdtp_seconds_space;
        this.mSecondSpaceView = (TextView) viewInflate.findViewById(i4);
        TextView textView3 = (TextView) viewInflate.findViewById(R$id.mdtp_seconds);
        this.mSecondView = textView3;
        textView3.setOnKeyListener(keyboardListener);
        TextView textView4 = (TextView) viewInflate.findViewById(R$id.mdtp_am_label);
        this.mAmTextView = textView4;
        textView4.setOnKeyListener(keyboardListener);
        TextView textView5 = (TextView) viewInflate.findViewById(R$id.mdtp_pm_label);
        this.mPmTextView = textView5;
        textView5.setOnKeyListener(keyboardListener);
        this.mAmPmLayout = viewInflate.findViewById(R$id.mdtp_ampm_layout);
        String[] amPmStrings = new DateFormatSymbols(this.mLocale).getAmPmStrings();
        this.mAmText = amPmStrings[0];
        this.mPmText = amPmStrings[1];
        this.mHapticFeedbackController = new HapticFeedbackController(getActivity());
        if (this.mTimePicker != null) {
            this.mInitialTime = new Timepoint(this.mTimePicker.getHours(), this.mTimePicker.getMinutes(), this.mTimePicker.getSeconds());
        }
        this.mInitialTime = roundToNearest(this.mInitialTime);
        RadialPickerLayout radialPickerLayout = (RadialPickerLayout) viewInflate.findViewById(R$id.mdtp_time_picker);
        this.mTimePicker = radialPickerLayout;
        radialPickerLayout.setOnValueSelectedListener(this);
        this.mTimePicker.setOnKeyListener(keyboardListener);
        this.mTimePicker.initialize(getActivity(), this.mLocale, this, this.mInitialTime, this.mIs24HourMode);
        setCurrentItemShowing((bundle == null || !bundle.containsKey("current_item_showing")) ? 0 : bundle.getInt("current_item_showing"), false, true, true);
        this.mTimePicker.invalidate();
        this.mHourView.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.TimePickerDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        this.mMinuteView.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.TimePickerDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        this.mSecondView.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.TimePickerDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        Button button = (Button) viewInflate.findViewById(R$id.mdtp_ok);
        this.mOkButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.TimePickerDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$3(view);
            }
        });
        this.mOkButton.setOnKeyListener(keyboardListener);
        Button button2 = this.mOkButton;
        int i5 = R$font.robotomedium;
        button2.setTypeface(ResourcesCompat.getFont(fragmentActivityRequireActivity, i5));
        String str = this.mOkString;
        if (str != null) {
            this.mOkButton.setText(str);
        } else {
            this.mOkButton.setText(this.mOkResid);
        }
        Button button3 = (Button) viewInflate.findViewById(R$id.mdtp_cancel);
        this.mCancelButton = button3;
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.TimePickerDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$4(view);
            }
        });
        this.mCancelButton.setTypeface(ResourcesCompat.getFont(fragmentActivityRequireActivity, i5));
        String str2 = this.mCancelString;
        if (str2 != null) {
            this.mCancelButton.setText(str2);
        } else {
            this.mCancelButton.setText(this.mCancelResid);
        }
        this.mCancelButton.setVisibility(isCancelable() ? 0 : 8);
        if (this.mIs24HourMode) {
            this.mAmPmLayout.setVisibility(8);
        } else {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.time.TimePickerDialog$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreateView$5(view);
                }
            };
            this.mAmTextView.setVisibility(8);
            this.mPmTextView.setVisibility(0);
            this.mAmPmLayout.setOnClickListener(onClickListener);
            if (this.mVersion == Version.VERSION_2) {
                this.mAmTextView.setText(this.mAmText);
                this.mPmTextView.setText(this.mPmText);
                this.mAmTextView.setVisibility(0);
            }
            updateAmPmDisplay(!this.mInitialTime.isAM() ? 1 : 0);
        }
        if (!this.mEnableSeconds) {
            this.mSecondView.setVisibility(8);
            viewInflate.findViewById(R$id.mdtp_separator_seconds).setVisibility(8);
        }
        if (!this.mEnableMinutes) {
            this.mMinuteSpaceView.setVisibility(8);
            viewInflate.findViewById(R$id.mdtp_separator).setVisibility(8);
        }
        if (getResources().getConfiguration().orientation == 2) {
            if (!this.mEnableMinutes && !this.mEnableSeconds) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(2, R$id.mdtp_center_view);
                layoutParams.addRule(14);
                this.mHourSpaceView.setLayoutParams(layoutParams);
                if (this.mIs24HourMode) {
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(1, i2);
                    this.mAmPmLayout.setLayoutParams(layoutParams2);
                }
            } else {
                boolean z = this.mEnableSeconds;
                if (!z && this.mIs24HourMode) {
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams3.addRule(14);
                    layoutParams3.addRule(2, R$id.mdtp_center_view);
                    ((TextView) viewInflate.findViewById(R$id.mdtp_separator)).setLayoutParams(layoutParams3);
                } else if (!z) {
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(14);
                    int i6 = R$id.mdtp_center_view;
                    layoutParams4.addRule(2, i6);
                    ((TextView) viewInflate.findViewById(R$id.mdtp_separator)).setLayoutParams(layoutParams4);
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams5.addRule(13);
                    layoutParams5.addRule(3, i6);
                    this.mAmPmLayout.setLayoutParams(layoutParams5);
                } else if (this.mIs24HourMode) {
                    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams6.addRule(14);
                    layoutParams6.addRule(2, i4);
                    ((TextView) viewInflate.findViewById(R$id.mdtp_separator)).setLayoutParams(layoutParams6);
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams7.addRule(13);
                    this.mSecondSpaceView.setLayoutParams(layoutParams7);
                } else {
                    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams8.addRule(13);
                    this.mSecondSpaceView.setLayoutParams(layoutParams8);
                    RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams9.addRule(14);
                    layoutParams9.addRule(2, i4);
                    ((TextView) viewInflate.findViewById(R$id.mdtp_separator)).setLayoutParams(layoutParams9);
                    RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams10.addRule(14);
                    layoutParams10.addRule(3, i4);
                    this.mAmPmLayout.setLayoutParams(layoutParams10);
                }
            }
        } else if (this.mIs24HourMode && !this.mEnableSeconds && this.mEnableMinutes) {
            RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams11.addRule(13);
            ((TextView) viewInflate.findViewById(R$id.mdtp_separator)).setLayoutParams(layoutParams11);
        } else if (!this.mEnableMinutes && !this.mEnableSeconds) {
            RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams12.addRule(13);
            this.mHourSpaceView.setLayoutParams(layoutParams12);
            if (!this.mIs24HourMode) {
                RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams13.addRule(1, i2);
                layoutParams13.addRule(4, i2);
                this.mAmPmLayout.setLayoutParams(layoutParams13);
            }
        } else if (this.mEnableSeconds) {
            View viewFindViewById = viewInflate.findViewById(R$id.mdtp_separator);
            RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams14.addRule(0, i3);
            layoutParams14.addRule(15, -1);
            viewFindViewById.setLayoutParams(layoutParams14);
            if (!this.mIs24HourMode) {
                RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams15.addRule(13);
                this.mMinuteSpaceView.setLayoutParams(layoutParams15);
            } else {
                RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams16.addRule(1, R$id.mdtp_center_view);
                this.mMinuteSpaceView.setLayoutParams(layoutParams16);
            }
        }
        this.mAllowAutoAdvance = true;
        setHour(this.mInitialTime.getHour(), true);
        setMinute(this.mInitialTime.getMinute());
        setSecond(this.mInitialTime.getSecond());
        this.mDoublePlaceholderText = resources.getString(R$string.mdtp_time_placeholder);
        this.mDeletedKeyFormat = resources.getString(R$string.mdtp_deleted_key);
        this.mPlaceholderText = this.mDoublePlaceholderText.charAt(0);
        this.mPmKeyCode = -1;
        this.mAmKeyCode = -1;
        generateLegalTimesTree();
        if (this.mInKbMode && bundle != null) {
            this.mTypedTimes = bundle.getIntegerArrayList("typed_times");
            tryStartingKbMode(-1);
            this.mHourView.invalidate();
        } else if (this.mTypedTimes == null) {
            this.mTypedTimes = new ArrayList<>();
        }
        TextView textView6 = (TextView) viewInflate.findViewById(R$id.mdtp_time_picker_header);
        if (!this.mTitle.isEmpty()) {
            textView6.setVisibility(0);
            textView6.setText(this.mTitle);
        }
        textView6.setBackgroundColor(Utils.darkenColor(this.mAccentColor.intValue()));
        viewInflate.findViewById(R$id.mdtp_time_display_background).setBackgroundColor(this.mAccentColor.intValue());
        viewInflate.findViewById(R$id.mdtp_time_display).setBackgroundColor(this.mAccentColor.intValue());
        if (this.mOkColor == null) {
            this.mOkColor = this.mAccentColor;
        }
        this.mOkButton.setTextColor(this.mOkColor.intValue());
        if (this.mCancelColor == null) {
            this.mCancelColor = this.mAccentColor;
        }
        this.mCancelButton.setTextColor(this.mCancelColor.intValue());
        if (getDialog() == null) {
            viewInflate.findViewById(R$id.mdtp_done_background).setVisibility(8);
        }
        int color = ContextCompat.getColor(fragmentActivityRequireActivity, R$color.mdtp_circle_background);
        int color2 = ContextCompat.getColor(fragmentActivityRequireActivity, R$color.mdtp_background_color);
        int i7 = R$color.mdtp_light_gray;
        int color3 = ContextCompat.getColor(fragmentActivityRequireActivity, i7);
        int color4 = ContextCompat.getColor(fragmentActivityRequireActivity, i7);
        RadialPickerLayout radialPickerLayout2 = this.mTimePicker;
        if (this.mThemeDark) {
            color = color4;
        }
        radialPickerLayout2.setBackgroundColor(color);
        View viewFindViewById2 = viewInflate.findViewById(i);
        if (this.mThemeDark) {
            color2 = color3;
        }
        viewFindViewById2.setBackgroundColor(color2);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        setCurrentItemShowing(0, true, false, true);
        tryVibrate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        setCurrentItemShowing(1, true, false, true);
        tryVibrate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        setCurrentItemShowing(2, true, false, true);
        tryVibrate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$3(View view) {
        if (this.mInKbMode && isTypedTimeFullyLegal()) {
            finishKbMode(false);
        } else {
            tryVibrate();
        }
        notifyOnDateListener();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$4(View view) {
        tryVibrate();
        if (getDialog() != null) {
            getDialog().cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$5(View view) {
        if (isAmDisabled() || isPmDisabled()) {
            return;
        }
        tryVibrate();
        int isCurrentlyAmOrPm = this.mTimePicker.getIsCurrentlyAmOrPm();
        if (isCurrentlyAmOrPm == 0) {
            isCurrentlyAmOrPm = 1;
        } else if (isCurrentlyAmOrPm == 1) {
            isCurrentlyAmOrPm = 0;
        }
        this.mTimePicker.setAmOrPm(isCurrentlyAmOrPm);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViewsInLayout();
            viewGroup.addView(onCreateView(requireActivity().getLayoutInflater(), viewGroup, null));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mHapticFeedbackController.start();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mHapticFeedbackController.stop();
        if (this.mDismissOnPause) {
            dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        DialogInterface.OnCancelListener onCancelListener = this.mOnCancelListener;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public void tryVibrate() {
        if (this.mVibrate) {
            this.mHapticFeedbackController.tryVibrate();
        }
    }

    private void updateAmPmDisplay(int i) {
        if (this.mVersion == Version.VERSION_2) {
            if (i == 0) {
                this.mAmTextView.setTextColor(this.mSelectedColor);
                this.mPmTextView.setTextColor(this.mUnselectedColor);
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mAmText);
                return;
            } else {
                this.mAmTextView.setTextColor(this.mUnselectedColor);
                this.mPmTextView.setTextColor(this.mSelectedColor);
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mPmText);
                return;
            }
        }
        if (i == 0) {
            this.mPmTextView.setText(this.mAmText);
            Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mAmText);
            this.mPmTextView.setContentDescription(this.mAmText);
        } else {
            if (i == 1) {
                this.mPmTextView.setText(this.mPmText);
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mPmText);
                this.mPmTextView.setContentDescription(this.mPmText);
                return;
            }
            this.mPmTextView.setText(this.mDoublePlaceholderText);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        RadialPickerLayout radialPickerLayout = this.mTimePicker;
        if (radialPickerLayout != null) {
            bundle.putParcelable("initial_time", radialPickerLayout.getTime());
            bundle.putBoolean("is_24_hour_view", this.mIs24HourMode);
            bundle.putInt("current_item_showing", this.mTimePicker.getCurrentItemShowing());
            bundle.putBoolean("in_kb_mode", this.mInKbMode);
            if (this.mInKbMode) {
                bundle.putIntegerArrayList("typed_times", this.mTypedTimes);
            }
            bundle.putString("dialog_title", this.mTitle);
            bundle.putBoolean("theme_dark", this.mThemeDark);
            bundle.putBoolean("theme_dark_changed", this.mThemeDarkChanged);
            Integer num = this.mAccentColor;
            if (num != null) {
                bundle.putInt("accent", num.intValue());
            }
            bundle.putBoolean("vibrate", this.mVibrate);
            bundle.putBoolean("dismiss", this.mDismissOnPause);
            bundle.putBoolean("enable_seconds", this.mEnableSeconds);
            bundle.putBoolean("enable_minutes", this.mEnableMinutes);
            bundle.putInt("ok_resid", this.mOkResid);
            bundle.putString("ok_string", this.mOkString);
            Integer num2 = this.mOkColor;
            if (num2 != null) {
                bundle.putInt("ok_color", num2.intValue());
            }
            bundle.putInt("cancel_resid", this.mCancelResid);
            bundle.putString("cancel_string", this.mCancelString);
            Integer num3 = this.mCancelColor;
            if (num3 != null) {
                bundle.putInt("cancel_color", num3.intValue());
            }
            bundle.putSerializable("version", this.mVersion);
            bundle.putParcelable("timepoint_limiter", this.mLimiter);
            bundle.putSerializable("locale", this.mLocale);
        }
    }

    @Override // com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.OnValueSelectedListener
    public void onValueSelected(Timepoint timepoint) {
        setHour(timepoint.getHour(), false);
        this.mTimePicker.setContentDescription(this.mHourPickerDescription + ": " + timepoint.getHour());
        setMinute(timepoint.getMinute());
        this.mTimePicker.setContentDescription(this.mMinutePickerDescription + ": " + timepoint.getMinute());
        setSecond(timepoint.getSecond());
        this.mTimePicker.setContentDescription(this.mSecondPickerDescription + ": " + timepoint.getSecond());
        if (this.mIs24HourMode) {
            return;
        }
        updateAmPmDisplay(!timepoint.isAM() ? 1 : 0);
    }

    @Override // com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.OnValueSelectedListener
    public void advancePicker(int i) {
        if (this.mAllowAutoAdvance) {
            if (i == 0 && this.mEnableMinutes) {
                setCurrentItemShowing(1, true, true, false);
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mSelectHours + ". " + this.mTimePicker.getMinutes());
                return;
            }
            if (i == 1 && this.mEnableSeconds) {
                setCurrentItemShowing(2, true, true, false);
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mSelectMinutes + ". " + this.mTimePicker.getSeconds());
            }
        }
    }

    @Override // com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.OnValueSelectedListener
    public void enablePicker() {
        if (!isTypedTimeFullyLegal()) {
            this.mTypedTimes.clear();
        }
        finishKbMode(true);
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public boolean isOutOfRange(Timepoint timepoint, int i) {
        return this.mLimiter.isOutOfRange(timepoint, i, getPickerResolution());
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public boolean isAmDisabled() {
        return this.mLimiter.isAmDisabled();
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public boolean isPmDisabled() {
        return this.mLimiter.isPmDisabled();
    }

    private Timepoint roundToNearest(Timepoint timepoint) {
        return roundToNearest(timepoint, null);
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimePickerController
    public Timepoint roundToNearest(Timepoint timepoint, Timepoint.TYPE type) {
        return this.mLimiter.roundToNearest(timepoint, type, getPickerResolution());
    }

    Timepoint.TYPE getPickerResolution() {
        return this.mEnableSeconds ? Timepoint.TYPE.SECOND : this.mEnableMinutes ? Timepoint.TYPE.MINUTE : Timepoint.TYPE.HOUR;
    }

    private void setHour(int i, boolean z) {
        String str;
        if (this.mIs24HourMode) {
            str = "%02d";
        } else {
            i %= 12;
            str = "%d";
            if (i == 0) {
                i = 12;
            }
        }
        String str2 = String.format(this.mLocale, str, Integer.valueOf(i));
        this.mHourView.setText(str2);
        this.mHourSpaceView.setText(str2);
        if (z) {
            Utils.tryAccessibilityAnnounce(this.mTimePicker, str2);
        }
    }

    private void setMinute(int i) {
        if (i == 60) {
            i = 0;
        }
        String str = String.format(this.mLocale, "%02d", Integer.valueOf(i));
        Utils.tryAccessibilityAnnounce(this.mTimePicker, str);
        this.mMinuteView.setText(str);
        this.mMinuteSpaceView.setText(str);
    }

    private void setSecond(int i) {
        if (i == 60) {
            i = 0;
        }
        String str = String.format(this.mLocale, "%02d", Integer.valueOf(i));
        Utils.tryAccessibilityAnnounce(this.mTimePicker, str);
        this.mSecondView.setText(str);
        this.mSecondSpaceView.setText(str);
    }

    private void setCurrentItemShowing(int i, boolean z, boolean z2, boolean z3) {
        TextView textView;
        this.mTimePicker.setCurrentItemShowing(i, z);
        if (i == 0) {
            int hours = this.mTimePicker.getHours();
            if (!this.mIs24HourMode) {
                hours %= 12;
            }
            this.mTimePicker.setContentDescription(this.mHourPickerDescription + ": " + hours);
            if (z3) {
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mSelectHours);
            }
            textView = this.mHourView;
        } else if (i == 1) {
            int minutes = this.mTimePicker.getMinutes();
            this.mTimePicker.setContentDescription(this.mMinutePickerDescription + ": " + minutes);
            if (z3) {
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mSelectMinutes);
            }
            textView = this.mMinuteView;
        } else {
            int seconds = this.mTimePicker.getSeconds();
            this.mTimePicker.setContentDescription(this.mSecondPickerDescription + ": " + seconds);
            if (z3) {
                Utils.tryAccessibilityAnnounce(this.mTimePicker, this.mSelectSeconds);
            }
            textView = this.mSecondView;
        }
        int i2 = i == 0 ? this.mSelectedColor : this.mUnselectedColor;
        int i3 = i == 1 ? this.mSelectedColor : this.mUnselectedColor;
        int i4 = i == 2 ? this.mSelectedColor : this.mUnselectedColor;
        this.mHourView.setTextColor(i2);
        this.mMinuteView.setTextColor(i3);
        this.mSecondView.setTextColor(i4);
        ObjectAnimator pulseAnimator = Utils.getPulseAnimator(textView, 0.85f, 1.1f);
        if (z2) {
            pulseAnimator.setStartDelay(300L);
        }
        pulseAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processKeyUp(int i) {
        String str;
        if (i == 61) {
            if (this.mInKbMode) {
                if (isTypedTimeFullyLegal()) {
                    finishKbMode(true);
                }
                return true;
            }
        } else {
            if (i == 66) {
                if (this.mInKbMode) {
                    if (!isTypedTimeFullyLegal()) {
                        return true;
                    }
                    finishKbMode(false);
                }
                OnTimeSetListener onTimeSetListener = this.mCallback;
                if (onTimeSetListener != null) {
                    onTimeSetListener.onTimeSet(this, this.mTimePicker.getHours(), this.mTimePicker.getMinutes(), this.mTimePicker.getSeconds());
                }
                dismiss();
                return true;
            }
            if (i == 67) {
                if (this.mInKbMode && !this.mTypedTimes.isEmpty()) {
                    int iDeleteLastTypedKey = deleteLastTypedKey();
                    if (iDeleteLastTypedKey == getAmOrPmKeyCode(0)) {
                        str = this.mAmText;
                    } else if (iDeleteLastTypedKey == getAmOrPmKeyCode(1)) {
                        str = this.mPmText;
                    } else {
                        str = String.format(this.mLocale, "%d", Integer.valueOf(getValFromKeyCode(iDeleteLastTypedKey)));
                    }
                    Utils.tryAccessibilityAnnounce(this.mTimePicker, String.format(this.mDeletedKeyFormat, str));
                    updateDisplay(true);
                }
            } else if (i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || (!this.mIs24HourMode && (i == getAmOrPmKeyCode(0) || i == getAmOrPmKeyCode(1)))) {
                if (!this.mInKbMode) {
                    if (this.mTimePicker == null) {
                        Log.e("TimePickerDialog", "Unable to initiate keyboard mode, TimePicker was null.");
                        return true;
                    }
                    this.mTypedTimes.clear();
                    tryStartingKbMode(i);
                    return true;
                }
                if (addKeyIfLegal(i)) {
                    updateDisplay(false);
                }
                return true;
            }
        }
        return false;
    }

    private void tryStartingKbMode(int i) {
        if (this.mTimePicker.trySettingInputEnabled(false)) {
            if (i == -1 || addKeyIfLegal(i)) {
                this.mInKbMode = true;
                this.mOkButton.setEnabled(false);
                updateDisplay(false);
            }
        }
    }

    private boolean addKeyIfLegal(int i) {
        boolean z = this.mEnableMinutes;
        int i2 = (!z || this.mEnableSeconds) ? 6 : 4;
        if (!z && !this.mEnableSeconds) {
            i2 = 2;
        }
        if ((this.mIs24HourMode && this.mTypedTimes.size() == i2) || (!this.mIs24HourMode && isTypedTimeFullyLegal())) {
            return false;
        }
        this.mTypedTimes.add(Integer.valueOf(i));
        if (!isTypedTimeLegalSoFar()) {
            deleteLastTypedKey();
            return false;
        }
        Utils.tryAccessibilityAnnounce(this.mTimePicker, String.format(this.mLocale, "%d", Integer.valueOf(getValFromKeyCode(i))));
        if (isTypedTimeFullyLegal()) {
            if (!this.mIs24HourMode && this.mTypedTimes.size() <= i2 - 1) {
                ArrayList<Integer> arrayList = this.mTypedTimes;
                arrayList.add(arrayList.size() - 1, 7);
                ArrayList<Integer> arrayList2 = this.mTypedTimes;
                arrayList2.add(arrayList2.size() - 1, 7);
            }
            this.mOkButton.setEnabled(true);
        }
        return true;
    }

    private boolean isTypedTimeLegalSoFar() {
        Node nodeCanReach = this.mLegalTimesTree;
        Iterator<Integer> it = this.mTypedTimes.iterator();
        while (it.hasNext()) {
            nodeCanReach = nodeCanReach.canReach(it.next().intValue());
            if (nodeCanReach == null) {
                return false;
            }
        }
        return true;
    }

    private boolean isTypedTimeFullyLegal() {
        int i;
        int i2;
        if (!this.mIs24HourMode) {
            return this.mTypedTimes.contains(Integer.valueOf(getAmOrPmKeyCode(0))) || this.mTypedTimes.contains(Integer.valueOf(getAmOrPmKeyCode(1)));
        }
        Boolean bool = Boolean.FALSE;
        int[] enteredTime = getEnteredTime(new Boolean[]{bool, bool, bool});
        return enteredTime[0] >= 0 && (i = enteredTime[1]) >= 0 && i < 60 && (i2 = enteredTime[2]) >= 0 && i2 < 60;
    }

    private int deleteLastTypedKey() {
        int iIntValue = this.mTypedTimes.remove(r0.size() - 1).intValue();
        if (!isTypedTimeFullyLegal()) {
            this.mOkButton.setEnabled(false);
        }
        return iIntValue;
    }

    private void finishKbMode(boolean z) {
        this.mInKbMode = false;
        if (!this.mTypedTimes.isEmpty()) {
            Boolean bool = Boolean.FALSE;
            int[] enteredTime = getEnteredTime(new Boolean[]{bool, bool, bool});
            this.mTimePicker.setTime(new Timepoint(enteredTime[0], enteredTime[1], enteredTime[2]));
            if (!this.mIs24HourMode) {
                this.mTimePicker.setAmOrPm(enteredTime[3]);
            }
            this.mTypedTimes.clear();
        }
        if (z) {
            updateDisplay(false);
            this.mTimePicker.trySettingInputEnabled(true);
        }
    }

    private void updateDisplay(boolean z) {
        if (!z && this.mTypedTimes.isEmpty()) {
            int hours = this.mTimePicker.getHours();
            int minutes = this.mTimePicker.getMinutes();
            int seconds = this.mTimePicker.getSeconds();
            setHour(hours, true);
            setMinute(minutes);
            setSecond(seconds);
            if (!this.mIs24HourMode) {
                updateAmPmDisplay(hours >= 12 ? 1 : 0);
            }
            setCurrentItemShowing(this.mTimePicker.getCurrentItemShowing(), true, true, true);
            this.mOkButton.setEnabled(true);
            return;
        }
        Boolean bool = Boolean.FALSE;
        Boolean[] boolArr = {bool, bool, bool};
        int[] enteredTime = getEnteredTime(boolArr);
        String str = boolArr[0].booleanValue() ? "%02d" : "%2d";
        String str2 = boolArr[1].booleanValue() ? "%02d" : "%2d";
        String str3 = boolArr[1].booleanValue() ? "%02d" : "%2d";
        int i = enteredTime[0];
        String strReplace = i == -1 ? this.mDoublePlaceholderText : String.format(str, Integer.valueOf(i)).replace(' ', this.mPlaceholderText);
        int i2 = enteredTime[1];
        String strReplace2 = i2 == -1 ? this.mDoublePlaceholderText : String.format(str2, Integer.valueOf(i2)).replace(' ', this.mPlaceholderText);
        String strReplace3 = enteredTime[2] == -1 ? this.mDoublePlaceholderText : String.format(str3, Integer.valueOf(enteredTime[1])).replace(' ', this.mPlaceholderText);
        this.mHourView.setText(strReplace);
        this.mHourSpaceView.setText(strReplace);
        this.mHourView.setTextColor(this.mUnselectedColor);
        this.mMinuteView.setText(strReplace2);
        this.mMinuteSpaceView.setText(strReplace2);
        this.mMinuteView.setTextColor(this.mUnselectedColor);
        this.mSecondView.setText(strReplace3);
        this.mSecondSpaceView.setText(strReplace3);
        this.mSecondView.setTextColor(this.mUnselectedColor);
        if (this.mIs24HourMode) {
            return;
        }
        updateAmPmDisplay(enteredTime[3]);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] getEnteredTime(java.lang.Boolean[] r14) {
        /*
            r13 = this;
            boolean r0 = r13.mIs24HourMode
            r1 = 2
            r2 = 0
            r3 = -1
            r4 = 1
            if (r0 != 0) goto L32
            boolean r0 = r13.isTypedTimeFullyLegal()
            if (r0 == 0) goto L32
            java.util.ArrayList<java.lang.Integer> r0 = r13.mTypedTimes
            int r5 = r0.size()
            int r5 = r5 - r4
            java.lang.Object r0 = r0.get(r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r5 = r13.getAmOrPmKeyCode(r2)
            if (r0 != r5) goto L27
            r0 = r2
            goto L30
        L27:
            int r5 = r13.getAmOrPmKeyCode(r4)
            if (r0 != r5) goto L2f
            r0 = r4
            goto L30
        L2f:
            r0 = r3
        L30:
            r5 = r1
            goto L34
        L32:
            r0 = r3
            r5 = r4
        L34:
            boolean r6 = r13.mEnableSeconds
            if (r6 == 0) goto L3a
            r6 = r1
            goto L3b
        L3a:
            r6 = r2
        L3b:
            r9 = r2
            r7 = r3
            r8 = r5
        L3e:
            java.util.ArrayList<java.lang.Integer> r10 = r13.mTypedTimes
            int r10 = r10.size()
            if (r8 > r10) goto Lb1
            java.util.ArrayList<java.lang.Integer> r10 = r13.mTypedTimes
            int r11 = r10.size()
            int r11 = r11 - r8
            java.lang.Object r10 = r10.get(r11)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            int r10 = getValFromKeyCode(r10)
            boolean r11 = r13.mEnableSeconds
            if (r11 == 0) goto L70
            if (r8 != r5) goto L63
            r9 = r10
            goto L70
        L63:
            int r11 = r5 + 1
            if (r8 != r11) goto L70
            int r11 = r10 * 10
            int r9 = r9 + r11
            if (r10 != 0) goto L70
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            r14[r1] = r11
        L70:
            boolean r11 = r13.mEnableMinutes
            if (r11 == 0) goto L9b
            int r11 = r5 + r6
            if (r8 != r11) goto L7a
            r7 = r10
            goto Lae
        L7a:
            int r12 = r11 + 1
            if (r8 != r12) goto L88
            int r11 = r10 * 10
            int r7 = r7 + r11
            if (r10 != 0) goto Lae
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r14[r4] = r10
            goto Lae
        L88:
            int r12 = r11 + 2
            if (r8 != r12) goto L8d
            goto L9f
        L8d:
            int r11 = r11 + 3
            if (r8 != r11) goto Lae
            int r11 = r10 * 10
            int r3 = r3 + r11
            if (r10 != 0) goto Lae
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r14[r2] = r10
            goto Lae
        L9b:
            int r11 = r5 + r6
            if (r8 != r11) goto La1
        L9f:
            r3 = r10
            goto Lae
        La1:
            int r11 = r11 + 1
            if (r8 != r11) goto Lae
            int r11 = r10 * 10
            int r3 = r3 + r11
            if (r10 != 0) goto Lae
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r14[r2] = r10
        Lae:
            int r8 = r8 + 1
            goto L3e
        Lb1:
            int[] r14 = new int[]{r3, r7, r9, r0}
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.time.TimePickerDialog.getEnteredTime(java.lang.Boolean[]):int[]");
    }

    private int getAmOrPmKeyCode(int i) {
        if (this.mAmKeyCode == -1 || this.mPmKeyCode == -1) {
            KeyCharacterMap keyCharacterMapLoad = KeyCharacterMap.load(-1);
            int i2 = 0;
            while (true) {
                if (i2 >= Math.max(this.mAmText.length(), this.mPmText.length())) {
                    break;
                }
                char cCharAt = this.mAmText.toLowerCase(this.mLocale).charAt(i2);
                char cCharAt2 = this.mPmText.toLowerCase(this.mLocale).charAt(i2);
                if (cCharAt != cCharAt2) {
                    KeyEvent[] events = keyCharacterMapLoad.getEvents(new char[]{cCharAt, cCharAt2});
                    if (events != null && events.length == 4) {
                        this.mAmKeyCode = events[0].getKeyCode();
                        this.mPmKeyCode = events[2].getKeyCode();
                    } else {
                        Log.e("TimePickerDialog", "Unable to find keycodes for AM and PM.");
                    }
                } else {
                    i2++;
                }
            }
        }
        if (i == 0) {
            return this.mAmKeyCode;
        }
        if (i == 1) {
            return this.mPmKeyCode;
        }
        return -1;
    }

    private void generateLegalTimesTree() {
        this.mLegalTimesTree = new Node(new int[0]);
        boolean z = this.mEnableMinutes;
        if (!z && this.mIs24HourMode) {
            Node node = new Node(7, 8);
            this.mLegalTimesTree.addChild(node);
            node.addChild(new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
            Node node2 = new Node(9);
            this.mLegalTimesTree.addChild(node2);
            node2.addChild(new Node(7, 8, 9, 10));
            return;
        }
        if (!z && !this.mIs24HourMode) {
            Node node3 = new Node(getAmOrPmKeyCode(0), getAmOrPmKeyCode(1));
            Node node4 = new Node(8);
            this.mLegalTimesTree.addChild(node4);
            node4.addChild(node3);
            Node node5 = new Node(7, 8, 9);
            node4.addChild(node5);
            node5.addChild(node3);
            Node node6 = new Node(9, 10, 11, 12, 13, 14, 15, 16);
            this.mLegalTimesTree.addChild(node6);
            node6.addChild(node3);
            return;
        }
        if (this.mIs24HourMode) {
            Node node7 = new Node(7, 8, 9, 10, 11, 12);
            Node node8 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            node7.addChild(node8);
            if (this.mEnableSeconds) {
                Node node9 = new Node(7, 8, 9, 10, 11, 12);
                node9.addChild(new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
                node8.addChild(node9);
            }
            Node node10 = new Node(7, 8);
            this.mLegalTimesTree.addChild(node10);
            Node node11 = new Node(7, 8, 9, 10, 11, 12);
            node10.addChild(node11);
            node11.addChild(node7);
            node11.addChild(new Node(13, 14, 15, 16));
            Node node12 = new Node(13, 14, 15, 16);
            node10.addChild(node12);
            node12.addChild(node7);
            Node node13 = new Node(9);
            this.mLegalTimesTree.addChild(node13);
            Node node14 = new Node(7, 8, 9, 10);
            node13.addChild(node14);
            node14.addChild(node7);
            Node node15 = new Node(11, 12);
            node13.addChild(node15);
            node15.addChild(node8);
            Node node16 = new Node(10, 11, 12, 13, 14, 15, 16);
            this.mLegalTimesTree.addChild(node16);
            node16.addChild(node7);
            return;
        }
        Node node17 = new Node(getAmOrPmKeyCode(0), getAmOrPmKeyCode(1));
        Node node18 = new Node(7, 8, 9, 10, 11, 12);
        Node node19 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node19.addChild(node17);
        node18.addChild(node19);
        Node node20 = new Node(8);
        this.mLegalTimesTree.addChild(node20);
        node20.addChild(node17);
        Node node21 = new Node(7, 8, 9);
        node20.addChild(node21);
        node21.addChild(node17);
        Node node22 = new Node(7, 8, 9, 10, 11, 12);
        node21.addChild(node22);
        node22.addChild(node17);
        Node node23 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node22.addChild(node23);
        node23.addChild(node17);
        if (this.mEnableSeconds) {
            node23.addChild(node18);
        }
        Node node24 = new Node(13, 14, 15, 16);
        node21.addChild(node24);
        node24.addChild(node17);
        if (this.mEnableSeconds) {
            node24.addChild(node18);
        }
        Node node25 = new Node(10, 11, 12);
        node20.addChild(node25);
        Node node26 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node25.addChild(node26);
        node26.addChild(node17);
        if (this.mEnableSeconds) {
            node26.addChild(node18);
        }
        Node node27 = new Node(9, 10, 11, 12, 13, 14, 15, 16);
        this.mLegalTimesTree.addChild(node27);
        node27.addChild(node17);
        Node node28 = new Node(7, 8, 9, 10, 11, 12);
        node27.addChild(node28);
        Node node29 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node28.addChild(node29);
        node29.addChild(node17);
        if (this.mEnableSeconds) {
            node29.addChild(node18);
        }
    }

    private static class Node {
        private ArrayList<Node> mChildren = new ArrayList<>();
        private int[] mLegalKeys;

        public Node(int... iArr) {
            this.mLegalKeys = iArr;
        }

        public void addChild(Node node) {
            this.mChildren.add(node);
        }

        public boolean containsKey(int i) {
            for (int i2 : this.mLegalKeys) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public Node canReach(int i) {
            ArrayList<Node> arrayList = this.mChildren;
            if (arrayList == null) {
                return null;
            }
            Iterator<Node> it = arrayList.iterator();
            while (it.hasNext()) {
                Node next = it.next();
                if (next.containsKey(i)) {
                    return next;
                }
            }
            return null;
        }
    }

    private class KeyboardListener implements View.OnKeyListener {
        private KeyboardListener() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 1) {
                return TimePickerDialog.this.processKeyUp(i);
            }
            return false;
        }
    }

    public void notifyOnDateListener() {
        OnTimeSetListener onTimeSetListener = this.mCallback;
        if (onTimeSetListener != null) {
            onTimeSetListener.onTimeSet(this, this.mTimePicker.getHours(), this.mTimePicker.getMinutes(), this.mTimePicker.getSeconds());
        }
    }
}
