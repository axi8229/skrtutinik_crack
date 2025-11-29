package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Bg {
    public static final Bg b = new Bg();

    @SuppressLint({"StaticFieldLeak"})
    private static final Map<String, Ag> a = new LinkedHashMap();

    private Bg() {
    }

    public final Map<String, Ag> a() {
        return a;
    }
}
