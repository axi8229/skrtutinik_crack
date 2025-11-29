package npi.spay;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: npi.spay.ua, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1962ua implements Factory {
    public final Provider a;

    public C1962ua(Factory factory) {
        this.a = factory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new F9((Context) this.a.get());
    }
}
