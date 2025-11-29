package com.huawei.location.tiles.utils;

import com.huawei.location.lite.common.log.LogLocation;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class FB {
    private static AtomicInteger yn = new AtomicInteger(0);

    public static void FB() {
        yn.yn(String.valueOf(yn.decrementAndGet()), new File(com.huawei.location.tiles.store.dC.yn + "DailyDownloads"));
    }

    public static int Vw() throws IOException {
        String str = com.huawei.location.tiles.store.dC.yn + "DailyDownloads";
        File file = new File(str);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str2 = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
        String str3 = simpleDateFormat.format(Long.valueOf(file.lastModified()));
        if (!file.exists() || !str2.equals(str3)) {
            yn.yn(String.valueOf(0), file);
            yn.set(0);
        } else if (yn.get() <= 0) {
            try {
                yn.set(Integer.parseInt(yn.Vw(str)));
            } catch (NumberFormatException e) {
                LogLocation.e("DailyDownloadsUtil", "get delay downloads error:" + e.getMessage());
                if (file.delete()) {
                    LogLocation.e("DailyDownloadsUtil", "downloads file delete error:" + e.getMessage());
                }
            }
        }
        return yn.get();
    }

    public static void yn() {
        yn.yn(String.valueOf(yn.incrementAndGet()), new File(com.huawei.location.tiles.store.dC.yn + "DailyDownloads"));
    }
}
