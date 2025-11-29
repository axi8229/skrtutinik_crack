package npi.spay;

import com.google.android.gms.location.DeviceOrientationRequest;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class T3 {
    public final String a;
    public final String b;
    public int c;
    public final C1457a3 d;
    public long e;

    public T3(String url, String apiKey) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.a = url;
        this.b = apiKey;
        this.c = 10;
        this.d = new C1457a3();
        this.e = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
    }
}
