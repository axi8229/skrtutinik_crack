package com.wdullaer.materialdatetimepicker.date;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
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
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class DatePickerDialog extends AppCompatDialogFragment implements View.OnClickListener, DatePickerController {
    private static SimpleDateFormat VERSION_2_FORMAT;
    private AccessibleDateAnimator mAnimator;
    private OnDateSetListener mCallBack;
    private String mCancelString;
    private TextView mDatePickerHeaderView;
    private DateRangeLimiter mDateRangeLimiter;
    private String mDayPickerDescription;
    private DayPickerGroup mDayPickerView;
    private DefaultDateRangeLimiter mDefaultLimiter;
    private boolean mDelayAnimation;
    private HapticFeedbackController mHapticFeedbackController;
    private LinearLayout mMonthAndDayView;
    private String mOkString;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private ScrollOrientation mScrollOrientation;
    private String mSelectDay;
    private String mSelectYear;
    private TextView mSelectedDayTextView;
    private TextView mSelectedMonthTextView;
    private TimeZone mTimezone;
    private String mTitle;
    private Version mVersion;
    private String mYearPickerDescription;
    private YearPickerView mYearPickerView;
    private TextView mYearView;
    private static SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy", Locale.getDefault());
    private static SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MMM", Locale.getDefault());
    private static SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("dd", Locale.getDefault());
    private Calendar mCalendar = Utils.trimToMidnight(Calendar.getInstance(getTimeZone()));
    private HashSet<OnDateChangedListener> mListeners = new HashSet<>();
    private int mCurrentView = -1;
    private int mWeekStart = this.mCalendar.getFirstDayOfWeek();
    private HashSet<Calendar> highlightedDays = new HashSet<>();
    private boolean mThemeDark = false;
    private boolean mThemeDarkChanged = false;
    private Integer mAccentColor = null;
    private boolean mVibrate = true;
    private boolean mDismissOnPause = false;
    private boolean mAutoDismiss = false;
    private int mDefaultView = 0;
    private int mOkResid = R$string.mdtp_ok;
    private Integer mOkColor = null;
    private int mCancelResid = R$string.mdtp_cancel;
    private Integer mCancelColor = null;
    private Locale mLocale = Locale.getDefault();

    protected interface OnDateChangedListener {
        void onDateChanged();
    }

    public interface OnDateSetListener {
        void onDateSet(DatePickerDialog datePickerDialog, int i, int i2, int i3);
    }

    public enum ScrollOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum Version {
        VERSION_1,
        VERSION_2
    }

    public DatePickerDialog() {
        DefaultDateRangeLimiter defaultDateRangeLimiter = new DefaultDateRangeLimiter();
        this.mDefaultLimiter = defaultDateRangeLimiter;
        this.mDateRangeLimiter = defaultDateRangeLimiter;
        this.mDelayAnimation = true;
    }

    public static DatePickerDialog newInstance(OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        DatePickerDialog datePickerDialog = new DatePickerDialog();
        datePickerDialog.initialize(onDateSetListener, i, i2, i3);
        return datePickerDialog;
    }

    public void initialize(OnDateSetListener onDateSetListener, Calendar calendar) {
        this.mCallBack = onDateSetListener;
        Calendar calendarTrimToMidnight = Utils.trimToMidnight((Calendar) calendar.clone());
        this.mCalendar = calendarTrimToMidnight;
        this.mScrollOrientation = null;
        setTimeZone(calendarTrimToMidnight.getTimeZone());
        this.mVersion = Version.VERSION_2;
    }

    public void initialize(OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance(getTimeZone());
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        initialize(onDateSetListener, calendar);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requireActivity().getWindow().setSoftInputMode(3);
        setStyle(1, 0);
        this.mCurrentView = -1;
        if (bundle != null) {
            this.mCalendar.set(1, bundle.getInt("year"));
            this.mCalendar.set(2, bundle.getInt("month"));
            this.mCalendar.set(5, bundle.getInt("day"));
            this.mDefaultView = bundle.getInt("default_view");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat.getBestDateTimePattern(this.mLocale, "EEEMMMdd"), this.mLocale);
        VERSION_2_FORMAT = simpleDateFormat;
        simpleDateFormat.setTimeZone(getTimeZone());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        int firstVisiblePosition;
        super.onSaveInstanceState(bundle);
        bundle.putInt("year", this.mCalendar.get(1));
        bundle.putInt("month", this.mCalendar.get(2));
        bundle.putInt("day", this.mCalendar.get(5));
        bundle.putInt("week_start", this.mWeekStart);
        bundle.putInt("current_view", this.mCurrentView);
        int i = this.mCurrentView;
        if (i == 0) {
            firstVisiblePosition = this.mDayPickerView.getMostVisiblePosition();
        } else if (i == 1) {
            firstVisiblePosition = this.mYearPickerView.getFirstVisiblePosition();
            bundle.putInt("list_position_offset", this.mYearPickerView.getFirstPositionOffset());
        } else {
            firstVisiblePosition = -1;
        }
        bundle.putInt("list_position", firstVisiblePosition);
        bundle.putSerializable("highlighted_days", this.highlightedDays);
        bundle.putBoolean("theme_dark", this.mThemeDark);
        bundle.putBoolean("theme_dark_changed", this.mThemeDarkChanged);
        Integer num = this.mAccentColor;
        if (num != null) {
            bundle.putInt("accent", num.intValue());
        }
        bundle.putBoolean("vibrate", this.mVibrate);
        bundle.putBoolean("dismiss", this.mDismissOnPause);
        bundle.putBoolean("auto_dismiss", this.mAutoDismiss);
        bundle.putInt("default_view", this.mDefaultView);
        bundle.putString(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, this.mTitle);
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
        bundle.putSerializable("scrollorientation", this.mScrollOrientation);
        bundle.putSerializable("timezone", this.mTimezone);
        bundle.putParcelable("daterangelimiter", this.mDateRangeLimiter);
        bundle.putSerializable("locale", this.mLocale);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        int i3 = this.mDefaultView;
        if (this.mScrollOrientation == null) {
            this.mScrollOrientation = this.mVersion == Version.VERSION_1 ? ScrollOrientation.VERTICAL : ScrollOrientation.HORIZONTAL;
        }
        if (bundle != null) {
            this.mWeekStart = bundle.getInt("week_start");
            i3 = bundle.getInt("current_view");
            i = bundle.getInt("list_position");
            i2 = bundle.getInt("list_position_offset");
            this.highlightedDays = (HashSet) bundle.getSerializable("highlighted_days");
            this.mThemeDark = bundle.getBoolean("theme_dark");
            this.mThemeDarkChanged = bundle.getBoolean("theme_dark_changed");
            if (bundle.containsKey("accent")) {
                this.mAccentColor = Integer.valueOf(bundle.getInt("accent"));
            }
            this.mVibrate = bundle.getBoolean("vibrate");
            this.mDismissOnPause = bundle.getBoolean("dismiss");
            this.mAutoDismiss = bundle.getBoolean("auto_dismiss");
            this.mTitle = bundle.getString(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE);
            this.mOkResid = bundle.getInt("ok_resid");
            this.mOkString = bundle.getString("ok_string");
            if (bundle.containsKey("ok_color")) {
                this.mOkColor = Integer.valueOf(bundle.getInt("ok_color"));
            }
            this.mCancelResid = bundle.getInt("cancel_resid");
            this.mCancelString = bundle.getString("cancel_string");
            if (bundle.containsKey("cancel_color")) {
                this.mCancelColor = Integer.valueOf(bundle.getInt("cancel_color"));
            }
            this.mVersion = (Version) bundle.getSerializable("version");
            this.mScrollOrientation = (ScrollOrientation) bundle.getSerializable("scrollorientation");
            this.mTimezone = (TimeZone) bundle.getSerializable("timezone");
            this.mDateRangeLimiter = (DateRangeLimiter) bundle.getParcelable("daterangelimiter");
            setLocale((Locale) bundle.getSerializable("locale"));
            DateRangeLimiter dateRangeLimiter = this.mDateRangeLimiter;
            if (dateRangeLimiter instanceof DefaultDateRangeLimiter) {
                this.mDefaultLimiter = (DefaultDateRangeLimiter) dateRangeLimiter;
            } else {
                this.mDefaultLimiter = new DefaultDateRangeLimiter();
            }
        } else {
            i = -1;
            i2 = 0;
        }
        this.mDefaultLimiter.setController(this);
        View viewInflate = layoutInflater.inflate(this.mVersion == Version.VERSION_1 ? R$layout.mdtp_date_picker_dialog : R$layout.mdtp_date_picker_dialog_v2, viewGroup, false);
        this.mCalendar = this.mDateRangeLimiter.setToNearestDate(this.mCalendar);
        this.mDatePickerHeaderView = (TextView) viewInflate.findViewById(R$id.mdtp_date_picker_header);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.mdtp_date_picker_month_and_day);
        this.mMonthAndDayView = linearLayout;
        linearLayout.setOnClickListener(this);
        this.mSelectedMonthTextView = (TextView) viewInflate.findViewById(R$id.mdtp_date_picker_month);
        this.mSelectedDayTextView = (TextView) viewInflate.findViewById(R$id.mdtp_date_picker_day);
        TextView textView = (TextView) viewInflate.findViewById(R$id.mdtp_date_picker_year);
        this.mYearView = textView;
        textView.setOnClickListener(this);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        this.mDayPickerView = new DayPickerGroup(fragmentActivityRequireActivity, this);
        this.mYearPickerView = new YearPickerView(fragmentActivityRequireActivity, this);
        if (!this.mThemeDarkChanged) {
            this.mThemeDark = Utils.isDarkTheme(fragmentActivityRequireActivity, this.mThemeDark);
        }
        Resources resources = getResources();
        this.mDayPickerDescription = resources.getString(R$string.mdtp_day_picker_description);
        this.mSelectDay = resources.getString(R$string.mdtp_select_day);
        this.mYearPickerDescription = resources.getString(R$string.mdtp_year_picker_description);
        this.mSelectYear = resources.getString(R$string.mdtp_select_year);
        viewInflate.setBackgroundColor(ContextCompat.getColor(fragmentActivityRequireActivity, this.mThemeDark ? R$color.mdtp_date_picker_view_animator_dark_theme : R$color.mdtp_date_picker_view_animator));
        AccessibleDateAnimator accessibleDateAnimator = (AccessibleDateAnimator) viewInflate.findViewById(R$id.mdtp_animator);
        this.mAnimator = accessibleDateAnimator;
        accessibleDateAnimator.addView(this.mDayPickerView);
        this.mAnimator.addView(this.mYearPickerView);
        this.mAnimator.setDateMillis(this.mCalendar.getTimeInMillis());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        this.mAnimator.setInAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(300L);
        this.mAnimator.setOutAnimation(alphaAnimation2);
        Button button = (Button) viewInflate.findViewById(R$id.mdtp_ok);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.date.DatePickerDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$0(view);
            }
        });
        int i4 = R$font.robotomedium;
        button.setTypeface(ResourcesCompat.getFont(fragmentActivityRequireActivity, i4));
        String str = this.mOkString;
        if (str != null) {
            button.setText(str);
        } else {
            button.setText(this.mOkResid);
        }
        Button button2 = (Button) viewInflate.findViewById(R$id.mdtp_cancel);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.wdullaer.materialdatetimepicker.date.DatePickerDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        button2.setTypeface(ResourcesCompat.getFont(fragmentActivityRequireActivity, i4));
        String str2 = this.mCancelString;
        if (str2 != null) {
            button2.setText(str2);
        } else {
            button2.setText(this.mCancelResid);
        }
        button2.setVisibility(isCancelable() ? 0 : 8);
        if (this.mAccentColor == null) {
            this.mAccentColor = Integer.valueOf(Utils.getAccentColorFromThemeIfAvailable(getActivity()));
        }
        TextView textView2 = this.mDatePickerHeaderView;
        if (textView2 != null) {
            textView2.setBackgroundColor(Utils.darkenColor(this.mAccentColor.intValue()));
        }
        viewInflate.findViewById(R$id.mdtp_day_picker_selected_date_layout).setBackgroundColor(this.mAccentColor.intValue());
        if (this.mOkColor == null) {
            this.mOkColor = this.mAccentColor;
        }
        button.setTextColor(this.mOkColor.intValue());
        if (this.mCancelColor == null) {
            this.mCancelColor = this.mAccentColor;
        }
        button2.setTextColor(this.mCancelColor.intValue());
        if (getDialog() == null) {
            viewInflate.findViewById(R$id.mdtp_done_background).setVisibility(8);
        }
        updateDisplay(false);
        setCurrentView(i3);
        if (i != -1) {
            if (i3 == 0) {
                this.mDayPickerView.postSetSelection(i);
            } else if (i3 == 1) {
                this.mYearPickerView.postSetSelectionFromTop(i, i2);
            }
        }
        this.mHapticFeedbackController = new HapticFeedbackController(fragmentActivityRequireActivity);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        tryVibrate();
        notifyOnDateListener();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        tryVibrate();
        if (getDialog() != null) {
            getDialog().cancel();
        }
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

    private void setCurrentView(int i) {
        long timeInMillis = this.mCalendar.getTimeInMillis();
        if (i == 0) {
            if (this.mVersion == Version.VERSION_1) {
                ObjectAnimator pulseAnimator = Utils.getPulseAnimator(this.mMonthAndDayView, 0.9f, 1.05f);
                if (this.mDelayAnimation) {
                    pulseAnimator.setStartDelay(500L);
                    this.mDelayAnimation = false;
                }
                if (this.mCurrentView != i) {
                    this.mMonthAndDayView.setSelected(true);
                    this.mYearView.setSelected(false);
                    this.mAnimator.setDisplayedChild(0);
                    this.mCurrentView = i;
                }
                this.mDayPickerView.onDateChanged();
                pulseAnimator.start();
            } else {
                if (this.mCurrentView != i) {
                    this.mMonthAndDayView.setSelected(true);
                    this.mYearView.setSelected(false);
                    this.mAnimator.setDisplayedChild(0);
                    this.mCurrentView = i;
                }
                this.mDayPickerView.onDateChanged();
            }
            String dateTime = DateUtils.formatDateTime(getActivity(), timeInMillis, 16);
            this.mAnimator.setContentDescription(this.mDayPickerDescription + ": " + dateTime);
            Utils.tryAccessibilityAnnounce(this.mAnimator, this.mSelectDay);
            return;
        }
        if (i != 1) {
            return;
        }
        if (this.mVersion == Version.VERSION_1) {
            ObjectAnimator pulseAnimator2 = Utils.getPulseAnimator(this.mYearView, 0.85f, 1.1f);
            if (this.mDelayAnimation) {
                pulseAnimator2.setStartDelay(500L);
                this.mDelayAnimation = false;
            }
            this.mYearPickerView.onDateChanged();
            if (this.mCurrentView != i) {
                this.mMonthAndDayView.setSelected(false);
                this.mYearView.setSelected(true);
                this.mAnimator.setDisplayedChild(1);
                this.mCurrentView = i;
            }
            pulseAnimator2.start();
        } else {
            this.mYearPickerView.onDateChanged();
            if (this.mCurrentView != i) {
                this.mMonthAndDayView.setSelected(false);
                this.mYearView.setSelected(true);
                this.mAnimator.setDisplayedChild(1);
                this.mCurrentView = i;
            }
        }
        String str = YEAR_FORMAT.format(Long.valueOf(timeInMillis));
        this.mAnimator.setContentDescription(this.mYearPickerDescription + ": " + ((Object) str));
        Utils.tryAccessibilityAnnounce(this.mAnimator, this.mSelectYear);
    }

    private void updateDisplay(boolean z) {
        this.mYearView.setText(YEAR_FORMAT.format(this.mCalendar.getTime()));
        if (this.mVersion == Version.VERSION_1) {
            TextView textView = this.mDatePickerHeaderView;
            if (textView != null) {
                String str = this.mTitle;
                if (str != null) {
                    textView.setText(str);
                } else {
                    textView.setText(this.mCalendar.getDisplayName(7, 2, this.mLocale));
                }
            }
            this.mSelectedMonthTextView.setText(MONTH_FORMAT.format(this.mCalendar.getTime()));
            this.mSelectedDayTextView.setText(DAY_FORMAT.format(this.mCalendar.getTime()));
        }
        if (this.mVersion == Version.VERSION_2) {
            this.mSelectedDayTextView.setText(VERSION_2_FORMAT.format(this.mCalendar.getTime()));
            String str2 = this.mTitle;
            if (str2 != null) {
                this.mDatePickerHeaderView.setText(str2.toUpperCase(this.mLocale));
            } else {
                this.mDatePickerHeaderView.setVisibility(8);
            }
        }
        long timeInMillis = this.mCalendar.getTimeInMillis();
        this.mAnimator.setDateMillis(timeInMillis);
        this.mMonthAndDayView.setContentDescription(DateUtils.formatDateTime(getActivity(), timeInMillis, 24));
        if (z) {
            Utils.tryAccessibilityAnnounce(this.mAnimator, DateUtils.formatDateTime(getActivity(), timeInMillis, 20));
        }
    }

    public void vibrate(boolean z) {
        this.mVibrate = z;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public boolean isThemeDark() {
        return this.mThemeDark;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public int getAccentColor() {
        return this.mAccentColor.intValue();
    }

    public void setMinDate(Calendar calendar) {
        this.mDefaultLimiter.setMinDate(calendar);
        DayPickerGroup dayPickerGroup = this.mDayPickerView;
        if (dayPickerGroup != null) {
            dayPickerGroup.onChange();
        }
    }

    public void setMaxDate(Calendar calendar) {
        this.mDefaultLimiter.setMaxDate(calendar);
        DayPickerGroup dayPickerGroup = this.mDayPickerView;
        if (dayPickerGroup != null) {
            dayPickerGroup.onChange();
        }
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public boolean isHighlighted(int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance(getTimeZone());
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        Utils.trimToMidnight(calendar);
        return this.highlightedDays.contains(calendar);
    }

    public void setVersion(Version version) {
        this.mVersion = version;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public Version getVersion() {
        return this.mVersion;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public ScrollOrientation getScrollOrientation() {
        return this.mScrollOrientation;
    }

    @Deprecated
    public void setTimeZone(TimeZone timeZone) {
        this.mTimezone = timeZone;
        this.mCalendar.setTimeZone(timeZone);
        YEAR_FORMAT.setTimeZone(timeZone);
        MONTH_FORMAT.setTimeZone(timeZone);
        DAY_FORMAT.setTimeZone(timeZone);
    }

    public void setLocale(Locale locale) {
        this.mLocale = locale;
        this.mWeekStart = Calendar.getInstance(this.mTimezone, locale).getFirstDayOfWeek();
        YEAR_FORMAT = new SimpleDateFormat("yyyy", locale);
        MONTH_FORMAT = new SimpleDateFormat("MMM", locale);
        DAY_FORMAT = new SimpleDateFormat("dd", locale);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public Locale getLocale() {
        return this.mLocale;
    }

    private Calendar adjustDayInMonthIfNeeded(Calendar calendar) {
        int i = calendar.get(5);
        int actualMaximum = calendar.getActualMaximum(5);
        if (i > actualMaximum) {
            calendar.set(5, actualMaximum);
        }
        return this.mDateRangeLimiter.setToNearestDate(calendar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        tryVibrate();
        if (view.getId() == R$id.mdtp_date_picker_year) {
            setCurrentView(1);
        } else if (view.getId() == R$id.mdtp_date_picker_month_and_day) {
            setCurrentView(0);
        }
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public void onYearSelected(int i) {
        this.mCalendar.set(1, i);
        this.mCalendar = adjustDayInMonthIfNeeded(this.mCalendar);
        updatePickers();
        setCurrentView(0);
        updateDisplay(true);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public void onDayOfMonthSelected(int i, int i2, int i3) {
        this.mCalendar.set(1, i);
        this.mCalendar.set(2, i2);
        this.mCalendar.set(5, i3);
        updatePickers();
        updateDisplay(true);
        if (this.mAutoDismiss) {
            notifyOnDateListener();
            dismiss();
        }
    }

    private void updatePickers() {
        Iterator<OnDateChangedListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onDateChanged();
        }
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public MonthAdapter.CalendarDay getSelectedDay() {
        return new MonthAdapter.CalendarDay(this.mCalendar, getTimeZone());
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public Calendar getStartDate() {
        return this.mDateRangeLimiter.getStartDate();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public Calendar getEndDate() {
        return this.mDateRangeLimiter.getEndDate();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public int getMinYear() {
        return this.mDateRangeLimiter.getMinYear();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public int getMaxYear() {
        return this.mDateRangeLimiter.getMaxYear();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public boolean isOutOfRange(int i, int i2, int i3) {
        return this.mDateRangeLimiter.isOutOfRange(i, i2, i3);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public int getFirstDayOfWeek() {
        return this.mWeekStart;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public void registerOnDateChangedListener(OnDateChangedListener onDateChangedListener) {
        this.mListeners.add(onDateChangedListener);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public void tryVibrate() {
        if (this.mVibrate) {
            this.mHapticFeedbackController.tryVibrate();
        }
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerController
    public TimeZone getTimeZone() {
        TimeZone timeZone = this.mTimezone;
        return timeZone == null ? TimeZone.getDefault() : timeZone;
    }

    public void notifyOnDateListener() {
        OnDateSetListener onDateSetListener = this.mCallBack;
        if (onDateSetListener != null) {
            onDateSetListener.onDateSet(this, this.mCalendar.get(1), this.mCalendar.get(2), this.mCalendar.get(5));
        }
    }
}
