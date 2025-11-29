package flussonic.watcher.sdk.presentation.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import flussonic.watcher.sdk.R$drawable;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.R$layout;
import flussonic.watcher.sdk.presentation.watcher.FlussonicColorTheme;

/* loaded from: classes3.dex */
class FlussonicLiveButton extends LinearLayout {
    private AppCompatImageButton liveButton;
    private boolean liveState;

    interface OnPlayClickListener {
        void onLiveClick();

        void onPlayClick();
    }

    public FlussonicLiveButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.liveState = true;
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R$layout.fs_view_flussonic_live_button, this);
        setOrientation(1);
        setup();
    }

    private void setBtnPressedColor() {
        this.liveButton.setColorFilter(FlussonicColorTheme.getInstance().getColor("fs_pause_button_pressed"), PorterDuff.Mode.SRC_ATOP);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setup() {
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) findViewById(R$id.fs_live_btn);
        this.liveButton = appCompatImageButton;
        appCompatImageButton.setOnTouchListener(new View.OnTouchListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicLiveButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$setup$0(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setup$0(View v, MotionEvent event) {
        if (event.getAction() == 0) {
            setBtnPressedColor();
            return false;
        }
        if (event.getAction() != 1) {
            return false;
        }
        this.liveButton.clearColorFilter();
        return false;
    }

    public void setOnPlayClickListener(final OnPlayClickListener listener) {
        this.liveButton.setOnClickListener(new View.OnClickListener() { // from class: flussonic.watcher.sdk.presentation.timeline.FlussonicLiveButton$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setOnPlayClickListener$1(listener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnPlayClickListener$1(final OnPlayClickListener listener, View view) {
        if (listener != null) {
            if (this.liveState) {
                listener.onLiveClick();
            } else {
                listener.onPlayClick();
            }
        }
    }

    public void setLiveState(boolean isLive) {
        this.liveState = isLive;
        if (isLive) {
            this.liveButton.setImageResource(R$drawable.fs_btn_live);
        } else {
            this.liveButton.setImageResource(R$drawable.fs_btn_play);
        }
    }
}
