package npi.spay;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.data.dto.MerchantDataWithOrderId;
import spay.sdk.domain.model.response.SPaySdkConfig;
import timber.log.Timber;

/* renamed from: npi.spay.u3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1955u3 {
    public static boolean f;
    public static Tl g;
    public final Context a;
    public final C1993vg b;
    public final Ih c;
    public final F9 d;
    public final LinkedList e;

    public C1955u3(Context context, C1993vg featuresHandler, Ih sPayDataContract, F9 appNameUtil) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(appNameUtil, "appNameUtil");
        this.a = context;
        this.b = featuresHandler;
        this.c = sPayDataContract;
        this.d = appNameUtil;
        this.e = new LinkedList();
    }

    public final void a(C1560e6 analyticMetric) {
        Intrinsics.checkNotNullParameter(analyticMetric, "analyticMetric");
        if (f) {
            Tl tl = g;
            if (tl != null) {
                tl.a(analyticMetric);
                return;
            }
            return;
        }
        this.e.add(analyticMetric);
        Timber.INSTANCE.tag("MetricFacade").d("Метрика " + analyticMetric + " была добавлена в очередь для последующей отправки", new Object[0]);
    }

    public final void a(SPaySdkConfig config, C1552dn networkClientBuilder) throws PackageManager.NameNotFoundException {
        Object next;
        String appPackage;
        String clickStreamUrl;
        String clickStreamAppId;
        String stand;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(networkClientBuilder, "networkClientBuilder");
        C1993vg c1993vg = this.b;
        EnumC1628h tag = EnumC1628h.CLICKSTREAM_METRICS;
        c1993vg.getClass();
        Intrinsics.checkNotNullParameter(tag, "tag");
        InterfaceC2089zc interfaceC2089zc = (InterfaceC2089zc) c1993vg.c.get(tag);
        if (interfaceC2089zc != null) {
            String strB = null;
            if (((Boolean) interfaceC2089zc.a((Pe) null)).booleanValue()) {
                String strA = Fd.a();
                Iterator<T> it = config.getSchemas().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    SPaySdkConfig.Schema schema = (SPaySdkConfig.Schema) next;
                    String strB2 = (schema == null || (stand = schema.getStand()) == null) ? null : AbstractC1946tj.b(stand);
                    if (strB2 == null) {
                        strB2 = "";
                    }
                    if (Intrinsics.areEqual(strB2, strA)) {
                        break;
                    }
                }
                SPaySdkConfig.Schema schema2 = (SPaySdkConfig.Schema) next;
                String strB3 = (schema2 == null || (clickStreamAppId = schema2.getClickStreamAppId()) == null) ? null : AbstractC1946tj.b(clickStreamAppId);
                if (strB3 == null) {
                    strB3 = "";
                }
                if (schema2 != null && (clickStreamUrl = schema2.getClickStreamUrl()) != null) {
                    strB = AbstractC1946tj.b(clickStreamUrl);
                }
                if (strB == null) {
                    strB = "";
                }
                C1455a1 c1455a1 = new C1455a1(this.a, strB3, strB);
                Intrinsics.checkNotNullParameter(networkClientBuilder, "networkClientBuilder");
                c1455a1.d = networkClientBuilder;
                C1480b1 c1480b1A = c1455a1.a();
                MerchantDataWithOrderId merchantDataWithOrderId = ((Di) this.c).i;
                if (merchantDataWithOrderId == null || (appPackage = merchantDataWithOrderId.getAppPackage()) == null) {
                    this.c.getClass();
                    appPackage = "";
                }
                String strA2 = this.d.a(appPackage);
                String hashUserLoginId = strA2 != null ? strA2 : "";
                Intrinsics.checkNotNullParameter(hashUserLoginId, "hashUserLoginId");
                C2023wl c2023wl = c1480b1A.b;
                if (c2023wl != null) {
                    Intrinsics.checkNotNullParameter(hashUserLoginId, "hashUserLoginId");
                    c2023wl.e = hashUserLoginId;
                }
                g = new Tl(c1480b1A, this.c);
            }
        }
        f = g != null;
        if (this.e.isEmpty()) {
            return;
        }
        while (!this.e.isEmpty()) {
            C1560e6 event = (C1560e6) this.e.pop();
            Tl tl = g;
            if (tl != null) {
                Intrinsics.checkNotNullExpressionValue(event, "event");
                tl.a(event);
            }
        }
    }
}
