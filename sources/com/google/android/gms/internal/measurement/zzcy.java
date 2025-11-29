package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public abstract class zzcy {
    private static zzcy zza = new zzcx();

    public static synchronized zzcy zza() {
        return zza;
    }

    public abstract URLConnection zza(URL url, String str) throws IOException;
}
