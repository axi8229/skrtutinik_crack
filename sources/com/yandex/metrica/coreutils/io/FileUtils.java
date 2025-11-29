package com.yandex.metrica.coreutils.io;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/yandex/metrica/coreutils/io/FileUtils;", "", "()V", "getStorageDirectory", "Ljava/io/File;", "context", "Landroid/content/Context;", "needToUseNoBackup", "", "core-utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    @JvmStatic
    public static final boolean needToUseNoBackup() {
        return true;
    }

    private FileUtils() {
    }

    @JvmStatic
    public static final File getStorageDirectory(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return needToUseNoBackup() ? context.getNoBackupFilesDir() : context.getFilesDir();
    }
}
