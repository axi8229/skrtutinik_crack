package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class s implements Function2 {
    public final Function2 a;
    public final Function2 b;
    public final Function1 c;
    public final I d;

    public s(Function2 showState, Function2 showEffect, Function1 source, I tokenizeUseCase) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(tokenizeUseCase, "tokenizeUseCase");
        this.a = showState;
        this.b = showEffect;
        this.c = source;
        this.d = tokenizeUseCase;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Out.Companion companion;
        Function mVar;
        Out.Companion companion2;
        Function c2534k;
        H state = (H) obj;
        z action = (z) obj2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof E) {
            return action instanceof w ? Out.INSTANCE.invoke(new F(((w) action).a), new C2527d(this)) : Out.INSTANCE.skip((E) state, this.c);
        }
        if (!(state instanceof F)) {
            if (state instanceof G) {
                return action instanceof w ? Out.INSTANCE.invoke(new F(((w) action).a), new r(this)) : Out.INSTANCE.skip((G) state, this.c);
            }
            throw new NoWhenBranchMatchedException();
        }
        F f = (F) state;
        if (!(action instanceof u)) {
            if (action instanceof v) {
                companion2 = Out.INSTANCE;
                c2534k = new C2531h(this);
            } else if (action instanceof t) {
                companion2 = Out.INSTANCE;
                c2534k = new C2534k(this);
            } else {
                if (!(action instanceof y)) {
                    return action instanceof x ? Out.INSTANCE.invoke(new G(f.a, ((x) action).a), new o(this)) : Out.INSTANCE.skip(f, this.c);
                }
                companion = Out.INSTANCE;
                mVar = new m(this, action);
            }
            return companion2.invoke(f, c2534k);
        }
        companion = Out.INSTANCE;
        mVar = new C2529f(this, action);
        return companion.invoke(f, mVar);
    }
}
