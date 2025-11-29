package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.common.base.Optional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzhg {

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
    public static class zza {
        private static volatile Optional<zzhh> zza;

        private zza() {
        }

        public static Optional<zzhh> zza(Context context) {
            Optional<zzhh> optionalZza;
            Optional<zzhh> optional = zza;
            if (optional == null) {
                synchronized (zza.class) {
                    try {
                        optional = zza;
                        if (optional == null) {
                            new zzhg();
                            if (zzhk.zza(Build.TYPE, Build.TAGS)) {
                                if (zzgs.zza() && !context.isDeviceProtectedStorage()) {
                                    context = context.createDeviceProtectedStorageContext();
                                }
                                optionalZza = zzhg.zza(context);
                            } else {
                                optionalZza = Optional.absent();
                            }
                            zza = optionalZza;
                            optional = optionalZza;
                        }
                    } finally {
                    }
                }
            }
            return optional;
        }
    }

    private static zzhh zza(Context context, File file) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                HashMap map = new HashMap();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        Log.w("HermeticFileOverrides", "Parsed " + String.valueOf(file) + " for Android package " + context.getPackageName());
                        zzgy zzgyVar = new zzgy(simpleArrayMap);
                        bufferedReader.close();
                        return zzgyVar;
                    }
                    String[] strArrSplit = line.split(" ", 3);
                    if (strArrSplit.length != 3) {
                        Log.e("HermeticFileOverrides", "Invalid: " + line);
                    } else {
                        String strZza = zza(strArrSplit[0]);
                        String strDecode = Uri.decode(zza(strArrSplit[1]));
                        String strDecode2 = (String) map.get(strArrSplit[2]);
                        if (strDecode2 == null) {
                            String strZza2 = zza(strArrSplit[2]);
                            strDecode2 = Uri.decode(strZza2);
                            if (strDecode2.length() < 1024 || strDecode2 == strZza2) {
                                map.put(strZza2, strDecode2);
                            }
                        }
                        SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(strZza);
                        if (simpleArrayMap2 == null) {
                            simpleArrayMap2 = new SimpleArrayMap();
                            simpleArrayMap.put(strZza, simpleArrayMap2);
                        }
                        simpleArrayMap2.put(strDecode, strDecode2);
                    }
                }
            } finally {
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Optional<File> zzb(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? Optional.of(file) : Optional.absent();
        } catch (RuntimeException e) {
            Log.e("HermeticFileOverrides", "no data dir", e);
            return Optional.absent();
        }
    }

    static Optional<zzhh> zza(Context context) {
        Optional<zzhh> optionalAbsent;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            Optional<File> optionalZzb = zzb(context);
            if (optionalZzb.isPresent()) {
                optionalAbsent = Optional.of(zza(context, optionalZzb.get()));
            } else {
                optionalAbsent = Optional.absent();
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return optionalAbsent;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    private static final String zza(String str) {
        return new String(str);
    }
}
