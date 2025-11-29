package com.group_ib.sdk;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.group_ib.sdk.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0613o implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.endsWith(".cached");
    }
}
