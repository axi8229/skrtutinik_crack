package com.google.common.primitives;

import com.google.common.base.Preconditions;

/* loaded from: classes2.dex */
public final class Ints extends IntsMethodsForWeb {
    public static int constrainToRange(int i, int i2, int i3) {
        Preconditions.checkArgument(i2 <= i3, "min (%s) must be less than or equal to max (%s)", i2, i3);
        return Math.min(Math.max(i, i2), i3);
    }
}
