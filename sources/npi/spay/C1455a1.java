package npi.spay;

import android.content.Context;
import com.google.android.gms.location.DeviceOrientationRequest;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.a1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1455a1 {
    public final String a;
    public final String b;
    public final Context c;
    public C1552dn d;

    public C1455a1(Context context, String apiKey, String url) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = apiKey;
        this.b = url;
        this.c = context;
    }

    public final C1480b1 a() {
        T3 settings = new T3(this.b, this.a);
        settings.e = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
        settings.c = 10;
        Lazy lazy = V5.a;
        Context context = this.c;
        C1552dn networkClientBuilder = this.d;
        if (networkClientBuilder == null) {
            throw new IllegalStateException("NetworkClientBuilder must be set");
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(networkClientBuilder, "networkClientBuilder");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Context appContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext");
        C1655i1 c1655i1 = new C1655i1(settings, (InterfaceC1548dj) V5.a.getValue());
        S8 s8 = new S8(settings, new C1675im(networkClientBuilder.a));
        C2078z1 c2078z1 = new C2078z1(appContext, settings);
        if (V5.c == null) {
            V5.c = new W3(appContext, new C1555e1());
        }
        W3 w3 = V5.c;
        Intrinsics.checkNotNull(w3, "null cannot be cast to non-null type ru.sber.platform.clickstream.clickstreamlite.internal.data.providers.helpers.DeviceIdProvider");
        if (V5.c == null) {
            V5.c = new W3(appContext, new C1555e1());
        }
        W3 w32 = V5.c;
        Intrinsics.checkNotNull(w32, "null cannot be cast to non-null type ru.sber.platform.clickstream.clickstreamlite.internal.data.providers.helpers.DeviceIdProvider");
        C2023wl c2023wl = new C2023wl(appContext, w3, new B2(w32));
        V5.b = c2023wl;
        return new C1480b1(new Si(new D7(c1655i1, s8, new C1752m(c2078z1, c2023wl)), new Oe(new C1546dh(appContext, new Qh(appContext), new C1736l8(), new C1725km(appContext, settings)))), V5.b);
    }
}
