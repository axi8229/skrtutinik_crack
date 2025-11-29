package spay.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import dagger.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.FlowKt;
import npi.spay.A3;
import npi.spay.C0;
import npi.spay.C1453a;
import npi.spay.C1508c4;
import npi.spay.C1518ce;
import npi.spay.C1560e6;
import npi.spay.C1620gg;
import npi.spay.C1767me;
import npi.spay.C1895ri;
import npi.spay.C1936t9;
import npi.spay.C1955u3;
import npi.spay.C1979v2;
import npi.spay.C1993vg;
import npi.spay.Di;
import npi.spay.Ei;
import npi.spay.EnumC1505c1;
import npi.spay.EnumC1577en;
import npi.spay.EnumC1877r0;
import npi.spay.Gk;
import npi.spay.Ih;
import npi.spay.Ik;
import npi.spay.Im;
import npi.spay.InterfaceC1495bg;
import npi.spay.InterfaceC1626gm;
import npi.spay.InterfaceC1728l0;
import npi.spay.N9;
import npi.spay.Pj;
import npi.spay.Qb;
import npi.spay.Vl;
import npi.spay.W0;
import npi.spay.Yf;
import sberid.sdk.auth.login.SberIDLoginManager;
import spay.sdk.api.MerchantError;
import spay.sdk.api.PaymentResult;
import spay.sdk.api.PaymentTokenResult;
import spay.sdk.b;
import spay.sdk.data.dto.MerchantDataWithOrderId;
import spay.sdk.domain.model.PaymentModel;
import spay.sdk.utils.permissions.PermissionsActivity;

/* loaded from: classes5.dex */
public final class d implements b {
    public static volatile d f;
    public Ih b;
    public Gk c;
    public W0 d;
    public final C1955u3 e;

    public static final class a extends Lambda implements Function1<PaymentTokenResult, Unit> {
        public final /* synthetic */ Context b;
        public final /* synthetic */ MerchantDataWithOrderId c;
        public final /* synthetic */ Function1<PaymentResult, Unit> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Context context, MerchantDataWithOrderId merchantDataWithOrderId, Function1<? super PaymentResult, Unit> function1) {
            super(1);
            this.b = context;
            this.c = merchantDataWithOrderId;
            this.d = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(PaymentTokenResult paymentTokenResult) {
            Function1<? super PaymentResult, Unit> function1;
            PaymentTokenResult paymentTokenResult2 = paymentTokenResult;
            Intrinsics.checkNotNullParameter(paymentTokenResult2, "paymentTokenResult");
            if (paymentTokenResult2 instanceof PaymentTokenResult.Success) {
                d dVar = d.this;
                Context context = this.b;
                String authorization = this.c.getAuthorization();
                String orderId = this.c.getOrderId();
                String paymentToken = ((PaymentTokenResult.Success) paymentTokenResult2).getPaymentToken();
                String merchantLogin = this.c.getMerchantLogin();
                c cVar = new c(this.d);
                C1955u3 c1955u3 = dVar.e;
                if (c1955u3 != null) {
                    c1955u3.a(new C1560e6(EnumC1505c1.MAPay, null, C0.MA, null, null, null, null, 122));
                }
                MerchantDataWithOrderId merchantDataWithOrderId = ((Di) dVar.a()).i;
                if (merchantDataWithOrderId != null) {
                    if (!Intrinsics.areEqual(authorization, merchantDataWithOrderId.getAuthorization()) || !Intrinsics.areEqual(orderId, merchantDataWithOrderId.getOrderId()) || !Intrinsics.areEqual(merchantLogin, merchantDataWithOrderId.getMerchantLogin())) {
                        Gk gk = dVar.c;
                        if (gk == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("clearSdkUtil");
                            gk = null;
                        }
                        gk.a(false);
                    }
                    dVar.b();
                }
                if (orderId.length() != 32) {
                    cVar.invoke(new PaymentResult.Error((String) FlowKt.asStateFlow(((Di) dVar.a()).B).getValue(), new MerchantError.RequiredDataNotSent("Длина bankInvoiceId должна быть 32 символа")));
                } else {
                    b.a.d = cVar;
                    context.startActivity(new Intent(context, (Class<?>) RedirectActivity.class).putExtra("PAYMENT_DATA", new PaymentModel(authorization, orderId, paymentToken, merchantLogin)));
                }
            } else if ((paymentTokenResult2 instanceof PaymentTokenResult.Error) && (function1 = b.a.d) != null) {
                function1.invoke(new PaymentResult.Error((String) FlowKt.asStateFlow(((Di) d.this.a()).B).getValue(), ((PaymentTokenResult.Error) paymentTokenResult2).getMerchantError()));
            }
            return Unit.INSTANCE;
        }
    }

