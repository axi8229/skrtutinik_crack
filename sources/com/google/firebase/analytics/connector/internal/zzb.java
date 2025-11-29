package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzji;
import com.google.android.gms.measurement.internal.zzjj;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.1.2 */
/* loaded from: classes.dex */
public final class zzb {
    private static final ImmutableSet<String> zza = ImmutableSet.of("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");
    private static final ImmutableList<String> zzb = ImmutableList.of("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    private static final ImmutableList<String> zzc = ImmutableList.of("auto", "app", "am");
    private static final ImmutableList<String> zzd = ImmutableList.of("_r", "_dbg");
    private static final ImmutableList<String> zze = new ImmutableList.Builder().add((Object[]) zzjj.zza).add((Object[]) zzjj.zzb).build();
    private static final ImmutableList<String> zzf = ImmutableList.of("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static String zza(String str) {
        String strZza = zzji.zza(str);
        return strZza != null ? strZza : str;
    }

    public static void zza(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean zzb(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zzf(str) || bundle == null) {
            return false;
        }
        ImmutableList<String> immutableList = zzd;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            String str3 = immutableList.get(i);
            i++;
            if (bundle.containsKey(str3)) {
                return false;
            }
        }
        str.hashCode();
        switch (str) {
            case "fcm":
                bundle.putString("_cis", "fcm_integration");
                return true;
            case "fdl":
                bundle.putString("_cis", "fdl_integration");
                return true;
            case "fiam":
                bundle.putString("_cis", "fiam_integration");
                return true;
            default:
                return false;
        }
    }

    public static boolean zza(String str, Bundle bundle) {
        if (zzb.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        ImmutableList<String> immutableList = zzd;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            String str2 = immutableList.get(i);
            i++;
            if (bundle.containsKey(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean zze(String str) {
        return !zza.contains(str);
    }

    public static boolean zzf(String str) {
        return !zzc.contains(str);
    }

    public static boolean zza(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals(AppMeasurement.FCM_ORIGIN) || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals(AppMeasurement.FCM_ORIGIN) || str.equals(AppMeasurement.FIAM_ORIGIN);
        }
        if (zze.contains(str2)) {
            return false;
        }
        ImmutableList<String> immutableList = zzf;
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            String str3 = immutableList.get(i);
            i++;
            if (str2.matches(str3)) {
                return false;
            }
        }
        return true;
    }
}
