package com.huawei.location.tiles.utils;

import java.io.File;
import java.util.Comparator;

/* loaded from: classes3.dex */
final class dC implements Comparator<File> {
    dC() {
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return (int) (file2.lastModified() - file.lastModified());
    }
}