    public d() {
        Im sdkComponent = SPaySdkApp.INSTANCE.getInstance().getSdkComponent();
        this.e = sdkComponent != null ? ((Ik) sdkComponent).b() : null;
        b();
    }

    public final Pair<Boolean, List<String>> a(Context context) {
        C1955u3 c1955u3;
        C1560e6 c1560e6;
        Intrinsics.checkNotNullParameter(context, "context");
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
        ArrayList arrayList = new ArrayList();
        for (String str : listListOf) {
            if (ContextCompat.checkSelfPermission(context, str) == -1) {
                arrayList.add(str);
            }
        }
        Pair<Boolean, List<String>> pair = new Pair<>(Boolean.valueOf(arrayList.isEmpty()), arrayList);
        if (pair.getFirst().booleanValue()) {
            c1955u3 = this.e;
            if (c1955u3 != null) {
                c1560e6 = new C1560e6(EnumC1577en.SC_GOOD_PERMISSIONS, EnumC1877r0.MERCHANT_VIEW, C0.SC, null, null, null, null, 120);
                c1955u3.a(c1560e6);
            }
        } else {
            c1955u3 = this.e;
            if (c1955u3 != null) {
                c1560e6 = new C1560e6(EnumC1577en.SC_FAIL_PERMISSIONS, EnumC1877r0.MERCHANT_VIEW, C0.SC, MapsKt.mapOf(TuplesKt.to("Denied", pair.getSecond().toString())), null, null, null, 112);
                c1955u3.a(c1560e6);
            }
        }
        return pair;
    }

