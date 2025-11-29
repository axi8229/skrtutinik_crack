package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.Eg;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.gd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0949gd extends Eg {
    private final C1097mc m;

    /* renamed from: com.yandex.metrica.impl.ob.gd$b */
    public static class b {
        public final C1178pi a;
        public final C1097mc b;

        public b(C1178pi c1178pi, C1097mc c1097mc) {
            this.a = c1178pi;
            this.b = c1097mc;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.gd$c */
    public static class c implements Eg.d<C0949gd, b> {
        private final Context a;
        private final Cg b;

        c(Context context, Cg cg) {
            this.a = context;
            this.b = cg;
        }

        @Override // com.yandex.metrica.impl.ob.Eg.d
        public C0949gd a(b bVar) {
            C0949gd c0949gd = new C0949gd(bVar.b);
            Cg cg = this.b;
            Context context = this.a;
            cg.getClass();
            c0949gd.b(A2.a(context, context.getPackageName()));
            Cg cg2 = this.b;
            Context context2 = this.a;
            cg2.getClass();
            c0949gd.a(String.valueOf(A2.b(context2, context2.getPackageName())));
            c0949gd.a(bVar.a);
            c0949gd.a(U.a());
            c0949gd.a(F0.g().n().a());
            c0949gd.e(this.a.getPackageName());
            c0949gd.a(F0.g().r().a(this.a));
            c0949gd.a(F0.g().a().a());
            return c0949gd;
        }
    }

    public List<String> A() {
        return v().x();
    }

    @Override // com.yandex.metrica.impl.ob.Eg
    public String toString() {
        return "RequestConfig{mSuitableCollectionConfig=" + this.m + "} " + super.toString();
    }

    public C1097mc z() {
        return this.m;
    }

    private C0949gd(C1097mc c1097mc) {
        this.m = c1097mc;
    }
}
