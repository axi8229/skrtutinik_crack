package com.yandex.metrica.impl.ob;

import com.huawei.hms.android.SystemUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.yandex.metrica.impl.ob.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1326w implements InterfaceC1062l2 {
    private final Set<Integer> a = new HashSet();
    private final Set<Integer> b = new HashSet();
    private volatile a c = a.UNKNOWN;
    private final Set<b> d = new CopyOnWriteArraySet();

    /* renamed from: com.yandex.metrica.impl.ob.w$a */
    public enum a {
        UNKNOWN(SystemUtils.UNKNOWN),
        BACKGROUND("background"),
        VISIBLE("visible");

        a(String str) {
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.w$b */
    public interface b {
        void a(a aVar);
    }

    private void d() {
        a aVar = a.UNKNOWN;
        if (!this.a.isEmpty()) {
            aVar = a.VISIBLE;
        } else if (!this.b.isEmpty()) {
            aVar = a.BACKGROUND;
        }
        if (this.c != aVar) {
            this.c = aVar;
            Iterator<b> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().a(this.c);
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
    public void a() {
        d();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
    public void b() {
        if (this.c == a.VISIBLE) {
            this.c = a.BACKGROUND;
        }
    }

    public a c() {
        return this.c;
    }

    public a a(b bVar) {
        this.d.add(bVar);
        return this.c;
    }

    public void c(int i) {
        this.a.add(Integer.valueOf(i));
        this.b.remove(Integer.valueOf(i));
        d();
    }

    public void b(int i) {
        this.b.add(Integer.valueOf(i));
        this.a.remove(Integer.valueOf(i));
        d();
    }

    public void a(int i) {
        this.a.remove(Integer.valueOf(i));
        d();
    }
}
