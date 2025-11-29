package npi.spay;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class B4 {
    public final String a;
    public final List b;
    public final List c;

    public B4(String resultString, List links, List substringIndexes) {
        Intrinsics.checkNotNullParameter(resultString, "resultString");
        Intrinsics.checkNotNullParameter(links, "links");
        Intrinsics.checkNotNullParameter(substringIndexes, "substringIndexes");
        this.a = resultString;
        this.b = links;
        this.c = substringIndexes;
    }

    public static B4 a(B4 b4, String resultString, List links, List substringIndexes, int i) {
        if ((i & 1) != 0) {
            resultString = b4.a;
        }
        if ((i & 2) != 0) {
            links = b4.b;
        }
        if ((i & 4) != 0) {
            substringIndexes = b4.c;
        }
        b4.getClass();
        Intrinsics.checkNotNullParameter(resultString, "resultString");
        Intrinsics.checkNotNullParameter(links, "links");
        Intrinsics.checkNotNullParameter(substringIndexes, "substringIndexes");
        return new B4(resultString, links, substringIndexes);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B4)) {
            return false;
        }
        B4 b4 = (B4) obj;
        return Intrinsics.areEqual(this.a, b4.a) && Intrinsics.areEqual(this.b, b4.b) && Intrinsics.areEqual(this.c, b4.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParsedStringData(resultString=");
        sb.append(this.a);
        sb.append(", links=");
        sb.append(this.b);
        sb.append(", substringIndexes=");
        return U0.a(sb, this.c, ')');
    }
}
