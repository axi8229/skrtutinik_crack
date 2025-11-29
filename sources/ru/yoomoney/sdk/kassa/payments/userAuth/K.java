package ru.yoomoney.sdk.kassa.payments.userAuth;

import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.F1;
import ru.yoomoney.sdk.march.Out;

/* loaded from: classes5.dex */
public final class K implements Function2 {
    public final Function2 a;
    public final Function1 b;
    public final ru.yoomoney.sdk.kassa.payments.tmx.a c;
    public final ru.yoomoney.sdk.kassa.payments.payment.b d;
    public final U e;
    public final F1 f;
    public final InterfaceC2538a g;
    public final PaymentParameters h;
    public final ru.yoomoney.sdk.kassa.payments.payment.c i;

    public K(Function2 showState, Function1 source, ru.yoomoney.sdk.kassa.payments.tmx.a profilingSessionIdStorage, ru.yoomoney.sdk.kassa.payments.payment.b currentUserRepository, ru.yoomoney.sdk.kassa.payments.secure.j userAuthInfoRepository, F1 paymentOptionsListUseCase, InterfaceC2538a getTransferDataUseCase, PaymentParameters paymentParameters, ru.yoomoney.sdk.kassa.payments.payment.c loadedPaymentOptionListRepository) {
        Intrinsics.checkNotNullParameter(showState, "showState");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(profilingSessionIdStorage, "profilingSessionIdStorage");
        Intrinsics.checkNotNullParameter(currentUserRepository, "currentUserRepository");
        Intrinsics.checkNotNullParameter(userAuthInfoRepository, "userAuthInfoRepository");
        Intrinsics.checkNotNullParameter(paymentOptionsListUseCase, "paymentOptionsListUseCase");
        Intrinsics.checkNotNullParameter(getTransferDataUseCase, "getTransferDataUseCase");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(loadedPaymentOptionListRepository, "loadedPaymentOptionListRepository");
        this.a = showState;
        this.b = source;
        this.c = profilingSessionIdStorage;
        this.d = currentUserRepository;
        this.e = userAuthInfoRepository;
        this.f = paymentOptionsListUseCase;
        this.g = getTransferDataUseCase;
        this.h = paymentParameters;
        this.i = loadedPaymentOptionListRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.userAuth.K r6, ru.yoomoney.sdk.kassa.payments.userAuth.C2543f r7, kotlin.coroutines.Continuation r8) {
        /*
            r6.getClass()
            boolean r0 = r8 instanceof ru.yoomoney.sdk.kassa.payments.userAuth.C2555s
            if (r0 == 0) goto L16
            r0 = r8
            ru.yoomoney.sdk.kassa.payments.userAuth.s r0 = (ru.yoomoney.sdk.kassa.payments.userAuth.C2555s) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.c = r1
            goto L1b
        L16:
            ru.yoomoney.sdk.kassa.payments.userAuth.s r0 = new ru.yoomoney.sdk.kassa.payments.userAuth.s
            r0.<init>(r6, r8)
        L1b:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto Lc7
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            ru.yoomoney.sdk.kassa.payments.userAuth.U r8 = r6.e
            java.lang.String r2 = r7.a
            ru.yoomoney.sdk.kassa.payments.secure.j r8 = (ru.yoomoney.sdk.kassa.payments.secure.j) r8
            android.content.SharedPreferences r4 = r8.a
            r5 = 0
            if (r2 == 0) goto L4c
            kotlin.jvm.functions.Function1 r8 = r8.b
            java.lang.Object r8 = r8.invoke(r2)
            java.lang.String r8 = (java.lang.String) r8
            goto L4d
        L4c:
            r8 = r5
        L4d:
            java.lang.String r2 = "yooUserAuthToken"
            ru.yoomoney.sdk.kassa.payments.extensions.k.a(r4, r2, r8)
            ru.yoomoney.sdk.kassa.payments.userAuth.U r8 = r6.e
            ru.yoomoney.sdk.auth.api.account.model.UserAccount r2 = r7.b
            if (r2 == 0) goto L5d
            java.lang.String r2 = r2.getUid()
            goto L5e
        L5d:
            r2 = r5
        L5e:
            ru.yoomoney.sdk.kassa.payments.secure.j r8 = (ru.yoomoney.sdk.kassa.payments.secure.j) r8
            android.content.SharedPreferences r8 = r8.a
            java.lang.String r4 = "yooUserUID"
            ru.yoomoney.sdk.kassa.payments.extensions.k.a(r8, r4, r2)
            ru.yoomoney.sdk.kassa.payments.userAuth.U r8 = r6.e
            ru.yoomoney.sdk.auth.api.account.model.UserAccount r2 = r7.b
            if (r2 == 0) goto L78
            ru.yoomoney.sdk.auth.api.account.model.DisplayNameInfo r2 = r2.getDisplayName()
            if (r2 == 0) goto L78
            java.lang.String r2 = r2.getTitle()
            goto L79
        L78:
            r2 = r5
        L79:
            ru.yoomoney.sdk.kassa.payments.secure.j r8 = (ru.yoomoney.sdk.kassa.payments.secure.j) r8
            android.content.SharedPreferences r8 = r8.a
            java.lang.String r4 = "yooUserAuthName"
            ru.yoomoney.sdk.kassa.payments.extensions.k.a(r8, r4, r2)
            ru.yoomoney.sdk.kassa.payments.userAuth.U r8 = r6.e
            ru.yoomoney.sdk.auth.api.account.model.UserAccount r2 = r7.b
            if (r2 == 0) goto L93
            ru.yoomoney.sdk.auth.api.account.model.AvatarInfo r2 = r2.getAvatar()
            if (r2 == 0) goto L93
            java.lang.String r2 = r2.getUrl()
            goto L94
        L93:
            r2 = r5
        L94:
            ru.yoomoney.sdk.kassa.payments.secure.j r8 = (ru.yoomoney.sdk.kassa.payments.secure.j) r8
            android.content.SharedPreferences r8 = r8.a
            java.lang.String r4 = "yooUserAvatarUrl"
            ru.yoomoney.sdk.kassa.payments.extensions.k.a(r8, r4, r2)
            ru.yoomoney.sdk.kassa.payments.payment.b r8 = r6.d
            ru.yoomoney.sdk.kassa.payments.model.o r2 = new ru.yoomoney.sdk.kassa.payments.model.o
            r2.<init>()
            r8.a(r2)
            ru.yoomoney.sdk.kassa.payments.tmx.a r8 = r6.c
            java.lang.String r7 = r7.c
            r8.a = r7
            ru.yoomoney.sdk.kassa.payments.payment.c r7 = r6.i
            r8 = 0
            ru.yoomoney.sdk.kassa.payments.payment.d r7 = (ru.yoomoney.sdk.kassa.payments.payment.d) r7
            r7.a = r8
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.F1 r7 = r6.f
            ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters r6 = r6.h
            ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r6 = r6.getAmount()
            r0.c = r3
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.I1 r7 = (ru.yoomoney.sdk.kassa.payments.paymentOptionList.I1) r7
            java.lang.Object r6 = r7.a(r6, r5, r0)
            if (r6 != r1) goto Lc7
            goto Lc9
        Lc7:
            ru.yoomoney.sdk.kassa.payments.userAuth.e r1 = ru.yoomoney.sdk.kassa.payments.userAuth.C2542e.a
        Lc9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.userAuth.K.a(ru.yoomoney.sdk.kassa.payments.userAuth.K, ru.yoomoney.sdk.kassa.payments.userAuth.f, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Out.Companion companion;
        AbstractC2554q abstractC2554q;
        Function b;
        AbstractC2554q state = (AbstractC2554q) obj;
        AbstractC2546i action = (AbstractC2546i) obj2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (state instanceof C2550m) {
            if (action instanceof C2545h) {
                return Out.INSTANCE.invoke(state, new C2557u(this));
            }
            if (action instanceof C2543f) {
                if (((C2543f) action).a != null) {
                    return Out.INSTANCE.invoke(C2552o.a, new w(this, action));
                }
                companion = Out.INSTANCE;
                abstractC2554q = C2551n.a;
                b = new z(this);
            } else if (action instanceof C2540c) {
                companion = Out.INSTANCE;
                abstractC2554q = C2553p.a;
                b = new B(this);
            } else if (action instanceof C2544g) {
                return Out.INSTANCE.invoke(state, new D(this, action));
            }
            return companion.invoke(abstractC2554q, b);
        }
        if (Intrinsics.areEqual(state, C2552o.a)) {
            if (action instanceof C2545h) {
                return Out.INSTANCE.invoke(new C2550m(((C2545h) action).a ? C2547j.a : C2548k.a), new F(this));
            }
        } else {
            if (Intrinsics.areEqual(state, C2551n.a)) {
                return Out.INSTANCE.invoke(C2553p.a, new H(this));
            }
            if (!Intrinsics.areEqual(state, C2553p.a)) {
                throw new NoWhenBranchMatchedException();
            }
            if (action instanceof C2545h) {
                return Out.INSTANCE.invoke(new C2550m(((C2545h) action).a ? C2547j.a : C2548k.a), new J(this));
            }
        }
        return Out.INSTANCE.skip(state, this.b);
    }
}
