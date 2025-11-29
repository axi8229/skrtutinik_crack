package npi.spay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.util.Consumer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import ru.yoomoney.sdk.kassa.payments.R$string;
import sberid.sdk.auth.login.SberIDLoginManager;
import sberid.sdk.auth.model.SberIDResultModel;
import spay.sdk.RedirectActivity;
import spay.sdk.data.dto.MerchantDataWithOrderId;
import spay.sdk.domain.model.FakeBankAuthData;
import spay.sdk.domain.model.response.ContentResponse;
import spay.sdk.domain.model.response.SessionIdResponseBody;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class W0 implements InterfaceC1995vi {
    public final Ih a;
    public final C1955u3 b;
    public final InterfaceC1626gm c;
    public final Qb d;
    public final SberIDLoginManager e;
    public final InterfaceC1495bg f;
    public final InterfaceC1728l0 g;

    public W0(Ih sPayDataContract, C1955u3 metricFacade, InterfaceC1626gm bankAuthenticationContract, Qb authHandler, SberIDLoginManager sberIdLoginManager, InterfaceC1495bg sPaySdkReducer, InterfaceC1728l0 sPaySdkConfigRepository) {
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(metricFacade, "metricFacade");
        Intrinsics.checkNotNullParameter(bankAuthenticationContract, "bankAuthenticationContract");
        Intrinsics.checkNotNullParameter(authHandler, "authHandler");
        Intrinsics.checkNotNullParameter(sberIdLoginManager, "sberIdLoginManager");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(sPaySdkConfigRepository, "sPaySdkConfigRepository");
        this.a = sPayDataContract;
        this.b = metricFacade;
        this.c = bankAuthenticationContract;
        this.d = authHandler;
        this.e = sberIdLoginManager;
        this.f = sPaySdkReducer;
        this.g = sPaySdkConfigRepository;
    }

    public final Consumer a(final CancellableContinuationImpl cancellableContinuationImpl, final RedirectActivity redirectActivity, final Ph ph) {
        return new Consumer() { // from class: npi.spay.W0$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                W0.a(this.f$0, redirectActivity, ph, cancellableContinuationImpl, (Intent) obj);
            }
        };
    }

    @Override // npi.spay.InterfaceC1995vi
    public final Object a(RedirectActivity redirectActivity, Ph ph, Continuation continuation) {
        String deeplink;
        String appPackage;
        C1955u3 c1955u3;
        C1560e6 c1560e6;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Di di = (Di) this.a;
        ContentResponse.Success success = di.c;
        if (success == null) {
            success = null;
        }
        SessionIdResponseBody sessionIdResponseBody = success != null ? (SessionIdResponseBody) success.getData() : null;
        if (sessionIdResponseBody != null && (deeplink = sessionIdResponseBody.getDeeplink()) != null) {
            Intrinsics.checkNotNullParameter(deeplink, "<this>");
            String strConcat = "https://".concat(deeplink);
            if (strConcat != null) {
                Uri uri = Uri.parse(strConcat);
                Intrinsics.checkNotNullExpressionValue(uri, "parse(this)");
                if (uri != null) {
                    String queryParameter = uri.getQueryParameter("client_id");
                    if (queryParameter == null) {
                        queryParameter = "-1";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "deepLink.getQueryParamet…ID) ?: STRING_UNAVAILABLE");
                    String queryParameter2 = uri.getQueryParameter("scope");
                    if (queryParameter2 == null) {
                        queryParameter2 = "-1";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter2, "deepLink.getQueryParamet…PE) ?: STRING_UNAVAILABLE");
                    String queryParameter3 = uri.getQueryParameter("state");
                    if (queryParameter3 == null) {
                        queryParameter3 = "-1";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter3, "deepLink.getQueryParamet…TE) ?: STRING_UNAVAILABLE");
                    String queryParameter4 = uri.getQueryParameter("nonce");
                    if (queryParameter4 == null) {
                        queryParameter4 = "-1";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter4, "deepLink.getQueryParamet…CE) ?: STRING_UNAVAILABLE");
                    String queryParameter5 = uri.getQueryParameter("code_challenge");
                    if (queryParameter5 == null) {
                        queryParameter5 = "-1";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter5, "deepLink.getQueryParamet…GE) ?: STRING_UNAVAILABLE");
                    String queryParameter6 = uri.getQueryParameter("code_challenge_method");
                    if (queryParameter6 == null) {
                        queryParameter6 = "-1";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter6, "deepLink.getQueryParamet…OD) ?: STRING_UNAVAILABLE");
                    String queryParameter7 = uri.getQueryParameter("redirect_uri");
                    String str = queryParameter7 != null ? queryParameter7 : "-1";
                    Intrinsics.checkNotNullExpressionValue(str, "{\n            deepLink.g…ING_UNAVAILABLE\n        }");
                    MerchantDataWithOrderId merchantDataWithOrderId = di.i;
                    if (merchantDataWithOrderId == null || (appPackage = merchantDataWithOrderId.getAppPackage()) == null) {
                        throw B9.a;
                    }
                    Uri uriBuild = SberIDLoginManager.INSTANCE.sberIDBuilder().clientID(queryParameter).scope(queryParameter2).state(queryParameter3).nonce(queryParameter4).redirectUri(str).codeChallenge(queryParameter5).codeChallengeMethod(queryParameter6).build().buildUpon().appendQueryParameter("package", appPackage).build();
                    Intrinsics.checkNotNullExpressionValue(uriBuild, "SberIDLoginManager\n     …age)\n            .build()");
                    Timber.Companion companion = Timber.INSTANCE;
                    companion.i("AUTHORIZATION_URI" + uriBuild, new Object[0]);
                    if (C1815oc.b == 6) {
                        ((Jh) this.f).a(ao.a);
                    } else {
                        this.e.loginWithSberbankID(redirectActivity, uriBuild);
                        ((C1502bn) this.c).b = false;
                        companion.i("BANK_AUTH_VIEW_APPEARED : ", new Object[0]);
                        if (ph == Ph.AUTH_FOR_FULL_EMISSION) {
                            c1955u3 = this.b;
                            c1560e6 = new C1560e6(K7.LC_BANK_APP_AUTH, EnumC1877r0.PAY_VIEW, C0.LC, null, null, null, null, 120);
                        } else {
                            c1955u3 = this.b;
                            c1560e6 = new C1560e6(EnumC1770mh.LC_BANK_APP_SDK_AUTH, EnumC1877r0.AUTH_VIEW, C0.LC, null, null, null, null, 120);
                        }
                        c1955u3.a(c1560e6);
                    }
                    Consumer<Intent> consumerA = a(cancellableContinuationImpl, redirectActivity, ph);
                    redirectActivity.addOnNewIntentListener(consumerA);
                    cancellableContinuationImpl.invokeOnCancellation(new V0(redirectActivity, consumerA));
                    Object result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return result;
                }
            }
        }
        throw C1778n0.a;
    }

    public static final void a(W0 this$0, RedirectActivity activity, Ph reason, CancellableContinuation cancellableContinuation, Intent intent) {
        SberIDResultModel sberIDResultModel;
        C1955u3 c1955u3;
        C1560e6 c1560e6;
        C1874ql c1874ql;
        int i;
        C1955u3 c1955u32;
        C1560e6 c1560e62;
        C1955u3 c1955u33;
        C1560e6 c1560e63;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(reason, "$reason");
        Intrinsics.checkNotNullParameter(cancellableContinuation, "$cancellableContinuation");
        Bundle extras = intent.getExtras();
        if ((extras == null || !extras.containsKey("FAKE_BANK_AUTH_INTENT_KEY")) && intent.getData() == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        this$0.getClass();
        int i2 = C1815oc.b;
        if (i2 == 6) {
            Parcelable parcelableExtra = intent.getParcelableExtra("FAKE_BANK_AUTH_INTENT_KEY");
            FakeBankAuthData fakeBankAuthData = parcelableExtra instanceof FakeBankAuthData ? (FakeBankAuthData) parcelableExtra : null;
            sberIDResultModel = fakeBankAuthData != null ? new SberIDResultModel(Boolean.TRUE, fakeBankAuthData.getState(), fakeBankAuthData.getNonce(), fakeBankAuthData.getAuthCode(), null, null, 48, null) : new SberIDResultModel(Boolean.FALSE, null, null, null, null, null, 62, null);
        } else if (i2 == 5 || i2 == 4) {
            SberIDResultModel sberIDAuthResult = this$0.e.getSberIDAuthResult(intent);
            sberIDResultModel = new SberIDResultModel(Boolean.TRUE, sberIDAuthResult.getState(), sberIDAuthResult.getNonce(), sberIDAuthResult.getAuthCode(), null, null, 48, null);
        } else {
            sberIDResultModel = this$0.e.getSberIDAuthResult(intent);
        }
        Context baseContext = activity.getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "activity.baseContext");
        Boolean isSuccess = sberIDResultModel.getIsSuccess();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isSuccess, bool)) {
            if (reason == Ph.AUTH_FOR_FULL_EMISSION) {
                c1955u33 = this$0.b;
                c1560e63 = new C1560e6(K7.LC_BANK_APP_AUTH_GOOD, EnumC1877r0.PAY_VIEW, C0.LC, null, null, null, null, 120);
            } else {
                c1955u33 = this$0.b;
                c1560e63 = new C1560e6(EnumC1770mh.LC_BANK_APP_SDK_AUTH_GOOD, EnumC1877r0.AUTH_VIEW, C0.LC, null, null, null, null, 120);
            }
            c1955u33.a(c1560e63);
            c1874ql = new C1874ql(sberIDResultModel, null, true, 2);
        } else if (Intrinsics.areEqual(sberIDResultModel.getIsSuccess(), bool) || !((i = C1815oc.b) == 5 || i == 4)) {
            if (reason == Ph.AUTH_FOR_FULL_EMISSION) {
                c1955u3 = this$0.b;
                c1560e6 = new C1560e6(K7.LC_BANK_APP_AUTH_FAIL, EnumC1877r0.PAY_VIEW, C0.LC, null, null, null, null, 120);
            } else {
                c1955u3 = this$0.b;
                c1560e6 = new C1560e6(EnumC1770mh.LC_BANK_APP_SDK_AUTH_FAIL, EnumC1877r0.AUTH_VIEW, C0.LC, null, null, null, null, 120);
            }
            c1955u3.a(c1560e6);
            c1874ql = new C1874ql(null, baseContext.getString(R$string.spay_exception_bank_auth_failed), false, 1);
        } else {
            if (reason == Ph.AUTH_FOR_FULL_EMISSION) {
                c1955u32 = this$0.b;
                c1560e62 = new C1560e6(K7.LC_BANK_APP_AUTH_GOOD, EnumC1877r0.PAY_VIEW, C0.LC, null, null, null, null, 120);
            } else {
                c1955u32 = this$0.b;
                c1560e62 = new C1560e6(EnumC1770mh.LC_BANK_APP_SDK_AUTH_GOOD, EnumC1877r0.AUTH_VIEW, C0.LC, null, null, null, null, 120);
            }
            c1955u32.a(c1560e62);
            c1874ql = new C1874ql(sberIDResultModel, null, true, 2);
        }
        Timber.INSTANCE.i("RESPONSE FROM BANK APP : " + sberIDResultModel, new Object[0]);
        ((C1502bn) this$0.c).b = true;
        ((Ec) this$0.d).b = true;
        Intrinsics.checkNotNullParameter(cancellableContinuation, "<this>");
        if (cancellableContinuation.isActive()) {
            cancellableContinuation.resume(c1874ql, null);
        }
        CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    @Override // npi.spay.InterfaceC1995vi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.content.Context r12) {
        /*
            r11 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            npi.spay.l0 r0 = r11.g
            npi.spay.O0 r0 = (npi.spay.O0) r0
            spay.sdk.domain.model.response.SPaySdkConfig r0 = r0.a()
            if (r0 == 0) goto L42
            java.util.ArrayList r0 = r0.getSchemas()
            if (r0 == 0) goto L42
            java.util.Iterator r0 = r0.iterator()
        L19:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L38
            java.lang.Object r1 = r0.next()
            r3 = r1
            spay.sdk.domain.model.response.SPaySdkConfig$Schema r3 = (spay.sdk.domain.model.response.SPaySdkConfig.Schema) r3
            if (r3 == 0) goto L2d
            java.lang.String r2 = r3.getStand()
        L2d:
            java.lang.String r3 = npi.spay.Fd.a()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L19
            r2 = r1
        L38:
            spay.sdk.domain.model.response.SPaySdkConfig$Schema r2 = (spay.sdk.domain.model.response.SPaySdkConfig.Schema) r2
            if (r2 == 0) goto L42
            java.lang.String r0 = r2.getBankAppAuthUri()
            if (r0 != 0) goto L44
        L42:
            java.lang.String r0 = "sberbankidlogin://sberbankid"
        L44:
            android.content.Intent r1 = new android.content.Intent
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r2 = "android.intent.action.VIEW"
            r1.<init>(r2, r0)
            android.content.pm.PackageManager r12 = r12.getPackageManager()
            android.content.ComponentName r12 = r1.resolveActivity(r12)
            if (r12 == 0) goto L5b
            r12 = 1
            goto L5c
        L5b:
            r12 = 0
        L5c:
            if (r12 == 0) goto L62
            npi.spay.en r0 = npi.spay.EnumC1577en.LC_BANK_APP_FOUND
        L60:
            r2 = r0
            goto L65
        L62:
            npi.spay.en r0 = npi.spay.EnumC1577en.LC_NO_BANK_APP_FOUND
            goto L60
        L65:
            npi.spay.u3 r0 = r11.b
            npi.spay.e6 r10 = new npi.spay.e6
            npi.spay.r0 r3 = npi.spay.EnumC1877r0.MERCHANT_VIEW
            npi.spay.C0 r4 = npi.spay.C0.LC
            r8 = 0
            r9 = 120(0x78, float:1.68E-43)
            r5 = 0
            r6 = 0
            r7 = 0
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r0.a(r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.W0.a(android.content.Context):boolean");
    }
}
