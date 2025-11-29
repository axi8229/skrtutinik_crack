package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class Wrappers {
    private static final Wrappers zza = new Wrappers();
    private PackageManagerWrapper zzb = null;

    @KeepForSdk
    public static PackageManagerWrapper packageManager(Context context) {
        return zza.zza(context);
    }

    public final synchronized PackageManagerWrapper zza(Context context) {
        try {
            if (this.zzb == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.zzb = new PackageManagerWrapper(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzb;
    }
}
