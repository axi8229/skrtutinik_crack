package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public final class LibraryLoader {
    private boolean isAvailable;
    private boolean loadAttempted;
    private String[] nativeLibraries;
    private String lastLoadLib = "";
    private UnsatisfiedLinkError lastError = null;

    public LibraryLoader(String... libraries) {
        this.nativeLibraries = libraries;
    }

    public synchronized boolean isAvailable() {
        if (this.loadAttempted) {
            return this.isAvailable;
        }
        this.loadAttempted = true;
        try {
            for (String str : this.nativeLibraries) {
                this.lastLoadLib = str;
                System.loadLibrary(str);
            }
            this.lastLoadLib = "";
            this.isAvailable = true;
        } catch (UnsatisfiedLinkError e) {
            Log.e("LibraryLoader", String.format("Failed to load native library: %s", this.lastLoadLib), e);
            this.lastError = e;
        }
        return this.isAvailable;
    }
}
