package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Qi implements InterfaceC1846pi {
    public final InterfaceC1713ka a;

    public Qi(C1876qn resourceManager, InterfaceC1713ka commonRepository) {
        Intrinsics.checkNotNullParameter(resourceManager, "resourceManager");
        Intrinsics.checkNotNullParameter(commonRepository, "commonRepository");
        this.a = commonRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof npi.spay.Pi
            if (r0 == 0) goto L13
            r0 = r5
            npi.spay.Pi r0 = (npi.spay.Pi) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            npi.spay.Pi r0 = new npi.spay.Pi
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            npi.spay.ka r5 = r4.a
            r0.c = r3
            npi.spay.Db r5 = (npi.spay.Db) r5
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            spay.sdk.domain.model.response.ContentResponse r5 = (spay.sdk.domain.model.response.ContentResponse) r5
            boolean r0 = r5 instanceof spay.sdk.domain.model.response.ContentResponse.Success
            if (r0 == 0) goto L50
            spay.sdk.domain.model.response.ContentResponse$Success r5 = (spay.sdk.domain.model.response.ContentResponse.Success) r5
            java.lang.Object r5 = r5.getData()
            spay.sdk.domain.model.response.SPaySdkConfig r5 = (spay.sdk.domain.model.response.SPaySdkConfig) r5
            goto L55
        L50:
            boolean r5 = r5 instanceof spay.sdk.domain.model.response.ContentResponse.Failure
            if (r5 == 0) goto L6c
            r5 = 0
        L55:
            timber.log.Timber$Forest r0 = timber.log.Timber.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "CONFIG_FROM_API : "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.i(r1, r2)
            return r5
        L6c:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Qi.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
