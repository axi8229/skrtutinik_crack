package npi.spay;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.AuthResponseBody;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.ErrorEntity;

/* loaded from: classes4.dex */
public final class Zk {
    public final InterfaceC2073yl a;

    public Zk(InterfaceC2073yl sPayRepository) {
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        this.a = sPayRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(spay.sdk.domain.model.request.AuthWithPurchaseRequestBody r6, spay.sdk.domain.model.request.AuthWithOrderIdRequestBody r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof npi.spay.Yk
            if (r0 == 0) goto L13
            r0 = r9
            npi.spay.Yk r0 = (npi.spay.Yk) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            npi.spay.Yk r0 = new npi.spay.Yk
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 == r4) goto L31
            if (r2 != r3) goto L29
            goto L31
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            npi.spay.Zk r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5e
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            if (r7 == 0) goto L4d
            npi.spay.yl r6 = r5.a
            r0.a = r5
            r0.d = r4
            npi.spay.Hm r6 = (npi.spay.Hm) r6
            java.lang.Object r9 = r6.a(r8, r7, r0)
            if (r9 != r1) goto L4b
            return r1
        L4b:
            r6 = r5
            goto L5e
        L4d:
            if (r6 == 0) goto L68
            npi.spay.yl r7 = r5.a
            r0.a = r5
            r0.d = r3
            npi.spay.Hm r7 = (npi.spay.Hm) r7
            java.lang.Object r9 = r7.a(r8, r6, r0)
            if (r9 != r1) goto L4b
            return r1
        L5e:
            spay.sdk.domain.model.response.ContentResponse r9 = (spay.sdk.domain.model.response.ContentResponse) r9
            r6.getClass()
            npi.spay.q2 r6 = a(r9)
            goto L7a
        L68:
            timber.log.Timber$Forest r6 = timber.log.Timber.INSTANCE
            r7 = 0
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r8 = "something wrong with request params"
            r6.e(r8, r7)
            npi.spay.S1 r6 = new npi.spay.S1
            java.lang.String r7 = "Некорректный формат запроса или ответа"
            r6.<init>(r7)
        L7a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.Zk.a(spay.sdk.domain.model.request.AuthWithPurchaseRequestBody, spay.sdk.domain.model.request.AuthWithOrderIdRequestBody, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static AbstractC1855q2 a(ContentResponse contentResponse) {
        if (contentResponse instanceof ContentResponse.Failure) {
            ContentResponse.Failure failure = (ContentResponse.Failure) contentResponse;
            ErrorEntity error = failure.getError();
            return error instanceof ErrorEntity.ApiError ? new K1(failure.getError()) : Intrinsics.areEqual(error, ErrorEntity.TimeOut.INSTANCE) ? new V1() : Intrinsics.areEqual(error, ErrorEntity.Unknown.INSTANCE) ? new S1("Системная или внутренняя ошибка") : new S1("Некорректный формат запроса или ответа");
        }
        if (!(contentResponse instanceof ContentResponse.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        Object data = ((ContentResponse.Success) contentResponse).getData();
        Intrinsics.checkNotNull(data);
        return new F1((AuthResponseBody) data);
    }
}
