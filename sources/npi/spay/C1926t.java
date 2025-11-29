package npi.spay;

import timber.log.Timber;

/* renamed from: npi.spay.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1926t implements InterfaceC2089zc {
    public final boolean a = true;

    @Override // npi.spay.InterfaceC2089zc
    public final Object a(Pe pe) {
        return Boolean.valueOf(this.a);
    }

    public final String toString() {
        return AbstractC1901s.a(new StringBuilder("HelperCreditCardFeatureHandlerImpl(isHelperCreditCardEnabledByConfig="), this.a, ')');
    }

    @Override // npi.spay.InterfaceC2089zc
    public final void a(Zd zd) {
        Timber.INSTANCE.e("Wrong argument: " + zd, new Object[0]);
    }
}
