package npi.spay;

import android.os.SystemClock;
import android.view.View;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import ru.yoomoney.sdk.kassa.payments.R$string;

/* renamed from: npi.spay.d0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewOnClickListenerC1529d0 implements View.OnClickListener {
    public final /* synthetic */ Ref$LongRef a;
    public final /* synthetic */ Na b;
    public final /* synthetic */ C1579f0 c;

    public ViewOnClickListenerC1529d0(Ref$LongRef ref$LongRef, Na na, C1579f0 c1579f0) {
        this.a = ref$LongRef;
        this.b = na;
        this.c = c1579f0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View it) throws NoSuchAlgorithmException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Ref$LongRef ref$LongRef = this.a;
        if (jElapsedRealtime - ref$LongRef.element < 400) {
            return;
        }
        ref$LongRef.element = SystemClock.elapsedRealtime();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        C1525cl c1525cl = this.b.d.b;
        if (c1525cl != null) {
            c1525cl.setText(R$string.spay_empty_string);
        }
        ((C2081z4) this.c.b()).a(C1776mn.a);
    }
}
