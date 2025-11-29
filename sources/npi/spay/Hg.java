package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import org.jsoup.nodes.Document;

/* loaded from: classes4.dex */
public final class Hg {
    public final Document a;

    public Hg(Document content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.a = content;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Hg) && Intrinsics.areEqual(this.a, ((Hg) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "HtmlPage(content=" + this.a + ')';
    }
}
