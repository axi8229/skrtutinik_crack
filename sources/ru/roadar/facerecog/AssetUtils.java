package ru.roadar.facerecog;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetUtils.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lru/roadar/facerecog/AssetUtils;", "", "()V", "copy2Cache", "Ljava/io/File;", "context", "Landroid/content/Context;", "path", "", "facerecog_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AssetUtils {
    public static final AssetUtils INSTANCE = new AssetUtils();

    private AssetUtils() {
    }

    public final File copy2Cache(Context context, String path) throws IOException {
        File parentFile;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(context.getCacheDir(), path);
        File parentFile2 = file.getParentFile();
        if ((parentFile2 == null || !parentFile2.exists()) && (parentFile = file.getParentFile()) != null) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            return file;
        }
        InputStream inputStreamOpen = context.getAssets().open(path);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                Intrinsics.checkNotNull(inputStreamOpen);
                ByteStreamsKt.copyTo$default(inputStreamOpen, fileOutputStream, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                CloseableKt.closeFinally(inputStreamOpen, null);
                return file;
            } finally {
            }
        } finally {
        }
    }
}
