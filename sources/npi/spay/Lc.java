package npi.spay;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Lc extends Lambda implements Function1 {
    public final /* synthetic */ C1940td a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Lc(C1940td c1940td) {
        super(1);
        this.a = c1940td;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        View it = (View) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        ((Xf) this.a.b()).a(C1941te.a);
        return Unit.INSTANCE;
    }
}
