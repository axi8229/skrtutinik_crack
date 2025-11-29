package com.huawei.location.gnss.sdm;

import android.location.Location;
import android.location.LocationListener;
import com.huawei.location.lite.common.log.LogLocation;
import com.huawei.location.lite.common.util.ReflectionUtils;
import com.yandex.varioqub.config.model.ConfigValue;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class Vw {
    private FB yn;
    private final CopyOnWriteArrayList<yn> Vw = new CopyOnWriteArrayList<>();
    private boolean FB = false;

    private static class yn {
        private final LocationListener FB;
        private final float Vw;
        private final long yn;
        private long LW = 0;
        private C0088yn dC = new C0088yn();

        /* renamed from: com.huawei.location.gnss.sdm.Vw$yn$yn, reason: collision with other inner class name */
        private static class C0088yn {
            private final double Vw;
            private final double yn;

            C0088yn() {
                this(ConfigValue.DOUBLE_DEFAULT_VALUE, ConfigValue.DOUBLE_DEFAULT_VALUE);
            }

            C0088yn(double d, double d2) {
                this.yn = d;
                this.Vw = d2;
            }

            static float yn(C0088yn c0088yn, C0088yn c0088yn2) {
                float[] fArr = new float[1];
                double d = c0088yn.yn;
                double d2 = c0088yn2.Vw;
                Location.distanceBetween(d, d2, c0088yn2.yn, d2, fArr);
                return fArr[0];
            }
        }

        yn(long j, float f, LocationListener locationListener) {
            this.yn = j;
            this.Vw = f;
            this.FB = locationListener;
        }

        void yn(Location location) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jAbs = Math.abs(jCurrentTimeMillis - this.LW);
            if (jAbs < this.yn) {
                LogLocation.d("SdmProvider", "not need, interval check failed. timeDiff:" + jAbs);
                return;
            }
            C0088yn c0088yn = new C0088yn(location.getLatitude(), location.getLongitude());
            float fYn = C0088yn.yn(this.dC, c0088yn);
            if (fYn >= this.Vw) {
                this.LW = jCurrentTimeMillis;
                this.dC = c0088yn;
                this.FB.onLocationChanged(location);
            } else {
                LogLocation.d("SdmProvider", "not need, distance check failed. distanceDiff:" + fYn);
            }
        }
    }

    public Vw() {
        this.yn = null;
        if (yn()) {
            this.yn = new FB();
        }
    }

    static void yn(Vw vw, Location location) {
        Iterator<yn> it = vw.Vw.iterator();
        while (it.hasNext()) {
            it.next().yn(location);
        }
    }

    private static boolean yn() {
        if (ReflectionUtils.isSupportClass("com.huawei.location.sdm.Sdm")) {
            LogLocation.i("SdmProvider", "support sdm");
            return true;
        }
        LogLocation.w("SdmProvider", "not support sdm");
        return false;
    }

    private boolean yn(LocationListener locationListener) {
        Iterator<yn> it = this.Vw.iterator();
        yn ynVar = null;
        while (it.hasNext()) {
            yn next = it.next();
            if (next.FB == locationListener) {
                ynVar = next;
            }
        }
        if (ynVar == null) {
            return false;
        }
        return this.Vw.remove(ynVar);
    }

    public void Vw(LocationListener locationListener) {
        if (!yn(locationListener)) {
            LogLocation.d("SdmProvider", "not need remove");
            return;
        }
        if (this.FB && this.Vw.isEmpty()) {
            this.yn.yn();
            this.FB = false;
        }
        LogLocation.i("SdmProvider", "remove success");
    }

    public boolean yn(long j, float f, LocationListener locationListener) {
        boolean zYn;
        FB fb = this.yn;
        if (fb == null) {
            LogLocation.d("SdmProvider", "not support sdm");
            zYn = false;
        } else {
            zYn = fb.yn(j, f);
        }
        if (!zYn) {
            return false;
        }
        if (yn(locationListener)) {
            LogLocation.w("SdmProvider", "duplicate request");
        }
        this.Vw.add(new yn(j, f, locationListener));
        if (!this.FB && !this.Vw.isEmpty()) {
            this.yn.yn(new com.huawei.location.gnss.sdm.yn(this));
            this.FB = true;
        }
        LogLocation.i("SdmProvider", "request success");
        return true;
    }
}
