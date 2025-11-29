package com.google.common.collect;

/* loaded from: classes2.dex */
public final class Collections2 {
    static StringBuilder newStringBuilderForCollection(int i) {
        CollectPreconditions.checkNonnegative(i, "size");
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }
}
