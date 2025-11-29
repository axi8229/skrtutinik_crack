package bz;

import dagger.internal.Preconditions;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class N {
    public final String a;
    public final Throwable b;
    public Class c;
    public final LinkedHashSet d;

    public N(Class cls, String str, Throwable th) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.d = linkedHashSet;
        this.a = (String) Preconditions.checkNotNull(str, "StartedThreadName is required");
        this.b = (Throwable) Preconditions.checkNotNull(th, "Stacktrace source is required");
        linkedHashSet.add(cls);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("\n\t| Dependency chain (started from thread - ");
        sb.append(this.a);
        sb.append(")\n\t| ");
        Iterator it = this.d.iterator();
        if (it.hasNext()) {
            Class cls = (Class) it.next();
            sb.append("\n\t| \t\t");
            sb.append(cls.getName());
        }
        while (it.hasNext()) {
            sb.append("\n\t| \t\t\t\tdepends on: ");
            sb.append(((Class) it.next()).getName());
        }
        if (this.c != null) {
            sb.append("\n\t| \t\t\t\tdepends on (cycle is here): ");
            sb.append(this.c.getName());
        }
        sb.append("\n\n\n\t| Stacktrace:\n");
        Throwable th = this.b;
        Preconditions.checkNotNull(th, "Not null throwable expected");
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        sb.append(stringWriter.toString());
        return sb.toString();
    }
}
