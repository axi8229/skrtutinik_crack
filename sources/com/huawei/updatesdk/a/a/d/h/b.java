package com.huawei.updatesdk.a.a.d.h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes3.dex */
public class b extends com.huawei.updatesdk.a.b.c.c.b {
    private String abis_;
    private String deviceFeatures_;
    private int dpi_;
    private String preferLan_;

    /* renamed from: com.huawei.updatesdk.a.a.d.h.b$b, reason: collision with other inner class name */
    public static class C0103b {
        private final Context a;
        private boolean b;
        private Set<String> c;
        private String[] d;
        private boolean e;

        public C0103b(Context context) {
            this.a = context;
        }

        private String b() {
            ArrayList arrayList = new ArrayList(c.d(this.a));
            Set<String> set = this.c;
            if (set != null) {
                for (String str : set) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                    }
                }
            }
            return this.e ? com.huawei.updatesdk.a.a.d.e.a(c.a(arrayList, this.d), ",") : com.huawei.updatesdk.a.a.d.e.a(arrayList, ",");
        }

        public C0103b a(boolean z) {
            this.b = z;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.abis_ = com.huawei.updatesdk.a.a.d.e.a(c.f(), ",");
            bVar.dpi_ = Integer.parseInt(c.f(this.a));
            bVar.preferLan_ = b();
            if (this.b) {
                bVar.deviceFeatures_ = c.a(this.a);
            }
            return bVar;
        }
    }

    private b() {
    }
}
