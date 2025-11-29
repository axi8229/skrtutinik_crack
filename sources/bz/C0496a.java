package bz;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: bz.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0496a extends R0 {
    public final /* synthetic */ C0499b a;

    public C0496a(C0499b c0499b) {
        this.a = c0499b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.a(A0.n) != null) {
            return;
        }
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a.c);
            if (advertisingIdInfo != null) {
                this.a.a(advertisingIdInfo.getId());
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
        }
    }
}
