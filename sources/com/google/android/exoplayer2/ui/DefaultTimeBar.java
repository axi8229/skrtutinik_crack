package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public class DefaultTimeBar extends View implements TimeBar {
    private int adGroupCount;
    private long[] adGroupTimesMs;
    private final Paint adMarkerPaint;
    private final int adMarkerWidth;
    private final int barHeight;
    private final Rect bufferedBar;
    private final Paint bufferedPaint;
    private long bufferedPosition;
    private final float density;
    private long duration;
    private final int fineScrubYThreshold;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private int keyCountIncrement;
    private long keyTimeIncrement;
    private int lastCoarseScrubXPosition;
    private Rect lastExclusionRectangle;
    private final CopyOnWriteArraySet<TimeBar.OnScrubListener> listeners;
    private final int[] locationOnScreen;
    private boolean[] playedAdGroups;
    private final Paint playedAdMarkerPaint;
    private final Paint playedPaint;
    private long position;
    private final Rect progressBar;
    private long scrubPosition;
    private final Rect scrubberBar;
    private final int scrubberDisabledSize;
    private final int scrubberDraggedSize;
    private final Drawable scrubberDrawable;
    private final int scrubberEnabledSize;
    private final int scrubberPadding;
    private final Paint scrubberPaint;
    private float scrubberScale;
    private ValueAnimator scrubberScalingAnimator;
    private boolean scrubbing;
    private final Rect seekBounds;
    private final Runnable stopScrubbingRunnable;
    private final Point touchPosition;
    private final int touchTargetHeight;
    private final Paint unplayedPaint;

    private static int dpToPx(float density, int dps) {
        return (int) ((dps * density) + 0.5f);
    }

    private static int pxToDp(float density, int px) {
        return (int) (px / density);
    }

    public DefaultTimeBar(Context context, AttributeSet attrs, int defStyleAttr, AttributeSet timebarAttrs) {
        super(context, attrs, defStyleAttr);
        this.seekBounds = new Rect();
        this.progressBar = new Rect();
        this.bufferedBar = new Rect();
        this.scrubberBar = new Rect();
        Paint paint = new Paint();
        this.playedPaint = paint;
        Paint paint2 = new Paint();
        this.bufferedPaint = paint2;
        Paint paint3 = new Paint();
        this.unplayedPaint = paint3;
        Paint paint4 = new Paint();
        this.adMarkerPaint = paint4;
        Paint paint5 = new Paint();
        this.playedAdMarkerPaint = paint5;
        Paint paint6 = new Paint();
        this.scrubberPaint = paint6;
        paint6.setAntiAlias(true);
        this.listeners = new CopyOnWriteArraySet<>();
        this.locationOnScreen = new int[2];
        this.touchPosition = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.density = f;
        this.fineScrubYThreshold = dpToPx(f, -50);
        int iDpToPx = dpToPx(f, 4);
        int iDpToPx2 = dpToPx(f, 26);
        int iDpToPx3 = dpToPx(f, 4);
        int iDpToPx4 = dpToPx(f, 12);
        int iDpToPx5 = dpToPx(f, 0);
        int iDpToPx6 = dpToPx(f, 16);
        if (timebarAttrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(timebarAttrs, R$styleable.DefaultTimeBar, 0, 0);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.DefaultTimeBar_scrubber_drawable);
                this.scrubberDrawable = drawable;
                if (drawable != null) {
                    setDrawableLayoutDirection(drawable);
                    iDpToPx2 = Math.max(drawable.getMinimumHeight(), iDpToPx2);
                }
                this.barHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_bar_height, iDpToPx);
                this.touchTargetHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_touch_target_height, iDpToPx2);
                this.adMarkerWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_ad_marker_width, iDpToPx3);
                this.scrubberEnabledSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_enabled_size, iDpToPx4);
                this.scrubberDisabledSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_disabled_size, iDpToPx5);
                this.scrubberDraggedSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DefaultTimeBar_scrubber_dragged_size, iDpToPx6);
                int i = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_color, -1);
                int i2 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_scrubber_color, -1);
                int i3 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_buffered_color, -855638017);
                int i4 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_unplayed_color, 872415231);
                int i5 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                int i6 = typedArrayObtainStyledAttributes.getInt(R$styleable.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i);
                paint6.setColor(i2);
                paint2.setColor(i3);
                paint3.setColor(i4);
                paint4.setColor(i5);
                paint5.setColor(i6);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.barHeight = iDpToPx;
            this.touchTargetHeight = iDpToPx2;
            this.adMarkerWidth = iDpToPx3;
            this.scrubberEnabledSize = iDpToPx4;
            this.scrubberDisabledSize = iDpToPx5;
            this.scrubberDraggedSize = iDpToPx6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.scrubberDrawable = null;
        }
        StringBuilder sb = new StringBuilder();
        this.formatBuilder = sb;
        this.formatter = new Formatter(sb, Locale.getDefault());
        this.stopScrubbingRunnable = new Runnable() { // from class: com.google.android.exoplayer2.ui.DefaultTimeBar$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        Drawable drawable2 = this.scrubberDrawable;
        if (drawable2 != null) {
            this.scrubberPadding = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.scrubberPadding = (Math.max(this.scrubberDisabledSize, Math.max(this.scrubberEnabledSize, this.scrubberDraggedSize)) + 1) / 2;
        }
        this.scrubberScale = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.scrubberScalingAnimator = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.DefaultTimeBar$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f$0.lambda$new$1(valueAnimator2);
            }
        });
        this.duration = -9223372036854775807L;
        this.keyTimeIncrement = -9223372036854775807L;
        this.keyCountIncrement = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        stopScrubbing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(ValueAnimator animation) {
        this.scrubberScale = ((Float) animation.getAnimatedValue()).floatValue();
        invalidate(this.seekBounds);
    }

    public void setPlayedColor(int playedColor) {
        this.playedPaint.setColor(playedColor);
        invalidate(this.seekBounds);
    }

    public void setScrubberColor(int scrubberColor) {
        this.scrubberPaint.setColor(scrubberColor);
        invalidate(this.seekBounds);
    }

    public void setBufferedColor(int bufferedColor) {
        this.bufferedPaint.setColor(bufferedColor);
        invalidate(this.seekBounds);
    }

    public void setUnplayedColor(int unplayedColor) {
        this.unplayedPaint.setColor(unplayedColor);
        invalidate(this.seekBounds);
    }

    public void setAdMarkerColor(int adMarkerColor) {
        this.adMarkerPaint.setColor(adMarkerColor);
        invalidate(this.seekBounds);
    }

    public void setPlayedAdMarkerColor(int playedAdMarkerColor) {
        this.playedAdMarkerPaint.setColor(playedAdMarkerColor);
        invalidate(this.seekBounds);
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void addListener(TimeBar.OnScrubListener listener) {
        this.listeners.add(listener);
    }

    public void setKeyTimeIncrement(long time) {
        Assertions.checkArgument(time > 0);
        this.keyCountIncrement = -1;
        this.keyTimeIncrement = time;
    }

    public void setKeyCountIncrement(int count) {
        Assertions.checkArgument(count > 0);
        this.keyCountIncrement = count;
        this.keyTimeIncrement = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setPosition(long position) {
        this.position = position;
        setContentDescription(getProgressText());
        update();
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setBufferedPosition(long bufferedPosition) {
        this.bufferedPosition = bufferedPosition;
        update();
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setDuration(long duration) {
        this.duration = duration;
        if (this.scrubbing && duration == -9223372036854775807L) {
            stopScrubbing(true);
        }
        update();
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public long getPreferredUpdateDelay() {
        int iPxToDp = pxToDp(this.density, this.progressBar.width());
        if (iPxToDp != 0) {
            long j = this.duration;
            if (j != 0 && j != -9223372036854775807L) {
                return j / iPxToDp;
            }
        }
        return Long.MAX_VALUE;
    }

    @Override // com.google.android.exoplayer2.ui.TimeBar
    public void setAdGroupTimesMs(long[] adGroupTimesMs, boolean[] playedAdGroups, int adGroupCount) {
        Assertions.checkArgument(adGroupCount == 0 || !(adGroupTimesMs == null || playedAdGroups == null));
        this.adGroupCount = adGroupCount;
        this.adGroupTimesMs = adGroupTimesMs;
        this.playedAdGroups = playedAdGroups;
        update();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.TimeBar
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (!this.scrubbing || enabled) {
            return;
        }
        stopScrubbing(true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        drawTimeBar(canvas);
        drawPlayhead(canvas);
        canvas.restore();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L76
            long r2 = r7.duration
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L10
            goto L76
        L10:
            android.graphics.Point r0 = r7.resolveRelativeTouchPosition(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L5d
            r5 = 3
            if (r3 == r4) goto L4e
            r6 = 2
            if (r3 == r6) goto L28
            if (r3 == r5) goto L4e
            goto L76
        L28:
            boolean r8 = r7.scrubbing
            if (r8 == 0) goto L76
            int r8 = r7.fineScrubYThreshold
            if (r0 >= r8) goto L3a
            int r8 = r7.lastCoarseScrubXPosition
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.positionScrubber(r8)
            goto L40
        L3a:
            r7.lastCoarseScrubXPosition = r2
            float r8 = (float) r2
            r7.positionScrubber(r8)
        L40:
            long r0 = r7.getScrubberPosition()
            r7.updateScrubbing(r0)
            r7.update()
            r7.invalidate()
            return r4
        L4e:
            boolean r0 = r7.scrubbing
            if (r0 == 0) goto L76
            int r8 = r8.getAction()
            if (r8 != r5) goto L59
            r1 = r4
        L59:
            r7.stopScrubbing(r1)
            return r4
        L5d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.isInSeekBar(r8, r0)
            if (r0 == 0) goto L76
            r7.positionScrubber(r8)
            long r0 = r7.getScrubberPosition()
            r7.startScrubbing(r0)
            r7.update()
            r7.invalidate()
            return r4
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L30
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L27
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L27;
                default: goto L12;
            }
        L12:
            goto L30
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.scrubIncrementally(r0)
            if (r0 == 0) goto L30
            java.lang.Runnable r5 = r4.stopScrubbingRunnable
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.stopScrubbingRunnable
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L27:
            boolean r0 = r4.scrubbing
            if (r0 == 0) goto L30
            r5 = 0
            r4.stopScrubbing(r5)
            return r3
        L30:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (!this.scrubbing || gainFocus) {
            return;
        }
        stopScrubbing(false);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateDrawableState();
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode == 0) {
            size = this.touchTargetHeight;
        } else if (mode != 1073741824) {
            size = Math.min(this.touchTargetHeight, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), size);
        updateDrawableState();
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i = right - left;
        int i2 = bottom - top;
        int i3 = (i2 - this.touchTargetHeight) / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i - getPaddingRight();
        int i4 = this.touchTargetHeight;
        int i5 = ((i4 - this.barHeight) / 2) + i3;
        this.seekBounds.set(paddingLeft, i3, paddingRight, i4 + i3);
        Rect rect = this.progressBar;
        Rect rect2 = this.seekBounds;
        int i6 = rect2.left;
        int i7 = this.scrubberPadding;
        rect.set(i6 + i7, i5, rect2.right - i7, this.barHeight + i5);
        if (Util.SDK_INT >= 29) {
            setSystemGestureExclusionRectsV29(i, i2);
        }
        update();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        Drawable drawable = this.scrubberDrawable;
        if (drawable == null || !setDrawableLayoutDirection(drawable, layoutDirection)) {
            return;
        }
        invalidate();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        if (event.getEventType() == 4) {
            event.getText().add(getProgressText());
        }
        event.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.SeekBar");
        info.setContentDescription(getProgressText());
        if (this.duration <= 0) {
            return;
        }
        if (Util.SDK_INT >= 21) {
            info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            info.addAction(4096);
            info.addAction(8192);
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, Bundle args) {
        if (super.performAccessibilityAction(action, args)) {
            return true;
        }
        if (this.duration <= 0) {
            return false;
        }
        if (action == 8192) {
            if (scrubIncrementally(-getPositionIncrement())) {
                stopScrubbing(false);
            }
        } else {
            if (action != 4096) {
                return false;
            }
            if (scrubIncrementally(getPositionIncrement())) {
                stopScrubbing(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    private void startScrubbing(long scrubPosition) {
        this.scrubPosition = scrubPosition;
        this.scrubbing = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onScrubStart(this, scrubPosition);
        }
    }

    private void updateScrubbing(long scrubPosition) {
        if (this.scrubPosition == scrubPosition) {
            return;
        }
        this.scrubPosition = scrubPosition;
        Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onScrubMove(this, scrubPosition);
        }
    }

    private void stopScrubbing(boolean canceled) {
        removeCallbacks(this.stopScrubbingRunnable);
        this.scrubbing = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<TimeBar.OnScrubListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onScrubStop(this, this.scrubPosition, canceled);
        }
    }

    private boolean scrubIncrementally(long positionChange) {
        long j = this.duration;
        if (j <= 0) {
            return false;
        }
        long j2 = this.scrubbing ? this.scrubPosition : this.position;
        long jConstrainValue = Util.constrainValue(j2 + positionChange, 0L, j);
        if (jConstrainValue == j2) {
            return false;
        }
        if (!this.scrubbing) {
            startScrubbing(jConstrainValue);
        } else {
            updateScrubbing(jConstrainValue);
        }
        update();
        return true;
    }

    private void update() {
        this.bufferedBar.set(this.progressBar);
        this.scrubberBar.set(this.progressBar);
        long j = this.scrubbing ? this.scrubPosition : this.position;
        if (this.duration > 0) {
            int iWidth = (int) ((this.progressBar.width() * this.bufferedPosition) / this.duration);
            Rect rect = this.bufferedBar;
            Rect rect2 = this.progressBar;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((this.progressBar.width() * j) / this.duration);
            Rect rect3 = this.scrubberBar;
            Rect rect4 = this.progressBar;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.bufferedBar;
            int i = this.progressBar.left;
            rect5.right = i;
            this.scrubberBar.right = i;
        }
        invalidate(this.seekBounds);
    }

    private void positionScrubber(float xPosition) {
        Rect rect = this.scrubberBar;
        Rect rect2 = this.progressBar;
        rect.right = Util.constrainValue((int) xPosition, rect2.left, rect2.right);
    }

    private Point resolveRelativeTouchPosition(MotionEvent motionEvent) {
        getLocationOnScreen(this.locationOnScreen);
        this.touchPosition.set(((int) motionEvent.getRawX()) - this.locationOnScreen[0], ((int) motionEvent.getRawY()) - this.locationOnScreen[1]);
        return this.touchPosition;
    }

    private long getScrubberPosition() {
        if (this.progressBar.width() <= 0 || this.duration == -9223372036854775807L) {
            return 0L;
        }
        return (this.scrubberBar.width() * this.duration) / this.progressBar.width();
    }

    private boolean isInSeekBar(float x, float y) {
        return this.seekBounds.contains((int) x, (int) y);
    }

    private void drawTimeBar(Canvas canvas) {
        int iHeight = this.progressBar.height();
        int iCenterY = this.progressBar.centerY() - (iHeight / 2);
        int i = iHeight + iCenterY;
        if (this.duration <= 0) {
            Rect rect = this.progressBar;
            canvas.drawRect(rect.left, iCenterY, rect.right, i, this.unplayedPaint);
            return;
        }
        Rect rect2 = this.bufferedBar;
        int i2 = rect2.left;
        int i3 = rect2.right;
        int iMax = Math.max(Math.max(this.progressBar.left, i3), this.scrubberBar.right);
        int i4 = this.progressBar.right;
        if (iMax < i4) {
            canvas.drawRect(iMax, iCenterY, i4, i, this.unplayedPaint);
        }
        int iMax2 = Math.max(i2, this.scrubberBar.right);
        if (i3 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i3, i, this.bufferedPaint);
        }
        if (this.scrubberBar.width() > 0) {
            Rect rect3 = this.scrubberBar;
            canvas.drawRect(rect3.left, iCenterY, rect3.right, i, this.playedPaint);
        }
        if (this.adGroupCount == 0) {
            return;
        }
        long[] jArr = (long[]) Assertions.checkNotNull(this.adGroupTimesMs);
        boolean[] zArr = (boolean[]) Assertions.checkNotNull(this.playedAdGroups);
        int i5 = this.adMarkerWidth / 2;
        for (int i6 = 0; i6 < this.adGroupCount; i6++) {
            int iWidth = ((int) ((this.progressBar.width() * Util.constrainValue(jArr[i6], 0L, this.duration)) / this.duration)) - i5;
            Rect rect4 = this.progressBar;
            canvas.drawRect(rect4.left + Math.min(rect4.width() - this.adMarkerWidth, Math.max(0, iWidth)), iCenterY, r10 + this.adMarkerWidth, i, zArr[i6] ? this.playedAdMarkerPaint : this.adMarkerPaint);
        }
    }

    private void drawPlayhead(Canvas canvas) {
        int i;
        if (this.duration <= 0) {
            return;
        }
        Rect rect = this.scrubberBar;
        int iConstrainValue = Util.constrainValue(rect.right, rect.left, this.progressBar.right);
        int iCenterY = this.scrubberBar.centerY();
        if (this.scrubberDrawable == null) {
            if (this.scrubbing || isFocused()) {
                i = this.scrubberDraggedSize;
            } else {
                i = isEnabled() ? this.scrubberEnabledSize : this.scrubberDisabledSize;
            }
            canvas.drawCircle(iConstrainValue, iCenterY, (int) ((i * this.scrubberScale) / 2.0f), this.scrubberPaint);
            return;
        }
        int intrinsicWidth = ((int) (r2.getIntrinsicWidth() * this.scrubberScale)) / 2;
        int intrinsicHeight = ((int) (this.scrubberDrawable.getIntrinsicHeight() * this.scrubberScale)) / 2;
        this.scrubberDrawable.setBounds(iConstrainValue - intrinsicWidth, iCenterY - intrinsicHeight, iConstrainValue + intrinsicWidth, iCenterY + intrinsicHeight);
        this.scrubberDrawable.draw(canvas);
    }

    private void updateDrawableState() {
        Drawable drawable = this.scrubberDrawable;
        if (drawable != null && drawable.isStateful() && this.scrubberDrawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    private void setSystemGestureExclusionRectsV29(int width, int height) {
        Rect rect = this.lastExclusionRectangle;
        if (rect != null && rect.width() == width && this.lastExclusionRectangle.height() == height) {
            return;
        }
        Rect rect2 = new Rect(0, 0, width, height);
        this.lastExclusionRectangle = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    private String getProgressText() {
        return Util.getStringForTime(this.formatBuilder, this.formatter, this.position);
    }

    private long getPositionIncrement() {
        long j = this.keyTimeIncrement;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.duration;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / this.keyCountIncrement;
    }

    private boolean setDrawableLayoutDirection(Drawable drawable) {
        return Util.SDK_INT >= 23 && setDrawableLayoutDirection(drawable, getLayoutDirection());
    }

    private static boolean setDrawableLayoutDirection(Drawable drawable, int layoutDirection) {
        return Util.SDK_INT >= 23 && drawable.setLayoutDirection(layoutDirection);
    }
}
