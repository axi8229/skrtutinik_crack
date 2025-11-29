package org.apache.commons.compress.archivers.sevenz;

/* loaded from: classes4.dex */
public class SevenZFileOptions {
    public static final SevenZFileOptions DEFAULT = new SevenZFileOptions(Integer.MAX_VALUE, false, false);
    private final int maxMemoryLimitInKb;
    private final boolean tryToRecoverBrokenArchives;
    private final boolean useDefaultNameForUnnamedEntries;

    private SevenZFileOptions(int i, boolean z, boolean z2) {
        this.maxMemoryLimitInKb = i;
        this.useDefaultNameForUnnamedEntries = z;
        this.tryToRecoverBrokenArchives = z2;
    }

    public int getMaxMemoryLimitInKb() {
        return this.maxMemoryLimitInKb;
    }

    public boolean getUseDefaultNameForUnnamedEntries() {
        return this.useDefaultNameForUnnamedEntries;
    }

    public boolean getTryToRecoverBrokenArchives() {
        return this.tryToRecoverBrokenArchives;
    }
}
