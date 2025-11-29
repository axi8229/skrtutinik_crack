package npi.spay;

import android.util.DisplayMetrics;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: npi.spay.x1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2028x1 extends Lambda implements Function0 {
    public final /* synthetic */ C2078z1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2028x1(C2078z1 c2078z1) {
        super(0);
        this.a = c2078z1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        DisplayMetrics displayMetrics = this.a.a.getResources().getDisplayMetrics();
        StringBuilder sb = new StringBuilder();
        sb.append(displayMetrics.heightPixels);
        sb.append('x');
        sb.append(displayMetrics.widthPixels);
        return sb.toString();
    }
}
