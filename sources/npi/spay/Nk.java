package npi.spay;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes4.dex */
public final class Nk extends AbstractC1489ba {
    public final InterfaceC2073yl a;
    public final Ih b;
    public final Ei c;
    public final InterfaceC1495bg d;
    public final C1993vg e;
    public final C1612g8 f;
    public int g;

    public Nk(Ih sPayDataContract, InterfaceC1495bg sPaySdkReducer, InterfaceC2073yl sPayRepository, Ei sPayStorage, C1612g8 fraudMonResultHandler, C1993vg featuresHandler) {
        Intrinsics.checkNotNullParameter(sPayRepository, "sPayRepository");
        Intrinsics.checkNotNullParameter(sPayDataContract, "sPayDataContract");
        Intrinsics.checkNotNullParameter(sPayStorage, "sPayStorage");
        Intrinsics.checkNotNullParameter(sPaySdkReducer, "sPaySdkReducer");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        Intrinsics.checkNotNullParameter(fraudMonResultHandler, "fraudMonResultHandler");
        this.a = sPayRepository;
        this.b = sPayDataContract;
        this.c = sPayStorage;
        this.d = sPaySdkReducer;
        this.e = featuresHandler;
        this.f = fraudMonResultHandler;
    }

    @Override // npi.spay.AbstractC1489ba
    public final Object a(Object obj, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(coroutineDispatcher.plus(SupervisorKt.SupervisorJob$default(null, 1, null)), new C1498bj(this, (C1849pl) obj, coroutineDispatcher, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Nk)) {
            return false;
        }
        Nk nk = (Nk) obj;
        return Intrinsics.areEqual(this.a, nk.a) && Intrinsics.areEqual(this.b, nk.b) && Intrinsics.areEqual(this.c, nk.c) && Intrinsics.areEqual(this.d, nk.d) && Intrinsics.areEqual(this.e, nk.e) && Intrinsics.areEqual(this.f, nk.f);
    }

    public final int hashCode() {
        return this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "GetPayOnlineUseCase(sPayRepository=" + this.a + ", sPayDataContract=" + this.b + ", sPayStorage=" + this.c + ", sPaySdkReducer=" + this.d + ", featuresHandler=" + this.e + ", fraudMonResultHandler=" + this.f + ')';
    }
}
