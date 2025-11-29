package bz;

import dagger.internal.Factory;
import dagger.internal.MapFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

/* renamed from: bz.u1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0558u1 implements Factory {
    public final Provider a;

    public C0558u1(MapFactory mapFactory) {
        this.a = mapFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return (B) Preconditions.checkNotNull(new B((Map) this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
