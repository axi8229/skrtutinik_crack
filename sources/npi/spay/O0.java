package npi.spay;

import com.google.gson.Gson;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.SPaySdkInitConfig;
import spay.sdk.domain.model.response.SPaySdkConfig;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class O0 implements InterfaceC1728l0 {
    public final InterfaceC1846pi a;
    public final InterfaceC1943tg b;
    public SPaySdkConfig c;
    public SPaySdkInitConfig d;
    public final LinkedHashMap e;

    public O0(InterfaceC1846pi configService, InterfaceC1943tg defaultSharedPreferences) {
        Intrinsics.checkNotNullParameter(configService, "configService");
        Intrinsics.checkNotNullParameter(defaultSharedPreferences, "defaultSharedPreferences");
        this.a = configService;
        this.b = defaultSharedPreferences;
        this.e = new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof npi.spay.N0
            if (r0 == 0) goto L13
            r0 = r5
            npi.spay.N0 r0 = (npi.spay.N0) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            npi.spay.N0 r0 = new npi.spay.N0
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            npi.spay.O0 r1 = r0.b
            npi.spay.O0 r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4b
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            npi.spay.pi r5 = r4.a
            r0.a = r4
            r0.b = r4
            r0.e = r3
            npi.spay.Qi r5 = (npi.spay.Qi) r5
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            r0 = r4
            r1 = r0
        L4b:
            spay.sdk.domain.model.response.SPaySdkConfig r5 = (spay.sdk.domain.model.response.SPaySdkConfig) r5
            if (r5 != 0) goto L53
            spay.sdk.domain.model.response.SPaySdkConfig r5 = r0.a()
        L53:
            r1.c = r5
            spay.sdk.domain.model.response.SPaySdkConfig r5 = r0.c
            if (r5 == 0) goto Lb7
            r0.c = r5
            spay.sdk.domain.model.response.SPaySdkConfig$Localization r5 = r5.getLocalization()
            if (r5 == 0) goto La3
            java.util.LinkedHashMap r1 = r0.e
            java.lang.String r2 = r5.getBankApp()
            java.lang.String r3 = "bankApp"
            r1.put(r3, r2)
            java.util.LinkedHashMap r1 = r0.e
            java.lang.String r2 = r5.getEnableSPay()
            java.lang.String r3 = "enableSPay"
            r1.put(r3, r2)
            java.util.LinkedHashMap r1 = r0.e
            java.lang.String r2 = r5.getPayError()
            java.lang.String r3 = "payError"
            r1.put(r3, r2)
            java.util.LinkedHashMap r1 = r0.e
            java.lang.String r2 = r5.getPayLoading()
            java.lang.String r3 = "payLoading"
            r1.put(r3, r2)
            java.util.LinkedHashMap r1 = r0.e
            java.lang.String r2 = r5.getBankAppLoading()
            java.lang.String r3 = "bankAppLoading"
            r1.put(r3, r2)
            java.util.LinkedHashMap r1 = r0.e
            java.lang.String r5 = r5.getSuccessEnableSPay()
            java.lang.String r2 = "successEnableSPay"
            r1.put(r2, r5)
        La3:
            spay.sdk.domain.model.response.SPaySdkConfig r5 = r0.c
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            java.lang.String r5 = r1.toJson(r5)
            if (r5 == 0) goto Lb7
            npi.spay.tg r0 = r0.b
            java.lang.String r1 = "APP_CONFIG"
            r0.mo2849a(r1, r5)
        Lb7:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: npi.spay.O0.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final SPaySdkConfig a() {
        SPaySdkConfig sPaySdkConfig;
        try {
            sPaySdkConfig = (SPaySdkConfig) new Gson().fromJson((String) this.b.a("APP_CONFIG", "-1"), SPaySdkConfig.class);
        } catch (Exception e) {
            Timber.INSTANCE.i("CATCH BLOCK EXCEPTION " + e, new Object[0]);
            sPaySdkConfig = null;
        }
        Timber.INSTANCE.i("CONFIG_FROM_SHARED_PREFERENCES : " + sPaySdkConfig, new Object[0]);
        return sPaySdkConfig;
    }
}
