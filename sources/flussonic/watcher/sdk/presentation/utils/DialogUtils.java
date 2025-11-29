package flussonic.watcher.sdk.presentation.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import flussonic.watcher.sdk.domain.utils.CalendarUtils;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class DialogUtils {
    private static final boolean isMarshmallowOrUp = true;
    private static final DatePickerDialog.Version DATE_PICKER_VERSION = DatePickerDialog.Version.VERSION_2;
    private static final TimePickerDialog.Version TIME_PICKER_VERSION = TimePickerDialog.Version.VERSION_2;

    public interface DateTimePickerListener {
        void onDateTimeSelected(long dateTimeInSecs);
    }

    public static void hideDateTimePicker(FragmentManager fragmentManager, String dateTimePickerSuffix) {
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(String.format("TAG_DATE_PICKER_%s", dateTimePickerSuffix));
        if (fragmentFindFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        Fragment fragmentFindFragmentByTag2 = fragmentManager.findFragmentByTag(String.format("TAG_TIME_PICKER_%s", dateTimePickerSuffix));
        if (fragmentFindFragmentByTag2 != null) {
            fragmentManager.beginTransaction().remove(fragmentFindFragmentByTag2).commitAllowingStateLoss();
        }
    }

    public static void showDateTimePicker(final FragmentManager fragmentManager, final String dateTimePickerSuffix, long minDateTimeInSecs, long maxDateTimeInSecs, long nowInSecs, final DateTimePickerListener listener) {
        Calendar calendar = minDateTimeInSecs > 0 ? CalendarUtils.calendar(minDateTimeInSecs) : null;
        Calendar calendar2 = maxDateTimeInSecs > 0 ? CalendarUtils.calendar(maxDateTimeInSecs) : null;
        final Calendar calendar3 = CalendarUtils.calendar(nowInSecs);
        final Calendar calendar4 = calendar;
        final Calendar calendar5 = calendar2;
        DatePickerDialog datePickerDialogNewInstance = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() { // from class: flussonic.watcher.sdk.presentation.utils.DialogUtils$$ExternalSyntheticLambda0
            @Override // com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePickerDialog datePickerDialog, int i, int i2, int i3) {
                DialogUtils.lambda$showDateTimePicker$1(listener, calendar3, calendar4, calendar5, dateTimePickerSuffix, fragmentManager, datePickerDialog, i, i2, i3);
            }
        }, calendar3.get(1), calendar3.get(2), calendar3.get(5));
        if (calendar != null) {
            datePickerDialogNewInstance.setMinDate(calendar);
        }
        if (calendar2 != null) {
            datePickerDialogNewInstance.setMaxDate(calendar2);
        }
        datePickerDialogNewInstance.setVersion(DATE_PICKER_VERSION);
        datePickerDialogNewInstance.vibrate(false);
        datePickerDialogNewInstance.show(fragmentManager, String.format("TAG_DATE_PICKER_%s", dateTimePickerSuffix));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showDateTimePicker$1(final DateTimePickerListener listener, final Calendar now, final Calendar minDate, final Calendar maxDate, final String dateTimePickerSuffix, final FragmentManager fragmentManager, DatePickerDialog view, final int year, final int monthOfYear, final int dayOfMonth) {
        TimePickerDialog timePickerDialogNewInstance = TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() { // from class: flussonic.watcher.sdk.presentation.utils.DialogUtils$$ExternalSyntheticLambda1
            @Override // com.wdullaer.materialdatetimepicker.time.TimePickerDialog.OnTimeSetListener
            public final void onTimeSet(TimePickerDialog timePickerDialog, int i, int i2, int i3) {
                DialogUtils.lambda$null$0(year, monthOfYear, dayOfMonth, listener, timePickerDialog, i, i2, i3);
            }
        }, now.get(11), now.get(12), true);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        if (minDate != null && CalendarUtils.equals(calendar, minDate)) {
            timePickerDialogNewInstance.setMinTime(minDate.get(11), minDate.get(12), minDate.get(13));
        }
        if (maxDate != null && CalendarUtils.equals(calendar, maxDate)) {
            timePickerDialogNewInstance.setMaxTime(maxDate.get(11), maxDate.get(12), maxDate.get(13));
        }
        timePickerDialogNewInstance.setVersion(TIME_PICKER_VERSION);
        timePickerDialogNewInstance.vibrate(false);
        timePickerDialogNewInstance.show(fragmentManager, String.format("TAG_TIME_PICKER_%s", dateTimePickerSuffix));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$0(final int year, final int monthOfYear, final int dayOfMonth, final DateTimePickerListener listener, TimePickerDialog view1, int hourOfDay, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth, hourOfDay, minute, second);
        listener.onDateTimeSelected(CalendarUtils.toSeconds(calendar));
    }
}
