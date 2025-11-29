package bz;

import androidx.core.util.Pair;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class K extends AbstractC0538n1 {
    public static final String d = AbstractC0569y0.a(new byte[]{-7, -16, -105, 48, 73, -76, -81, 82, 26, 73, -1, -121, -90, 26, -113, 66});
    public static final String e = AbstractC0569y0.a(new byte[]{73, 37, -73, 69, -12, 97, 94, 60, 121, -85, 4, -114, 12, 14, -5, 26});
    public final InterfaceC0531l1 c;

    public K(W1 w1) {
        super(zone.bi.mobile.fingerprint.api.f.ShareScreenInfo);
        this.c = w1;
    }

    @Override // bz.AbstractC0538n1
    public final Serializable i() {
        return h();
    }

    @Override // bz.AbstractC0538n1
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final zone.bi.mobile.fingerprint.api.serialize.model.a h() {
        zone.bi.mobile.fingerprint.api.serialize.model.a aVar = new zone.bi.mobile.fingerprint.api.serialize.model.a();
        if (((W1) this.c).b()) {
            for (int i = 0; i < ((W1) this.c).a().size(); i++) {
                zone.bi.mobile.fingerprint.api.serialize.model.a aVar2 = new zone.bi.mobile.fingerprint.api.serialize.model.a();
                aVar2.put(d, (Serializable) ((Pair) ((W1) this.c).a().get(i)).first);
                aVar2.put(e, (Serializable) ((Pair) ((W1) this.c).a().get(i)).second);
                aVar.put(String.valueOf(i), aVar2);
            }
        }
        return aVar;
    }
}
