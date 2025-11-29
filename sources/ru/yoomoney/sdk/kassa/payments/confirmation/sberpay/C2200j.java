package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.march.Out;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2200j implements Function2 {
    public final Function2 a;
    public final Function2 b;
    public final Function1 c;
    public final I d;
    public final String e;
    public final String f;

    public C2200j(Function2 showState, Function2 showEffect, Function1 source, I sberPayConfirmationInteractor, String confirmationData, String shopId) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sberPayConfirmationInteractor, "sberPayConfirmationInteractor");
        Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        this.a = showState;
        this.b = showEffect;
        this.c = source;
        this.d = sberPayConfirmationInteractor;
        this.e = confirmationData;
        this.f = shopId;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        AbstractC2210u state = (AbstractC2210u) obj;
        AbstractC2205o action = (AbstractC2205o) obj2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof C2209t) {
            C2209t c2209t = (C2209t) state;
            return action instanceof C2201k ? Out.INSTANCE.invoke(c2209t, new C2195e(this)) : action instanceof C2204n ? Out.INSTANCE.invoke(c2209t, new C2197g(this, action)) : action instanceof C2203m ? Out.INSTANCE.invoke(new C2208s(((C2203m) action).a), new C2199i(this)) : Out.INSTANCE.skip(c2209t, this.c);
        }
        if (state instanceof C2208s) {
            return action instanceof C2202l ? Out.INSTANCE.invoke(C2209t.a, new C2193c(this)) : Out.INSTANCE.skip((C2208s) state, this.c);
        }
        throw new NoWhenBranchMatchedException();
    }
}
