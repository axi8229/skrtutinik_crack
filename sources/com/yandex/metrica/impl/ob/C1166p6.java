package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.coreutils.io.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.p6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1166p6 implements InterfaceC1141o6 {
    private final List<InterfaceC1107mm<String>> a;
    private final C1334w7 b;
    private final InterfaceC1107mm<String> c;

    /* renamed from: com.yandex.metrica.impl.ob.p6$a */
    class a implements InterfaceC1107mm<String> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(String str) {
            C1166p6.a(C1166p6.this, str);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C1166p6(Context context) {
        String str;
        String strA = C0810b.a(context);
        File storageDirectory = FileUtils.getStorageDirectory(context);
        if (storageDirectory == null) {
            str = null;
        } else {
            str = storageDirectory.getAbsolutePath() + "/appmetrica_native_crashes";
        }
        this(new C1334w7(strA, str));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1141o6
    public synchronized void a(InterfaceC1107mm<String> interfaceC1107mm) {
        this.a.add(interfaceC1107mm);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1141o6
    public synchronized void b(InterfaceC1107mm<String> interfaceC1107mm) {
        this.a.remove(interfaceC1107mm);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
    public void a() {
        this.b.a(this.c);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
    public void b() {
        this.b.b(this.c);
    }

    static void a(C1166p6 c1166p6, String str) {
        ArrayList arrayList;
        synchronized (c1166p6) {
            arrayList = new ArrayList(c1166p6.a);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC1107mm) it.next()).b(str);
        }
    }

    C1166p6(C1334w7 c1334w7) {
        this.a = new ArrayList();
        this.c = new a();
        this.b = c1334w7;
    }
}
