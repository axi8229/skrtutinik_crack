package zone.bi.mobile.fingerprint.api;

import java.util.Comparator;

/* loaded from: classes5.dex */
public final class e implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((f) obj).ordinal(), ((f) obj2).ordinal());
    }
}
