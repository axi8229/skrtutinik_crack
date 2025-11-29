package flussonic.watcher.sdk.presentation.timeline;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.R$layout;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.pojo.Ranges;
import flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent;
import flussonic.watcher.sdk.presentation.timeline.OnScaleGestureListener;
import timber.log.Timber;

/* loaded from: classes3.dex */
class FlussonicChartBar extends HorizontalScrollView {
    private FlussonicChartView chartView;
    private boolean isTouchOnChart;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private OnScrollChanged onScrollChangedListener;
    private OnUserScrollListener onUserScrollListener;
    private OnVisibleIntervalChanged onVisibleIntervalChangedListener;
    private ScaleGestureDetector scaleGestureDetector;
    private OnScaleGestureListener scaleGestureListener;
    private boolean wasScale;

    interface OnScrollChanged {
        void onScroll(long currentPosition);
    }

    interface OnUserScrollListener {
        void onScroll();
    }

    interface OnVisibleIntervalChanged {
        void onChanged(VisibleRangeChangedEvent event);
    }

    public FlussonicChartBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        View.inflate(getContext(), R$layout.fs_view_flussonic_chart_bar, this);
        setOverScrollMode(2);
        setHorizontalScrollBarEnabled(false);
        setup();
    }

    private void setup() {
        this.chartView = (FlussonicChartView) findViewById(R$id.fs_chart_view);
        this.scaleGestureListener = new OnScaleGestureListener(this, this.chartView);
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), this.scaleGestureListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            this.isTouchOnChart = true;
        } else if (ev.getAction() == 1) {
            this.isTouchOnChart = false;
        }
        if (ev.getPointerCount() < 2) {
            if (this.wasScale) {
                ev.setAction(0);
            }
            this.wasScale = false;
            return super.dispatchTouchEvent(ev);
        }
        this.wasScale = true;
        return this.scaleGestureDetector.onTouchEvent(ev);
    }

    @Override // android.view.View
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (this.onScrollChangedListener != null) {
            this.onScrollChangedListener.onScroll((long) ((getScrollX() / this.chartView.getScale()) + this.chartView.getBorderFrom()));
        }
        OnUserScrollListener onUserScrollListener = this.onUserScrollListener;
        if (onUserScrollListener != null && this.isTouchOnChart) {
            onUserScrollListener.onScroll();
        }
        this.chartView.invalidate();
        visibleIntervalChanged(VisibleRangeChangedEvent.EventType.SCROLL);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Timber.d("onConfigurationChanged", new Object[0]);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        this.onGlobalLayoutListener = new OnGlobalLayoutListener(getWidth());
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int scrollX = getScrollX();
        super.onLayout(changed, l, t, r, b);
        if (!changed || scrollX == getScrollX()) {
            return;
        }
        postDelayed(new Runnable() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicChartBar$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onLayout$0(scrollX);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLayout$0(final int lostScrollPosition) {
        scrollTo(lostScrollPosition, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void visibleIntervalChanged(VisibleRangeChangedEvent.EventType eventType) {
        if (this.onVisibleIntervalChangedListener == null || !isBordersInitialized()) {
            return;
        }
        long scrollX = (long) ((getScrollX() - this.chartView.getLeftPadding()) / this.chartView.getScale());
        long width = (long) (getWidth() / this.chartView.getScale());
        long borderFrom = getBorderFrom() + scrollX;
        if (borderFrom < getBorderFrom()) {
            borderFrom = getBorderFrom();
        }
        long borderFrom2 = scrollX + width + getBorderFrom();
        if (borderFrom2 > getBorderTo()) {
            borderFrom2 = getBorderTo();
        }
        this.onVisibleIntervalChangedListener.onChanged(VisibleRangeChangedEvent.builder().setRange(Range.createFromTo(borderFrom, borderFrom2)).setEventType(eventType).setSecondsInScreen(width).build());
    }

    public long getBorderFrom() {
        return this.chartView.getBorderFrom();
    }

    public long getBorderTo() {
        return this.chartView.getBorderTo();
    }

    public boolean isBordersInitialized() {
        return this.chartView.isBordersInitialized();
    }

    public double getScaleFactor() {
        return this.chartView.getScaleFactor();
    }

    public void setOnUserScrollListener(OnUserScrollListener listener) {
        this.onUserScrollListener = listener;
    }

    public void setOnScrollChangedListener(OnScrollChanged listener) {
        this.onScrollChangedListener = listener;
    }

    public void setOnVisibleIntervalChangedListener(OnVisibleIntervalChanged listener) {
        this.onVisibleIntervalChangedListener = listener;
        if (listener == null) {
            this.scaleGestureListener.setOnScaleEndListener(null);
        } else {
            this.scaleGestureListener.setOnScaleEndListener(new OnScaleGestureListener.OnScaleEndListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicChartBar$$ExternalSyntheticLambda2
                @Override // flussonic.watcher.sdk.presentation.timeline.OnScaleGestureListener.OnScaleEndListener
                public final void onScaleEnd() {
                    this.f$0.lambda$setOnVisibleIntervalChangedListener$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnVisibleIntervalChangedListener$1() {
        visibleIntervalChanged(VisibleRangeChangedEvent.EventType.ZOOM);
    }

    public void setBorders(Range range) {
        this.chartView.setBorders(range);
    }

    public void setRanges(Ranges ranges) {
        this.chartView.setRanges(ranges);
    }

    public long getActualPosition() {
        return (long) (this.chartView.getBorderFrom() + (getScrollX() / this.chartView.getScale()));
    }

    public long getTimeAtPosition(float position) {
        return (long) (this.chartView.getBorderFrom() + (((getScrollX() + position) - this.chartView.getLeftPadding()) / this.chartView.getScale()));
    }

    public void increaseWidthIfNecessary(long position) {
        this.chartView.increaseWidthIfNecessary(position);
    }

    public void scrollToPosition(final long position) {
        post(new Runnable() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicChartBar$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$scrollToPosition$2(position);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scrollToPosition$2(final long position) {
        int iRound = (int) Math.round((position - this.chartView.getBorderFrom()) * this.chartView.getScale());
        smoothScrollTo(iRound, 0);
        if (iRound == 0) {
            visibleIntervalChanged(VisibleRangeChangedEvent.EventType.SCROLL);
        }
    }

    public boolean isCollapsed() {
        return this.chartView.isCollapsed();
    }

    public void collapse() {
        this.chartView.collapse();
    }

    public void expand() {
        this.chartView.expand();
    }

    public void setTransparentFactor(float factor) {
        this.chartView.setTransparentFactor(factor);
    }

    private static class OnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private final int oldWidth;
        private final FlussonicChartBar view;

        private OnGlobalLayoutListener(FlussonicChartBar view, int oldWidth) {
            this.view = view;
            this.oldWidth = oldWidth;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.view.getWidth() != this.oldWidth) {
                this.view.visibleIntervalChanged(VisibleRangeChangedEvent.EventType.CONFIGURATION_CHANGED);
                this.view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }
}
