package androidx.databinding.adapters;

import android.widget.CompoundButton;

/* loaded from: classes.dex */
public class CompoundButtonBindingAdapter {
    public static void setChecked(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isChecked() != z) {
            compoundButton.setChecked(z);
        }
    }
}
