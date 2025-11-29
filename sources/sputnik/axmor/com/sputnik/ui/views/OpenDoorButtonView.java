package sputnik.axmor.com.sputnik.ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.location.DeviceOrientationRequest;
import sputnik.axmor.com.R;
import sputnik.axmor.com.databinding.ViewOpenDoorButtonBinding;

/* loaded from: classes5.dex */
public class OpenDoorButtonView extends ConstraintLayout {
    Animation.AnimationListener animationEnlargeListener;
    private boolean animationLocked;
    ViewOpenDoorButtonBinding binding;
    private ClickListener clickListener;
    long lastCLickTime;
    View.OnClickListener outerListener;
    private Animation scaleAnimation;

    public OpenDoorButtonView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.clickListener = new ClickListener();
        this.lastCLickTime = 0L;
        this.animationLocked = false;
        this.animationEnlargeListener = new Animation.AnimationListener() { // from class: sputnik.axmor.com.sputnik.ui.views.OpenDoorButtonView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Drawable drawable = AppCompatResources.getDrawable(OpenDoorButtonView.this.getContext(), R.drawable.ic_buttonopen);
                OpenDoorButtonView.this.binding.buttonBackground.setVisibility(0);
                OpenDoorButtonView.this.binding.mainBackground.setImageDrawable(drawable);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                OpenDoorButtonView.this.binding.mainBackground.setImageDrawable(AppCompatResources.getDrawable(OpenDoorButtonView.this.getContext(), R.drawable.ic_buttonclose));
                OpenDoorButtonView.this.binding.buttonBackground.setVisibility(4);
                OpenDoorButtonView.this.performHapticFeedback(1, 2);
            }
        };
        init();
    }

    private void init() throws Resources.NotFoundException {
        ViewOpenDoorButtonBinding viewOpenDoorButtonBindingInflate = ViewOpenDoorButtonBinding.inflate((LayoutInflater) getContext().getSystemService("layout_inflater"), this, true);
        this.binding = viewOpenDoorButtonBindingInflate;
        viewOpenDoorButtonBindingInflate.getRoot().setOnClickListener(this.clickListener);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.enlarge);
        this.scaleAnimation = animationLoadAnimation;
        animationLoadAnimation.setAnimationListener(this.animationEnlargeListener);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != this.clickListener) {
            this.outerListener = onClickListener;
        }
    }

    private class ClickListener implements View.OnClickListener {
        private ClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (OpenDoorButtonView.this.outerListener != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                OpenDoorButtonView openDoorButtonView = OpenDoorButtonView.this;
                long j = openDoorButtonView.lastCLickTime;
                long j2 = jCurrentTimeMillis - j;
                if (j == 0 || j2 >= DeviceOrientationRequest.OUTPUT_PERIOD_FAST) {
                    openDoorButtonView.lastCLickTime = jCurrentTimeMillis;
                    if (!openDoorButtonView.animationLocked) {
                        animation();
                    }
                    OpenDoorButtonView.this.outerListener.onClick(view);
                    OpenDoorButtonView.this.performHapticFeedback(1, 2);
                }
            }
        }

        private void animation() {
            OpenDoorButtonView openDoorButtonView = OpenDoorButtonView.this;
            openDoorButtonView.binding.buttonBackground.startAnimation(openDoorButtonView.scaleAnimation);
        }
    }
}
