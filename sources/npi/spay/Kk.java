package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.PluginExceptionsKt;

/* loaded from: classes4.dex */
public final class Kk {
    public final String a;
    public final String b;

    public /* synthetic */ Kk(int i, String str, String str2) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, Jk.a.getDescriptor());
        }
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Kk)) {
            return false;
        }
        Kk kk = (Kk) obj;
        return Intrinsics.areEqual(this.a, kk.a) && Intrinsics.areEqual(this.b, kk.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventProperty(key=");
        sb.append(this.a);
        sb.append(", value=");
        return Q1.a(sb, this.b, ')');
    }

    public Kk(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.a = key;
        this.b = value;
    }
}
