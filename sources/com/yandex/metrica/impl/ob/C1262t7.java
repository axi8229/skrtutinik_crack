package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.text.TextUtils;
import com.yandex.metrica.impl.ac.CrashpadServiceHelper;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.yandex.metrica.impl.ob.t7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1262t7 implements InterfaceC0893e7<String> {
    private final C1310v7 a;
    private final InterfaceC1132nm<String, Bundle> b;
    private final Callable<List<Bundle>> c;
    private final InterfaceC1107mm<String> d;
    private final C1238s7 e;

    /* renamed from: com.yandex.metrica.impl.ob.t7$a */
    class a implements InterfaceC1132nm<String, Bundle> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
        public Bundle a(String str) {
            return CrashpadServiceHelper.readCrash(str);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.t7$b */
    class b implements Callable<List<Bundle>> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        public List<Bundle> call() throws Exception {
            return CrashpadServiceHelper.readOldCrashes();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.t7$c */
    class c implements InterfaceC1107mm<String> {
        c() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(String str) {
            CrashpadServiceHelper.a(str);
        }
    }

    public C1262t7(C1310v7 c1310v7) {
        this(c1310v7, new C1238s7(), new a(), new b(), new c());
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0893e7
    public void a(String str) {
        Bundle bundleA;
        String str2 = str;
        try {
            bundleA = this.b.a(str2);
        } catch (Throwable unused) {
        }
        C1214r7 c1214r7A = bundleA != null ? this.e.a(str2, bundleA) : null;
        if (c1214r7A != null) {
            this.a.a2(c1214r7A);
        } else {
            this.d.b(str2);
        }
    }

    public C1262t7(C1310v7 c1310v7, C1238s7 c1238s7, InterfaceC1132nm<String, Bundle> interfaceC1132nm, Callable<List<Bundle>> callable, InterfaceC1107mm<String> interfaceC1107mm) {
        this.a = c1310v7;
        this.e = c1238s7;
        this.b = interfaceC1132nm;
        this.c = callable;
        this.d = interfaceC1107mm;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0893e7
    public void a() {
        try {
            for (Bundle bundle : this.c.call()) {
                String string = bundle.getString("arg_ui");
                if (!TextUtils.isEmpty(string)) {
                    C1214r7 c1214r7A = this.e.a(string, bundle);
                    if (c1214r7A != null) {
                        this.a.b2(c1214r7A);
                    } else {
                        this.d.b(string);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
