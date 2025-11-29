package coil.content;

import android.content.Context;
import coil.disk.DiskCache;
import kotlin.Metadata;
import kotlin.io.FilesKt;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcoil/util/SingletonDiskCache;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcoil/disk/DiskCache;", "get", "(Landroid/content/Context;)Lcoil/disk/DiskCache;", "instance", "Lcoil/disk/DiskCache;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SingletonDiskCache {
    public static final SingletonDiskCache INSTANCE = new SingletonDiskCache();
    private static DiskCache instance;

    private SingletonDiskCache() {
    }

    public final synchronized DiskCache get(Context context) {
        DiskCache diskCacheBuild;
        diskCacheBuild = instance;
        if (diskCacheBuild == null) {
            diskCacheBuild = new DiskCache.Builder().directory(FilesKt.resolve(Utils.getSafeCacheDir(context), "image_cache")).build();
            instance = diskCacheBuild;
        }
        return diskCacheBuild;
    }
}
