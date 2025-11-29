package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class Key {
    public static int UNSET = -1;
    HashMap<String, ConstraintAttribute> mCustomConstraints;
    int mFramePosition;
    int mTargetId;
    String mTargetString;
    protected int mType;

    public abstract void addValues(HashMap<String, ViewSpline> splines);

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract Key mo2211clone();

    abstract void getAttributeNames(HashSet<String> attributes);

    abstract void load(Context context, AttributeSet attrs);

    public void setInterpolation(HashMap<String, Integer> interpolation) {
    }

    public Key() {
        int i = UNSET;
        this.mFramePosition = i;
        this.mTargetId = i;
        this.mTargetString = null;
    }

    public Key copy(Key src) {
        this.mFramePosition = src.mFramePosition;
        this.mTargetId = src.mTargetId;
        this.mTargetString = src.mTargetString;
        this.mType = src.mType;
        this.mCustomConstraints = src.mCustomConstraints;
        return this;
    }

    public Key setViewId(int id) {
        this.mTargetId = id;
        return this;
    }
}
