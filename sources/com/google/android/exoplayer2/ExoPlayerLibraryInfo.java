package com.google.android.exoplayer2;

import java.util.HashSet;

/* loaded from: classes2.dex */
public final class ExoPlayerLibraryInfo {
    private static final HashSet<String> registeredModules = new HashSet<>();
    private static String registeredModulesString = "goog.exo.core";

    public static synchronized String registeredModules() {
        return registeredModulesString;
    }

    public static synchronized void registerModule(String name) {
        if (registeredModules.add(name)) {
            registeredModulesString += ", " + name;
        }
    }
}
