package ru.yoomoney.sdk.auth.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toTimeString", "", "", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NumberExtensionsKt {
    public static final String toTimeString(long j) {
        if (j >= 10) {
            return String.valueOf(j);
        }
        return "0" + j;
    }
}
