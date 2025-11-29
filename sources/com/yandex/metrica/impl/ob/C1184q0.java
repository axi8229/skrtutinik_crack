package com.yandex.metrica.impl.ob;

import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import java.util.Iterator;
import java.util.UUID;
import okhttp3.internal.ws.RealWebSocket;

/* renamed from: com.yandex.metrica.impl.ob.q0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1184q0 {
    private final Context a;
    private final b b;

    /* renamed from: com.yandex.metrica.impl.ob.q0$a */
    public static class a {
        public final long a;
        public final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.q0$b */
    static class b {
        b() {
        }
    }

    public C1184q0(Context context) {
        this(context, new b());
    }

    public a a() {
        long j;
        long totalBytes = 0;
        if (!A2.a(26)) {
            if (A2.a(18)) {
                try {
                    this.b.getClass();
                    StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
                    long blockSizeLong = statFs.getBlockSizeLong();
                    return new a((statFs.getBlockCountLong() * blockSizeLong) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE, (statFs.getAvailableBlocksLong() * blockSizeLong) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
                } catch (Throwable unused) {
                    return new a(0L, 0L);
                }
            }
            try {
                this.b.getClass();
                long blockSize = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getBlockSize();
                return new a((r0.getBlockCount() * blockSize) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE, (r0.getAvailableBlocks() * blockSize) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
            } catch (Throwable unused2) {
                return new a(0L, 0L);
            }
        }
        StorageStatsManager storageStatsManagerM = q0$$ExternalSyntheticApiModelOutline0.m(this.a.getSystemService("storagestats"));
        StorageManager storageManager = (StorageManager) this.a.getSystemService("storage");
        if (storageManager == null || storageStatsManagerM == null) {
            j = 0;
        } else {
            Iterator<StorageVolume> it = storageManager.getStorageVolumes().iterator();
            long freeBytes = 0;
            while (it.hasNext()) {
                try {
                    String uuid = it.next().getUuid();
                    UUID uuidFromString = uuid == null ? StorageManager.UUID_DEFAULT : UUID.fromString(uuid);
                    totalBytes += storageStatsManagerM.getTotalBytes(uuidFromString);
                    freeBytes += storageStatsManagerM.getFreeBytes(uuidFromString);
                } catch (Throwable unused3) {
                }
            }
            long j2 = totalBytes;
            totalBytes = freeBytes;
            j = j2;
        }
        return new a(j / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE, totalBytes / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
    }

    C1184q0(Context context, b bVar) {
        this.a = context;
        this.b = bVar;
    }
}
