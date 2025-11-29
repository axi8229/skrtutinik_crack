package npi.spay;

import android.content.pm.PackageManager;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import spay.sdk.RedirectActivity;
import spay.sdk.data.dto.MerchantDataWithOrderId;
import spay.sdk.domain.model.response.SPaySdkConfig;

/* renamed from: npi.spay.y3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2055y3 extends Lambda implements Function1 {
    public final /* synthetic */ RedirectActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2055y3(RedirectActivity redirectActivity) {
        super(1);
        this.a = redirectActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws PackageManager.NameNotFoundException {
        F9 f9;
        Object next;
        Object next2;
        String appPackage;
        String clickStreamUrl;
        String clickStreamAppId;
        Pair pair = (Pair) obj;
        RedirectActivity redirectActivity = this.a;
        SPaySdkConfig sPaySdkConfig = (SPaySdkConfig) pair.getFirst();
        int i = RedirectActivity.g;
        redirectActivity.getClass();
        String strA = Fd.a();
        Iterator<T> it = sPaySdkConfig.getSchemas().iterator();
        while (true) {
            f9 = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            SPaySdkConfig.Schema schema = (SPaySdkConfig.Schema) next;
            if (Intrinsics.areEqual(schema != null ? schema.getStand() : null, strA)) {
                break;
            }
        }
        SPaySdkConfig.Schema schema2 = (SPaySdkConfig.Schema) next;
        String strB = (schema2 == null || (clickStreamAppId = schema2.getClickStreamAppId()) == null) ? null : AbstractC1946tj.b(clickStreamAppId);
        if (strB == null) {
            strB = "";
        }
        Iterator<T> it2 = sPaySdkConfig.getSchemas().iterator();
        while (true) {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
            SPaySdkConfig.Schema schema3 = (SPaySdkConfig.Schema) next2;
            if (Intrinsics.areEqual(schema3 != null ? schema3.getStand() : null, strA)) {
                break;
            }
        }
        SPaySdkConfig.Schema schema4 = (SPaySdkConfig.Schema) next2;
        String strB2 = (schema4 == null || (clickStreamUrl = schema4.getClickStreamUrl()) == null) ? null : AbstractC1946tj.b(clickStreamUrl);
        if (strB2 == null) {
            strB2 = "";
        }
        C1480b1 c1480b1A = new C1455a1(redirectActivity, strB, strB2).a();
        Ih ih = redirectActivity.d;
        if (ih == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sPayDataContract");
            ih = null;
        }
        MerchantDataWithOrderId merchantDataWithOrderId = ((Di) ih).i;
        if (merchantDataWithOrderId == null || (appPackage = merchantDataWithOrderId.getAppPackage()) == null) {
            Ih ih2 = redirectActivity.d;
            if (ih2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sPayDataContract");
                ih2 = null;
            }
            ih2.getClass();
            appPackage = "";
        }
        F9 f92 = redirectActivity.e;
        if (f92 != null) {
            f9 = f92;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("appNameUtil");
        }
        String strA2 = f9.a(appPackage);
        String hashUserLoginId = strA2 != null ? strA2 : "";
        Intrinsics.checkNotNullParameter(hashUserLoginId, "hashUserLoginId");
        C2023wl c2023wl = c1480b1A.b;
        if (c2023wl != null) {
            Intrinsics.checkNotNullParameter(hashUserLoginId, "hashUserLoginId");
            c2023wl.e = hashUserLoginId;
        }
        return Unit.INSTANCE;
    }
}
