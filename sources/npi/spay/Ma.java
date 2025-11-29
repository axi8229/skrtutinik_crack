package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ma implements InterfaceC2020wi {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public Ma(String header, String text, String deeplink, String iconUrl, String type) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = header;
        this.b = text;
        this.c = deeplink;
        this.d = iconUrl;
        this.e = type;
    }

    @Override // npi.spay.InterfaceC2020wi
    public final String a() {
        return this.e;
    }

    @Override // npi.spay.InterfaceC2020wi
    public final String b() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ma)) {
            return false;
        }
        Ma ma = (Ma) obj;
        return Intrinsics.areEqual(this.a, ma.a) && Intrinsics.areEqual(this.b, ma.b) && Intrinsics.areEqual(this.c, ma.c) && Intrinsics.areEqual(this.d, ma.d) && Intrinsics.areEqual(this.e, ma.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + AbstractC1553e.a(this.d, AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SingleHelperBannerItem(header=");
        sb.append(this.a);
        sb.append(", text=");
        sb.append(this.b);
        sb.append(", deeplink=");
        sb.append(this.c);
        sb.append(", iconUrl=");
        sb.append(this.d);
        sb.append(", type=");
        return Q1.a(sb, this.e, ')');
    }
}
