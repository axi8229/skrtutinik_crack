package androidx.constraintlayout.motion.widget;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionLayout.TransitionListener {
    private float mProgress;
    private boolean mUseOnHide;
    private boolean mUseOnShow;
    protected View[] views;

    public boolean isDecorator() {
        return false;
    }

    public void onFinishedMotionScene(MotionLayout motionLayout) {
    }

    public void onPostDraw(Canvas canvas) {
    }

    public void onPreDraw(Canvas canvas) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {
    }

    public void setProgress(View view, float progress) {
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet attrs) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.init(attrs);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$styleable.MotionHelper);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.MotionHelper_onShow) {
                    this.mUseOnShow = typedArrayObtainStyledAttributes.getBoolean(index, this.mUseOnShow);
                } else if (index == R$styleable.MotionHelper_onHide) {
                    this.mUseOnHide = typedArrayObtainStyledAttributes.getBoolean(index, this.mUseOnHide);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
        int i = 0;
        if (this.mCount > 0) {
            this.views = getViews((ConstraintLayout) getParent());
            while (i < this.mCount) {
                setProgress(this.views[i], progress);
                i++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, progress);
            }
            i++;
        }
    }
}
