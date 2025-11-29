package com.google.crypto.tink.internal;

import android.os.Build;

/* loaded from: classes2.dex */
final class BuildDispatchedCode {
    private BuildDispatchedCode() {
    }

    public static Integer getApiLevel() {
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }
}
