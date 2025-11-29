package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.recyclerview.widget.RecyclerView;
import com.wdullaer.materialdatetimepicker.date.MonthView;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public abstract class MonthAdapter extends RecyclerView.Adapter<MonthViewHolder> implements MonthView.OnDayClickListener {
    protected final DatePickerController mController;
    private CalendarDay mSelectedDay;

    public abstract MonthView createMonthView(Context context);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public static class CalendarDay {
        private Calendar calendar;
        int day;
        TimeZone mTimeZone;
        int month;
        int year;

        public CalendarDay(TimeZone timeZone) {
            this.mTimeZone = timeZone;
            setTime(System.currentTimeMillis());
        }

        public CalendarDay(long j, TimeZone timeZone) {
            this.mTimeZone = timeZone;
            setTime(j);
        }

        public CalendarDay(Calendar calendar, TimeZone timeZone) {
            this.mTimeZone = timeZone;
            this.year = calendar.get(1);
            this.month = calendar.get(2);
            this.day = calendar.get(5);
        }

        public CalendarDay(int i, int i2, int i3, TimeZone timeZone) {
            this.mTimeZone = timeZone;
            setDay(i, i2, i3);
        }

        public void set(CalendarDay calendarDay) {
            this.year = calendarDay.year;
            this.month = calendarDay.month;
            this.day = calendarDay.day;
        }

        public void setDay(int i, int i2, int i3) {
            this.year = i;
            this.month = i2;
            this.day = i3;
        }

        private void setTime(long j) {
            if (this.calendar == null) {
                this.calendar = Calendar.getInstance(this.mTimeZone);
            }
            this.calendar.setTimeInMillis(j);
            this.month = this.calendar.get(2);
            this.year = this.calendar.get(1);
            this.day = this.calendar.get(5);
        }
    }

    public MonthAdapter(DatePickerController datePickerController) {
        this.mController = datePickerController;
        init();
        setSelectedDay(datePickerController.getSelectedDay());
        setHasStableIds(true);
    }

    public void setSelectedDay(CalendarDay calendarDay) {
        this.mSelectedDay = calendarDay;
        notifyDataSetChanged();
    }

    protected void init() {
        this.mSelectedDay = new CalendarDay(System.currentTimeMillis(), this.mController.getTimeZone());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MonthViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MonthView monthViewCreateMonthView = createMonthView(viewGroup.getContext());
        monthViewCreateMonthView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        monthViewCreateMonthView.setClickable(true);
        monthViewCreateMonthView.setOnDayClickListener(this);
        return new MonthViewHolder(monthViewCreateMonthView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MonthViewHolder monthViewHolder, int i) {
        monthViewHolder.bind(i, this.mController, this.mSelectedDay);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Calendar endDate = this.mController.getEndDate();
        Calendar startDate = this.mController.getStartDate();
        return (((endDate.get(1) * 12) + endDate.get(2)) - ((startDate.get(1) * 12) + startDate.get(2))) + 1;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.MonthView.OnDayClickListener
    public void onDayClick(MonthView monthView, CalendarDay calendarDay) {
        if (calendarDay != null) {
            onDayTapped(calendarDay);
        }
    }

    protected void onDayTapped(CalendarDay calendarDay) {
        this.mController.tryVibrate();
        this.mController.onDayOfMonthSelected(calendarDay.year, calendarDay.month, calendarDay.day);
        setSelectedDay(calendarDay);
    }

    static class MonthViewHolder extends RecyclerView.ViewHolder {
        public MonthViewHolder(MonthView monthView) {
            super(monthView);
        }

        void bind(int i, DatePickerController datePickerController, CalendarDay calendarDay) {
            int i2 = (datePickerController.getStartDate().get(2) + i) % 12;
            int minYear = ((i + datePickerController.getStartDate().get(2)) / 12) + datePickerController.getMinYear();
            ((MonthView) this.itemView).setMonthParams(isSelectedDayInMonth(calendarDay, minYear, i2) ? calendarDay.day : -1, minYear, i2, datePickerController.getFirstDayOfWeek());
            this.itemView.invalidate();
        }

        private boolean isSelectedDayInMonth(CalendarDay calendarDay, int i, int i2) {
            return calendarDay.year == i && calendarDay.month == i2;
        }
    }
}
