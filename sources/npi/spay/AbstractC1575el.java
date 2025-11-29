package npi.spay;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.view.otpTextView.SpayOtpTextView;

/* renamed from: npi.spay.el, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1575el {
    public static final void a(View this_showDelayedKeyboard, View view) {
        Intrinsics.checkNotNullParameter(this_showDelayedKeyboard, "$this_showDelayedKeyboard");
        Intrinsics.checkNotNullParameter(view, "$view");
        Context context = this_showDelayedKeyboard.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AbstractC1977v0.a(context, view);
    }

    public static final void a(final SpayOtpTextView spayOtpTextView, final C1525cl view) {
        Intrinsics.checkNotNullParameter(spayOtpTextView, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: npi.spay.el$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC1575el.a(spayOtpTextView, view);
            }
        }, 100);
    }
}
