package bz;

import android.content.Context;
import android.content.ContextWrapper;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Collections;
import javax.inject.Provider;

/* renamed from: bz.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0505d extends ContextWrapper implements Q {
    public final DoubleCheck a;
    public final B b;

    public C0505d(Context context) {
        super(context);
        this.a = (DoubleCheck) DoubleCheck.provider(new Provider() { // from class: bz.d$$ExternalSyntheticLambda0
            @Override // javax.inject.Provider
            public final Object get() {
                return this.f$0.a();
            }
        });
        this.b = b();
    }

    public final C0520i a() {
        C0505d c0505d = (C0505d) Preconditions.checkNotNull(this);
        Preconditions.checkBuilderRequirement(c0505d, C0505d.class);
        return new C0520i(new C0527k0(c0505d));
    }

    public final B b() {
        C0520i c0520i = (C0520i) this.a.get();
        B b = (B) ((C0527k0) c0520i.a).e.get();
        b.a.putAll(Collections.singletonMap(InterfaceC0523j.class, c0520i));
        return b;
    }
}
