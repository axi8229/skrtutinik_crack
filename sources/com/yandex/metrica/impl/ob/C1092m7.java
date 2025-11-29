package com.yandex.metrica.impl.ob;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.yandex.metrica.impl.ob.m7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1092m7 implements FilenameFilter {
    C1092m7(C1117n7 c1117n7) {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(".dmp");
    }
}
