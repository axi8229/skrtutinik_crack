package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;
import ru.yoomoney.sdk.march.CoreKt;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class A0 extends Lambda implements Function1 {
    public final /* synthetic */ C2508s a;
    public final /* synthetic */ E1 b;
    public final /* synthetic */ Q c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A0(C2508s c2508s, E1 e1, Q q) {
        super(1);
        this.a = c2508s;
        this.b = e1;
        this.c = q;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Function1 c2523z0;
        Object next;
        Out.Builder invoke = (Out.Builder) obj;
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        AbstractC2499n0 abstractC2499n0 = this.a.a;
        if (abstractC2499n0 instanceof C2506q0) {
            Iterator it = abstractC2499n0.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((ru.yoomoney.sdk.kassa.payments.model.T) next) instanceof LinkedCard) {
                    break;
                }
            }
            if (next == null) {
                CoreKt.output(invoke, new C2521y0(this.b, this.c, null));
                c2523z0 = this.b.c;
                CoreKt.input(invoke, c2523z0);
            } else {
                E1.a(this.b, invoke, this.a);
            }
        } else if (abstractC2499n0 instanceof C2496m0) {
            c2523z0 = new C2523z0(this.b, invoke, null);
            CoreKt.input(invoke, c2523z0);
        }
        return Unit.INSTANCE;
    }
}
