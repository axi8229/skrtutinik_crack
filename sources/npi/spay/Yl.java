package npi.spay;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.PluginExceptionsKt;

/* loaded from: classes4.dex */
public final class Yl {
    public final C2001w a;
    public final C1747lj b;
    public final List c;

    public /* synthetic */ Yl(int i, C2001w c2001w, C1747lj c1747lj, List list) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, Xl.a.getDescriptor());
        }
        this.a = c2001w;
        this.b = c1747lj;
        this.c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Yl)) {
            return false;
        }
        Yl yl = (Yl) obj;
        return Intrinsics.areEqual(this.a, yl.a) && Intrinsics.areEqual(this.b, yl.b) && Intrinsics.areEqual(this.c, yl.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventsPackage(meta=");
        sb.append(this.a);
        sb.append(", profile=");
        sb.append(this.b);
        sb.append(", data=");
        return U0.a(sb, this.c, ')');
    }

    public Yl(C2001w meta, C1747lj profile, List data) {
        Intrinsics.checkNotNullParameter(meta, "meta");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = meta;
        this.b = profile;
        this.c = data;
    }
}
