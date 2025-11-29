package com.huawei.location.gnss.sdm;

import android.location.Location;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.sdm.Sdm;

/* loaded from: classes3.dex */
class FB {
    private Sdm Vw;
    private com.huawei.location.sdm.yn yn = null;

    interface Vw {
    }

    class yn implements com.huawei.location.sdm.yn {
        final /* synthetic */ Vw yn;

        yn(FB fb, Vw vw) {
            this.yn = vw;
        }

        @Override // com.huawei.location.sdm.yn
        public void onLocationChanged(Location location) {
            com.huawei.location.gnss.sdm.Vw.yn(((com.huawei.location.gnss.sdm.yn) this.yn).yn, location);
        }
    }

    FB() {
        this.Vw = null;
        this.Vw = new Sdm();
    }

    void yn() {
        com.huawei.location.sdm.yn ynVar = this.yn;
        if (ynVar == null) {
            LogLocation.i("SdmWrapper", "no need stop");
            return;
        }
        Sdm sdm = this.Vw;
        if (sdm == null) {
            LogLocation.e("SdmWrapper", "no sdm to stop");
            return;
        }
        sdm.remove(ynVar);
        this.yn = null;
        LogLocation.i("SdmWrapper", "sdm stop success");
    }

    void yn(Vw vw) {
        yn();
        Sdm sdm = this.Vw;
        if (sdm == null) {
            LogLocation.e("SdmWrapper", "no sdm to start");
            return;
        }
        yn ynVar = new yn(this, vw);
        this.yn = ynVar;
        sdm.request(ynVar);
        LogLocation.i("SdmWrapper", "sdm start success");
    }

    boolean yn(long j, float f) {
        Sdm sdm = this.Vw;
        if (sdm == null) {
            return false;
        }
        return sdm.support(j, f);
    }
}
