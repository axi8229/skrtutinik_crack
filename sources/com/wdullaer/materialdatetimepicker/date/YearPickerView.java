package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.wdullaer.materialdatetimepicker.R$dimen;
import com.wdullaer.materialdatetimepicker.R$layout;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

/* loaded from: classes3.dex */
public class YearPickerView extends ListView implements AdapterView.OnItemClickListener, DatePickerDialog.OnDateChangedListener {
    private YearAdapter mAdapter;
    private int mChildSize;
    private final DatePickerController mController;
    private TextViewWithCircularIndicator mSelectedView;
    private int mViewSize;

    public YearPickerView(Context context, DatePickerController datePickerController) throws Resources.NotFoundException {
        int dimensionPixelOffset;
        super(context);
        this.mController = datePickerController;
        datePickerController.registerOnDateChangedListener(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Resources resources = context.getResources();
        if (datePickerController.getVersion() == DatePickerDialog.Version.VERSION_1) {
            dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mdtp_date_picker_view_animator_height);
        } else {
            dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mdtp_date_picker_view_animator_height_v2);
        }
        this.mViewSize = dimensionPixelOffset;
        this.mChildSize = resources.getDimensionPixelOffset(R$dimen.mdtp_year_label_height);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(this.mChildSize / 3);
        init();
        setOnItemClickListener(this);
        setSelector(new StateListDrawable());
        setDividerHeight(0);
        onDateChanged();
    }

    private void init() {
        YearAdapter yearAdapter = new YearAdapter(this.mController.getMinYear(), this.mController.getMaxYear());
        this.mAdapter = yearAdapter;
        setAdapter((ListAdapter) yearAdapter);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mController.tryVibrate();
        TextViewWithCircularIndicator textViewWithCircularIndicator = (TextViewWithCircularIndicator) view;
        if (textViewWithCircularIndicator != null) {
            TextViewWithCircularIndicator textViewWithCircularIndicator2 = this.mSelectedView;
            if (textViewWithCircularIndicator != textViewWithCircularIndicator2) {
                if (textViewWithCircularIndicator2 != null) {
                    textViewWithCircularIndicator2.drawIndicator(false);
                    this.mSelectedView.requestLayout();
                }
                textViewWithCircularIndicator.drawIndicator(true);
                textViewWithCircularIndicator.requestLayout();
                this.mSelectedView = textViewWithCircularIndicator;
            }
            this.mController.onYearSelected(getYearFromTextView(textViewWithCircularIndicator));
            this.mAdapter.notifyDataSetChanged();
        }
    }

    private static int getYearFromTextView(TextView textView) {
        return Integer.valueOf(textView.getText().toString()).intValue();
    }

    private final class YearAdapter extends BaseAdapter {
        private final int mMaxYear;
        private final int mMinYear;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        YearAdapter(int i, int i2) {
            if (i > i2) {
                throw new IllegalArgumentException("minYear > maxYear");
            }
            this.mMinYear = i;
            this.mMaxYear = i2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return (this.mMaxYear - this.mMinYear) + 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(this.mMinYear + i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextViewWithCircularIndicator textViewWithCircularIndicator;
            if (view != null) {
                textViewWithCircularIndicator = (TextViewWithCircularIndicator) view;
            } else {
                textViewWithCircularIndicator = (TextViewWithCircularIndicator) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mdtp_year_label_text_view, viewGroup, false);
                textViewWithCircularIndicator.setAccentColor(YearPickerView.this.mController.getAccentColor(), YearPickerView.this.mController.isThemeDark());
            }
            int i2 = this.mMinYear + i;
            boolean z = YearPickerView.this.mController.getSelectedDay().year == i2;
            textViewWithCircularIndicator.setText(String.format(YearPickerView.this.mController.getLocale(), "%d", Integer.valueOf(i2)));
            textViewWithCircularIndicator.drawIndicator(z);
            textViewWithCircularIndicator.requestLayout();
            if (z) {
                YearPickerView.this.mSelectedView = textViewWithCircularIndicator;
            }
            return textViewWithCircularIndicator;
        }
    }

    public void postSetSelectionCentered(int i) {
        postSetSelectionFromTop(i, (this.mViewSize / 2) - (this.mChildSize / 2));
    }

    public void postSetSelectionFromTop(final int i, final int i2) {
        post(new Runnable() { // from class: com.wdullaer.materialdatetimepicker.date.YearPickerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$postSetSelectionFromTop$0(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$postSetSelectionFromTop$0(int i, int i2) {
        setSelectionFromTop(i, i2);
        requestLayout();
    }

    public int getFirstPositionOffset() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return childAt.getTop();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateChangedListener
    public void onDateChanged() {
        this.mAdapter.notifyDataSetChanged();
        postSetSelectionCentered(this.mController.getSelectedDay().year - this.mController.getMinYear());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4096) {
            accessibilityEvent.setFromIndex(0);
            accessibilityEvent.setToIndex(0);
        }
    }
}
