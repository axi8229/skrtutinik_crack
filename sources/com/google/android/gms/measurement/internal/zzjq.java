package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzje;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.Unit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzjq extends zzh {
    final zzu zza;
    private zzkz zzb;
    private zzjm zzc;
    private final Set<zzjl> zzd;
    private boolean zze;
    private final AtomicReference<String> zzf;
    private final Object zzg;
    private boolean zzh;
    private int zzi;
    private zzav zzj;
    private PriorityQueue<zzno> zzk;
    private boolean zzl;
    private zzje zzm;
    private final AtomicLong zzn;
    private long zzo;
    private boolean zzp;
    private zzav zzq;
    private SharedPreferences.OnSharedPreferenceChangeListener zzr;
    private zzav zzs;
    private final zzor zzt;

    public static int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.zzh
    protected final boolean zzz() {
        return false;
    }

    public final Application.ActivityLifecycleCallbacks zzaa() {
        return this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzja, com.google.android.gms.measurement.internal.zzjc
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
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

    public final zzaj zzab() {
        zzt();
        return zzo().zzaa();
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

    static /* synthetic */ int zza(zzjq zzjqVar, Throwable th) {
        String message = th.getMessage();
        zzjqVar.zzl = false;
        if (message == null) {
            return 2;
        }
        if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            return (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) ? 2 : 3;
        }
        if (message.contains("Background")) {
            zzjqVar.zzl = true;
        }
        return 1;
    }

    @Override // com.google.android.gms.measurement.internal.zze
    public final /* bridge */ /* synthetic */ zzjq zzm() {
        return super.zzm();
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

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, 15000L, "boolean test flag value", new zzka(this, atomicReference));
    }

    public final Double zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, 15000L, "double test flag value", new zzkw(this, atomicReference));
    }

    public final Integer zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, 15000L, "int test flag value", new zzkt(this, atomicReference));
    }

    public final Long zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, 15000L, "long test flag value", new zzku(this, atomicReference));
    }

    public final String zzag() {
        return this.zzf.get();
    }

    public final String zzah() {
        zzlk zzlkVarZzaa = this.zzu.zzq().zzaa();
        if (zzlkVarZzaa != null) {
            return zzlkVarZzaa.zzb;
        }
        return null;
    }

    public final String zzai() {
        zzlk zzlkVarZzaa = this.zzu.zzq().zzaa();
        if (zzlkVarZzaa != null) {
            return zzlkVarZzaa.zza;
        }
        return null;
    }

    public final String zzaj() throws IllegalStateException {
        if (this.zzu.zzu() != null) {
            return this.zzu.zzu();
        }
        try {
            return new zzhs(zza(), this.zzu.zzx()).zza("google_app_id");
        } catch (IllegalStateException e) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final String zzak() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, 15000L, "String test flag value", new zzkj(this, atomicReference));
    }

    public final ArrayList<Bundle> zza(String str, String str2) throws IllegalStateException {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, "get conditional user properties", new zzkq(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for get conditional user properties", null);
            return new ArrayList<>();
        }
        return zzos.zzb((List<zzae>) list);
    }

    public final List<zzon> zza(boolean z) throws IllegalStateException {
        zzu();
        zzj().zzp().zza("Getting user properties (FE)");
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, "get user properties", new zzkk(this, atomicReference, z));
        List<zzon> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzj().zzg().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
        return Collections.emptyList();
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) throws IllegalStateException {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, "get user properties", new zzkp(this, atomicReference, null, str, str2, z));
        List<zzon> list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzon zzonVar : list) {
            Object objZza = zzonVar.zza();
            if (objZza != null) {
                arrayMap.put(zzonVar.zza, objZza);
            }
        }
        return arrayMap;
    }

    @TargetApi(30)
    final PriorityQueue<zzno> zzal() {
        if (this.zzk == null) {
            this.zzk = new PriorityQueue<>(Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzjp
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((zzno) obj).zzb);
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzjs
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.zzk;
    }

    static /* synthetic */ void zza(zzjq zzjqVar, Bundle bundle) throws IllegalStateException {
        zzjqVar.zzt();
        zzjqVar.zzu();
        Preconditions.checkNotNull(bundle);
        String strCheckNotEmpty = Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!zzjqVar.zzu.zzac()) {
            zzjqVar.zzj().zzp().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzjqVar.zzo().zza(new zzae(bundle.getString(HiAnalyticsConstant.BI_KEY_APP_ID), "", new zzon(strCheckNotEmpty, 0L, null, ""), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzjqVar.zzq().zza(bundle.getString(HiAnalyticsConstant.BI_KEY_APP_ID), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void zza(zzjq zzjqVar, zzje zzjeVar, zzje zzjeVar2) {
        if (com.google.android.gms.internal.measurement.zznm.zza() && zzjqVar.zze().zza(zzbh.zzcx)) {
            return;
        }
        zzje.zza zzaVar = zzje.zza.ANALYTICS_STORAGE;
        zzje.zza zzaVar2 = zzje.zza.AD_STORAGE;
        boolean zZza = zzjeVar.zza(zzjeVar2, zzaVar, zzaVar2);
        boolean zZzb = zzjeVar.zzb(zzjeVar2, zzaVar, zzaVar2);
        if (zZza || zZzb) {
            zzjqVar.zzg().zzag();
        }
    }

    static /* synthetic */ void zzb(zzjq zzjqVar, Bundle bundle) throws IllegalStateException {
        zzjqVar.zzt();
        zzjqVar.zzu();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        String string2 = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN);
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        if (!zzjqVar.zzu.zzac()) {
            zzjqVar.zzj().zzp().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzon zzonVar = new zzon(string, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get(AppMeasurementSdk.ConditionalUserProperty.VALUE), string2);
        try {
            zzbf zzbfVarZza = zzjqVar.zzq().zza(bundle.getString(HiAnalyticsConstant.BI_KEY_APP_ID), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0L, true, true);
            zzjqVar.zzo().zza(new zzae(bundle.getString(HiAnalyticsConstant.BI_KEY_APP_ID), string2, zzonVar, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzjqVar.zzq().zza(bundle.getString(HiAnalyticsConstant.BI_KEY_APP_ID), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0L, true, true), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzbfVarZza, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzjqVar.zzq().zza(bundle.getString(HiAnalyticsConstant.BI_KEY_APP_ID), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void zza(zzjq zzjqVar, zzje zzjeVar, long j, boolean z, boolean z2) throws IllegalStateException {
        zzjqVar.zzt();
        zzjqVar.zzu();
        zzje zzjeVarZzo = zzjqVar.zzk().zzo();
        if (j <= zzjqVar.zzo && zzje.zza(zzjeVarZzo.zza(), zzjeVar.zza())) {
            zzjqVar.zzj().zzo().zza("Dropped out-of-date consent setting, proposed settings", zzjeVar);
            return;
        }
        if (zzjqVar.zzk().zza(zzjeVar)) {
            zzjqVar.zzj().zzp().zza("Setting storage consent(FE)", zzjeVar);
            zzjqVar.zzo = j;
            if (zzjqVar.zzo().zzao()) {
                zzjqVar.zzo().zzb(z);
            } else {
                zzjqVar.zzo().zza(z);
            }
            if (z2) {
                zzjqVar.zzo().zza(new AtomicReference<>());
                return;
            }
            return;
        }
        zzjqVar.zzj().zzo().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjeVar.zza()));
    }

    static /* synthetic */ void zzb(zzjq zzjqVar, int i) {
        if (zzjqVar.zzj == null) {
            zzjqVar.zzj = new zzkb(zzjqVar, zzjqVar.zzu);
        }
        zzjqVar.zzj.zza(i * 1000);
    }

    protected zzjq(zzhy zzhyVar) {
        super(zzhyVar);
        this.zzd = new CopyOnWriteArraySet();
        this.zzg = new Object();
        this.zzh = false;
        this.zzi = 1;
        this.zzp = true;
        this.zzt = new zzkr(this);
        this.zzf = new AtomicReference<>();
        this.zzm = zzje.zza;
        this.zzo = -1L;
        this.zzn = new AtomicLong(0L);
        this.zza = new zzu(zzhyVar);
    }

    public final void zzam() {
        zzt();
        zzu();
        if (zze().zza(zzbh.zzdd)) {
            zzls zzlsVarZzo = zzo();
            zzlsVarZzo.zzt();
            zzlsVarZzo.zzu();
            if (zzlsVarZzo.zzap() && zzlsVarZzo.zzq().zzg() < 242600) {
                return;
            }
            zzo().zzac();
        }
    }

    public final void zzan() {
        zzt();
        zzu();
        if (this.zzu.zzaf()) {
            Boolean boolZze = zze().zze("google_analytics_deferred_deep_link_enabled");
            if (boolZze != null && boolZze.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjv
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException {
                        this.zza.zzaq();
                    }
                });
            }
            zzo().zzad();
            this.zzp = false;
            String strZzw = zzk().zzw();
            if (TextUtils.isEmpty(strZzw)) {
                return;
            }
            zzf().zzac();
            if (strZzw.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strZzw);
            zzc("auto", "_ou", bundle);
        }
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

    public final void zza(String str, String str2, Bundle bundle) throws IllegalStateException {
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzl().zzb(new zzkn(this, bundle2));
    }

    public final void zzao() {
        if (!(zza().getApplicationContext() instanceof Application) || this.zzb == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzb);
    }

    final void zzap() throws IllegalStateException {
        if (zzpn.zza() && zze().zza(zzbh.zzci)) {
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (zzab.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzu();
            zzj().zzp().zza("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzl().zza(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_FAST, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(atomicReference);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get trigger URIs");
            } else {
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzju
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalStateException {
                        this.zza.zza(list);
                    }
                });
            }
        }
    }

    public final void zzaq() throws IllegalStateException {
        zzt();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jZza = zzk().zzp.zza();
        zzk().zzp.zza(1 + jZza);
        if (jZza >= 5) {
            zzj().zzu().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
        } else {
            if (this.zzq == null) {
                this.zzq = new zzkm(this, this.zzu);
            }
            this.zzq.zza(0L);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdo zzdoVar) throws IllegalStateException, RemoteException {
        zzl().zzb(new zzks(this, zzdoVar));
    }

    public final void zzar() {
        zzt();
        zzj().zzc().zza("Handle tcf update.");
        zznm zznmVarZza = zznm.zza(zzk().zzc());
        zzj().zzp().zza("Tcf preferences read", zznmVarZza);
        if (zzk().zza(zznmVarZza)) {
            Bundle bundleZza = zznmVarZza.zza();
            zzj().zzp().zza("Consent generated from Tcf", bundleZza);
            if (bundleZza != Bundle.EMPTY) {
                zza(bundleZza, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zznmVarZza.zzb());
            zzc("auto", "_tcf", bundle);
        }
    }

    final /* synthetic */ void zza(AtomicReference atomicReference) {
        Bundle bundleZza = zzk().zzi.zza();
        zzls zzlsVarZzo = zzo();
        if (bundleZza == null) {
            bundleZza = new Bundle();
        }
        zzlsVarZzo.zza((AtomicReference<List<zzno>>) atomicReference, bundleZza);
    }

    final /* synthetic */ void zza(List list) throws IllegalStateException {
        zzt();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> sparseArrayZzm = zzk().zzm();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzno zznoVar = (zzno) it.next();
                if (!sparseArrayZzm.contains(zznoVar.zzc) || sparseArrayZzm.get(zznoVar.zzc).longValue() < zznoVar.zzb) {
                    zzal().add(zznoVar);
                }
            }
            zzas();
        }
    }

    final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) throws IllegalStateException {
        if ("IABTCF_TCString".equals(str)) {
            zzj().zzp().zza("IABTCF_TCString change picked up in listener.");
            ((zzav) Preconditions.checkNotNull(this.zzs)).zza(500L);
        }
    }

    final /* synthetic */ void zza(Bundle bundle, long j) throws IllegalStateException {
        if (TextUtils.isEmpty(zzg().zzae())) {
            zza(bundle, 0, j);
        } else {
            zzj().zzv().zza("Using developer consent only; google app id found");
        }
    }

    final /* synthetic */ void zza(Bundle bundle) throws IllegalStateException {
        Bundle bundleZza;
        if (bundle.isEmpty()) {
            bundleZza = bundle;
        } else {
            bundleZza = zzk().zzt.zza();
            if (zze().zza(zzbh.zzdh)) {
                bundleZza = new Bundle(bundleZza);
            }
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzq();
                    if (zzos.zza(obj)) {
                        zzq();
                        zzos.zza(this.zzt, 27, (String) null, (String) null, 0);
                    }
                    zzj().zzv().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzos.zzg(str)) {
                    zzj().zzv().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    bundleZza.remove(str);
                } else if (zzq().zza(RemoteMessageConst.MessageBody.PARAM, str, zze().zza((String) null, false), obj)) {
                    zzq().zza(bundleZza, str, obj);
                }
            }
            zzq();
            if (zzos.zza(bundleZza, zze().zzc())) {
                zzq();
                zzos.zza(this.zzt, 26, (String) null, (String) null, 0);
                zzj().zzv().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzk().zzt.zza(bundleZza);
        if (!bundle.isEmpty() || zze().zza(zzbh.zzdf)) {
            zzo().zza(bundleZza);
        }
    }

    final /* synthetic */ void zzb(String str) {
        if (zzg().zzb(str)) {
            zzg().zzag();
        }
    }

    public final void zzb(String str, String str2, Bundle bundle) throws IllegalStateException {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws IllegalStateException {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, "screen_view")) {
            zzn().zza(bundle2, j);
        } else {
            zzb(str3, str2, j, bundle2, z2, !z2 || this.zzc == null || zzos.zzg(str2), z, null);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) throws IllegalStateException {
        zzs();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) throws IllegalStateException {
        zza(str, str2, bundle, true, false, j);
    }

    final void zzc(String str, String str2, Bundle bundle) {
        zzt();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    final void zza(String str, String str2, long j, Bundle bundle) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzt();
        zza(str, str2, j, bundle, true, this.zzc == null || zzos.zzg(str2), true, null);
    }

    protected final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        boolean zZza;
        String str4;
        ArrayList arrayList;
        long j2;
        int i;
        Object obj;
        int length;
        Class<?> cls;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzt();
        zzu();
        if (!this.zzu.zzac()) {
            zzj().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> listZzaf = zzg().zzaf();
        if (listZzaf != null && !listZzaf.contains(str2)) {
            zzj().zzc().zza("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.zze) {
            this.zze = true;
            try {
                if (!this.zzu.zzag()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zza().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod("initialize", Context.class).invoke(null, zza());
                } catch (Exception e) {
                    zzj().zzu().zza("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzj().zzo().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
            zza("auto", "_lgclid", bundle.getString("gclid"), zzb().currentTimeMillis());
        }
        if (z && zzos.zzj(str2)) {
            zzq().zza(bundle, zzk().zzt.zza());
        }
        if (!z3 && !"_iap".equals(str2)) {
            zzos zzosVarZzt = this.zzu.zzt();
            int i2 = 2;
            if (zzosVarZzt.zzc("event", str2)) {
                if (!zzosVarZzt.zza("event", zzji.zza, zzji.zzb, str2)) {
                    i2 = 13;
                } else if (zzosVarZzt.zza("event", 40, str2)) {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                zzj().zzm().zza("Invalid public event name. Event will not be logged (FE)", zzi().zza(str2));
                this.zzu.zzt();
                String strZza = zzos.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzt();
                zzos.zza(this.zzt, i2, "_ev", strZza, length);
                return;
            }
        }
        zzlk zzlkVarZza = zzn().zza(false);
        if (zzlkVarZza != null && !bundle.containsKey("_sc")) {
            zzlkVarZza.zzd = true;
        }
        zzos.zza(zzlkVarZza, bundle, z && !z3);
        boolean zEquals = "am".equals(str);
        boolean zZzg = zzos.zzg(str2);
        if (z && this.zzc != null && !zZzg && !zEquals) {
            zzj().zzc().zza("Passing event to registered event handler (FE)", zzi().zza(str2), zzi().zza(bundle));
            Preconditions.checkNotNull(this.zzc);
            this.zzc.interceptEvent(str, str2, bundle, j);
            return;
        }
        if (this.zzu.zzaf()) {
            int iZza = zzq().zza(str2);
            if (iZza != 0) {
                zzj().zzm().zza("Invalid event name. Event will not be logged (FE)", zzi().zza(str2));
                zzq();
                String strZza2 = zzos.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzt();
                zzos.zza(this.zzt, str3, iZza, "_ev", strZza2, length);
                return;
            }
            String str5 = "_o";
            Bundle bundleZza = zzq().zza(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
            Preconditions.checkNotNull(bundleZza);
            if (zzn().zza(false) != null && "_ae".equals(str2)) {
                zznh zznhVar = zzp().zzb;
                long jElapsedRealtime = zznhVar.zzb.zzb().elapsedRealtime();
                long j3 = jElapsedRealtime - zznhVar.zza;
                zznhVar.zza = jElapsedRealtime;
                if (j3 > 0) {
                    zzq().zza(bundleZza, j3);
                }
            }
            if (!"auto".equals(str) && "_ssr".equals(str2)) {
                zzos zzosVarZzq = zzq();
                String string = bundleZza.getString("_ffr");
                if (Strings.isEmptyOrWhitespace(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, zzosVarZzq.zzk().zzq.zza())) {
                    zzosVarZzq.zzj().zzc().zza("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                zzosVarZzq.zzk().zzq.zza(string);
            } else if ("_ae".equals(str2)) {
                String strZza3 = zzq().zzk().zzq.zza();
                if (!TextUtils.isEmpty(strZza3)) {
                    bundleZza.putString("_ffr", strZza3);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(bundleZza);
            if (zze().zza(zzbh.zzco)) {
                zZza = zzp().zzaa();
            } else {
                zZza = zzk().zzn.zza();
            }
            if (zzk().zzk.zza() <= 0 || !zzk().zza(j) || !zZza) {
                str4 = "_ae";
                arrayList = arrayList2;
                j2 = 0;
            } else {
                zzj().zzp().zza("Current session is expired, remove the session number, ID, and engagement time");
                arrayList = arrayList2;
                j2 = 0;
                str4 = "_ae";
                zza("auto", "_sid", (Object) null, zzb().currentTimeMillis());
                zza("auto", "_sno", (Object) null, zzb().currentTimeMillis());
                zza("auto", "_se", (Object) null, zzb().currentTimeMillis());
                zzk().zzl.zza(0L);
            }
            if (bundleZza.getLong("extend_session", j2) == 1) {
                zzj().zzp().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                i = 1;
                this.zzu.zzs().zza.zza(j, true);
            } else {
                i = 1;
            }
            ArrayList arrayList3 = new ArrayList(bundleZza.keySet());
            Collections.sort(arrayList3);
            int size = arrayList3.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList3.get(i3);
                i3 += i;
                String str6 = (String) obj2;
                if (str6 != null) {
                    zzq();
                    Bundle[] bundleArrZzb = zzos.zzb(bundleZza.get(str6));
                    if (bundleArrZzb != null) {
                        bundleZza.putParcelableArray(str6, bundleArrZzb);
                    }
                }
                i = 1;
            }
            int i4 = 0;
            while (i4 < arrayList.size()) {
                ArrayList arrayList4 = arrayList;
                Bundle bundleZza2 = (Bundle) arrayList4.get(i4);
                String str7 = i4 != 0 ? "_ep" : str2;
                bundleZza2.putString(str5, str);
                if (z2) {
                    obj = null;
                    bundleZza2 = zzq().zza(bundleZza2, (String) null);
                } else {
                    obj = null;
                }
                Bundle bundle2 = bundleZza2;
                String str8 = str5;
                zzo().zza(new zzbf(str7, new zzbe(bundle2), str, j), str3);
                if (!zEquals) {
                    Iterator<zzjl> it = this.zzd.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, str2, new Bundle(bundle2), j);
                    }
                }
                i4++;
                arrayList = arrayList4;
                str5 = str8;
            }
            if (zzn().zza(false) == null || !str4.equals(str2)) {
                return;
            }
            zzp().zza(true, true, zzb().elapsedRealtime());
        }
    }

    @TargetApi(30)
    final void zzas() throws IllegalStateException {
        zzno zznoVarPoll;
        MeasurementManagerFutures measurementManagerFuturesZzo;
        zzt();
        this.zzl = false;
        if (zzal().isEmpty() || this.zzh || (zznoVarPoll = zzal().poll()) == null || (measurementManagerFuturesZzo = zzq().zzo()) == null) {
            return;
        }
        this.zzh = true;
        zzj().zzp().zza("Registering trigger URI", zznoVarPoll.zza);
        ListenableFuture<Unit> listenableFutureRegisterTriggerAsync = measurementManagerFuturesZzo.registerTriggerAsync(Uri.parse(zznoVarPoll.zza));
        if (listenableFutureRegisterTriggerAsync == null) {
            this.zzh = false;
            zzal().add(zznoVarPoll);
            return;
        }
        if (!zze().zza(zzbh.zzcn)) {
            SparseArray<Long> sparseArrayZzm = zzk().zzm();
            sparseArrayZzm.put(zznoVarPoll.zzc, Long.valueOf(zznoVarPoll.zzb));
            zzk().zza(sparseArrayZzm);
        }
        Futures.addCallback(listenableFutureRegisterTriggerAsync, new zzkc(this, zznoVarPoll), new zzjz(this));
    }

    public final void zza(zzjl zzjlVar) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(zzjlVar);
        if (this.zzd.add(zzjlVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener already registered");
    }

    public final void zzat() {
        zzt();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.zzr == null) {
            this.zzs = new zzkf(this, this.zzu);
            this.zzr = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzjy
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) throws IllegalStateException {
                    this.zza.zza(sharedPreferences, str);
                }
            };
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.zzr);
    }

    public final void zza(long j) throws IllegalStateException {
        zzc((String) null);
        zzl().zzb(new zzkl(this, j));
    }

    final void zzb(long j) throws IllegalStateException {
        zza(j, true);
    }

    final void zza(long j, boolean z) throws IllegalStateException {
        zzt();
        zzu();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zznb zznbVarZzp = zzp();
        zznbVarZzp.zzt();
        zznbVarZzp.zzb.zza();
        zzg().zzag();
        boolean zZzac = this.zzu.zzac();
        zzha zzhaVarZzk = zzk();
        zzhaVarZzk.zzc.zza(j);
        if (!TextUtils.isEmpty(zzhaVarZzk.zzk().zzq.zza())) {
            zzhaVarZzk.zzq.zza(null);
        }
        zzhaVarZzk.zzk.zza(0L);
        zzhaVarZzk.zzl.zza(0L);
        if (!zzhaVarZzk.zze().zzx()) {
            zzhaVarZzk.zzb(!zZzac);
        }
        zzhaVarZzk.zzr.zza(null);
        zzhaVarZzk.zzs.zza(0L);
        zzhaVarZzk.zzt.zza(null);
        if (z) {
            zzo().zzai();
        }
        zzp().zza.zza();
        this.zzp = !zZzac;
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) throws IllegalStateException {
        zzl().zzb(new zzki(this, str, str2, j, zzos.zza(bundle), z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) throws IllegalStateException {
        zzl().zzb(new zzkh(this, str, str2, obj, j));
    }

    public final void zzb(boolean z) {
        if (zza().getApplicationContext() instanceof Application) {
            Application application = (Application) zza().getApplicationContext();
            if (this.zzb == null) {
                this.zzb = new zzkz(this);
            }
            if (z) {
                application.unregisterActivityLifecycleCallbacks(this.zzb);
                application.registerActivityLifecycleCallbacks(this.zzb);
                zzj().zzp().zza("Registered activity lifecycle callback");
            }
        }
    }

    final void zzc(String str) {
        this.zzf.set(str);
    }

    public final void zzb(Bundle bundle) throws IllegalStateException {
        zzb(bundle, zzb().currentTimeMillis());
    }

    public final void zzb(Bundle bundle, long j) throws IllegalStateException {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString(HiAnalyticsConstant.BI_KEY_APP_ID))) {
            zzj().zzu().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(HiAnalyticsConstant.BI_KEY_APP_ID);
        Preconditions.checkNotNull(bundle2);
        zzjf.zza(bundle2, HiAnalyticsConstant.BI_KEY_APP_ID, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.ORIGIN, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.VALUE, Object.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzjf.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.ORIGIN));
        Preconditions.checkNotNull(bundle2.get(AppMeasurementSdk.ConditionalUserProperty.VALUE));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle2.get(AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (zzq().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
            return;
        }
        if (zzq().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
            return;
        }
        Object objZzc = zzq().zzc(string, obj);
        if (objZzc == null) {
            zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
            return;
        }
        zzjf.zza(bundle2, objZzc);
        long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j2 > 15552000000L || j2 < 1)) {
            zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        if (j3 > 15552000000L || j3 < 1) {
            zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j3));
        } else {
            zzl().zzb(new zzko(this, bundle2));
        }
    }

    public final void zzc(final Bundle bundle, final long j) throws IllegalStateException {
        zzl().zzc(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjw
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.zza.zza(bundle, j);
            }
        });
    }

    private final void zza(Bundle bundle, int i, long j) throws IllegalStateException {
        String str;
        zzu();
        String strZza = zzje.zza(bundle);
        if (strZza != null) {
            zzj().zzv().zza("Ignoring invalid consent setting", strZza);
            zzj().zzv().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zZzg = zzl().zzg();
        zzje zzjeVarZza = zzje.zza(bundle, i);
        if (zzjeVarZza.zzi()) {
            zza(zzjeVarZza, j, zZzg);
        }
        zzax zzaxVarZza = zzax.zza(bundle, i);
        if (zzaxVarZza.zzg()) {
            zza(zzaxVarZza, zZzg);
        }
        Boolean boolZza = zzax.zza(bundle);
        if (boolZza != null) {
            if (i == -30) {
                str = "tcf";
            } else {
                str = "app";
            }
            String str2 = str;
            if (zze().zza(zzbh.zzcs) && zZzg) {
                zza(str2, "allow_personalized_ads", boolZza.toString(), j);
            } else {
                zza(str2, "allow_personalized_ads", (Object) boolZza.toString(), false, j);
            }
        }
    }

    public final void zzd(Bundle bundle, long j) throws IllegalStateException {
        zza(bundle, -20, j);
    }

    public final void zzc(boolean z) throws IllegalStateException {
        zzu();
        zzl().zzb(new zzke(this, z));
    }

    public final void zzc(Bundle bundle) throws IllegalStateException {
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjt
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                this.zza.zza(bundle2);
            }
        });
    }

    final void zza(zzax zzaxVar, boolean z) {
        zzky zzkyVar = new zzky(this, zzaxVar);
        if (z) {
            zzt();
            zzkyVar.run();
        } else {
            zzl().zzb(zzkyVar);
        }
    }

    public final void zza(zzjm zzjmVar) {
        zzjm zzjmVar2;
        zzt();
        zzu();
        if (zzjmVar != null && zzjmVar != (zzjmVar2 = this.zzc)) {
            Preconditions.checkState(zzjmVar2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzjmVar;
    }

    public final void zza(Boolean bool) throws IllegalStateException {
        zzu();
        zzl().zzb(new zzkv(this, bool));
    }

    final void zza(zzje zzjeVar) {
        zzt();
        boolean z = (zzjeVar.zzh() && zzjeVar.zzg()) || zzo().zzan();
        if (z != this.zzu.zzad()) {
            this.zzu.zzb(z);
            Boolean boolZzu = zzk().zzu();
            if (!z || boolZzu == null || boolZzu.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z) throws IllegalStateException {
        zzt();
        zzu();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzad() || !(bool == null || bool.booleanValue())) {
            zzav();
        }
    }

    public final void zzc(long j) throws IllegalStateException {
        zzl().zzb(new zzkg(this, j));
    }

    public final void zza(Intent intent) throws IllegalStateException {
        if (zzpu.zza() && zze().zza(zzbh.zzby)) {
            Uri data = intent.getData();
            if (data == null) {
                zzj().zzo().zza("Activity intent has no data. Preview Mode was not enabled.");
                return;
            }
            String queryParameter = data.getQueryParameter("sgtm_debug_enable");
            if (queryParameter == null || !queryParameter.equals("1")) {
                zzj().zzo().zza("Preview Mode was not enabled.");
                zze().zzh(null);
                return;
            }
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            zzj().zzo().zza("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zze().zzh(queryParameter2);
        }
    }

    public final void zza(zzje zzjeVar, long j, boolean z) {
        zzje zzjeVar2;
        boolean z2;
        boolean zZzc;
        boolean z3;
        zzje zzjeVarZzb = zzjeVar;
        zzu();
        int iZza = zzjeVar.zza();
        if (iZza != -10) {
            zzjh zzjhVarZzc = zzjeVar.zzc();
            zzjh zzjhVar = zzjh.UNINITIALIZED;
            if (zzjhVarZzc == zzjhVar && zzjeVar.zzd() == zzjhVar) {
                zzj().zzv().zza("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.zzg) {
            try {
                zzjeVar2 = this.zzm;
                z2 = false;
                if (zzje.zza(iZza, zzjeVar2.zza())) {
                    zZzc = zzjeVar.zzc(this.zzm);
                    if (zzjeVar.zzh() && !this.zzm.zzh()) {
                        z2 = true;
                    }
                    zzjeVarZzb = zzjeVar.zzb(this.zzm);
                    this.zzm = zzjeVarZzb;
                    z3 = z2;
                    z2 = true;
                } else {
                    zZzc = false;
                    z3 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2) {
            zzj().zzo().zza("Ignoring lower-priority consent settings, proposed settings", zzjeVarZzb);
            return;
        }
        long andIncrement = this.zzn.getAndIncrement();
        if (zZzc) {
            zzc((String) null);
            zzkx zzkxVar = new zzkx(this, zzjeVarZzb, j, andIncrement, z3, zzjeVar2);
            if (z) {
                zzt();
                zzkxVar.run();
                return;
            } else {
                zzl().zzc(zzkxVar);
                return;
            }
        }
        zzla zzlaVar = new zzla(this, zzjeVarZzb, andIncrement, z3, zzjeVar2);
        if (z) {
            zzt();
            zzlaVar.run();
        } else if (iZza == 30 || iZza == -10) {
            zzl().zzc(zzlaVar);
        } else {
            zzl().zzb(zzlaVar);
        }
    }

    public final void zza(final String str, long j) throws IllegalStateException {
        if (str != null && TextUtils.isEmpty(str)) {
            this.zzu.zzj().zzu().zza("User ID must be non-empty or null");
        } else {
            zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjx
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb(str);
                }
            });
            zza((String) null, "_id", (Object) str, true, j);
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzb().currentTimeMillis());
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.String r7, java.lang.String r8, java.lang.Object r9, boolean r10, long r11) throws java.lang.IllegalStateException {
        /*
            r6 = this;
            if (r7 != 0) goto L4
            java.lang.String r7 = "app"
        L4:
            r1 = r7
            r7 = 0
            r0 = 24
            if (r10 == 0) goto L13
            com.google.android.gms.measurement.internal.zzos r10 = r6.zzq()
            int r10 = r10.zzb(r8)
            goto L35
        L13:
            com.google.android.gms.measurement.internal.zzos r10 = r6.zzq()
            java.lang.String r2 = "user property"
            boolean r3 = r10.zzc(r2, r8)
            r4 = 6
            if (r3 != 0) goto L22
        L20:
            r10 = r4
            goto L35
        L22:
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzjj.zza
            boolean r3 = r10.zza(r2, r3, r8)
            if (r3 != 0) goto L2d
            r10 = 15
            goto L35
        L2d:
            boolean r10 = r10.zza(r2, r0, r8)
            if (r10 != 0) goto L34
            goto L20
        L34:
            r10 = r7
        L35:
            java.lang.String r2 = "_ev"
            r3 = 1
            if (r10 == 0) goto L52
            r6.zzq()
            java.lang.String r9 = com.google.android.gms.measurement.internal.zzos.zza(r8, r0, r3)
            if (r8 == 0) goto L47
            int r7 = r8.length()
        L47:
            com.google.android.gms.measurement.internal.zzhy r8 = r6.zzu
            r8.zzt()
            com.google.android.gms.measurement.internal.zzor r8 = r6.zzt
            com.google.android.gms.measurement.internal.zzos.zza(r8, r10, r2, r9, r7)
            return
        L52:
            if (r9 == 0) goto L91
            com.google.android.gms.measurement.internal.zzos r10 = r6.zzq()
            int r10 = r10.zza(r8, r9)
            if (r10 == 0) goto L80
            r6.zzq()
            java.lang.String r8 = com.google.android.gms.measurement.internal.zzos.zza(r8, r0, r3)
            boolean r11 = r9 instanceof java.lang.String
            if (r11 != 0) goto L6d
            boolean r11 = r9 instanceof java.lang.CharSequence
            if (r11 == 0) goto L75
        L6d:
            java.lang.String r7 = java.lang.String.valueOf(r9)
            int r7 = r7.length()
        L75:
            com.google.android.gms.measurement.internal.zzhy r9 = r6.zzu
            r9.zzt()
            com.google.android.gms.measurement.internal.zzor r9 = r6.zzt
            com.google.android.gms.measurement.internal.zzos.zza(r9, r10, r2, r8, r7)
            return
        L80:
            com.google.android.gms.measurement.internal.zzos r7 = r6.zzq()
            java.lang.Object r5 = r7.zzc(r8, r9)
            if (r5 == 0) goto L90
            r0 = r6
            r2 = r8
            r3 = r11
            r0.zza(r1, r2, r3, r5)
        L90:
            return
        L91:
            r5 = 0
            r0 = r6
            r2 = r8
            r3 = r11
            r0.zza(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjq.zza(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zza(java.lang.String r10, java.lang.String r11, java.lang.Object r12, long r13) throws java.lang.IllegalStateException {
        /*
            r9 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r9.zzt()
            r9.zzu()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L6e
            boolean r0 = r12 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L51
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L51
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            java.lang.String r12 = "false"
            boolean r11 = r12.equals(r11)
            r2 = 1
            if (r11 == 0) goto L35
            r4 = r2
            goto L37
        L35:
            r4 = 0
        L37:
            java.lang.Long r11 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzha r0 = r9.zzk()
            com.google.android.gms.measurement.internal.zzhd r0 = r0.zzh
            long r4 = r11.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L4b
            java.lang.String r12 = "true"
        L4b:
            r0.zza(r12)
            r12 = r11
        L4f:
            r11 = r1
            goto L5f
        L51:
            if (r12 != 0) goto L5f
            com.google.android.gms.measurement.internal.zzha r11 = r9.zzk()
            com.google.android.gms.measurement.internal.zzhd r11 = r11.zzh
            java.lang.String r0 = "unset"
            r11.zza(r0)
            goto L4f
        L5f:
            com.google.android.gms.measurement.internal.zzgo r0 = r9.zzj()
            com.google.android.gms.measurement.internal.zzgq r0 = r0.zzp()
            java.lang.String r1 = "Setting user property(FE)"
            java.lang.String r2 = "non_personalized_ads(_npa)"
            r0.zza(r1, r2, r12)
        L6e:
            r4 = r11
            r7 = r12
            com.google.android.gms.measurement.internal.zzhy r11 = r9.zzu
            boolean r11 = r11.zzac()
            if (r11 != 0) goto L86
            com.google.android.gms.measurement.internal.zzgo r10 = r9.zzj()
            com.google.android.gms.measurement.internal.zzgq r10 = r10.zzp()
            java.lang.String r11 = "User property not set since app measurement is disabled"
            r10.zza(r11)
            return
        L86:
            com.google.android.gms.measurement.internal.zzhy r11 = r9.zzu
            boolean r11 = r11.zzaf()
            if (r11 != 0) goto L8f
            return
        L8f:
            com.google.android.gms.measurement.internal.zzon r11 = new com.google.android.gms.measurement.internal.zzon
            r3 = r11
            r5 = r13
            r8 = r10
            r3.<init>(r4, r5, r7, r8)
            com.google.android.gms.measurement.internal.zzls r10 = r9.zzo()
            r10.zza(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjq.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void zzb(zzjl zzjlVar) throws IllegalStateException {
        zzu();
        Preconditions.checkNotNull(zzjlVar);
        if (this.zzd.remove(zzjlVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener had not been registered");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzav() throws IllegalStateException {
        zzt();
        String strZza = zzk().zzh.zza();
        if (strZza != null) {
            if ("unset".equals(strZza)) {
                zza("app", "_npa", (Object) null, zzb().currentTimeMillis());
            } else {
                zza("app", "_npa", Long.valueOf("true".equals(strZza) ? 1L : 0L), zzb().currentTimeMillis());
            }
        }
        if (this.zzu.zzac() && this.zzp) {
            zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzan();
            zzp().zza.zza();
            zzl().zzb(new zzkd(this));
            return;
        }
        zzj().zzc().zza("Updating Scion state (FE)");
        zzo().zzak();
    }

    final boolean zzau() {
        return this.zzl;
    }
}
