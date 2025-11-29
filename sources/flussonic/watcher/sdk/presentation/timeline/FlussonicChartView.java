package flussonic.watcher.sdk.presentation.timeline;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.graphics.ColorUtils;
import flussonic.watcher.sdk.R$dimen;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.pojo.Ranges;
import flussonic.watcher.sdk.domain.utils.CalendarUtils;
import flussonic.watcher.sdk.presentation.watcher.FlussonicColorTheme;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import timber.log.Timber;

/* loaded from: classes3.dex */
class FlussonicChartView extends View {
    private Drawable backgroundDrawable;
    private long borderFrom;
    private long borderTo;
    private int chartHeight;
    private int chartHeightCollapsed;
    private boolean collapsed;
    private double defaultScale;
    private int eventColor;
    private final Paint eventPaint;
    private final List<Range> events;
    private float fifteenMinutesLineHeight;
    private float fiveMinutesLineHeight;
    private float hourLineHeight;
    private int labelColor;
    private final Paint labelPaint;
    private final Rect labelRect;
    private TimelineLabelScale labelScale;
    private int leftPadding;
    private long length;
    private int loadingRangeColor;
    private final Paint loadingRangePaint;
    private final List<Range> loadingRanges;
    private long maxDuration;
    private double maxScale;
    private double minScale;
    private OnGlobalLayoutListener onGlobalLayoutListener;
    private Runnable onSizeChangedAction;
    private float oneMinuteLineHeight;
    private float playMarginEnd;
    private float playWidth;
    private int rangeColor;
    private final Paint rangePaint;
    private final Rect rangeRect;
    private final List<Range> ranges;
    private int rightPadding;
    private final Paint rulerPaint;
    private double scale;
    private final Rect utilRect;
    private final Rect visibleRect;

    public FlussonicChartView(Context context, AttributeSet attrs) throws Resources.NotFoundException {
        super(context, attrs);
        this.loadingRanges = new ArrayList();
        this.ranges = new ArrayList();
        this.events = new ArrayList();
        this.rulerPaint = new Paint();
        this.loadingRangePaint = new Paint();
        this.rangePaint = new Paint();
        this.eventPaint = new Paint();
        this.labelPaint = new Paint();
        this.visibleRect = new Rect();
        this.labelRect = new Rect();
        this.rangeRect = new Rect();
        this.utilRect = new Rect();
        init(context);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setupColors();
    }

