package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.t0;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class m implements Function2 {
    public final Function2 a;
    public final Function2 b;
    public final Function1 c;
    public final s d;

    public m(Function2 showState, Function2 showEffect, Function1 source, s paymentDetailsUseCase) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(paymentDetailsUseCase, "paymentDetailsUseCase");
        this.a = showState;
        this.b = showEffect;
        this.c = source;
        this.d = paymentDetailsUseCase;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ru.yoomoney.sdk.kassa.payments.confirmation.sbp.l state = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.l) obj;
        ru.yoomoney.sdk.kassa.payments.confirmation.sbp.f action = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.f) obj2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (!(state instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.j)) {
            if (state instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.k) {
                return action instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.a ? Out.INSTANCE.invoke(ru.yoomoney.sdk.kassa.payments.confirmation.sbp.j.a, new c(this, (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.a) action)) : Out.INSTANCE.skip((ru.yoomoney.sdk.kassa.payments.confirmation.sbp.k) state, this.c);
            }
            throw new NoWhenBranchMatchedException();
        }
        ru.yoomoney.sdk.kassa.payments.confirmation.sbp.j jVar = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.j) state;
        if (action instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.a) {
            return Out.INSTANCE.invoke(ru.yoomoney.sdk.kassa.payments.confirmation.sbp.j.a, new c(this, (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.a) action));
        }
        if (action instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.c) {
            return Out.INSTANCE.invoke(jVar, new l(this, action));
        }
        if (action instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.e) {
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.e eVar = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.e) action;
            return eVar.d == t0.b ? Out.INSTANCE.invoke(ru.yoomoney.sdk.kassa.payments.confirmation.sbp.j.a, new e(this)) : Out.INSTANCE.invoke(ru.yoomoney.sdk.kassa.payments.confirmation.sbp.j.a, new g(this, eVar));
        }
        if (action instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.d) {
            return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.k(((ru.yoomoney.sdk.kassa.payments.confirmation.sbp.d) action).a), new i(this));
        }
        if (action instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.b) {
            return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.k(((ru.yoomoney.sdk.kassa.payments.confirmation.sbp.b) action).a), new i(this));
        }
        throw new NoWhenBranchMatchedException();
    }
}
