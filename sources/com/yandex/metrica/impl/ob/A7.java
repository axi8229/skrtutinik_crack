package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ac.CrashpadHelper;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class A7 implements InterfaceC1042k7 {
    private final Context a;
    private final A3 b;
    private C1382y7 c;
    private final InterfaceC1107mm<Bundle> d;
    private final E7 e;
    private final I7 f;
    private final InterfaceC1132nm<Void, String> g;

    class a implements InterfaceC1107mm<Bundle> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(Bundle bundle) {
            CrashpadHelper.setUpNativeUncaughtExceptionHandler(bundle);
        }
    }

    class b implements InterfaceC1132nm<Void, String> {
        b() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
        public String a(Void r1) {
            return CrashpadHelper.getLibraryVersion();
        }
    }

    public A7(Context context, A3 a3) {
        this(context, a3, new B0(), new a());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public String a() {
        return "appmetrica_native_crashes";
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public void a(String str, String str2, String str3) {
        C7 c7B = this.c.b();
        if (c7B != null) {
            if (TextUtils.isEmpty(c7B.a) && c7B.d == null) {
                return;
            }
            this.f.a(str3);
            String strEncodeToString = null;
            this.f.b(this.g.a(null));
            InterfaceC1107mm<Bundle> interfaceC1107mm = this.d;
            String strA = this.f.a();
            Bundle bundle = new Bundle();
            E7 e7 = this.e;
            A3 a3 = this.b;
            e7.getClass();
            try {
                strEncodeToString = Base64.encodeToString(new JSONObject().put("arg_cd", new JSONObject().put("arg_ak", str).put("arg_pn", a3.f()).put("arg_pd", a3.g()).put("arg_ps", a3.h()).put("arg_rt", CounterConfiguration.b.MAIN.a())).toString().getBytes(), 0);
            } catch (Throwable unused) {
            }
            bundle.putString("arg_cd", strEncodeToString);
            bundle.putString("arg_rc", strA);
            bundle.putString("arg_dd", str2);
            bundle.putString("arg_hp", c7B.a);
            bundle.putBoolean("arg_i64", c7B.b);
            bundle.putBoolean("arg_ul", c7B.c);
            bundle.putString("arg_sn", this.a.getPackageName() + "-crashpad_new_crash_socket");
            if (c7B.d == null) {
                bundle.putBoolean("arg_ap", false);
            } else {
                bundle.putBoolean("arg_ap", true);
                Objects.requireNonNull(c7B.d);
                bundle.putString("arg_mc", "com.yandex.metrica.impl.ac.HandlerRunner");
                bundle.putString("arg_akp", c7B.d.a);
                bundle.putString("arg_lp", c7B.d.b);
                bundle.putString("arg_dp", c7B.d.c);
            }
            interfaceC1107mm.b(bundle);
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public void b() {
        CrashpadHelper.cancelSetUpNativeUncaughtExceptionHandler();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public String c() {
        return "appmetrica-native";
    }

    private A7(Context context, A3 a3, B0 b0, InterfaceC1107mm<Bundle> interfaceC1107mm) {
        this(context, a3, new C1382y7(context, b0, P.g().d().b()), interfaceC1107mm, new E7(), new I7(), new b());
    }

    A7(Context context, A3 a3, C1382y7 c1382y7, InterfaceC1107mm<Bundle> interfaceC1107mm, E7 e7, I7 i7, InterfaceC1132nm<Void, String> interfaceC1132nm) {
        this.a = context;
        this.b = a3;
        this.c = c1382y7;
        this.d = interfaceC1107mm;
        this.e = e7;
        this.f = i7;
        this.g = interfaceC1132nm;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public void a(boolean z) {
        CrashpadHelper.logsEnabled(z);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1042k7
    public void a(String str) {
        this.f.a(str);
        CrashpadHelper.updateRuntimeConfig(this.f.a());
    }
}
