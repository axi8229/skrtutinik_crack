package npi.spay;

import androidx.lifecycle.ViewModelKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* renamed from: npi.spay.h3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1632h3 extends AbstractC1810o7 {
    public final InterfaceC1495bg e;
    public final W1 f;
    public final MutableStateFlow g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1632h3(C1955u3 metricFacade, Ih sPayDataContract, Gk clearSdkUtil, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage) {
        super(metricFacade, sPayDataContract, clearSdkUtil, sPaySdkReducer);
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(clearSdkUtil, "clearSdkUtil");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        this.e = sPaySdkReducer;
        AbstractC1855q2 abstractC1855q2A = ((C1604g0) ((C1822oj) sPayStorage).a().getValue()).a();
        Intrinsics.checkNotNull(abstractC1855q2A, "null cannot be cast to non-null type spay.sdk.domain.OutcomeState.FraudMonReview");
        this.f = (W1) abstractC1855q2A;
        this.g = StateFlowKt.MutableStateFlow(null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C1582f3(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof npi.spay.C1607g3
            if (r0 == 0) goto L13
            r0 = r14
            npi.spay.g3 r0 = (npi.spay.C1607g3) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            npi.spay.g3 r0 = new npi.spay.g3
            r0.<init>(r13, r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r14)
            goto L79
        L29:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L31:
            kotlin.ResultKt.throwOnFailure(r14)
            npi.spay.W1 r14 = r13.f
            npi.spay.M8 r14 = r14.a
            spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult r14 = r14.a()
            if (r14 == 0) goto L79
            spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult$FormParameters r14 = r14.getFormParameters()
            if (r14 == 0) goto L79
            kotlinx.coroutines.flow.MutableStateFlow r2 = r13.g
            npi.spay.Sj r12 = new npi.spay.Sj
            java.lang.String r4 = r14.getHeader()
            java.lang.String r5 = ""
            if (r4 != 0) goto L52
            r6 = r5
            goto L53
        L52:
            r6 = r4
        L53:
            java.lang.String r4 = r14.getTextDecline()
            if (r4 != 0) goto L5b
            r7 = r5
            goto L5c
        L5b:
            r7 = r4
        L5c:
            java.lang.String r14 = r14.getButtonDeclineText()
            if (r14 != 0) goto L64
            r9 = r5
            goto L65
        L64:
            r9 = r14
        L65:
            r10 = 0
            r11 = 234(0xea, float:3.28E-43)
            r14 = 0
            r8 = 0
            r4 = r12
            r5 = r6
            r6 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r0.c = r3
            java.lang.Object r14 = r2.emit(r12, r0)
            if (r14 != r1) goto L79
            return r1
        L79:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1632h3.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(D9 fraudMonReviewEvent) {
        C1955u3 c1955u3;
        C1560e6 c1560e6;
        Intrinsics.checkNotNullParameter(fraudMonReviewEvent, "fraudMonReviewEvent");
        A0 a0 = (A0) fraudMonReviewEvent;
        if (Intrinsics.areEqual(a0, C2027x0.a)) {
            this.a.a(new C1560e6(Wl.TOUCH_TO_PAYMENT_METHODS_BUTTON, EnumC1877r0.DENY_VIEW, C0.TOUCH, null, null, null, null, 120));
            ((Jh) this.e).a(C1975un.a);
            return;
        }
        if (Intrinsics.areEqual(a0, C2052y0.a)) {
            c1955u3 = this.a;
            c1560e6 = new C1560e6(Wl.LC_DENY_VIEW_APPEARED, EnumC1877r0.DENY_VIEW, C0.LCStart, null, null, null, null, 120);
        } else {
            if (!Intrinsics.areEqual(a0, C2077z0.a)) {
                return;
            }
            c1955u3 = this.a;
            c1560e6 = new C1560e6(Wl.LC_DENY_VIEW_DISAPPEARED, EnumC1877r0.DENY_VIEW, C0.LCEnd, null, null, null, null, 120);
        }
        c1955u3.a(c1560e6);
    }
}
