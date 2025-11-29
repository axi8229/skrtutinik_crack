package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j0 implements d0 {
    public final Context a;
    public final k0 b;
    public boolean c;

    public j0(Context context, k0 bankListRepository) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bankListRepository, "bankListRepository");
        this.a = context;
        this.b = bankListRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.f0
            if (r0 == 0) goto L13
            r0 = r9
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.f0 r0 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.f0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.f0 r0 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.f0
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4e
            if (r2 == r5) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb4
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            java.lang.String r8 = r0.b
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0 r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r9)
            goto La6
        L40:
            java.lang.String r8 = r0.b
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0 r2 = r0.a
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r9 = r9.getValue()
            goto L63
        L4e:
            kotlin.ResultKt.throwOnFailure(r9)
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.k0 r9 = r7.b
            r0.a = r7
            r0.b = r8
            r0.e = r5
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.p0 r9 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.p0) r9
            java.lang.Object r9 = r9.a(r8, r0)
            if (r9 != r1) goto L62
            return r1
        L62:
            r2 = r7
        L63:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r9)
            if (r6 != 0) goto L7d
            ru.yoomoney.sdk.kassa.payments.model.N r9 = (ru.yoomoney.sdk.kassa.payments.model.N) r9
            ru.yoomoney.sdk.kassa.payments.model.t0 r8 = r9.c
            int[] r9 = ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.e0.a
            int r8 = r8.ordinal()
            r8 = r9[r8]
            if (r8 != r5) goto L7a
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.j r8 = ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.j.a
            goto L7c
        L7a:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.k r8 = ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.k.a
        L7c:
            return r8
        L7d:
            boolean r9 = r6 instanceof ru.yoomoney.sdk.kassa.payments.model.C2319c
            if (r9 == 0) goto Lbf
            r9 = r6
            ru.yoomoney.sdk.kassa.payments.model.c r9 = (ru.yoomoney.sdk.kassa.payments.model.C2319c) r9
            ru.yoomoney.sdk.kassa.payments.model.v r5 = r9.a()
            java.lang.Integer r5 = r5.e
            if (r5 == 0) goto Lbf
            ru.yoomoney.sdk.kassa.payments.model.v r9 = r9.a()
            java.lang.Integer r9 = r9.e
            if (r9 == 0) goto Lb7
            int r9 = r9.intValue()
            long r5 = (long) r9
            r0.a = r2
            r0.b = r8
            r0.e = r4
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r9 != r1) goto La6
            return r1
        La6:
            r9 = 0
            r0.a = r9
            r0.b = r9
            r0.e = r3
            java.lang.Object r9 = r2.a(r8, r0)
            if (r9 != r1) goto Lb4
            return r1
        Lb4:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.o r9 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.o) r9
            goto Lc4
        Lb7:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Required value was null."
            r8.<init>(r9)
            throw r8
        Lbf:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.l r9 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.l
            r9.<init>(r6)
        Lc4:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.util.List r11, kotlin.coroutines.Continuation r12) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r10 = this;
            boolean r0 = r12 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.h0
            if (r0 == 0) goto L13
            r0 = r12
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.h0 r0 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.h0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.h0 r0 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.h0
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.util.List r11 = r0.b
            java.util.List r11 = (java.util.List) r11
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0 r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.Result r12 = (kotlin.Result) r12
            java.lang.Object r12 = r12.getValue()
            goto L57
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3d:
            kotlin.ResultKt.throwOnFailure(r12)
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.k0 r12 = r10.b
            android.content.Context r2 = r10.a
            r0.a = r10
            r4 = r11
            java.util.List r4 = (java.util.List) r4
            r0.b = r4
            r0.e = r3
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.p0 r12 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.p0) r12
            java.lang.Object r12 = r12.a(r2, r0)
            if (r12 != r1) goto L56
            return r1
        L56:
            r0 = r10
        L57:
            boolean r1 = kotlin.Result.m2633isFailureimpl(r12)
            r2 = 0
            if (r1 == 0) goto L5f
            r12 = r2
        L5f:
            java.util.List r12 = (java.util.List) r12
            if (r12 != 0) goto L67
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
        L67:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r11 = r11.iterator()
        L72:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto Lbf
            java.lang.Object r3 = r11.next()
            r4 = r3
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.a r4 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.a) r4
            r5 = r12
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L86:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto Lb8
            java.lang.Object r6 = r5.next()
            r7 = r6
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.PrioritySbpBank r7 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.PrioritySbpBank) r7
            java.lang.String r8 = r7.getMemberId()
            java.lang.String r9 = r4.a
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r9)
            if (r8 == 0) goto L86
            android.content.Context r8 = r0.a
            java.lang.String r7 = r7.getPackageName()
            java.lang.String r9 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r9)
            java.lang.String r9 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r9)
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L86
            r9 = 0
            r8.getPackageInfo(r7, r9)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L86
            goto Lb9
        Lb8:
            r6 = r2
        Lb9:
            if (r6 == 0) goto L72
            r1.add(r3)
            goto L72
        Lbf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0.b(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r7, kotlin.coroutines.Continuation r8) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.i0
            if (r0 == 0) goto L13
            r0 = r8
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.i0 r0 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.i0) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.i0 r0 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.i0
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r7 = r0.a
            java.util.List r7 = (java.util.List) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6f
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            java.lang.Object r7 = r0.a
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0 r7 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0) r7
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r8 = r8.getValue()
            goto L59
        L46:
            kotlin.ResultKt.throwOnFailure(r8)
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.k0 r8 = r6.b
            r0.a = r6
            r0.d = r4
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.p0 r8 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.p0) r8
            java.lang.Object r8 = r8.b(r7, r0)
            if (r8 != r1) goto L58
            return r1
        L58:
            r7 = r6
        L59:
            java.lang.Throwable r2 = kotlin.Result.m2631exceptionOrNullimpl(r8)
            if (r2 != 0) goto L83
            java.util.List r8 = (java.util.List) r8
            r0.a = r8
            r0.d = r3
            java.lang.Object r7 = r7.b(r8, r0)
            if (r7 != r1) goto L6c
            return r1
        L6c:
            r5 = r8
            r8 = r7
            r7 = r5
        L6f:
            java.util.List r8 = (java.util.List) r8
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L7d
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.f r0 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.f
            r0.<init>(r7, r8)
            goto L82
        L7d:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.i r0 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.i
            r0.<init>(r8, r7)
        L82:
            return r0
        L83:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.e r7 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.e
            r7.<init>(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0.b(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.util.List r5, kotlin.coroutines.Continuation r6) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.g0
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.g0 r0 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.g0) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.g0 r0 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.g0
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.util.List r5 = r0.a
            java.util.List r5 = (java.util.List) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            java.util.List r6 = (java.util.List) r6
            r0.a = r6
            r0.d = r3
            java.lang.Object r6 = r4.b(r5, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            java.util.List r6 = (java.util.List) r6
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.i r0 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.i
            r0.<init>(r6, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0.a(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
