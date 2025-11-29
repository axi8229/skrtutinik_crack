package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.impl.ob.InterfaceC0921fa;
import com.yandex.metrica.networktasks.api.CacheControlHttpsConnectionPerformer;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.bh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0828bh {
    private ICommonExecutor a;
    private final ProtobufStateStorage b;
    private b c;
    private C1312v9 d;
    private final CacheControlHttpsConnectionPerformer e;
    private final SystemTimeProvider f;
    private final C1148od g;
    private String h;

    /* renamed from: com.yandex.metrica.impl.ob.bh$a */
    class a implements Runnable {
        final /* synthetic */ C0803ah a;

        a(C0803ah c0803ah) {
            this.a = c0803ah;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0828bh c0828bh = C0828bh.this;
            C0828bh.a(c0828bh, this.a, c0828bh.h);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.bh$b */
    public static class b {
        private final C1002ih a;

        public b() {
            this(new C1002ih());
        }

        public List<C0978hh> a(byte[] bArr) {
            ArrayList arrayList = new ArrayList();
            if (A2.a(bArr)) {
                return arrayList;
            }
            try {
                return this.a.a(new String(bArr, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                return arrayList;
            }
        }

        b(C1002ih c1002ih) {
            this.a = c1002ih;
        }
    }

    public C0828bh(Context context, String str, ICommonExecutor iCommonExecutor) {
        ProtobufStateStorage protobufStateStorageA = InterfaceC0921fa.b.a(C0903eh.class).a(context);
        b bVar = new b();
        F0.g().t().getClass();
        this(null, protobufStateStorageA, bVar, new CacheControlHttpsConnectionPerformer(null), iCommonExecutor, new C1312v9(), new SystemTimeProvider(), new C1148od(context));
    }

    public void a(C0803ah c0803ah) {
        this.a.execute(new a(c0803ah));
    }

    public boolean b(C1178pi c1178pi) {
        return this.h == null ? c1178pi.L() != null : !r0.equals(c1178pi.L());
    }

    static void a(C0828bh c0828bh, C0803ah c0803ah, String str) {
        if (!c0828bh.g.canBeExecuted() || str == null) {
            return;
        }
        c0828bh.e.performConnection(str, new C0853ch(c0828bh, (C0903eh) c0828bh.b.read(), c0803ah));
    }

    C0828bh(String str, ProtobufStateStorage protobufStateStorage, b bVar, CacheControlHttpsConnectionPerformer cacheControlHttpsConnectionPerformer, ICommonExecutor iCommonExecutor, C1312v9 c1312v9, SystemTimeProvider systemTimeProvider, C1148od c1148od) {
        this.h = str;
        this.b = protobufStateStorage;
        this.c = bVar;
        this.e = cacheControlHttpsConnectionPerformer;
        this.a = iCommonExecutor;
        this.d = c1312v9;
        this.f = systemTimeProvider;
        this.g = c1148od;
    }

    public void a(C1178pi c1178pi) {
        if (c1178pi != null) {
            this.h = c1178pi.L();
        }
    }
}
