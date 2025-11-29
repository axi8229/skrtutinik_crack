package npi.spay;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.e6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1560e6 {
    public final InterfaceC1852q a;
    public final EnumC1877r0 b;
    public final C0 c;
    public final Map d;
    public final Integer e;
    public final String f;
    public final String g;

    public C1560e6(InterfaceC1852q action, EnumC1877r0 view, C0 actionType, Map map, Integer num, String str, String str2) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        this.a = action;
        this.b = view;
        this.c = actionType;
        this.d = map;
        this.e = num;
        this.f = str;
        this.g = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1560e6)) {
            return false;
        }
        C1560e6 c1560e6 = (C1560e6) obj;
        return Intrinsics.areEqual(this.a, c1560e6.a) && this.b == c1560e6.b && this.c == c1560e6.c && Intrinsics.areEqual(this.d, c1560e6.d) && Intrinsics.areEqual(this.e, c1560e6.e) && Intrinsics.areEqual(this.f, c1560e6.f) && Intrinsics.areEqual(this.g, c1560e6.g);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        Map map = this.d;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        Integer num = this.e;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.f;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MetricEvent(action=");
        sb.append(this.a);
        sb.append(", view=");
        sb.append(this.b);
        sb.append(", actionType=");
        sb.append(this.c);
        sb.append(", actionParams=");
        sb.append(this.d);
        sb.append(", httpCode=");
        sb.append(this.e);
        sb.append(", errorCode=");
        sb.append(this.f);
        sb.append(", parsingError=");
        return Q1.a(sb, this.g, ')');
    }

    public /* synthetic */ C1560e6(InterfaceC1852q interfaceC1852q, EnumC1877r0 enumC1877r0, C0 c0, Map map, Integer num, String str, String str2, int i) {
        this(interfaceC1852q, (i & 2) != 0 ? EnumC1877r0.NONE : enumC1877r0, c0, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str, (i & 64) != 0 ? null : str2);
    }
}
