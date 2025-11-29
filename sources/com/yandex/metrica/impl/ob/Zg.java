package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.io.File;

/* loaded from: classes3.dex */
public class Zg {
    private final B0 a;

    class a implements com.yandex.metrica.rtm.wrapper.i {
        a() {
        }

        public File getCrashesDirectory(Context context) {
            return Zg.this.a.a(context, "appmetrica_rtm_crashes");
        }

        public File getCrashesTriggerDirectory(Context context) {
            return Zg.this.a.a(context, "appmetrica_rtm_crashes_triggers");
        }
    }

    class b implements com.yandex.metrica.rtm.wrapper.j {
        b(Zg zg) {
        }

        public String getDeviceType(Context context) {
            com.yandex.metrica.b bVarA = F0.g().n().a().a();
            if (bVarA == null) {
                return null;
            }
            return bVarA.a();
        }

        public String getVersion(Context context) {
            return A2.a(context, context.getPackageName());
        }
    }

    class c implements com.yandex.metrica.rtm.wrapper.i {
        c() {
        }

        public File getCrashesDirectory(Context context) {
            return Zg.this.a.a(context, "appmetrica_rtm_crashes");
        }

        public File getCrashesTriggerDirectory(Context context) {
            return Zg.this.a.a(context, "appmetrica_rtm_crashes_triggers");
        }
    }

    public Zg() {
        this(new B0());
    }

    public com.yandex.metrica.rtm.wrapper.f b(Context context) {
        com.yandex.metrica.rtm.wrapper.l lVar;
        if (C0963h2.a("com.yandex.metrica.rtm.client.ExceptionProcessor")) {
            try {
                lVar = new com.yandex.metrica.rtm.wrapper.l(new a(), context, F0.g().q().f(), new b(this));
            } catch (Throwable unused) {
            }
        } else {
            lVar = null;
        }
        return lVar == null ? new Wg() : lVar;
    }

    Zg(B0 b0) {
        this.a = b0;
    }

    public com.yandex.metrica.rtm.wrapper.e a(Context context) {
        com.yandex.metrica.rtm.wrapper.h hVar;
        if (C0963h2.a("com.yandex.metrica.rtm.client.ExceptionProcessor")) {
            try {
                hVar = new com.yandex.metrica.rtm.wrapper.h(new c(), context);
            } catch (Throwable unused) {
            }
        } else {
            hVar = null;
        }
        return hVar == null ? new Vg() : hVar;
    }

    public com.yandex.metrica.rtm.wrapper.d a(com.yandex.metrica.rtm.wrapper.k kVar, String str, boolean z) {
        com.yandex.metrica.rtm.wrapper.g gVar;
        if (C0963h2.a("com.yandex.metrica.rtm.client.ExceptionProcessor")) {
            try {
                gVar = new com.yandex.metrica.rtm.wrapper.g(kVar, str, z);
            } catch (Throwable unused) {
            }
        } else {
            gVar = null;
        }
        return gVar == null ? new Ug() : gVar;
    }
}
