package npi.spay;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* renamed from: npi.spay.s1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1903s1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((H9) obj2).a), Integer.valueOf(((H9) obj).a));
    }
}
