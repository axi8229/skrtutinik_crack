package com.group_ib.sdk;

import android.media.AudioManager;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public final class D0 extends B0 {
    public boolean e;
    public long f;

    public D0(MobileSdkService mobileSdkService) {
        super(mobileSdkService, Integer.MAX_VALUE, 0L);
        this.e = false;
        this.f = 0L;
    }

    @Override // com.group_ib.sdk.B0
    public final void a(b1 b1Var) {
        AudioManager audioManager = (AudioManager) this.a.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (audioManager != null) {
            boolean z = audioManager.getMode() == 2 || audioManager.getMode() == 3;
            b1Var.put("CallActive", z ? new a1("true") : "false");
            if (this.e != z) {
                c1.a(3, 3, "ParamsActiveCall", "Call ".concat(z ? "started" : "finished"));
                this.e = z;
            }
        }
    }

    @Override // com.group_ib.sdk.B0
    public final boolean a(int i) {
        long jCurrentTimeMillis;
        if (i == 16) {
            jCurrentTimeMillis = 0;
        } else {
            if (i != 32) {
                return this.f - System.currentTimeMillis() < 1000;
            }
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        this.f = jCurrentTimeMillis;
        return true;
    }
}
