package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ac.CrashpadServiceHelper;
import java.io.File;

/* renamed from: com.yandex.metrica.impl.ob.v7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1310v7 implements InterfaceC0918f7<C1214r7> {
    private final L1 a;

    /* renamed from: com.yandex.metrica.impl.ob.v7$a */
    class a implements InterfaceC1132nm<String, C0836c0> {
        final /* synthetic */ C1214r7 a;

        a(C1310v7 c1310v7, C1214r7 c1214r7) {
            this.a = c1214r7;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
        public C0836c0 a(String str) {
            return C1399z0.a(str, Ul.b(this.a.b.a())).c(this.a.c.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.v7$b */
    class b implements InterfaceC1132nm<String, C0836c0> {
        final /* synthetic */ C1214r7 a;

        b(C1310v7 c1310v7, C1214r7 c1214r7) {
            this.a = c1214r7;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
        public C0836c0 a(String str) {
            return C1399z0.b(str, Ul.b(this.a.b.a())).c(this.a.c.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.v7$c */
    public static class c implements InterfaceC1107mm<File> {
        private final String a;

        public c(String str) {
            this.a = str;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(File file) {
            CrashpadServiceHelper.a(this.a);
        }
    }

    public C1310v7(L1 l1) {
        this.a = l1;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0918f7
    public void a(C1214r7 c1214r7) {
        C1214r7 c1214r72 = c1214r7;
        this.a.a(c1214r72, new b(this, c1214r72));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0918f7
    public void b(C1214r7 c1214r7) {
        C1214r7 c1214r72 = c1214r7;
        this.a.a(c1214r72, new a(this, c1214r72));
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(C1214r7 c1214r7) {
        this.a.a(c1214r7, new a(this, c1214r7));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    public void b2(C1214r7 c1214r7) {
        this.a.a(c1214r7, new b(this, c1214r7));
    }
}