    public final synchronized void b() {
        Im sdkComponent;
        try {
            if (b.a.b == null && (sdkComponent = SPaySdkApp.INSTANCE.getInstance().getSdkComponent()) != null) {
                b.a.b = new Pj(((Ik) sdkComponent).c, new C1895ri(), new Vl(), new C1518ce(), new C1620gg(), new C1453a(), new C1767me(), new C1936t9(), new C1508c4());
            }
            N9 n9 = b.a.b;
            if (n9 != null) {
                Pj pj = (Pj) n9;
                this.b = (Ih) pj.d.g.get();
                C1895ri c1895ri = pj.c;
                Ih dataContract = (Ih) pj.d.g.get();
                Ei sPayStorage = (Ei) pj.e.get();
                C1993vg featuresHandler = (C1993vg) pj.d.i.get();
                Qb authHandler = (Qb) pj.d.v.get();
                c1895ri.getClass();
                Intrinsics.checkNotNullParameter(dataContract, "dataContract");
                Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
                Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
                Intrinsics.checkNotNullParameter(authHandler, "authHandler");
                this.c = (Gk) Preconditions.checkNotNullFromProvides(new Gk(dataContract, sPayStorage, featuresHandler, authHandler));
                Ih ih = (Ih) pj.d.g.get();
                C1955u3 c1955u3B = pj.d.b();
                InterfaceC1626gm interfaceC1626gm = (InterfaceC1626gm) pj.x.get();
                Qb qb = (Qb) pj.d.v.get();
                pj.a.getClass();
                this.d = new W0(ih, c1955u3B, interfaceC1626gm, qb, (SberIDLoginManager) Preconditions.checkNotNullFromProvides(new SberIDLoginManager(null, 1, null)), (InterfaceC1495bg) pj.j.get(), (InterfaceC1728l0) pj.d.s.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Ih a() {
        Ih ih = this.b;
        if (ih != null) {
            return ih;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sPayDataContract");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.ContentResolver r0 = r5.getContentResolver()
            java.lang.String r1 = "development_settings_enabled"
            r2 = 0
            int r0 = android.provider.Settings.Global.getInt(r0, r1, r2)
            android.content.ContentResolver r1 = r5.getContentResolver()
            java.lang.String r3 = "always_finish_activities"
            int r1 = android.provider.Settings.Global.getInt(r1, r3, r2)
            if (r0 != 0) goto L1d
            goto L1f
        L1d:
            if (r1 != 0) goto L37
        L1f:
            npi.spay.W0 r0 = r4.d
            if (r0 == 0) goto L24
            goto L2a
        L24:
            java.lang.String r0 = "bankAuthenticator"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L2a:
            boolean r5 = r0.a(r5)
            if (r5 != 0) goto L35
            int r5 = npi.spay.C1815oc.b
            r0 = 6
            if (r5 != r0) goto L37
        L35:
            r5 = 1
            goto L38
        L37:
            r5 = r2
        L38:
            timber.log.Timber$Forest r0 = timber.log.Timber.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "IS_READY_FOR_SPAY_SDK : "
            r1.<init>(r3)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.i(r1, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: spay.sdk.d.b(android.content.Context):boolean");
    }

    public final void a(Context context, String apiKey, String str, String bankInvoiceId, String orderNumber, String appPackage, String str2, Function1<? super PaymentResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(bankInvoiceId, "bankInvoiceId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(appPackage, "appPackage");
        Intrinsics.checkNotNullParameter(callback, "callback");
        C1955u3 c1955u3 = this.e;
        if (c1955u3 != null) {
            c1955u3.a(new C1560e6(EnumC1505c1.MA_PAY_WITH_BANK_INVOICE_ID, null, C0.MA, null, null, null, null, 122));
        }
        MerchantDataWithOrderId merchantDataWithOrderId = ((Di) a()).i;
        if (merchantDataWithOrderId != null) {
            if (Intrinsics.areEqual(apiKey, merchantDataWithOrderId.getAuthorization()) && Intrinsics.areEqual(bankInvoiceId, merchantDataWithOrderId.getOrderId())) {
                if (!Intrinsics.areEqual(str, merchantDataWithOrderId.getMerchantLogin())) {
                }
                b();
            }
            Gk gk = this.c;
            if (gk == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clearSdkUtil");
                gk = null;
            }
            gk.a(false);
            b();
        }
        if (bankInvoiceId.length() != 32) {
            callback.invoke(new PaymentResult.Error((String) FlowKt.asStateFlow(((Di) a()).B).getValue(), new MerchantError.RequiredDataNotSent("Длина bankInvoiceId должна быть 32 символа")));
            return;
        }
        b.a.d = callback;
        MerchantDataWithOrderId merchantDataWithOrderId2 = new MerchantDataWithOrderId(apiKey, str, bankInvoiceId, orderNumber, appPackage, str2);
        ((Di) a()).i = merchantDataWithOrderId2;
        b.a.c = new a(context, merchantDataWithOrderId2, callback);
        C1979v2 c1979v2 = new C1979v2(context);
        if (a(context).getFirst().booleanValue()) {
            c1979v2.invoke("action_permissions_granted");
            return;
        }
        context.startActivity(new Intent(context, (Class<?>) PermissionsActivity.class));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_permissions_granted");
        intentFilter.addAction("action_permissions_denied");
        ContextCompat.registerReceiver(context, new Yf(new A3(c1979v2)), intentFilter, 4);
    }
}
