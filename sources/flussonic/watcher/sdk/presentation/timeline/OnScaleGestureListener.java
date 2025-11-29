package flussonic.watcher.sdk.presentation.timeline;

import android.view.ScaleGestureDetector;

/* loaded from: classes3.dex */
class OnScaleGestureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private final FlussonicChartView childView;
    private double initialScale;
    private OnScaleEndListener onScaleEndListener;
    private final Runnable onSizeChangedAction;
    private double pivotRatio;
    private double scroll;
    private final FlussonicChartBar scrollView;

    interface OnScaleEndListener {
        void onScaleEnd();
    }

    OnScaleGestureListener(final FlussonicChartBar scrollView, FlussonicChartView childView) {
        this.childView = childView;
        this.scrollView = scrollView;
        this.onSizeChangedAction = new Runnable() { // from class: flussonic.watcher.sdk.presentation.timeline.OnScaleGestureListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0(scrollView);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(final FlussonicChartBar scrollView) {
        scrollView.scrollTo((int) this.scroll, 0);
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        this.initialScale = this.childView.getScale();
        this.pivotRatio = ((this.scrollView.getScrollX() + detector.getFocusX()) - this.childView.getLeftPadding()) / this.childView.getLength();
        return super.onScaleBegin(detector);
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        double scale = this.childView.getScale();
        this.childView.setScale(this.initialScale * detector.getScaleFactor());
        if (Math.abs(scale - this.childView.getScale()) < 1.0E-8d) {
            return false;
        }
        this.scroll = ((this.childView.getLength() * this.pivotRatio) - detector.getFocusX()) + this.childView.getLeftPadding();
        this.childView.setOnSizeChangedAction(this.onSizeChangedAction);
        return super.onScale(detector);
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
        OnScaleEndListener onScaleEndListener = this.onScaleEndListener;
        if (onScaleEndListener != null) {
            onScaleEndListener.onScaleEnd();
        }
        super.onScaleEnd(detector);
    }

    public void setOnScaleEndListener(OnScaleEndListener onScaleEndListener) {
        this.onScaleEndListener = onScaleEndListener;
    }
}
