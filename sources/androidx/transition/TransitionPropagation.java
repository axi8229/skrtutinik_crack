package androidx.transition;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class TransitionPropagation {
    public abstract void captureValues(TransitionValues transitionValues);

    @SuppressLint({"NullableCollection"})
    public abstract String[] getPropagationProperties();

    public abstract long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2);
}
