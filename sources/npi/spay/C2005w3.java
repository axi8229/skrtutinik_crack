package npi.spay;

import android.content.Intent;
import spay.sdk.utils.receiver.OtpReceiver;

/* renamed from: npi.spay.w3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2005w3 implements OtpReceiver.a {
    public final /* synthetic */ C1579f0 a;

    public C2005w3(C1579f0 c1579f0) {
        this.a = c1579f0;
    }

    @Override // spay.sdk.utils.receiver.OtpReceiver.a
    public final void a() {
    }

    @Override // spay.sdk.utils.receiver.OtpReceiver.a
    public final void a(Intent intent) {
        if (intent != null) {
            this.a.startActivityForResult(intent, 200);
        }
    }
}
