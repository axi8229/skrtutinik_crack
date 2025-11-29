package npi.spay;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import timber.log.Timber;

/* renamed from: npi.spay.x6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2033x6 implements InterfaceC2089zc {
    public boolean a;
    public boolean b;
    public boolean c;

    @Override // npi.spay.InterfaceC2089zc
    public final Object a(Pe pe) {
        if ((pe instanceof EnumC1908s6 ? (EnumC1908s6) pe : null) == null) {
            throw new La(String.valueOf(pe));
        }
        int iOrdinal = ((EnumC1908s6) pe).ordinal();
        if (iOrdinal == 0) {
            return Boolean.valueOf(this.a && this.b);
        }
        if (iOrdinal == 1) {
            return Boolean.valueOf(this.c);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BnplFeatureHandlerImpl(isBnplEnabledByMerch=");
        sb.append(this.a);
        sb.append(", isBnplEnabledByConfig=true, isBnplEnabledByBank=");
        sb.append(this.b);
        sb.append(", isBnplEnabledByUser=");
        return AbstractC1901s.a(sb, this.c, ')');
    }

    @Override // npi.spay.InterfaceC2089zc
    public final void a(Zd zd) {
        Unit unit = null;
        if ((zd instanceof AbstractC2008w6 ? (AbstractC2008w6) zd : null) != null) {
            AbstractC2008w6 abstractC2008w6 = (AbstractC2008w6) zd;
            if (abstractC2008w6 instanceof C1933t6) {
                this.b = abstractC2008w6.a();
            } else if (abstractC2008w6 instanceof C1958u6) {
                this.a = abstractC2008w6.a();
            } else if (abstractC2008w6 instanceof C1983v6) {
                this.c = abstractC2008w6.a();
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Timber.INSTANCE.e("Wrong argument: " + zd, new Object[0]);
        }
    }
}
