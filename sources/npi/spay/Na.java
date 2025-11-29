package npi.spay;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import spay.sdk.view.otpTextView.SpayOtpTextView;

/* loaded from: classes4.dex */
public final class Na implements ViewBinding {
    public final ConstraintLayout a;
    public final MaterialButton b;
    public final MaterialButton c;
    public final SpayOtpTextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;

    public Na(ConstraintLayout constraintLayout, MaterialButton materialButton, MaterialButton materialButton2, SpayOtpTextView spayOtpTextView, TextView textView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = materialButton;
        this.c = materialButton2;
        this.d = spayOtpTextView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
