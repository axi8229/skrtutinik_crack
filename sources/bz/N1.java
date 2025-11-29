package bz;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class N1 {
    public static HashSet a(Object... objArr) {
        HashSet hashSet = new HashSet(objArr.length);
        hashSet.addAll(Arrays.asList(objArr));
        return hashSet;
    }
}
