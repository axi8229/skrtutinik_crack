package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.content.Context;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.impl.ob.C1183q;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.a0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0786a0 {
    private Context a;
    private final C1183q.b b;
    private final C1183q c;
    private final IReporter d;

    /* renamed from: com.yandex.metrica.impl.ob.a0$a */
    static final class a implements C1183q.b {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.C1183q.b
        public final void a(Activity activity, C1183q.a aVar) {
            int iOrdinal = aVar.ordinal();
            if (iOrdinal == 1) {
                C0786a0.this.d.resumeSession();
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                C0786a0.this.d.pauseSession();
            }
        }
    }

    public C0786a0(C1183q c1183q) {
        this(c1183q, null, 2);
    }

    public C0786a0(C1183q c1183q, IReporter iReporter) {
        this.c = c1183q;
        this.d = iReporter;
        this.b = new a();
    }

    public final synchronized void a(Context context) {
        if (this.a == null) {
            Context applicationContext = context.getApplicationContext();
            this.c.a(applicationContext);
            this.c.a(this.b, C1183q.a.RESUMED, C1183q.a.PAUSED);
            this.a = applicationContext;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C0786a0(C1183q c1183q, IReporter iReporter, int i) {
        M0 m0A;
        if ((i & 2) != 0) {
            m0A = C1152oh.a();
            Intrinsics.checkNotNullExpressionValue(m0A, "YandexMetricaSelfReportFacade.getReporter()");
        } else {
            m0A = null;
        }
        this(c1183q, m0A);
    }
}
