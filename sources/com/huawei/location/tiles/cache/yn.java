package com.huawei.location.tiles.cache;

import java.io.File;
import java.util.Comparator;

/* loaded from: classes3.dex */
class yn implements Comparator<File> {
    yn(Vw vw) {
    }

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        long jLastModified = file.lastModified() - file2.lastModified();
        if (jLastModified > 0) {
            return -1;
        }
        return jLastModified == 0 ? 0 : 1;
    }
}
