package npi.spay;

import android.content.Intent;
import android.net.Uri;
import androidx.lifecycle.ViewModelKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import spay.sdk.domain.model.FraudMonInfo;

/* renamed from: npi.spay.kh, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1720kh extends AbstractC1810o7 {
    public final InterfaceC1495bg e;
    public final W1 f;
    public final MutableStateFlow g;
    public String h;
    public final MutableStateFlow i;
    public final MutableStateFlow j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1720kh(C1955u3 metricFacade, Ih sPayDataContract, Gk clearSdkUtil, InterfaceC1495bg sPaySdkReducer, Ei sPayStorage) {
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
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.i = MutableStateFlow;
        this.j = MutableStateFlow;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C1670ih(this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof npi.spay.C1695jh
            if (r0 == 0) goto L13
            r0 = r14
            npi.spay.jh r0 = (npi.spay.C1695jh) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            npi.spay.jh r0 = new npi.spay.jh
            r0.<init>(r13, r14)
        L18:
            java.lang.Object r14 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r14)
            goto L91
        L2a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L32:
            kotlin.ResultKt.throwOnFailure(r14)
            npi.spay.W1 r14 = r13.f
            npi.spay.M8 r14 = r14.a
            spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult r14 = r14.a()
            if (r14 == 0) goto L91
            spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult$FormParameters r14 = r14.getFormParameters()
            if (r14 == 0) goto L91
            java.lang.String r2 = r14.getCybercabinetUrlAndroid()
            r13.h = r2
            kotlinx.coroutines.flow.MutableStateFlow r2 = r13.g
            npi.spay.Sj r12 = new npi.spay.Sj
            java.lang.String r4 = r14.getHeader()
            java.lang.String r5 = ""
            if (r4 != 0) goto L59
            r6 = r5
            goto L5a
        L59:
            r6 = r4
        L5a:
            java.lang.String r4 = r14.getText()
            if (r4 != 0) goto L62
            r7 = r5
            goto L63
        L62:
            r7 = r4
        L63:
            java.lang.String r4 = r14.getButtonConfirmText()
            if (r4 != 0) goto L6b
            r8 = r5
            goto L6c
        L6b:
            r8 = r4
        L6c:
            java.lang.String r4 = r14.getButtonDeclineText()
            if (r4 != 0) goto L74
            r9 = r5
            goto L75
        L74:
            r9 = r4
        L75:
            java.lang.String r14 = r14.getButtonInformText()
            if (r14 != 0) goto L7d
            r10 = r5
            goto L7e
        L7d:
            r10 = r14
        L7e:
            r11 = 196(0xc4, float:2.75E-43)
            r14 = 0
            r4 = r12
            r5 = r6
            r6 = r7
            r7 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r0.c = r3
            java.lang.Object r14 = r2.emit(r12, r0)
            if (r14 != r1) goto L91
            return r1
        L91:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.C1720kh.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(D9 fraudMonReviewEvent) {
        C1955u3 c1955u3;
        C1560e6 c1560e6;
        Intrinsics.checkNotNullParameter(fraudMonReviewEvent, "fraudMonReviewEvent");
        Ve ve = (Ve) fraudMonReviewEvent;
        if (Intrinsics.areEqual(ve, Qe.a)) {
            Ih ih = this.b;
            FraudMonInfo fraudMonInfo = new FraudMonInfo(FraudMonInfo.CONFIRMED_GENUINE);
            Di di = (Di) ih;
            di.getClass();
            Intrinsics.checkNotNullParameter(fraudMonInfo, "fraudMonInfo");
            di.q = fraudMonInfo;
            ((Jh) this.e).a(new Vn(Boolean.FALSE, null, null));
            this.a.a(new C1560e6(P9.TOUCH_CONFIRM_OPERATION_BUTTON, EnumC1877r0.REVIEW_HINT_VIEW, C0.TOUCH, null, null, null, null, 120));
            return;
        }
        if (Intrinsics.areEqual(ve, Re.a)) {
            Ih ih2 = this.b;
            FraudMonInfo fraudMonInfo2 = new FraudMonInfo("UNKNOWN");
            Di di2 = (Di) ih2;
            di2.getClass();
            Intrinsics.checkNotNullParameter(fraudMonInfo2, "fraudMonInfo");
            di2.q = fraudMonInfo2;
            ((Jh) this.e).a(Sn.a);
            this.a.a(new C1560e6(P9.TOUCH_CANCEL_BUTTON, EnumC1877r0.REVIEW_HINT_VIEW, C0.TOUCH, null, null, null, null, 120));
            return;
        }
        if (Intrinsics.areEqual(ve, Se.a)) {
            Ih ih3 = this.b;
            FraudMonInfo fraudMonInfo3 = new FraudMonInfo(FraudMonInfo.CONFIRMED_FRAUD);
            Di di3 = (Di) ih3;
            di3.getClass();
            Intrinsics.checkNotNullParameter(fraudMonInfo3, "fraudMonInfo");
            di3.q = fraudMonInfo3;
            ((Jh) this.e).a(Sn.a);
            this.i.setValue(new Intent("android.intent.action.VIEW", Uri.parse(this.h)));
            c1955u3 = this.a;
            c1560e6 = new C1560e6(P9.TOUCH_HYPERLINK, EnumC1877r0.REVIEW_HINT_VIEW, C0.TOUCH, null, null, null, null, 120);
        } else if (Intrinsics.areEqual(ve, Te.a)) {
            c1955u3 = this.a;
            c1560e6 = new C1560e6(P9.LC_REVIEW_HINT_VIEW_APPEARED, EnumC1877r0.REVIEW_HINT_VIEW, C0.LCStart, null, null, null, null, 120);
        } else {
            if (!Intrinsics.areEqual(ve, Ue.a)) {
                return;
            }
            c1955u3 = this.a;
            c1560e6 = new C1560e6(P9.LC_REVIEW_HINT_VIEW_DISAPPEARED, EnumC1877r0.REVIEW_HINT_VIEW, C0.LCEnd, null, null, null, null, 120);
        }
        c1955u3.a(c1560e6);
    }
}
