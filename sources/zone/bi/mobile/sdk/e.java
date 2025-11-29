package zone.bi.mobile.sdk;

import android.content.Context;
import bz.C0527k0;
import bz.InterfaceC0523j;
import bz.O0;
import bz.Q;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class e extends d {
    public final c c;
    public final b d;
    public final DoubleCheck e;

    public e(Context context, c cVar, b bVar) {
        super(context);
        this.e = (DoubleCheck) DoubleCheck.provider(new Provider() { // from class: zone.bi.mobile.sdk.e$$ExternalSyntheticLambda0
            @Override // javax.inject.Provider
            public final Object get() {
                return this.f$0.a();
            }
        });
        this.c = cVar;
        this.d = bVar;
    }

    public final O0 a() {
        C0527k0 c0527k0 = (C0527k0) ((InterfaceC0523j) this.a.b.a(InterfaceC0523j.class));
        return new O0((Q) c0527k0.c.get(), this.c, this.d);
    }
}
