package npi.spay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import spay.sdk.view.otpTextView.SpayOtpTextView;

/* loaded from: classes4.dex */
public final class B1 extends Lambda implements Function1 {
    public final /* synthetic */ Na a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B1(Na na) {
        super(1);
        this.a = na;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SpayOtpTextView spayOtpTextView;
        C1525cl view;
        if (Intrinsics.areEqual((Boolean) obj, Boolean.TRUE) && (view = (spayOtpTextView = this.a.d).b) != null) {
            view.requestFocus();
            Intrinsics.checkNotNullParameter(spayOtpTextView, "<this>");
            Intrinsics.checkNotNullParameter(view, "view");
            AbstractC1575el.a(spayOtpTextView, view);
        }
        return Unit.INSTANCE;
    }
}
