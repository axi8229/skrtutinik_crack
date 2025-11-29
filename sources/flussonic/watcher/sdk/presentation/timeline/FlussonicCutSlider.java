package flussonic.watcher.sdk.presentation.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.R$layout;
import flussonic.watcher.sdk.presentation.watcher.FlussonicColorTheme;

/* loaded from: classes3.dex */
class FlussonicCutSlider extends LinearLayout {
    private AppCompatImageButton cutSliderButton;
    private OnSliderMoveListener onSliderMoveListener;
    private float startEventX;
    private float startTranslationX;

    interface OnSliderMoveListener {
        void onMoveSlide(float x);
    }

    public FlussonicCutSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.startTranslationX = 0.0f;
        this.startEventX = 0.0f;
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R$layout.fs_view_flussonic_cut_slider, this);
        setOrientation(1);
        setup();
    }

    private void setBtnPressedColor() {
        this.cutSliderButton.setColorFilter(FlussonicColorTheme.getInstance().getColor("fs_pause_button_pressed"), PorterDuff.Mode.SRC_ATOP);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setup() {
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) findViewById(R$id.fs_cut_slider_btn);
        this.cutSliderButton = appCompatImageButton;
        appCompatImageButton.setOnTouchListener(new View.OnTouchListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicCutSlider$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$setup$0(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setup$0(View ignored, MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            setBtnPressedColor();
            this.startTranslationX = getTranslationX();
            this.startEventX = event.getRawX();
            return false;
        }
        if (action == 1) {
            this.cutSliderButton.clearColorFilter();
            return false;
        }
        if (action != 2) {
            return false;
        }
        float rawX = event.getRawX() - this.startEventX;
        OnSliderMoveListener onSliderMoveListener = this.onSliderMoveListener;
        if (onSliderMoveListener == null) {
            return false;
        }
        onSliderMoveListener.onMoveSlide(this.startTranslationX + rawX);
        return false;
    }

    public void setImageResource(int resId) {
        this.cutSliderButton.setImageResource(resId);
    }

    public void setSliderOnMoveListener(OnSliderMoveListener onSliderMoveListener) {
        this.onSliderMoveListener = onSliderMoveListener;
    }
}
