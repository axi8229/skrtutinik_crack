package com.sputnik.common;

import kotlin.Metadata;

/* compiled from: GlobalVariables.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"parseBlockingLevel", "Lcom/sputnik/common/BlockingLevel;", "level", "", "(Ljava/lang/Integer;)Lcom/sputnik/common/BlockingLevel;", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GlobalVariablesKt {
    public static final BlockingLevel parseBlockingLevel(Integer num) {
        if (num == null) {
            return BlockingLevel.NONE;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            return BlockingLevel.NONE;
        }
        if (1 <= iIntValue && iIntValue < 51) {
            return BlockingLevel.PARTIAL;
        }
        if (51 <= iIntValue && iIntValue <= Integer.MAX_VALUE) {
            return BlockingLevel.FULL;
        }
        return BlockingLevel.NONE;
    }
}
