package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

/* renamed from: npi.spay.ak, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1474ak implements Factory {
    public final Jc a;
    public final C1598fj b;

    public C1474ak(Jc jc, C1598fj c1598fj) {
        this.a = jc;
        this.b = c1598fj;
    }

    @Override // javax.inject.Provider
    public final Object get() throws SecurityException {
        Jc jc = this.a;
        Retrofit retrofit = (Retrofit) this.b.get();
        jc.getClass();
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        Object objCreate = retrofit.create(InterfaceC1536d7.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "retrofit.create(SdkFlowSPayApi::class.java)");
        return (InterfaceC1536d7) Preconditions.checkNotNullFromProvides((InterfaceC1536d7) objCreate);
    }
}
