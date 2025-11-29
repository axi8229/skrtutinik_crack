package npi.spay;

import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import timber.log.Timber;

/* loaded from: classes4.dex */
public final class Cd implements InterfaceC2089zc {
    public final ArrayList a = new ArrayList();
    public String b = "";

    @Override // npi.spay.InterfaceC2089zc
    public final Object a(Pe pe) {
        Object objValueOf;
        if ((pe instanceof EnumC2065yd ? (EnumC2065yd) pe : null) != null) {
            int iOrdinal = ((EnumC2065yd) pe).ordinal();
            boolean z = true;
            if (iOrdinal == 0) {
                if ((this.a.isEmpty() || this.a.contains("2.2.4")) && !this.a.isEmpty()) {
                    z = false;
                }
                objValueOf = Boolean.valueOf(z);
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                objValueOf = this.b;
            }
            if (objValueOf != null) {
                return objValueOf;
            }
        }
        throw new La(String.valueOf(pe));
    }

    @Override // npi.spay.InterfaceC2089zc
    public final void a(Zd zd) {
        if ((zd instanceof Bd ? (Bd) zd : null) == null) {
            Timber.INSTANCE.e("Wrong argument: " + zd, new Object[0]);
            return;
        }
        Bd bd = (Bd) zd;
        if (bd instanceof C2090zd) {
            this.b = ((C2090zd) zd).b;
        } else {
            if (!(bd instanceof Ad)) {
                throw new NoWhenBranchMatchedException();
            }
            ArrayList arrayList = this.a;
            arrayList.clear();
            arrayList.addAll(((Ad) zd).b);
        }
    }
}