    private void init(Context context) throws Resources.NotFoundException {
        this.rulerPaint.setStrokeWidth(getResources().getDimension(R$dimen.fs_ruler_line_width));
        this.labelPaint.setStyle(Paint.Style.FILL);
        this.labelPaint.setTextSize(getResources().getDimension(R$dimen.fs_time_label_text_size));
        this.labelPaint.setAntiAlias(true);
        this.hourLineHeight = getResources().getDimension(R$dimen.fs_hour_line_height);
        this.fifteenMinutesLineHeight = getResources().getDimension(R$dimen.fs_fifteen_minutes_line_height);
        this.fiveMinutesLineHeight = getResources().getDimension(R$dimen.fs_five_minutes_line_height);
        this.oneMinuteLineHeight = getResources().getDimension(R$dimen.fs_one_minute_line_height);
        this.backgroundDrawable = getBackground();
        this.playMarginEnd = getResources().getDimension(R$dimen.fs_play_margin_end);
        this.playWidth = getResources().getDimension(R$dimen.fs_baloon_size);
        this.chartHeight = getResources().getDimensionPixelSize(R$dimen.fs_chart_height);
        this.chartHeightCollapsed = getResources().getDimensionPixelSize(R$dimen.fs_chart_height_collapsed);
        this.defaultScale = getResources().getDimension(R$dimen.fs_hour_length_by_default_zoom) / 3600.0f;
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R$dimen.fs_timeline_max_zoom, typedValue, true);
        this.maxScale = this.defaultScale * typedValue.getFloat();
        this.maxDuration = (long) ((1.6777215E7d / (this.defaultScale * typedValue.getFloat())) - 300000.0d);
        getResources().getValue(R$dimen.fs_timeline_min_zoom, typedValue, true);
        this.minScale = this.defaultScale * typedValue.getFloat();
        setScale(this.defaultScale);
        setupColors();
    }

    private void setupColors() {
        FlussonicColorTheme flussonicColorTheme = FlussonicColorTheme.getInstance();
        if (flussonicColorTheme.themeChanged || this.rangeColor != flussonicColorTheme.getColor("fs_range")) {
            setBackgroundColor(flussonicColorTheme.getColor("fs_chart_background"));
            this.rulerPaint.setColor(flussonicColorTheme.getColor("fs_ruler_line"));
            this.loadingRangeColor = flussonicColorTheme.getColor("fs_loading_range");
            this.rangeColor = flussonicColorTheme.getColor("fs_range");
            this.eventColor = flussonicColorTheme.getColor("fs_event");
            this.labelColor = flussonicColorTheme.getColor("fs_time_label");
            this.loadingRangePaint.setColor(this.loadingRangeColor);
            this.rangePaint.setColor(this.rangeColor);
            this.eventPaint.setColor(this.eventColor);
            this.labelPaint.setColor(this.labelColor);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = ((View) getParent().getParent()).getMeasuredWidth();
        int i = measuredWidth - ((int) (this.playMarginEnd + (this.playWidth / 2.0f)));
        this.leftPadding = i;
        this.rightPadding = measuredWidth - i;
        setMeasuredDimension(getWidthFromContent(), View.getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Runnable runnable = this.onSizeChangedAction;
        if (runnable != null) {
            runnable.run();
            this.onSizeChangedAction = null;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Timber.d("onConfigurationChanged", new Object[0]);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        this.onGlobalLayoutListener = new OnGlobalLayoutListener(this, getWidth(), null);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void setBorders(Range range) {
        if (range.isValid() && range.duration() > this.maxDuration) {
            range = Range.createFromTo(range.to() - this.maxDuration, range.to());
        }
        long jFrom = range.from();
        long j = range.to();
        if (range != Range.empty()) {
            checkPositive(jFrom);
            checkPositive(j);
        }
        this.borderFrom = jFrom;
        this.borderTo = j;
        this.length = j - jFrom;
        requestLayout();
    }

    private void setBorders(long from, long to) {
        boolean z;
        checkPositive(from);
        checkPositive(to);
        long j = this.borderFrom;
        if (from < j || to > this.borderTo) {
            boolean z2 = true;
            if (from < j || j == 0) {
                this.borderFrom = from;
                z = true;
            } else {
                z = false;
            }
            if (to > this.borderTo) {
                this.borderTo = to;
            } else {
                z2 = z;
            }
            if (z2) {
                this.length = this.borderTo - this.borderFrom;
                requestLayout();
            }
        }
    }

    public void setRanges(Ranges ranges) {
        this.ranges.clear();
        this.ranges.addAll(ranges.ranges());
        if (!ranges.ranges().isEmpty() && this.borderFrom != 0) {
            setBorders(this.borderFrom, this.ranges.get(r0.size() - 1).to());
        }
        this.events.clear();
        this.events.addAll(ranges.events());
        this.loadingRanges.clear();
        this.loadingRanges.addAll(ranges.loadingRanges());
        invalidate();
    }

    public void setOnSizeChangedAction(Runnable action) {
        this.onSizeChangedAction = action;
    }

    public void increaseWidthIfNecessary(long position) {
        checkPositive(position);
        long j = this.borderTo;
        if (position > j && j != 0) {
            setBorders(this.borderFrom, position);
        } else if (position < this.borderFrom) {
            setBorders(position, j);
        }
    }

    private void checkPositive(long value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
    }

    public double getScale() {
        return this.scale;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006 A[PHI: r0
  0x0006: PHI (r0v2 double) = (r0v0 double), (r0v1 double) binds: [B:3:0x0004, B:6:0x000c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setScale(double r4) {
        /*
            r3 = this;
            double r0 = r3.minScale
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 >= 0) goto L8
        L6:
            r4 = r0
            goto Lf
        L8:
            double r0 = r3.maxScale
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto Lf
            goto L6
        Lf:
            r3.scale = r4
            r3.computeLabelScale()
            r3.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: flussonic.watcher.sdk.presentation.timeline.FlussonicChartView.setScale(double):void");
    }

    private void computeLabelScale() {
        this.utilRect.setEmpty();
        String string = CalendarUtils.toString(0L, "dd.MM.yy");
        this.labelPaint.getTextBounds(string, 0, string.length(), this.utilRect);
        Rect rect = this.utilRect;
        float f = rect.right;
        rect.setEmpty();
        String string2 = CalendarUtils.toString(0L, "HH:mm");
        this.labelPaint.getTextBounds(string2, 0, string2.length(), this.utilRect);
        double d = f;
        double d2 = this.scale;
        if (d < (7200.0d * d2) + d) {
            this.labelScale = TimelineLabelScale.EVERY_SECOND_HOUR;
            if (d < (3600.0d * d2) + d) {
                this.labelScale = TimelineLabelScale.EVERY_HOUR;
                if (d < (1800.0d * d2) + d) {
                    this.labelScale = TimelineLabelScale.EVERY_HALF_HOUR;
                    if (d < (900.0d * d2) + d) {
                        this.labelScale = TimelineLabelScale.EVERY_FIFTEEN_MINUTES;
                        if (d < (300.0d * d2) + d) {
                            this.labelScale = TimelineLabelScale.EVERY_FIVE_MINUTES;
                            if (d < d + (d2 * 60.0d)) {
                                this.labelScale = TimelineLabelScale.EVERY_MINUTE;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.labelScale = TimelineLabelScale.EVERY_THIRD_HOUR;
    }

    public double getScaleFactor() {
        return this.defaultScale / this.scale;
    }

    public int getLeftPadding() {
        return this.leftPadding;
    }

    private int getWidthFromContent() {
        return getLength() + this.leftPadding + this.rightPadding;
    }

    public int getLength() {
        return (int) (this.length * this.scale);
    }

    public long getBorderFrom() {
        return this.borderFrom;
    }

    public long getBorderTo() {
        return this.borderTo;
    }

    public boolean isBordersInitialized() {
        return (this.borderFrom == 0 || this.borderTo == 0) ? false : true;
    }

    public boolean isCollapsed() {
        return this.collapsed;
    }

    private void setCollapsed(final boolean collapsed) {
        this.collapsed = collapsed;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (collapsed) {
            layoutParams.height = this.chartHeightCollapsed;
        } else {
            layoutParams.height = this.chartHeight;
        }
        setLayoutParams(layoutParams);
        postDelayed(new Runnable() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicChartView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setCollapsed$0(collapsed);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCollapsed$0(final boolean collapsed) {
        if (collapsed) {
            return;
        }
        invalidate();
    }

    public void collapse() {
        setCollapsed(true);
    }

    public void expand() {
        setCollapsed(false);
    }

    public void setTransparentFactor(float factor) {
        int iRound = Math.round(factor * 255.0f);
        this.backgroundDrawable.setAlpha(iRound);
        this.loadingRangePaint.setColor(ColorUtils.setAlphaComponent(this.loadingRangeColor, iRound));
        this.rangePaint.setColor(ColorUtils.setAlphaComponent(this.rangeColor, iRound));
        this.eventPaint.setColor(ColorUtils.setAlphaComponent(this.eventColor, iRound));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        getLocalVisibleRect(this.visibleRect);
        drawRanges(canvas, this.loadingRanges, this.loadingRangePaint);
        drawRanges(canvas, this.ranges, this.rangePaint);
        drawRanges(canvas, this.events, this.eventPaint);
        if (this.collapsed) {
            return;
        }
        drawRuler(canvas);
    }

    private void drawRuler(Canvas canvas) {
        if (this.length == 0) {
            return;
        }
        float strokeWidth = this.rulerPaint.getStrokeWidth() / 2.0f;
        canvas.drawLine(0.0f, strokeWidth, canvas.getWidth(), strokeWidth, this.rulerPaint);
        float height = canvas.getHeight() - strokeWidth;
        canvas.drawLine(0.0f, height, canvas.getWidth(), height, this.rulerPaint);
        float f = r1.left - 120;
        float f2 = this.visibleRect.right + 120;
        float f3 = strokeWidth + this.leftPadding;
        long j = (long) ((((f - f3) / this.scale) + this.borderFrom) / 60.0d);
        long j2 = 60;
        long j3 = this.borderTo / 60;
        while (j <= j3) {
            long j4 = j * j2;
            float f4 = (float) (((j4 - this.borderFrom) * this.scale) + f3);
            if (f4 > f && f4 < f2) {
                drawSticks(canvas, f4, j4);
                drawLabels(canvas, f4, j4);
            }
            j++;
            j2 = 60;
        }
    }

    private void drawSticks(Canvas canvas, float position, long time) {
        if (time % 3600 == 0) {
            drawStick(canvas, position, this.hourLineHeight);
            return;
        }
        if (time % 900 == 0) {
            drawStick(canvas, position, this.fifteenMinutesLineHeight);
            return;
        }
        if (time % 300 == 0) {
            drawStick(canvas, position, this.fiveMinutesLineHeight);
            return;
        }
        TimelineLabelScale timelineLabelScale = this.labelScale;
        if (timelineLabelScale == TimelineLabelScale.EVERY_FIVE_MINUTES || timelineLabelScale == TimelineLabelScale.EVERY_MINUTE) {
            drawStick(canvas, position, this.oneMinuteLineHeight);
        }
    }

    private void drawLabels(Canvas canvas, float position, long time) {
        Calendar calendar = CalendarUtils.calendar(time);
        if (calendar.get(11) == 0 && calendar.get(12) == 0) {
            drawLabel(canvas, position, time, "dd.MM.yy");
        }
        switch (AnonymousClass1.$SwitchMap$flussonic$watcher$sdk$presentation$timeline$TimelineLabelScale[this.labelScale.ordinal()]) {
            case 1:
                if (calendar.get(11) % 3 == 0 && calendar.get(12) == 0) {
                    drawLabel(canvas, position, time, "HH:mm");
                    break;
                }
                break;
            case 2:
                if (calendar.get(11) % 2 == 0 && calendar.get(12) == 0) {
                    drawLabel(canvas, position, time, "HH:mm");
                    break;
                }
                break;
            case 3:
                if (calendar.get(12) == 0) {
                    drawLabel(canvas, position, time, "HH:mm");
                    break;
                }
                break;
            case 4:
                if (calendar.get(12) % 30 == 0) {
                    drawLabel(canvas, position, time, "HH:mm");
                    break;
                }
                break;
            case 5:
                if (calendar.get(12) % 15 == 0) {
                    drawLabel(canvas, position, time, "HH:mm");
                    break;
                }
                break;
            case 6:
                if (calendar.get(12) % 5 == 0) {
                    drawLabel(canvas, position, time, "HH:mm");
                    break;
                }
                break;
            case 7:
                drawLabel(canvas, position, time, "HH:mm");
                break;
        }
    }

    /* renamed from: flussonic.watcher.sdk.presentation.timeline.FlussonicChartView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$flussonic$watcher$sdk$presentation$timeline$TimelineLabelScale;

        static {
            int[] iArr = new int[TimelineLabelScale.values().length];
            $SwitchMap$flussonic$watcher$sdk$presentation$timeline$TimelineLabelScale = iArr;
            try {
                iArr[TimelineLabelScale.EVERY_THIRD_HOUR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$flussonic$watcher$sdk$presentation$timeline$TimelineLabelScale[TimelineLabelScale.EVERY_SECOND_HOUR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$flussonic$watcher$sdk$presentation$timeline$TimelineLabelScale[TimelineLabelScale.EVERY_HOUR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$flussonic$watcher$sdk$presentation$timeline$TimelineLabelScale[TimelineLabelScale.EVERY_HALF_HOUR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$flussonic$watcher$sdk$presentation$timeline$TimelineLabelScale[TimelineLabelScale.EVERY_FIFTEEN_MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$flussonic$watcher$sdk$presentation$timeline$TimelineLabelScale[TimelineLabelScale.EVERY_FIVE_MINUTES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$flussonic$watcher$sdk$presentation$timeline$TimelineLabelScale[TimelineLabelScale.EVERY_MINUTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void drawRanges(Canvas canvas, List<Range> ranges, Paint paint) {
        Iterator<Range> it = ranges.iterator();
        while (it.hasNext()) {
            drawRange(canvas, it.next(), paint);
        }
    }

    private void drawLabel(Canvas canvas, float position, long time, String pattern) {
        String string = CalendarUtils.toString(time, pattern);
        this.labelPaint.getTextBounds(string, 0, string.length(), this.labelRect);
        canvas.drawText(string, position - (this.labelRect.width() / 2), (canvas.getHeight() + this.labelRect.height()) / 2, this.labelPaint);
    }

    private void drawStick(Canvas canvas, float x, float height) {
        canvas.drawLine(x, 0.0f, x, height, this.rulerPaint);
        canvas.drawLine(x, canvas.getHeight() - height, x, canvas.getHeight(), this.rulerPaint);
    }

    private void drawRange(Canvas canvas, Range range, Paint paint) {
        long jFrom = range.from();
        long j = range.to();
        long j2 = this.borderFrom;
        if (jFrom < j2) {
            if (j < j2) {
                return;
            } else {
                jFrom = j2;
            }
        }
        long j3 = this.borderTo;
        if (j > j3) {
            if (jFrom > j3) {
                return;
            } else {
                j = j3;
            }
        }
        Rect rect = this.rangeRect;
        double d = this.scale;
        int i = this.leftPadding;
        rect.left = (int) (((jFrom - j2) * d) + i);
        rect.top = 0;
        rect.right = (int) (((j - j2) * d) + i);
        rect.bottom = canvas.getHeight();
        canvas.drawRect(this.rangeRect, paint);
    }

    private static class OnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private final int oldWidth;
        private final View view;

        /* synthetic */ OnGlobalLayoutListener(View view, int i, AnonymousClass1 anonymousClass1) {
            this(view, i);
        }

        private OnGlobalLayoutListener(View view, int oldWidth) {
            this.view = view;
            this.oldWidth = oldWidth;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.view.getWidth() != this.oldWidth) {
                this.view.requestLayout();
                this.view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }
}
