package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import spay.sdk.RedirectActivity;

/* renamed from: npi.spay.m5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1758m5 extends SuspendLambda implements Function2 {
    public int a;
    public final /* synthetic */ RedirectActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1758m5(RedirectActivity redirectActivity, Continuation continuation) {
        super(2, continuation);
        this.b = redirectActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new C1758m5(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new C1758m5(this.b, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.a
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1f
            if (r1 == r4) goto L1b
            if (r1 != r3) goto L13
            kotlin.ResultKt.throwOnFailure(r7)
            goto L47
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1b:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L2d
        L1f:
            kotlin.ResultKt.throwOnFailure(r7)
            r6.a = r4
            r4 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r6)
            if (r7 != r0) goto L2d
            return r0
        L2d:
            spay.sdk.RedirectActivity r7 = r6.b
            npi.spay.W0 r7 = r7.c
            if (r7 == 0) goto L34
            goto L3a
        L34:
            java.lang.String r7 = "bankAuthenticator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r7 = r2
        L3a:
            spay.sdk.RedirectActivity r1 = r6.b
            npi.spay.Ph r4 = npi.spay.Ph.INITIAL_AUTH
            r6.a = r3
            java.lang.Object r7 = r7.a(r1, r4, r6)
            if (r7 != r0) goto L47
            return r0
        L47:
            npi.spay.ql r7 = (npi.spay.C1874ql) r7
            spay.sdk.RedirectActivity r0 = r6.b
            spay.sdk.a r0 = r0.b
            if (r0 != 0) goto L56
            java.lang.String r0 = "viewModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L57
        L56:
            r2 = r0
        L57:
            r2.getClass()
            java.lang.String r0 = "bankAuthResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r7.c
            if (r0 == 0) goto L74
            npi.spay.bg r0 = r2.m
            npi.spay.An r1 = new npi.spay.An
            java.lang.Object r7 = r7.a
            sberid.sdk.auth.model.SberIDResultModel r7 = (sberid.sdk.auth.model.SberIDResultModel) r7
            r1.<init>(r7)
            npi.spay.Jh r0 = (npi.spay.Jh) r0
            r0.a(r1)
            goto L87
        L74:
            npi.spay.bg r7 = r2.m
            npi.spay.On r0 = new npi.spay.On
            npi.spay.W6 r1 = new npi.spay.W6
            spay.sdk.domain.model.response.ErrorEntity$Unknown r2 = spay.sdk.domain.model.response.ErrorEntity.Unknown.INSTANCE
            r1.<init>(r2)
            r0.<init>(r1)
            npi.spay.Jh r7 = (npi.spay.Jh) r7
            r7.a(r0)
        L87:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1758m5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
