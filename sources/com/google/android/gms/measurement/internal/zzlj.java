package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzlj extends zzh {
    protected zzlk zza;
    private volatile zzlk zzb;
    private volatile zzlk zzc;
    private final Map<Integer, zzlk> zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzlk zzg;
    private zzlk zzh;
    private boolean zzi;
    private final Object zzj;

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzh
    protected final boolean zzz() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzgf zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzgh zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzjq zzm() {
        return super.zzm();
    }

    private final zzlk zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzlk zzlkVar = this.zzd.get(Integer.valueOf(activity.hashCode()));
        if (zzlkVar == null) {
            zzlk zzlkVar2 = new zzlk(null, zza(activity.getClass(), "Activity"), zzq().zzn());
            this.zzd.put(Integer.valueOf(activity.hashCode()), zzlkVar2);
            zzlkVar = zzlkVar2;
        }
        return this.zzg != null ? this.zzg : zzlkVar;
    }

    public final zzlk zzaa() {
        return this.zzb;
    }

    public final zzlk zza(boolean z) {
        zzu();
        zzt();
        if (!z) {
            return this.zza;
        }
        zzlk zzlkVar = this.zza;
        return zzlkVar != null ? zzlkVar : this.zzh;
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzlj zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zznb zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ zzos zzq() {
        return super.zzq();
    }

    private final String zza(Class<?> cls, String str) {
        String str2;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return str;
        }
        String[] strArrSplit = canonicalName.split("\\.");
        if (strArrSplit.length > 0) {
            str2 = strArrSplit[strArrSplit.length - 1];
        } else {
            str2 = "";
        }
        return str2.length() > zze().zza((String) null, false) ? str2.substring(0, zze().zza((String) null, false)) : str2;
    }

    static /* synthetic */ void zza(zzlj zzljVar, Bundle bundle, zzlk zzlkVar, zzlk zzlkVar2, long j) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        zzljVar.zza(zzlkVar, zzlkVar2, j, true, zzljVar.zzq().zza((String) null, "screen_view", bundle, (List<String>) null, false));
    }

    public zzlj(zzhy zzhyVar) {
        super(zzhyVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zza(Activity activity, zzlk zzlkVar, boolean z) throws IllegalStateException {
        zzlk zzlkVar2;
        zzlk zzlkVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzlkVar.zzb == null) {
            zzlkVar2 = new zzlk(zzlkVar.zza, activity != null ? zza(activity.getClass(), "Activity") : null, zzlkVar.zzc, zzlkVar.zze, zzlkVar.zzf);
        } else {
            zzlkVar2 = zzlkVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzlkVar2;
        zzl().zzb(new zzll(this, zzlkVar2, zzlkVar3, zzb().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.measurement.internal.zzlk r16, com.google.android.gms.measurement.internal.zzlk r17, long r18, boolean r20, android.os.Bundle r21) throws java.lang.IllegalStateException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r5 = r21
            r15.zzt()
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L2f
            long r8 = r2.zzc
            long r10 = r1.zzc
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 != 0) goto L2f
            java.lang.String r8 = r2.zzb
            java.lang.String r9 = r1.zzb
            boolean r8 = java.util.Objects.equals(r8, r9)
            if (r8 == 0) goto L2f
            java.lang.String r8 = r2.zza
            java.lang.String r9 = r1.zza
            boolean r8 = java.util.Objects.equals(r8, r9)
            if (r8 != 0) goto L2d
            goto L2f
        L2d:
            r8 = r6
            goto L30
        L2f:
            r8 = r7
        L30:
            if (r20 == 0) goto L37
            com.google.android.gms.measurement.internal.zzlk r9 = r0.zza
            if (r9 == 0) goto L37
            r6 = r7
        L37:
            if (r8 == 0) goto Lba
            android.os.Bundle r8 = new android.os.Bundle
            if (r5 == 0) goto L42
            r8.<init>(r5)
        L40:
            r14 = r8
            goto L46
        L42:
            r8.<init>()
            goto L40
        L46:
            com.google.android.gms.measurement.internal.zzos.zza(r1, r14, r7)
            if (r2 == 0) goto L64
            java.lang.String r5 = r2.zza
            if (r5 == 0) goto L54
            java.lang.String r8 = "_pn"
            r14.putString(r8, r5)
        L54:
            java.lang.String r5 = r2.zzb
            if (r5 == 0) goto L5d
            java.lang.String r8 = "_pc"
            r14.putString(r8, r5)
        L5d:
            java.lang.String r5 = "_pi"
            long r8 = r2.zzc
            r14.putLong(r5, r8)
        L64:
            r8 = 0
            if (r6 == 0) goto L7d
            com.google.android.gms.measurement.internal.zznb r2 = r15.zzp()
            com.google.android.gms.measurement.internal.zznh r2 = r2.zzb
            long r10 = r2.zza(r3)
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 <= 0) goto L7d
            com.google.android.gms.measurement.internal.zzos r2 = r15.zzq()
            r2.zza(r14, r10)
        L7d:
            com.google.android.gms.measurement.internal.zzag r2 = r15.zze()
            boolean r2 = r2.zzw()
            if (r2 != 0) goto L8e
            java.lang.String r2 = "_mst"
            r10 = 1
            r14.putLong(r2, r10)
        L8e:
            boolean r2 = r1.zze
            if (r2 == 0) goto L96
            java.lang.String r2 = "app"
        L94:
            r10 = r2
            goto L99
        L96:
            java.lang.String r2 = "auto"
            goto L94
        L99:
            com.google.android.gms.common.util.Clock r2 = r15.zzb()
            long r11 = r2.currentTimeMillis()
            boolean r2 = r1.zze
            r20 = r11
            if (r2 == 0) goto Laf
            long r11 = r1.zzf
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 == 0) goto Laf
            r12 = r11
            goto Lb1
        Laf:
            r12 = r20
        Lb1:
            com.google.android.gms.measurement.internal.zzjq r9 = r15.zzm()
            java.lang.String r11 = "_vs"
            r9.zza(r10, r11, r12, r14)
        Lba:
            if (r6 == 0) goto Lc1
            com.google.android.gms.measurement.internal.zzlk r2 = r0.zza
            r15.zza(r2, r7, r3)
        Lc1:
            r0.zza = r1
            boolean r2 = r1.zze
            if (r2 == 0) goto Lc9
            r0.zzh = r1
        Lc9:
            com.google.android.gms.measurement.internal.zzls r2 = r15.zzo()
            r2.zza(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlj.zza(com.google.android.gms.measurement.internal.zzlk, com.google.android.gms.measurement.internal.zzlk, long, boolean, android.os.Bundle):void");
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zze, com.google.android.gms.measurement.internal.zzja
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!zze().zzw() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(Integer.valueOf(activity.hashCode()), new zzlk(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zza(Activity activity) {
        synchronized (this.zzj) {
            try {
                if (activity == this.zze) {
                    this.zze = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zze().zzw()) {
            this.zzd.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public final void zzb(Activity activity) throws IllegalStateException {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long jElapsedRealtime = zzb().elapsedRealtime();
        if (!zze().zzw()) {
            this.zzb = null;
            zzl().zzb(new zzln(this, jElapsedRealtime));
        } else {
            zzlk zzlkVarZzd = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzl().zzb(new zzlq(this, zzlkVarZzd, jElapsedRealtime));
        }
    }

    public final void zzc(Activity activity) throws IllegalStateException {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (zze().zzw()) {
                    this.zzg = null;
                    zzl().zzb(new zzlp(this));
                }
            }
        }
        if (!zze().zzw()) {
            this.zzb = this.zzg;
            zzl().zzb(new zzlo(this));
        } else {
            zza(activity, zzd(activity), false);
            zzb zzbVarZzc = zzc();
            zzbVarZzc.zzl().zzb(new zzc(zzbVarZzc, zzbVarZzc.zzb().elapsedRealtime()));
        }
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzlk zzlkVar;
        if (!zze().zzw() || bundle == null || (zzlkVar = this.zzd.get(Integer.valueOf(activity.hashCode()))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzlkVar.zzc);
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zzlkVar.zza);
        bundle2.putString("referrer_name", zzlkVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzlk zzlkVar, boolean z, long j) {
        zzc().zza(zzb().elapsedRealtime());
        if (!zzp().zza(zzlkVar != null && zzlkVar.zzd, z, j) || zzlkVar == null) {
            return;
        }
        zzlkVar.zzd = false;
    }

    @Deprecated
    public final void zza(Activity activity, String str, String str2) throws IllegalStateException {
        if (!zze().zzw()) {
            zzj().zzv().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzlk zzlkVar = this.zzb;
        if (zzlkVar == null) {
            zzj().zzv().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(Integer.valueOf(activity.hashCode())) == null) {
            zzj().zzv().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(activity.getClass(), "Activity");
        }
        boolean zEquals = Objects.equals(zzlkVar.zzb, str2);
        boolean zEquals2 = Objects.equals(zzlkVar.zza, str);
        if (zEquals && zEquals2) {
            zzj().zzv().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zze().zza((String) null, false))) {
            zzj().zzv().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zze().zza((String) null, false))) {
            zzj().zzv().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzj().zzp().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzlk zzlkVar2 = new zzlk(str, str2, zzq().zzn());
        this.zzd.put(Integer.valueOf(activity.hashCode()), zzlkVar2);
        zza(activity, zzlkVar2, true);
    }

    public final void zza(Bundle bundle, long j) {
        String str;
        synchronized (this.zzj) {
            try {
                if (!this.zzi) {
                    zzj().zzv().zza("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String strZza = null;
                if (bundle != null) {
                    String string = bundle.getString("screen_name");
                    if (string != null && (string.length() <= 0 || string.length() > zze().zza((String) null, false))) {
                        zzj().zzv().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                        return;
                    }
                    String string2 = bundle.getString("screen_class");
                    if (string2 != null && (string2.length() <= 0 || string2.length() > zze().zza((String) null, false))) {
                        zzj().zzv().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                        return;
                    } else {
                        str = string;
                        strZza = string2;
                    }
                } else {
                    str = null;
                }
                if (strZza == null) {
                    Activity activity = this.zze;
                    if (activity != null) {
                        strZza = zza(activity.getClass(), "Activity");
                    } else {
                        strZza = "Activity";
                    }
                }
                String str2 = strZza;
                zzlk zzlkVar = this.zzb;
                if (this.zzf && zzlkVar != null) {
                    this.zzf = false;
                    boolean zEquals = Objects.equals(zzlkVar.zzb, str2);
                    boolean zEquals2 = Objects.equals(zzlkVar.zza, str);
                    if (zEquals && zEquals2) {
                        zzj().zzv().zza("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                zzj().zzp().zza("Logging screen view with name, class", str == null ? "null" : str, str2 == null ? "null" : str2);
                zzlk zzlkVar2 = this.zzb == null ? this.zzc : this.zzb;
                zzlk zzlkVar3 = new zzlk(str, str2, zzq().zzn(), true, j);
                this.zzb = zzlkVar3;
                this.zzc = zzlkVar2;
                this.zzg = zzlkVar3;
                zzl().zzb(new zzlm(this, bundle, zzlkVar3, zzlkVar2, zzb().elapsedRealtime()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
