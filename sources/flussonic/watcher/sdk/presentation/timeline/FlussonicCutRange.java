package flussonic.watcher.sdk.presentation.timeline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import flussonic.watcher.sdk.R$dimen;
import flussonic.watcher.sdk.R$drawable;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.R$layout;
import flussonic.watcher.sdk.presentation.timeline.FlussonicCutSlider;
import flussonic.watcher.sdk.presentation.watcher.FlussonicColorTheme;

/* loaded from: classes3.dex */
class FlussonicCutRange extends FrameLayout {
    private boolean isSliderOneInFront;
    private boolean isSliderTwoInFront;
    private OnCutRangeChangeListener onCutRangeChangeListener;
    private float rangeHeight;
    private final Paint rangePaint;
    private FlussonicCutSlider sliderOne;
    private FlussonicCutSlider sliderTwo;

    interface OnCutRangeChangeListener {
        void onCutRangeChanged(float sliderOnePosition, float sliderTwoPosition);
    }

    public FlussonicCutRange(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.rangePaint = new Paint();
        init(attrs);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setupColors();
    }

    private void setupColors() {
        int color = FlussonicColorTheme.getInstance().getColor("fs_cut_range");
        if (this.rangePaint.getColor() != color) {
            this.rangePaint.setColor(color);
        }
    }

    private void init(AttributeSet attrs) {
        View.inflate(getContext(), R$layout.fs_view_flussonic_cut_range, this);
        this.rangeHeight = getResources().getDimension(R$dimen.fs_chart_height);
        setupColors();
        setWillNotDraw(false);
        setVisibility(8);
        setup();
    }

    private void setup() {
        this.sliderOne = (FlussonicCutSlider) findViewById(R$id.fs_cut_slider_one);
        this.sliderTwo = (FlussonicCutSlider) findViewById(R$id.fs_cut_slider_two);
        this.sliderOne.setImageResource(R$drawable.fs_cut_slider_one);
        this.sliderTwo.setImageResource(R$drawable.fs_cut_slider_two);
        this.sliderOne.setSliderOnMoveListener(new FlussonicCutSlider.OnSliderMoveListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicCutRange$$ExternalSyntheticLambda0
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicCutSlider.OnSliderMoveListener
            public final void onMoveSlide(float f) {
                this.f$0.lambda$setup$0(f);
            }
        });
        this.sliderTwo.setSliderOnMoveListener(new FlussonicCutSlider.OnSliderMoveListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicCutRange$$ExternalSyntheticLambda1
            @Override // flussonic.watcher.sdk.presentation.timeline.FlussonicCutSlider.OnSliderMoveListener
            public final void onMoveSlide(float f) {
                this.f$0.lambda$setup$1(f);
            }
        });
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicCutRange.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                FlussonicCutRange.this.sliderOne.setTranslationX(FlussonicCutRange.this.getInitialPositionForSliderOne());
                FlussonicCutRange.this.sliderTwo.setTranslationX(FlussonicCutRange.this.getInitialPositionForSliderTwo());
                FlussonicCutRange.this.removeOnLayoutChangeListener(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setup$0(float x) {
        float fCorrectXConsiderScreenBorders = correctXConsiderScreenBorders(this.sliderOne, x);
        if (fCorrectXConsiderScreenBorders > this.sliderTwo.getX()) {
            fCorrectXConsiderScreenBorders = this.sliderTwo.getX();
        }
        if (!this.isSliderOneInFront) {
            this.sliderOne.bringToFront();
            this.isSliderOneInFront = true;
            this.isSliderTwoInFront = false;
        }
        setTranslationXForSlider(this.sliderOne, fCorrectXConsiderScreenBorders);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setup$1(float x) {
        float fCorrectXConsiderScreenBorders = correctXConsiderScreenBorders(this.sliderTwo, x);
        if (fCorrectXConsiderScreenBorders < this.sliderOne.getX()) {
            fCorrectXConsiderScreenBorders = this.sliderOne.getX();
        }
        if (!this.isSliderTwoInFront) {
            this.sliderTwo.bringToFront();
            this.isSliderOneInFront = false;
            this.isSliderTwoInFront = true;
        }
        setTranslationXForSlider(this.sliderTwo, fCorrectXConsiderScreenBorders);
    }

    private float correctXConsiderScreenBorders(FlussonicCutSlider slider, float x) {
        if (x < 0.0f) {
            x = 0.0f;
        }
        return x > ((float) (getWidth() - slider.getWidth())) ? getWidth() - slider.getWidth() : x;
    }

    private void setTranslationXForSlider(FlussonicCutSlider slider, float x) {
        slider.setTranslationX(x);
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (oldw == 0) {
            return;
        }
        FlussonicCutSlider flussonicCutSlider = this.sliderOne;
        float f = w;
        float f2 = oldw;
        flussonicCutSlider.setTranslationX((flussonicCutSlider.getTranslationX() + f) - f2);
        FlussonicCutSlider flussonicCutSlider2 = this.sliderTwo;
        flussonicCutSlider2.setTranslationX((flussonicCutSlider2.getTranslationX() + f) - f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getInitialPositionForSliderOne() {
        return (getWidth() / 2) - this.sliderOne.getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getInitialPositionForSliderTwo() {
        return getWidth() / 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float x;
        float x2;
        super.onDraw(canvas);
        OnCutRangeChangeListener onCutRangeChangeListener = this.onCutRangeChangeListener;
        if (onCutRangeChangeListener != null) {
            onCutRangeChangeListener.onCutRangeChanged(getSliderOnePosition(), getSliderTwoPosition());
        }
        if (this.sliderOne.getX() < 0.0f) {
            x = this.sliderOne.getWidth() / 2;
            this.sliderOne.setTranslationX(0.0f);
        } else {
            x = this.sliderOne.getX() + (this.sliderOne.getWidth() / 2);
        }
        float f = x;
        if (this.sliderTwo.getX() < 0.0f) {
            x2 = this.sliderTwo.getWidth() / 2;
            this.sliderTwo.setTranslationX(0.0f);
        } else {
            x2 = this.sliderTwo.getX() + (this.sliderTwo.getWidth() / 2);
        }
        canvas.drawRect(f, canvas.getHeight() - this.rangeHeight, x2, canvas.getHeight(), this.rangePaint);
    }

    public void setOnCutRangeChangeListener(OnCutRangeChangeListener onCutRangeChangeListener) {
        this.onCutRangeChangeListener = onCutRangeChangeListener;
    }

    public float getSliderOnePosition() {
        if (this.sliderOne.getX() < 0.0f) {
            return this.sliderOne.getWidth() / 2;
        }
        return this.sliderOne.getX() + (this.sliderOne.getWidth() / 2);
    }

    public float getSliderTwoPosition() {
        if (this.sliderTwo.getX() < 0.0f) {
            return this.sliderTwo.getWidth() / 2;
        }
        return this.sliderTwo.getX() + (this.sliderTwo.getWidth() / 2);
    }
}
