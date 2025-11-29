package npi.spay;

import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class K0 extends Lambda implements Function1 {
    public final /* synthetic */ C1579f0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K0(C1579f0 c1579f0) {
        super(1);
        this.a = c1579f0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String code = (String) obj;
        if (code != null) {
            Intrinsics.checkNotNullExpressionValue(code, "code");
            C1579f0 c1579f0 = this.a;
            int i = C1579f0.$r8$clinit;
            ViewBinding viewBinding = c1579f0.c;
            if (viewBinding == null) {
                throw C2040xd.a;
            }
            ((Na) viewBinding).d.setOTP(code);
        }
        return Unit.INSTANCE;
    }
}
