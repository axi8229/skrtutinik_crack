package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Function;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public abstract class zzhj<T> {
    private static final Object zza = new Object();
    private static volatile zzhu zzb = null;
    private static volatile boolean zzc = false;
    private static zzhy zzd;
    private static final AtomicInteger zze;
    private final zzhr zzf;
    private final String zzg;
    private Object zzh;
    private volatile int zzi;
    private volatile T zzj;
    private final boolean zzk;
    private volatile boolean zzl;

    static /* synthetic */ boolean zzd() {
        return true;
    }

    abstract T zza(Object obj);

    static /* synthetic */ zzhj zza(zzhr zzhrVar, String str, Boolean bool, boolean z) {
        return new zzhq(zzhrVar, str, bool, true);
    }

    static /* synthetic */ zzhj zza(zzhr zzhrVar, String str, Double d, boolean z) {
        return new zzhp(zzhrVar, str, d, true);
    }

    static /* synthetic */ zzhj zza(zzhr zzhrVar, String str, Long l, boolean z) {
        return new zzhn(zzhrVar, str, l, true);
    }

    static /* synthetic */ zzhj zza(zzhr zzhrVar, String str, String str2, boolean z) {
        return new zzhs(zzhrVar, str, str2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007c A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:8:0x001c, B:10:0x0020, B:12:0x0029, B:14:0x0039, B:20:0x0055, B:22:0x0060, B:35:0x0080, B:38:0x0088, B:39:0x008d, B:40:0x0091, B:25:0x0067, B:34:0x007c, B:28:0x006e, B:31:0x0075, B:41:0x0095), top: B:47:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T zza() {
        /*
            r8 = this;
            boolean r0 = r8.zzk
            if (r0 != 0) goto L11
            com.google.android.gms.internal.measurement.zzhy r0 = com.google.android.gms.internal.measurement.zzhj.zzd
            java.lang.String r1 = r8.zzg
            boolean r0 = r0.zza(r1)
            java.lang.String r1 = "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error."
            com.google.common.base.Preconditions.checkState(r0, r1)
        L11:
            java.util.concurrent.atomic.AtomicInteger r0 = com.google.android.gms.internal.measurement.zzhj.zze
            int r0 = r0.get()
            int r1 = r8.zzi
            if (r1 >= r0) goto L99
            monitor-enter(r8)
            int r1 = r8.zzi     // Catch: java.lang.Throwable -> L4e
            if (r1 >= r0) goto L95
            com.google.android.gms.internal.measurement.zzhu r1 = com.google.android.gms.internal.measurement.zzhj.zzb     // Catch: java.lang.Throwable -> L4e
            com.google.common.base.Optional r2 = com.google.common.base.Optional.absent()     // Catch: java.lang.Throwable -> L4e
            r3 = 0
            if (r1 == 0) goto L50
            com.google.common.base.Supplier r2 = r1.zzb()     // Catch: java.lang.Throwable -> L4e
            java.lang.Object r2 = r2.get()     // Catch: java.lang.Throwable -> L4e
            com.google.common.base.Optional r2 = (com.google.common.base.Optional) r2     // Catch: java.lang.Throwable -> L4e
            boolean r4 = r2.isPresent()     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L50
            java.lang.Object r3 = r2.get()     // Catch: java.lang.Throwable -> L4e
            com.google.android.gms.internal.measurement.zzhh r3 = (com.google.android.gms.internal.measurement.zzhh) r3     // Catch: java.lang.Throwable -> L4e
            com.google.android.gms.internal.measurement.zzhr r4 = r8.zzf     // Catch: java.lang.Throwable -> L4e
            android.net.Uri r5 = r4.zzb     // Catch: java.lang.Throwable -> L4e
            java.lang.String r6 = r4.zza     // Catch: java.lang.Throwable -> L4e
            java.lang.String r4 = r4.zzd     // Catch: java.lang.Throwable -> L4e
            java.lang.String r7 = r8.zzg     // Catch: java.lang.Throwable -> L4e
            java.lang.String r3 = r3.zza(r5, r6, r4, r7)     // Catch: java.lang.Throwable -> L4e
            goto L50
        L4e:
            r0 = move-exception
            goto L97
        L50:
            if (r1 == 0) goto L54
            r4 = 1
            goto L55
        L54:
            r4 = 0
        L55:
            java.lang.String r5 = "Must call PhenotypeFlagInitializer.maybeInit() first"
            com.google.common.base.Preconditions.checkState(r4, r5)     // Catch: java.lang.Throwable -> L4e
            com.google.android.gms.internal.measurement.zzhr r4 = r8.zzf     // Catch: java.lang.Throwable -> L4e
            boolean r4 = r4.zzf     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L6e
            java.lang.Object r4 = r8.zza(r1)     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L67
            goto L80
        L67:
            java.lang.Object r4 = r8.zzb(r1)     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L7c
            goto L80
        L6e:
            java.lang.Object r4 = r8.zzb(r1)     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L75
            goto L80
        L75:
            java.lang.Object r4 = r8.zza(r1)     // Catch: java.lang.Throwable -> L4e
            if (r4 == 0) goto L7c
            goto L80
        L7c:
            java.lang.Object r4 = r8.zze()     // Catch: java.lang.Throwable -> L4e
        L80:
            boolean r1 = r2.isPresent()     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L91
            if (r3 != 0) goto L8d
            java.lang.Object r4 = r8.zze()     // Catch: java.lang.Throwable -> L4e
            goto L91
        L8d:
            java.lang.Object r4 = r8.zza(r3)     // Catch: java.lang.Throwable -> L4e
        L91:
            r8.zzj = r4     // Catch: java.lang.Throwable -> L4e
            r8.zzi = r0     // Catch: java.lang.Throwable -> L4e
        L95:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L4e
            goto L99
        L97:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L4e
            throw r0
        L99:
            T r0 = r8.zzj
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhj.zza():java.lang.Object");
    }

    private final T zze() {
        return (T) this.zzh;
    }

    private final T zza(zzhu zzhuVar) {
        Function<Context, Boolean> function;
        zzhr zzhrVar = this.zzf;
        if (!zzhrVar.zze && ((function = zzhrVar.zzh) == null || function.apply(zzhuVar.zza()).booleanValue())) {
            zzhc zzhcVarZza = zzhc.zza(zzhuVar.zza());
            zzhr zzhrVar2 = this.zzf;
            Object objZza = zzhcVarZza.zza(zzhrVar2.zze ? null : zza(zzhrVar2.zzc));
            if (objZza != null) {
                return zza(objZza);
            }
        }
        return null;
    }

    private final T zzb(zzhu zzhuVar) {
        zzhb zzhbVarZza;
        Object objZza;
        if (this.zzf.zzb != null) {
            if (!zzhi.zza(zzhuVar.zza(), this.zzf.zzb)) {
                zzhbVarZza = null;
            } else if (this.zzf.zzg) {
                zzhbVarZza = zzgu.zza(zzhuVar.zza().getContentResolver(), zzhk.zza(zzhk.zza(zzhuVar.zza(), this.zzf.zzb.getLastPathSegment())), new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhm
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzhj.zzc();
                    }
                });
            } else {
                zzhbVarZza = zzgu.zza(zzhuVar.zza().getContentResolver(), this.zzf.zzb, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhm
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzhj.zzc();
                    }
                });
            }
        } else {
            zzhbVarZza = zzhw.zza(zzhuVar.zza(), this.zzf.zza, new Runnable() { // from class: com.google.android.gms.internal.measurement.zzhm
                @Override // java.lang.Runnable
                public final void run() {
                    zzhj.zzc();
                }
            });
        }
        if (zzhbVarZza == null || (objZza = zzhbVarZza.zza(zzb())) == null) {
            return null;
        }
        return zza(objZza);
    }

    public final String zzb() {
        return zza(this.zzf.zzd);
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzg;
        }
        return str + this.zzg;
    }

    static {
        new AtomicReference();
        zzd = new zzhy(new zzhx() { // from class: com.google.android.gms.internal.measurement.zzho
            @Override // com.google.android.gms.internal.measurement.zzhx
            public final boolean zza() {
                return zzhj.zzd();
            }
        });
        zze = new AtomicInteger();
    }

    private zzhj(zzhr zzhrVar, String str, T t, boolean z) {
        this.zzi = -1;
        String str2 = zzhrVar.zza;
        if (str2 == null && zzhrVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (str2 != null && zzhrVar.zzb != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.zzf = zzhrVar;
        this.zzg = str;
        this.zzh = t;
        this.zzk = z;
        this.zzl = false;
    }

    public static void zzc() {
        zze.incrementAndGet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void zzb(final android.content.Context r3) {
        /*
            com.google.android.gms.internal.measurement.zzhu r0 = com.google.android.gms.internal.measurement.zzhj.zzb
            if (r0 != 0) goto L4e
            if (r3 != 0) goto L7
            goto L4e
        L7:
            java.lang.Object r0 = com.google.android.gms.internal.measurement.zzhj.zza
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.zzhu r1 = com.google.android.gms.internal.measurement.zzhj.zzb     // Catch: java.lang.Throwable -> L48
            if (r1 != 0) goto L4a
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L48
            com.google.android.gms.internal.measurement.zzhu r1 = com.google.android.gms.internal.measurement.zzhj.zzb     // Catch: java.lang.Throwable -> L22
            android.content.Context r2 = r3.getApplicationContext()     // Catch: java.lang.Throwable -> L22
            if (r2 != 0) goto L18
            goto L19
        L18:
            r3 = r2
        L19:
            if (r1 == 0) goto L24
            android.content.Context r2 = r1.zza()     // Catch: java.lang.Throwable -> L22
            if (r2 == r3) goto L44
            goto L24
        L22:
            r3 = move-exception
            goto L46
        L24:
            if (r1 == 0) goto L2f
            com.google.android.gms.internal.measurement.zzgu.zzc()     // Catch: java.lang.Throwable -> L22
            com.google.android.gms.internal.measurement.zzhw.zza()     // Catch: java.lang.Throwable -> L22
            com.google.android.gms.internal.measurement.zzhc.zza()     // Catch: java.lang.Throwable -> L22
        L2f:
            com.google.android.gms.internal.measurement.zzhl r1 = new com.google.android.gms.internal.measurement.zzhl     // Catch: java.lang.Throwable -> L22
            r1.<init>()     // Catch: java.lang.Throwable -> L22
            com.google.common.base.Supplier r1 = com.google.common.base.Suppliers.memoize(r1)     // Catch: java.lang.Throwable -> L22
            com.google.android.gms.internal.measurement.zzgv r2 = new com.google.android.gms.internal.measurement.zzgv     // Catch: java.lang.Throwable -> L22
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L22
            com.google.android.gms.internal.measurement.zzhj.zzb = r2     // Catch: java.lang.Throwable -> L22
            java.util.concurrent.atomic.AtomicInteger r3 = com.google.android.gms.internal.measurement.zzhj.zze     // Catch: java.lang.Throwable -> L22
            r3.incrementAndGet()     // Catch: java.lang.Throwable -> L22
        L44:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
            goto L4a
        L46:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
            throw r3     // Catch: java.lang.Throwable -> L48
        L48:
            r3 = move-exception
            goto L4c
        L4a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L48
            return
        L4c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L48
            throw r3
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhj.zzb(android.content.Context):void");
    }
}
