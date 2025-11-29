package com.huawei.location.lite.common.log.logwrite;

import java.io.File;

/* loaded from: classes3.dex */
public class LogWriteConstants {
    public static final String DEBUG_PATH;
    public static final String FILE_SEPARATOR;
    public static final String LOCATION_PATH;

    static {
        String str = File.separator;
        FILE_SEPARATOR = str;
        DEBUG_PATH = str + "debug" + str;
        StringBuilder sb = new StringBuilder();
        sb.append("location");
        sb.append(str);
        LOCATION_PATH = sb.toString();
    }
}
