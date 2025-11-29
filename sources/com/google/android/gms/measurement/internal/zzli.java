package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzov;
import com.google.android.gms.internal.measurement.zzpo;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes2.dex */
final class zzli extends zznr {
    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // com.google.android.gms.measurement.internal.zznr
    protected final boolean zzc() {
        return false;
    }

    public zzli(zznv zznvVar) {
        super(zznvVar);
    }

    public final byte[] zza(zzbf zzbfVar, String str) throws IllegalStateException {
        zzop next;
        Bundle bundle;
        zzfy.zzk.zza zzaVar;
        zzfy.zzj.zza zzaVar2;
        zzg zzgVar;
        byte[] bArr;
        long j;
        zzbb zzbbVarZza;
        zzt();
        this.zzu.zzy();
        Preconditions.checkNotNull(zzbfVar);
        Preconditions.checkNotEmpty(str);
        if (!zze().zze(str, zzbh.zzbl)) {
            zzj().zzc().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzbfVar.zza) && !"_iapx".equals(zzbfVar.zza)) {
            zzj().zzc().zza("Generating a payload for this event is not available. package_name, event_name", str, zzbfVar.zza);
            return null;
        }
        zzfy.zzj.zza zzaVarZzb = zzfy.zzj.zzb();
        zzh().zzp();
        try {
            zzg zzgVarZze = zzh().zze(str);
            if (zzgVarZze == null) {
                zzj().zzc().zza("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!zzgVarZze.zzar()) {
                zzj().zzc().zza("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            zzfy.zzk.zza zzaVarZzp = zzfy.zzk.zzw().zzh(1).zzp("android");
            if (!TextUtils.isEmpty(zzgVarZze.zzac())) {
                zzaVarZzp.zzb(zzgVarZze.zzac());
            }
            if (!TextUtils.isEmpty(zzgVarZze.zzae())) {
                zzaVarZzp.zzd((String) Preconditions.checkNotNull(zzgVarZze.zzae()));
            }
            if (!TextUtils.isEmpty(zzgVarZze.zzaf())) {
                zzaVarZzp.zze((String) Preconditions.checkNotNull(zzgVarZze.zzaf()));
            }
            if (zzgVarZze.zze() != -2147483648L) {
                zzaVarZzp.zze((int) zzgVarZze.zze());
            }
            zzaVarZzp.zzf(zzgVarZze.zzq()).zzd(zzgVarZze.zzo());
            String strZzah = zzgVarZze.zzah();
            String strZzaa = zzgVarZze.zzaa();
            if (!TextUtils.isEmpty(strZzah)) {
                zzaVarZzp.zzm(strZzah);
            } else if (!TextUtils.isEmpty(strZzaa)) {
                zzaVarZzp.zza(strZzaa);
            }
            zzaVarZzp.zzj(zzgVarZze.zzw());
            zzje zzjeVarZzb = this.zzg.zzb(str);
            zzaVarZzp.zzc(zzgVarZze.zzn());
            if (this.zzu.zzac() && zze().zzj(zzaVarZzp.zzt()) && zzjeVarZzb.zzg() && !TextUtils.isEmpty(null)) {
                zzaVarZzp.zzj((String) null);
            }
            zzaVarZzp.zzg(zzjeVarZzb.zze());
            if (zzjeVarZzb.zzg() && zzgVarZze.zzaq()) {
                Pair<String, Boolean> pairZza = zzn().zza(zzgVarZze.zzac(), zzjeVarZzb);
                if (zzgVarZze.zzaq() && pairZza != null && !TextUtils.isEmpty((CharSequence) pairZza.first)) {
                    zzaVarZzp.zzq(zza((String) pairZza.first, Long.toString(zzbfVar.zzd)));
                    Object obj = pairZza.second;
                    if (obj != null) {
                        zzaVarZzp.zzc(((Boolean) obj).booleanValue());
                    }
                }
            }
            zzf().zzac();
            zzfy.zzk.zza zzaVarZzi = zzaVarZzp.zzi(Build.MODEL);
            zzf().zzac();
            zzaVarZzi.zzo(Build.VERSION.RELEASE).zzj((int) zzf().zzc()).zzs(zzf().zzg());
            if (zzjeVarZzb.zzh() && zzgVarZze.zzad() != null) {
                zzaVarZzp.zzc(zza((String) Preconditions.checkNotNull(zzgVarZze.zzad()), Long.toString(zzbfVar.zzd)));
            }
            if (!TextUtils.isEmpty(zzgVarZze.zzag())) {
                zzaVarZzp.zzl((String) Preconditions.checkNotNull(zzgVarZze.zzag()));
            }
            String strZzac = zzgVarZze.zzac();
            List<zzop> listZzl = zzh().zzl(strZzac);
            Iterator<zzop> it = listZzl.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if ("_lte".equals(next.zzc)) {
                    break;
                }
            }
            if (next == null || next.zze == null) {
                zzop zzopVar = new zzop(strZzac, "auto", "_lte", zzb().currentTimeMillis(), 0L);
                listZzl.add(zzopVar);
                zzh().zza(zzopVar);
            }
            zzfy.zzo[] zzoVarArr = new zzfy.zzo[listZzl.size()];
            for (int i = 0; i < listZzl.size(); i++) {
                zzfy.zzo.zza zzaVarZzb2 = zzfy.zzo.zze().zza(listZzl.get(i).zzc).zzb(listZzl.get(i).zzd);
                g_().zza(zzaVarZzb2, listZzl.get(i).zze);
                zzoVarArr[i] = (zzfy.zzo) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzb2.zzai());
            }
            zzaVarZzp.zze(Arrays.asList(zzoVarArr));
            this.zzg.zza(zzgVarZze, zzaVarZzp);
            if (zzov.zza() && zze().zza(zzbh.zzcu)) {
                this.zzg.zzb(zzgVarZze, zzaVarZzp);
            }
            zzgs zzgsVarZza = zzgs.zza(zzbfVar);
            zzq().zza(zzgsVarZza.zzc, zzh().zzd(str));
            zzq().zza(zzgsVarZza, zze().zzb(str));
            Bundle bundle2 = zzgsVarZza.zzc;
            bundle2.putLong("_c", 1L);
            zzj().zzc().zza("Marking in-app purchase as real-time");
            bundle2.putLong("_r", 1L);
            bundle2.putString("_o", zzbfVar.zzc);
            if (zzq().zzd(zzaVarZzp.zzt(), zzgVarZze.zzam())) {
                zzq().zza(bundle2, "_dbg", (Object) 1L);
                zzq().zza(bundle2, "_r", (Object) 1L);
            }
            zzbb zzbbVarZzd = zzh().zzd(str, zzbfVar.zza);
            if (zzbbVarZzd == null) {
                bundle = bundle2;
                zzaVar = zzaVarZzp;
                zzaVar2 = zzaVarZzb;
                zzgVar = zzgVarZze;
                bArr = null;
                zzbbVarZza = new zzbb(str, zzbfVar.zza, 0L, 0L, zzbfVar.zzd, 0L, null, null, null, null);
                j = 0;
            } else {
                bundle = bundle2;
                zzaVar = zzaVarZzp;
                zzaVar2 = zzaVarZzb;
                zzgVar = zzgVarZze;
                bArr = null;
                j = zzbbVarZzd.zzf;
                zzbbVarZza = zzbbVarZzd.zza(zzbfVar.zzd);
            }
            zzh().zza(zzbbVarZza);
            zzbc zzbcVar = new zzbc(this.zzu, zzbfVar.zzc, str, zzbfVar.zza, zzbfVar.zzd, j, bundle);
            zzfy.zzf.zza zzaVarZza = zzfy.zzf.zze().zzb(zzbcVar.zzd).zza(zzbcVar.zzb).zza(zzbcVar.zze);
            Iterator<String> it2 = zzbcVar.zzf.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                zzfy.zzh.zza zzaVarZza2 = zzfy.zzh.zze().zza(next2);
                Object objZzc = zzbcVar.zzf.zzc(next2);
                if (objZzc != null) {
                    g_().zza(zzaVarZza2, objZzc);
                    zzaVarZza.zza(zzaVarZza2);
                }
            }
            zzfy.zzk.zza zzaVar3 = zzaVar;
            zzaVar3.zza(zzaVarZza).zza(zzfy.zzl.zza().zza(zzfy.zzg.zza().zza(zzbbVarZza.zzc).zza(zzbfVar.zza)));
            zzaVar3.zza(zzg().zza(zzgVar.zzac(), Collections.emptyList(), zzaVar3.zzab(), Long.valueOf(zzaVarZza.zzc()), Long.valueOf(zzaVarZza.zzc())));
            if (zzaVarZza.zzg()) {
                zzaVar3.zzi(zzaVarZza.zzc()).zze(zzaVarZza.zzc());
            }
            long jZzs = zzgVar.zzs();
            if (jZzs != 0) {
                zzaVar3.zzg(jZzs);
            }
            long jZzu = zzgVar.zzu();
            if (jZzu != 0) {
                zzaVar3.zzh(jZzu);
            } else if (jZzs != 0) {
                zzaVar3.zzh(jZzs);
            }
            String strZzal = zzgVar.zzal();
            if (zzpo.zza() && zze().zze(str, zzbh.zzbw) && strZzal != null) {
                zzaVar3.zzr(strZzal);
            }
            zzgVar.zzap();
            zzaVar3.zzf((int) zzgVar.zzt()).zzl(106000L).zzk(zzb().currentTimeMillis()).zzd(true);
            this.zzg.zza(zzaVar3.zzt(), zzaVar3);
            zzfy.zzj.zza zzaVar4 = zzaVar2;
            zzaVar4.zza(zzaVar3);
            zzg zzgVar2 = zzgVar;
            zzgVar2.zzr(zzaVar3.zzf());
            zzgVar2.zzp(zzaVar3.zze());
            zzh().zza(zzgVar2, false, false);
            zzh().zzw();
            try {
                return g_().zzb(((zzfy.zzj) ((com.google.android.gms.internal.measurement.zzjt) zzaVar4.zzai())).zzca());
            } catch (IOException e) {
                zzj().zzg().zza("Data loss. Failed to bundle and serialize. appId", zzgo.zza(str), e);
                return bArr;
            }
        } catch (SecurityException e2) {
            zzj().zzc().zza("Resettable device id encryption failed", e2.getMessage());
            return new byte[0];
        } catch (SecurityException e3) {
            zzj().zzc().zza("app instance id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
            zzh().zzu();
        }
    }
}
