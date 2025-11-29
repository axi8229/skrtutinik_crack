package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Ak implements Bk {
    public final CharSequence a;

    public Ak(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.a = text;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Ak) && Intrinsics.areEqual(this.a, ((Ak) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Text(text=" + ((Object) this.a) + ')';
    }
}
