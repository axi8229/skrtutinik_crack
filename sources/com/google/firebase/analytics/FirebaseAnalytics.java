package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdy;
import com.google.android.gms.measurement.internal.zzlb;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import ru.yoomoney.sdk.auth.location.utils.UtilsKt;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.1.2 */
/* loaded from: classes.dex */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zza;
    private final zzdy zzb;

    @Keep
    public static zzlb getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzdy zzdyVarZza = zzdy.zza(context, (String) null, (String) null, (String) null, bundle);
        if (zzdyVarZza == null) {
            return null;
        }
        return new zzd(zzdyVarZza);
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (zza == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (zza == null) {
                        zza = new FirebaseAnalytics(zzdy.zza(context));
                    }
                } finally {
                }
            }
        }
        return zza;
    }

    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(FirebaseInstallations.getInstance().getId(), UtilsKt.UPDATE_INTERVAL, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    private FirebaseAnalytics(zzdy zzdyVar) {
        Preconditions.checkNotNull(zzdyVar);
        this.zzb = zzdyVar;
    }

    @Keep
    @Deprecated
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        this.zzb.zza(activity, str, str2);
    }
}
