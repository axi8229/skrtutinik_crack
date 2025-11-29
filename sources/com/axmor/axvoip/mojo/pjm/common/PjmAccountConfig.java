package com.axmor.axvoip.mojo.pjm.common;

import lombok.NonNull;

/* loaded from: classes.dex */
public final class PjmAccountConfig {
    public static String formatIdUri(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("user is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("host is marked non-null but is null");
        }
        return String.format("sip:%1$s@%2$s", str, str2);
    }

    public static String formatIdUri(String str, String str2, int i) {
        return String.format("sip:%1$s@%2$s:%3$s", str, str2, Integer.valueOf(i));
    }

    public static String formatRegistrarUri(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("host is marked non-null but is null");
        }
        return String.format("sip:%1$s", str);
    }

    public static String formatRegistrarUri(@NonNull String str, int i) {
        if (str == null) {
            throw new NullPointerException("host is marked non-null but is null");
        }
        return String.format("sip:%1$s:%2$s", str, Integer.valueOf(i));
    }
}
