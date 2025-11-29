package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class H0 implements Function2 {
    public final Function2 a;
    public final Function2 b;
    public final Function1 c;
    public final H1 d;
    public final E1 e;

    public H0(Function2 showState, Function2 showEffect, Function1 source, H1 requestPaymentAuthUseCase, E1 processPaymentAuthUseCase) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(showEffect, "showEffect");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(requestPaymentAuthUseCase, "requestPaymentAuthUseCase");
        Intrinsics.checkNotNullParameter(processPaymentAuthUseCase, "processPaymentAuthUseCase");
        this.a = showState;
        this.b = showEffect;
        this.c = source;
        this.d = requestPaymentAuthUseCase;
        this.e = processPaymentAuthUseCase;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        O state = (O) obj;
        E action = (E) obj2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof K) {
            K k = (K) state;
            return action instanceof B ? Out.INSTANCE.invoke(k, new C2429l0(this, action)) : action instanceof D ? Out.INSTANCE.invoke(new H(((D) action).a), new C2435n0(this)) : action instanceof C ? Out.INSTANCE.invoke(new M(((C) action).a), new C2439p0(this)) : action instanceof C2449v ? Out.INSTANCE.invoke(k, new C2442r0(this, action)) : action instanceof C2455y ? Out.INSTANCE.invoke(k, new C2446t0(this)) : action instanceof C2447u ? Out.INSTANCE.invoke(new M(((C2447u) action).a), new C2450v0(this)) : Out.INSTANCE.skip(k, this.c);
        }
        if (state instanceof M) {
            return action instanceof B ? Out.INSTANCE.invoke(K.a, new A0(this, action)) : Out.INSTANCE.skip((M) state, this.c);
        }
        if (state instanceof H) {
            H h = (H) state;
            return action instanceof C2451w ? Out.INSTANCE.invoke(new I(((C2451w) action).a, h.a), new T(this, action)) : action instanceof B ? Out.INSTANCE.invoke(K.a, new W(this, action)) : Out.INSTANCE.skip(h, this.c);
        }
        if (state instanceof I) {
            I i = (I) state;
            if (!(action instanceof A)) {
                return action instanceof C2455y ? Out.INSTANCE.invoke(i, new C2396a0(this)) : action instanceof C2447u ? Out.INSTANCE.invoke(new L(i.b, ((C2447u) action).a), new C2402c0(this)) : action instanceof C2457z ? Out.INSTANCE.invoke(new J(i.a, i.b), new C2408e0(this)) : action instanceof C2453x ? Out.INSTANCE.invoke(new M(((C2453x) action).a), new C2414g0(this)) : Out.INSTANCE.skip(i, this.c);
            }
            Out.Companion companion = Out.INSTANCE;
            C2326j c2326j = ((A) action).a;
            return companion.invoke(new N(c2326j, c2326j.c, c2326j.d), new Y(this));
        }
        if (state instanceof N) {
            N n = (N) state;
            return action instanceof C2451w ? Out.INSTANCE.invoke(new I(((C2451w) action).a, n.a), new D0(this, action)) : action instanceof B ? Out.INSTANCE.invoke(K.a, new G0(this, action)) : Out.INSTANCE.skip(n, this.c);
        }
        if (state instanceof J) {
            return action instanceof B ? Out.INSTANCE.invoke(K.a, new C2423j0(this, action)) : Out.INSTANCE.skip((J) state, this.c);
        }
        if (state instanceof L) {
            return action instanceof D ? Out.INSTANCE.invoke(new H(((D) action).a), new C2454x0(this)) : Out.INSTANCE.skip((L) state, this.c);
        }
        throw new NoWhenBranchMatchedException();
    }
}
