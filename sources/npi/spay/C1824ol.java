package npi.spay;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: npi.spay.ol, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1824ol extends AbstractC1489ba {
    public final C1951u a;
    public final Ih b;

    public C1824ol(C1951u lazyNetworkModule, Ih sPayDataContract) {
        Intrinsics.checkNotNullParameter(lazyNetworkModule, "lazyNetworkModule");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        this.a = lazyNetworkModule;
        this.b = sPayDataContract;
    }

    @Override // npi.spay.AbstractC1489ba
    public final /* bridge */ /* synthetic */ Object a(Object obj, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        return a((C1551dm) obj, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0072 -> B:24:0x0075). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(npi.spay.C1551dm r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof npi.spay.Mk
            if (r0 == 0) goto L13
            r0 = r10
            npi.spay.Mk r0 = (npi.spay.Mk) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            npi.spay.Mk r0 = new npi.spay.Mk
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.g
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.String r9 = r0.d
            java.util.Iterator r2 = r0.c
            java.util.Map r5 = r0.b
            npi.spay.ol r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L75
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            java.util.List r9 = r9.a
            java.util.Iterator r9 = r9.iterator()
            r6 = r8
            r2 = r9
            r5 = r10
        L4b:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L97
            java.lang.Object r9 = r2.next()
            java.lang.String r9 = (java.lang.String) r9
            npi.spay.u r10 = r6.a
            npi.spay.x3 r10 = r10.e
            if (r10 == 0) goto L5e
            goto L64
        L5e:
            java.lang.String r10 = "pageTitleApi"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = r3
        L64:
            r0.a = r6
            r0.b = r5
            r0.c = r2
            r0.d = r9
            r0.g = r4
            java.lang.Object r10 = r10.a(r9, r0)
            if (r10 != r1) goto L75
            return r1
        L75:
            retrofit2.Response r10 = (retrofit2.Response) r10
            boolean r7 = r10.isSuccessful()
            if (r7 == 0) goto L4b
            java.lang.Object r10 = r10.body()
            npi.spay.Hg r10 = (npi.spay.Hg) r10
            if (r10 == 0) goto L8e
            org.jsoup.nodes.Document r10 = r10.a
            if (r10 == 0) goto L8e
            java.lang.String r10 = r10.title()
            goto L8f
        L8e:
            r10 = r3
        L8f:
            if (r10 != 0) goto L93
            java.lang.String r10 = ""
        L93:
            r5.put(r9, r10)
            goto L4b
        L97:
            npi.spay.Ih r9 = r6.b
            npi.spay.Di r9 = (npi.spay.Di) r9
            r9.getClass()
            java.lang.String r10 = "linksWithTitles"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r10)
            kotlinx.coroutines.flow.MutableStateFlow r9 = r9.l
            r9.setValue(r5)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1824ol.a(npi.spay.dm, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
