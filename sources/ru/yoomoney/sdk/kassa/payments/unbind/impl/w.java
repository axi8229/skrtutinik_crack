package ru.yoomoney.sdk.kassa.payments.unbind.impl;

import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.LinkedCard;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class w implements Function2 {
    public final Function2 a;
    public final Function2 b;
    public final Function1 c;
    public final x d;

    public w(Function2 showState, Function2 showEffect, Function1 source, x unbindCardUseCase) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(unbindCardUseCase, "unbindCardUseCase");
        this.a = showState;
        this.b = showEffect;
        this.c = source;
        this.d = unbindCardUseCase;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Out.Companion companion;
        Function oVar;
        ru.yoomoney.sdk.kassa.payments.unbind.n state = (ru.yoomoney.sdk.kassa.payments.unbind.n) obj;
        ru.yoomoney.sdk.kassa.payments.unbind.f action = (ru.yoomoney.sdk.kassa.payments.unbind.f) obj2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof ru.yoomoney.sdk.kassa.payments.unbind.l) {
            ru.yoomoney.sdk.kassa.payments.unbind.l lVar = (ru.yoomoney.sdk.kassa.payments.unbind.l) state;
            if (!(action instanceof ru.yoomoney.sdk.kassa.payments.unbind.b)) {
                return Out.INSTANCE.skip(lVar, this.c);
            }
            ru.yoomoney.sdk.kassa.payments.unbind.b bVar = (ru.yoomoney.sdk.kassa.payments.unbind.b) action;
            LinkedCard linkedCard = bVar.a;
            if (linkedCard != null) {
                return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.unbind.k(linkedCard), new q(this));
            }
            Q q = bVar.b;
            return q != null ? Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.unbind.j(q), new s(this)) : Out.INSTANCE.skip(lVar, this.c);
        }
        if (state instanceof ru.yoomoney.sdk.kassa.payments.unbind.j) {
            ru.yoomoney.sdk.kassa.payments.unbind.j jVar = (ru.yoomoney.sdk.kassa.payments.unbind.j) state;
            return action instanceof ru.yoomoney.sdk.kassa.payments.unbind.c ? Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.unbind.m(jVar.a), new v(this)) : Out.INSTANCE.skip(jVar, this.c);
        }
        if (!(state instanceof ru.yoomoney.sdk.kassa.payments.unbind.m)) {
            return Out.INSTANCE.skip(state, this.c);
        }
        ru.yoomoney.sdk.kassa.payments.unbind.m mVar = (ru.yoomoney.sdk.kassa.payments.unbind.m) state;
        if (action instanceof ru.yoomoney.sdk.kassa.payments.unbind.c) {
            return Out.INSTANCE.invoke(new ru.yoomoney.sdk.kassa.payments.unbind.m(mVar.a), new k(this));
        }
        if (action instanceof ru.yoomoney.sdk.kassa.payments.unbind.e) {
            companion = Out.INSTANCE;
            oVar = new m(this);
        } else {
            if (!(action instanceof ru.yoomoney.sdk.kassa.payments.unbind.d)) {
                return Out.INSTANCE.skip(mVar, this.c);
            }
            companion = Out.INSTANCE;
            oVar = new o(this);
        }
        return companion.invoke(mVar, oVar);
    }
}
