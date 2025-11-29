package npi.spay;

import kotlin.Unit;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class Wd implements InterfaceC2089zc {
    public boolean a = true;

    @Override // npi.spay.InterfaceC2089zc
    public final Object a(Pe pe) {
        return Boolean.valueOf(this.a);
    }

    public final String toString() {
        return AbstractC1901s.a(new StringBuilder("CompoundWalletFeatureImpl(isCompoundWalletEnabledByConfig="), this.a, ')');
    }

    @Override // npi.spay.InterfaceC2089zc
    public final void a(Zd zd) {
        Unit unit = null;
        if ((zd instanceof Vd ? (Vd) zd : null) != null) {
            this.a = true;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Timber.INSTANCE.e("Wrong argument: " + zd, new Object[0]);
        }
    }
}
