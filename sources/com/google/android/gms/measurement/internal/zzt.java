package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfy;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes2.dex */
final class zzt extends zznr {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzv> zzc;
    private Long zzd;
    private Long zze;

    private final zzv zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzv zzvVar = new zzv(this, this.zza);
        this.zzc.put(num, zzvVar);
        return zzvVar;
    }

    @Override // com.google.android.gms.measurement.internal.zznr
    protected final boolean zzc() {
        return false;
    }

    final List<zzfy.zzd> zza(String str, List<zzfy.zzf> list, List<zzfy.zzo> list2, Long l, Long l2) {
        return zza(str, list, list2, l, l2, false);
    }

    final List<zzfy.zzd> zza(String str, List<zzfy.zzf> list, List<zzfy.zzo> list2, Long l, Long l2, boolean z) throws IllegalStateException {
        boolean z2;
        Map<Integer, zzfy.zzm> map;
        List<zzfo.zzb> list3;
        Iterator it;
        Iterator<zzfy.zzn> it2;
        Map<Integer, zzfy.zzm> map2;
        Map<Integer, List<Integer>> map3;
        Iterator<Integer> it3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator<zzfy.zzf> it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(it4.next().zzg())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = com.google.android.gms.internal.measurement.zzoe.zza() && zze().zzf(this.zza, zzbh.zzbp);
        boolean z4 = com.google.android.gms.internal.measurement.zzoe.zza() && zze().zzf(this.zza, zzbh.zzbo);
        if (z2) {
            zzal zzalVarZzh = zzh();
            String str2 = this.zza;
            zzalVarZzh.zzal();
            zzalVarZzh.zzt();
            Preconditions.checkNotEmpty(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                zzalVarZzh.e_().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e) {
                zzalVarZzh.zzj().zzg().zza("Error resetting session-scoped event counts. appId", zzgo.zza(str2), e);
            }
        }
        Map<Integer, List<zzfo.zzb>> mapEmptyMap = Collections.emptyMap();
        if (z4 && z3) {
            mapEmptyMap = zzh().zzn(this.zza);
        }
        Map<Integer, zzfy.zzm> mapZzm = zzh().zzm(this.zza);
        if (!mapZzm.isEmpty()) {
            HashSet hashSet = new HashSet(mapZzm.keySet());
            if (z2) {
                String str3 = this.zza;
                Map<Integer, List<Integer>> mapZzo = zzh().zzo(this.zza);
                Preconditions.checkNotEmpty(str3);
                Preconditions.checkNotNull(mapZzm);
                ArrayMap arrayMap = new ArrayMap();
                if (!mapZzm.isEmpty()) {
                    Iterator<Integer> it5 = mapZzm.keySet().iterator();
                    while (it5.hasNext()) {
                        Integer next = it5.next();
                        next.intValue();
                        zzfy.zzm zzmVar = mapZzm.get(next);
                        List<Integer> list4 = mapZzo.get(next);
                        if (list4 == null || list4.isEmpty()) {
                            map3 = mapZzo;
                            it3 = it5;
                            arrayMap.put(next, zzmVar);
                        } else {
                            List<Long> listZza = g_().zza(zzmVar.zzi(), list4);
                            if (!listZza.isEmpty()) {
                                zzfy.zzm.zza zzaVarZzb = zzmVar.zzcd().zzb().zzb(listZza);
                                zzaVarZzb.zzd().zzd(g_().zza(zzmVar.zzk(), list4));
                                ArrayList arrayList = new ArrayList();
                                for (zzfy.zze zzeVar : zzmVar.zzh()) {
                                    Map<Integer, List<Integer>> map4 = mapZzo;
                                    Iterator<Integer> it6 = it5;
                                    if (!list4.contains(Integer.valueOf(zzeVar.zza()))) {
                                        arrayList.add(zzeVar);
                                    }
                                    mapZzo = map4;
                                    it5 = it6;
                                }
                                map3 = mapZzo;
                                it3 = it5;
                                zzaVarZzb.zza().zza(arrayList);
                                ArrayList arrayList2 = new ArrayList();
                                for (zzfy.zzn zznVar : zzmVar.zzj()) {
                                    if (!list4.contains(Integer.valueOf(zznVar.zzb()))) {
                                        arrayList2.add(zznVar);
                                    }
                                }
                                zzaVarZzb.zzc().zzc(arrayList2);
                                arrayMap.put(next, (zzfy.zzm) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzb.zzai()));
                            }
                        }
                        mapZzo = map3;
                        it5 = it3;
                    }
                }
                map = arrayMap;
            } else {
                map = mapZzm;
            }
            Iterator it7 = hashSet.iterator();
            while (it7.hasNext()) {
                Integer num = (Integer) it7.next();
                num.intValue();
                zzfy.zzm zzmVar2 = map.get(num);
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap2 = new ArrayMap();
                if (zzmVar2 != null && zzmVar2.zza() != 0) {
                    for (zzfy.zze zzeVar2 : zzmVar2.zzh()) {
                        if (zzeVar2.zzf()) {
                            arrayMap2.put(Integer.valueOf(zzeVar2.zza()), zzeVar2.zze() ? Long.valueOf(zzeVar2.zzb()) : null);
                        }
                    }
                }
                ArrayMap arrayMap3 = new ArrayMap();
                if (zzmVar2 != null && zzmVar2.zzc() != 0) {
                    Iterator<zzfy.zzn> it8 = zzmVar2.zzj().iterator();
                    while (it8.hasNext()) {
                        zzfy.zzn next2 = it8.next();
                        if (!next2.zzf() || next2.zza() <= 0) {
                            it2 = it8;
                            map2 = map;
                        } else {
                            it2 = it8;
                            map2 = map;
                            arrayMap3.put(Integer.valueOf(next2.zzb()), Long.valueOf(next2.zza(next2.zza() - 1)));
                        }
                        it8 = it2;
                        map = map2;
                    }
                }
                Map<Integer, zzfy.zzm> map5 = map;
                if (zzmVar2 != null) {
                    int i = 0;
                    while (i < (zzmVar2.zzd() << 6)) {
                        if (zzoo.zza(zzmVar2.zzk(), i)) {
                            it = it7;
                            zzj().zzp().zza("Filter already evaluated. audience ID, filter ID", num, Integer.valueOf(i));
                            bitSet2.set(i);
                            if (zzoo.zza(zzmVar2.zzi(), i)) {
                                bitSet.set(i);
                            }
                            i++;
                            it7 = it;
                        } else {
                            it = it7;
                        }
                        arrayMap2.remove(Integer.valueOf(i));
                        i++;
                        it7 = it;
                    }
                }
                Iterator it9 = it7;
                zzfy.zzm zzmVar3 = mapZzm.get(num);
                if (z4 && z3 && (list3 = mapEmptyMap.get(num)) != null && this.zze != null && this.zzd != null) {
                    for (zzfo.zzb zzbVar : list3) {
                        int iZzb = zzbVar.zzb();
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzbVar.zzi()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        if (arrayMap2.containsKey(Integer.valueOf(iZzb))) {
                            arrayMap2.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(iZzb))) {
                            arrayMap3.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                    }
                }
                this.zzc.put(num, new zzv(this, this.zza, zzmVar3, bitSet, bitSet2, arrayMap2, arrayMap3));
                it7 = it9;
                mapZzm = mapZzm;
                map = map5;
            }
        }
        if (com.google.android.gms.internal.measurement.zznm.zza() && zze().zzf(null, zzbh.zzcy)) {
            zza(list, z);
            if (z) {
                return new ArrayList();
            }
            zza(list2);
            return zzu();
        }
        zza(list, true);
        zza(list2);
        return zzu();
    }

    private final List<zzfy.zzd> zzu() throws IllegalStateException {
        ArrayList arrayList = new ArrayList();
        Set<Integer> setKeySet = this.zzc.keySet();
        setKeySet.removeAll(this.zzb);
        for (Integer num : setKeySet) {
            int iIntValue = num.intValue();
            zzv zzvVar = this.zzc.get(num);
            Preconditions.checkNotNull(zzvVar);
            zzfy.zzd zzdVarZza = zzvVar.zza(iIntValue);
            arrayList.add(zzdVarZza);
            zzal zzalVarZzh = zzh();
            String str = this.zza;
            zzfy.zzm zzmVarZzd = zzdVarZza.zzd();
            zzalVarZzh.zzal();
            zzalVarZzh.zzt();
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotNull(zzmVarZzd);
            byte[] bArrZzca = zzmVarZzd.zzca();
            ContentValues contentValues = new ContentValues();
            contentValues.put(HiAnalyticsConstant.BI_KEY_APP_ID, str);
            contentValues.put("audience_id", num);
            contentValues.put("current_results", bArrZzca);
            try {
                if (zzalVarZzh.e_().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    zzalVarZzh.zzj().zzg().zza("Failed to insert filter results (got -1). appId", zzgo.zza(str));
                }
            } catch (SQLiteException e) {
                zzalVarZzh.zzj().zzg().zza("Error storing filter results. appId", zzgo.zza(str), e);
            }
        }
        return arrayList;
    }

    zzt(zznv zznvVar) {
        super(zznvVar);
    }

    private final void zza(List<zzfy.zzf> list, boolean z) throws IllegalStateException {
        zzbb zzbbVar;
        zzy zzyVar;
        Integer num;
        Map<Integer, List<zzfo.zzb>> map;
        long j;
        if (list.isEmpty()) {
            return;
        }
        String str = null;
        zzy zzyVar2 = new zzy(this);
        ArrayMap arrayMap = new ArrayMap();
        for (zzfy.zzf zzfVar : list) {
            zzfy.zzf zzfVarZza = zzyVar2.zza(this.zza, zzfVar);
            if (zzfVarZza != null) {
                zzal zzalVarZzh = zzh();
                String str2 = this.zza;
                String strZzg = zzfVarZza.zzg();
                zzbb zzbbVarZzd = zzalVarZzh.zzd(str2, zzfVar.zzg());
                if (zzbbVarZzd == null) {
                    zzalVarZzh.zzj().zzu().zza("Event aggregate wasn't created during raw event logging. appId, event", zzgo.zza(str2), zzalVarZzh.zzi().zza(strZzg));
                    zzbbVar = new zzbb(str2, zzfVar.zzg(), 1L, 1L, 1L, zzfVar.zzd(), 0L, null, null, null, null);
                } else {
                    zzbbVar = new zzbb(zzbbVarZzd.zza, zzbbVarZzd.zzb, zzbbVarZzd.zzc + 1, zzbbVarZzd.zzd + 1, zzbbVarZzd.zze + 1, zzbbVarZzd.zzf, zzbbVarZzd.zzg, zzbbVarZzd.zzh, zzbbVarZzd.zzi, zzbbVarZzd.zzj, zzbbVarZzd.zzk);
                }
                zzbb zzbbVar2 = zzbbVar;
                zzh().zza(zzbbVar2);
                if (!com.google.android.gms.internal.measurement.zznm.zza() || !zze().zzf(str, zzbh.zzcy) || !z) {
                    long j2 = zzbbVar2.zzc;
                    String strZzg2 = zzfVarZza.zzg();
                    Map<Integer, List<zzfo.zzb>> mapZzf = (Map) arrayMap.get(strZzg2);
                    if (mapZzf == null) {
                        mapZzf = zzh().zzf(this.zza, strZzg2);
                        arrayMap.put(strZzg2, mapZzf);
                    }
                    Map<Integer, List<zzfo.zzb>> map2 = mapZzf;
                    Iterator<Integer> it = map2.keySet().iterator();
                    while (it.hasNext()) {
                        Integer next = it.next();
                        int iIntValue = next.intValue();
                        if (this.zzb.contains(next)) {
                            zzj().zzp().zza("Skipping failed audience ID", next);
                        } else {
                            Iterator<zzfo.zzb> it2 = map2.get(next).iterator();
                            boolean zZza = true;
                            while (true) {
                                if (!it2.hasNext()) {
                                    zzyVar = zzyVar2;
                                    num = next;
                                    map = map2;
                                    j = j2;
                                    break;
                                }
                                zzfo.zzb next2 = it2.next();
                                zzx zzxVar = new zzx(this, this.zza, iIntValue, next2);
                                zzyVar = zzyVar2;
                                num = next;
                                int i = iIntValue;
                                map = map2;
                                j = j2;
                                zZza = zzxVar.zza(this.zzd, this.zze, zzfVarZza, j2, zzbbVar2, zza(iIntValue, next2.zzb()));
                                if (zZza) {
                                    zza(num).zza(zzxVar);
                                    next = num;
                                    zzyVar2 = zzyVar;
                                    iIntValue = i;
                                    map2 = map;
                                    j2 = j;
                                } else {
                                    this.zzb.add(num);
                                    break;
                                }
                            }
                            if (!zZza) {
                                this.zzb.add(num);
                            }
                            zzyVar2 = zzyVar;
                            map2 = map;
                            j2 = j;
                            str = null;
                        }
                    }
                }
            }
        }
    }

    private final void zza(List<zzfy.zzo> list) throws IllegalStateException {
        zzfo.zze next;
        if (list.isEmpty()) {
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzfy.zzo zzoVar : list) {
            String strZzg = zzoVar.zzg();
            Map<Integer, List<zzfo.zze>> mapZzg = (Map) arrayMap.get(strZzg);
            if (mapZzg == null) {
                mapZzg = zzh().zzg(this.zza, strZzg);
                arrayMap.put(strZzg, mapZzg);
            }
            Iterator<Integer> it = mapZzg.keySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Integer next2 = it.next();
                    int iIntValue = next2.intValue();
                    if (this.zzb.contains(next2)) {
                        zzj().zzp().zza("Skipping failed audience ID", next2);
                        break;
                    }
                    Iterator<zzfo.zze> it2 = mapZzg.get(next2).iterator();
                    boolean zZza = true;
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        next = it2.next();
                        if (zzj().zza(2)) {
                            zzj().zzp().zza("Evaluating filter. audience, filter, property", next2, next.zzi() ? Integer.valueOf(next.zza()) : null, zzi().zzc(next.zze()));
                            zzj().zzp().zza("Filter definition", g_().zza(next));
                        }
                        if (!next.zzi() || next.zza() > 256) {
                            break;
                        }
                        zzz zzzVar = new zzz(this, this.zza, iIntValue, next);
                        zZza = zzzVar.zza(this.zzd, this.zze, zzoVar, zza(iIntValue, next.zza()));
                        if (zZza) {
                            zza(next2).zza(zzzVar);
                        } else {
                            this.zzb.add(next2);
                            break;
                        }
                    }
                    zzj().zzu().zza("Invalid property filter ID. appId, id", zzgo.zza(this.zza), String.valueOf(next.zzi() ? Integer.valueOf(next.zza()) : null));
                    zZza = false;
                    if (!zZza) {
                        this.zzb.add(next2);
                    }
                }
            }
        }
    }

    private final boolean zza(int i, int i2) {
        zzv zzvVar = this.zzc.get(Integer.valueOf(i));
        if (zzvVar == null) {
            return false;
        }
        return zzvVar.zzd.get(i2);
    }
}
