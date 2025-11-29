package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.b3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0814b3 implements InterfaceC1084m {
    private final S3 a;
    private final ICommonExecutor b;

    /* renamed from: com.yandex.metrica.impl.ob.b3$a */
    class a extends AbstractRunnableC0908em {
        final /* synthetic */ com.yandex.metrica.billing_interface.d a;

        a(com.yandex.metrica.billing_interface.d dVar) {
            this.a = dVar;
        }

        @Override // com.yandex.metrica.impl.ob.AbstractRunnableC0908em
        public void a() throws Exception {
            S3 s3 = C0814b3.this.a;
            C0814b3 c0814b3 = C0814b3.this;
            com.yandex.metrica.billing_interface.d dVar = this.a;
            c0814b3.getClass();
            s3.a(C0836c0.a().a(new C0964h3(dVar).a()));
        }
    }

    public C0814b3(S3 s3, ICommonExecutor iCommonExecutor) {
        this.a = s3;
        this.b = iCommonExecutor;
    }

    public void a(List<com.yandex.metrica.billing_interface.d> list) {
        Iterator<com.yandex.metrica.billing_interface.d> it = list.iterator();
        while (it.hasNext()) {
            this.b.execute(new a(it.next()));
        }
    }
}
