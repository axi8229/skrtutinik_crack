package com.yandex.metrica.identifiers.impl;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class k implements i {
    @Override // com.yandex.metrica.identifiers.impl.i
    public g a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            Intrinsics.checkNotNullExpressionValue(advertisingIdInfo, "AdvertisingIdClient.getAdvertisingIdInfo(context)");
            return new g(l.b, new f("google", advertisingIdInfo.getId(), Boolean.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled())), null, 4);
        } catch (GooglePlayServicesNotAvailableException unused) {
            return new g(l.c, null, "could not resolve google services", 2);
        } catch (Throwable th) {
            return new g(l.d, null, "exception while fetching google adv_id: " + th.getMessage(), 2);
        }
    }
}
