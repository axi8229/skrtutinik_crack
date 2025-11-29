package com.google.android.gms.internal.measurement;

import com.yandex.varioqub.config.model.ConfigValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.1.2 */
/* loaded from: classes2.dex */
public final class zzbe {
    private static zzaf zza(zzaf zzafVar, zzh zzhVar, zzal zzalVar, Boolean bool, Boolean bool2) {
        zzaf zzafVar2 = new zzaf();
        Iterator<Integer> itZzg = zzafVar.zzg();
        while (itZzg.hasNext()) {
            int iIntValue = itZzg.next().intValue();
            if (zzafVar.zzc(iIntValue)) {
                zzaq zzaqVarZza = zzalVar.zza(zzhVar, Arrays.asList(zzafVar.zza(iIntValue), new zzai(Double.valueOf(iIntValue)), zzafVar));
                if (zzaqVarZza.zzd().equals(bool)) {
                    return zzafVar2;
                }
                if (bool2 == null || zzaqVarZza.zzd().equals(bool2)) {
                    zzafVar2.zzb(iIntValue, zzaqVarZza);
                }
            }
        }
        return zzafVar2;
    }

    private static zzaf zza(zzaf zzafVar, zzh zzhVar, zzal zzalVar) {
        return zza(zzafVar, zzhVar, zzalVar, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzaq zza(String str, zzaf zzafVar, zzh zzhVar, List<zzaq> list) {
        String str2;
        char c;
        double d;
        double dZza;
        String strZzf;
        zzal zzalVar;
        double dMin;
        int i;
        zzh zzhVar2;
        Double d2;
        double dZza2;
        str.hashCode();
        Double dValueOf = Double.valueOf(-1.0d);
        switch (str.hashCode()) {
            case -1776922004:
                str2 = "toString";
                if (str.equals(str2)) {
                    c = 0;
                    break;
                } else {
                    c = 65535;
                    break;
                }
            case -1354795244:
                if (str.equals("concat")) {
                    str2 = "toString";
                    c = 1;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    c = 2;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    str2 = "toString";
                    c = 3;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -895859076:
                if (str.equals("splice")) {
                    c = 4;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    c = 5;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c = 6;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    c = 7;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 107868:
                if (str.equals("map")) {
                    c = '\b';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 111185:
                if (str.equals("pop")) {
                    c = '\t';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3267882:
                if (str.equals("join")) {
                    c = '\n';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3452698:
                if (str.equals("push")) {
                    c = 11;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3536116:
                if (str.equals("some")) {
                    c = '\f';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3536286:
                if (str.equals("sort")) {
                    c = '\r';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 96891675:
                if (str.equals("every")) {
                    c = 14;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c = 15;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = 16;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c = 17;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c = 18;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c = 19;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            default:
                str2 = "toString";
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                zzg.zza(str2, 0, list);
                return new zzas(zzafVar.toString());
            case 1:
                zzaf zzafVar2 = (zzaf) zzafVar.zzc();
                if (!list.isEmpty()) {
                    Iterator<zzaq> it = list.iterator();
                    while (it.hasNext()) {
                        zzaq zzaqVarZza = zzhVar.zza(it.next());
                        if (zzaqVarZza instanceof zzaj) {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                        int iZzb = zzafVar2.zzb();
                        if (zzaqVarZza instanceof zzaf) {
                            zzaf zzafVar3 = (zzaf) zzaqVarZza;
                            Iterator<Integer> itZzg = zzafVar3.zzg();
                            while (itZzg.hasNext()) {
                                Integer next = itZzg.next();
                                zzafVar2.zzb(next.intValue() + iZzb, zzafVar3.zza(next.intValue()));
                            }
                        } else {
                            zzafVar2.zzb(iZzb, zzaqVarZza);
                        }
                    }
                }
                return zzafVar2;
            case 2:
                zzg.zza("filter", 1, list);
                zzaq zzaqVarZza2 = zzhVar.zza(list.get(0));
                if (!(zzaqVarZza2 instanceof zzar)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzafVar.zza() == 0) {
                    return new zzaf();
                }
                zzaf zzafVar4 = (zzaf) zzafVar.zzc();
                zzaf zzafVarZza = zza(zzafVar, zzhVar, (zzar) zzaqVarZza2, null, Boolean.TRUE);
                zzaf zzafVar5 = new zzaf();
                Iterator<Integer> itZzg2 = zzafVarZza.zzg();
                while (itZzg2.hasNext()) {
                    zzafVar5.zza(zzafVar4.zza(itZzg2.next().intValue()));
                }
                return zzafVar5;
            case 3:
                return zza(zzafVar, zzhVar, list, true);
            case 4:
                if (list.isEmpty()) {
                    return new zzaf();
                }
                int iZza = (int) zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue());
                if (iZza < 0) {
                    iZza = Math.max(0, iZza + zzafVar.zzb());
                } else if (iZza > zzafVar.zzb()) {
                    iZza = zzafVar.zzb();
                }
                int iZzb2 = zzafVar.zzb();
                zzaf zzafVar6 = new zzaf();
                if (list.size() <= 1) {
                    while (iZza < iZzb2) {
                        zzafVar6.zza(zzafVar.zza(iZza));
                        zzafVar.zzb(iZza, null);
                        iZza++;
                    }
                    return zzafVar6;
                }
                int iMax = Math.max(0, (int) zzg.zza(zzhVar.zza(list.get(1)).zze().doubleValue()));
                if (iMax > 0) {
                    for (int i2 = iZza; i2 < Math.min(iZzb2, iZza + iMax); i2++) {
                        zzafVar6.zza(zzafVar.zza(iZza));
                        zzafVar.zzb(iZza);
                    }
                }
                if (list.size() > 2) {
                    for (int i3 = 2; i3 < list.size(); i3++) {
                        zzaq zzaqVarZza3 = zzhVar.zza(list.get(i3));
                        if (zzaqVarZza3 instanceof zzaj) {
                            throw new IllegalArgumentException("Failed to parse elements to add");
                        }
                        zzafVar.zza((iZza + i3) - 2, zzaqVarZza3);
                    }
                }
                return zzafVar6;
            case 5:
                zzg.zza("forEach", 1, list);
                zzaq zzaqVarZza4 = zzhVar.zza(list.get(0));
                if (!(zzaqVarZza4 instanceof zzar)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzafVar.zza() == 0) {
                    return zzaq.zzc;
                }
                zza(zzafVar, zzhVar, (zzar) zzaqVarZza4);
                return zzaq.zzc;
            case 6:
                zzg.zzc("lastIndexOf", 2, list);
                zzaq zzaqVarZza5 = zzaq.zzc;
                if (!list.isEmpty()) {
                    zzaqVarZza5 = zzhVar.zza(list.get(0));
                }
                double dZzb = zzafVar.zzb() - 1;
                if (list.size() > 1) {
                    zzaq zzaqVarZza6 = zzhVar.zza(list.get(1));
                    if (Double.isNaN(zzaqVarZza6.zze().doubleValue())) {
                        dZza = zzafVar.zzb() - 1;
                    } else {
                        dZza = zzg.zza(zzaqVarZza6.zze().doubleValue());
                    }
                    dZzb = dZza;
                    d = ConfigValue.DOUBLE_DEFAULT_VALUE;
                    if (dZzb < ConfigValue.DOUBLE_DEFAULT_VALUE) {
                        dZzb += zzafVar.zzb();
                    }
                } else {
                    d = ConfigValue.DOUBLE_DEFAULT_VALUE;
                }
                if (dZzb < d) {
                    return new zzai(dValueOf);
                }
                for (int iMin = (int) Math.min(zzafVar.zzb(), dZzb); iMin >= 0; iMin--) {
                    if (zzafVar.zzc(iMin) && zzg.zza(zzafVar.zza(iMin), zzaqVarZza5)) {
                        return new zzai(Double.valueOf(iMin));
                    }
                }
                return new zzai(dValueOf);
            case 7:
                if (!list.isEmpty()) {
                    zzaf zzafVar7 = new zzaf();
                    Iterator<zzaq> it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaq zzaqVarZza7 = zzhVar.zza(it2.next());
                        if (zzaqVarZza7 instanceof zzaj) {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                        zzafVar7.zza(zzaqVarZza7);
                    }
                    int iZzb3 = zzafVar7.zzb();
                    Iterator<Integer> itZzg3 = zzafVar.zzg();
                    while (itZzg3.hasNext()) {
                        Integer next2 = itZzg3.next();
                        zzafVar7.zzb(next2.intValue() + iZzb3, zzafVar.zza(next2.intValue()));
                    }
                    zzafVar.zzj();
                    Iterator<Integer> itZzg4 = zzafVar7.zzg();
                    while (itZzg4.hasNext()) {
                        Integer next3 = itZzg4.next();
                        zzafVar.zzb(next3.intValue(), zzafVar7.zza(next3.intValue()));
                    }
                }
                return new zzai(Double.valueOf(zzafVar.zzb()));
            case '\b':
                zzg.zza("map", 1, list);
                zzaq zzaqVarZza8 = zzhVar.zza(list.get(0));
                if (!(zzaqVarZza8 instanceof zzar)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzafVar.zzb() == 0) {
                    return new zzaf();
                }
                return zza(zzafVar, zzhVar, (zzar) zzaqVarZza8);
            case '\t':
                zzg.zza("pop", 0, list);
                int iZzb4 = zzafVar.zzb();
                if (iZzb4 == 0) {
                    return zzaq.zzc;
                }
                int i4 = iZzb4 - 1;
                zzaq zzaqVarZza9 = zzafVar.zza(i4);
                zzafVar.zzb(i4);
                return zzaqVarZza9;
            case '\n':
                zzg.zzc("join", 1, list);
                if (zzafVar.zzb() == 0) {
                    return zzaq.zzj;
                }
                if (list.isEmpty()) {
                    strZzf = ",";
                } else {
                    zzaq zzaqVarZza10 = zzhVar.zza(list.get(0));
                    if ((zzaqVarZza10 instanceof zzao) || (zzaqVarZza10 instanceof zzax)) {
                        strZzf = "";
                    } else {
                        strZzf = zzaqVarZza10.zzf();
                    }
                }
                return new zzas(zzafVar.zzb(strZzf));
            case 11:
                if (!list.isEmpty()) {
                    Iterator<zzaq> it3 = list.iterator();
                    while (it3.hasNext()) {
                        zzafVar.zza(zzhVar.zza(it3.next()));
                    }
                }
                return new zzai(Double.valueOf(zzafVar.zzb()));
            case '\f':
                zzg.zza("some", 1, list);
                zzaq zzaqVarZza11 = zzhVar.zza(list.get(0));
                if (!(zzaqVarZza11 instanceof zzal)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzafVar.zzb() != 0) {
                    zzal zzalVar2 = (zzal) zzaqVarZza11;
                    Iterator<Integer> itZzg5 = zzafVar.zzg();
                    while (itZzg5.hasNext()) {
                        int iIntValue = itZzg5.next().intValue();
                        if (zzafVar.zzc(iIntValue) && zzalVar2.zza(zzhVar, Arrays.asList(zzafVar.zza(iIntValue), new zzai(Double.valueOf(iIntValue)), zzafVar)).zzd().booleanValue()) {
                            return zzaq.zzh;
                        }
                    }
                }
                return zzaq.zzi;
            case '\r':
                zzg.zzc("sort", 1, list);
                if (zzafVar.zzb() >= 2) {
                    List<zzaq> listZzi = zzafVar.zzi();
                    if (list.isEmpty()) {
                        zzalVar = null;
                    } else {
                        zzaq zzaqVarZza12 = zzhVar.zza(list.get(0));
                        if (!(zzaqVarZza12 instanceof zzal)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        zzalVar = (zzal) zzaqVarZza12;
                    }
                    Collections.sort(listZzi, new zzbh(zzalVar, zzhVar));
                    zzafVar.zzj();
                    Iterator<zzaq> it4 = listZzi.iterator();
                    int i5 = 0;
                    while (it4.hasNext()) {
                        zzafVar.zzb(i5, it4.next());
                        i5++;
                    }
                }
                return zzafVar;
            case 14:
                zzg.zza("every", 1, list);
                zzaq zzaqVarZza13 = zzhVar.zza(list.get(0));
                if (!(zzaqVarZza13 instanceof zzar)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzafVar.zzb() != 0 && zza(zzafVar, zzhVar, (zzar) zzaqVarZza13, Boolean.FALSE, Boolean.TRUE).zzb() != zzafVar.zzb()) {
                    return zzaq.zzi;
                }
                return zzaq.zzh;
            case 15:
                zzg.zza("shift", 0, list);
                if (zzafVar.zzb() == 0) {
                    return zzaq.zzc;
                }
                zzaq zzaqVarZza14 = zzafVar.zza(0);
                zzafVar.zzb(0);
                return zzaqVarZza14;
            case 16:
                zzg.zzc("slice", 2, list);
                if (list.isEmpty()) {
                    return zzafVar.zzc();
                }
                double dZzb2 = zzafVar.zzb();
                double dZza3 = zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue());
                if (dZza3 < ConfigValue.DOUBLE_DEFAULT_VALUE) {
                    dMin = Math.max(dZza3 + dZzb2, ConfigValue.DOUBLE_DEFAULT_VALUE);
                } else {
                    dMin = Math.min(dZza3, dZzb2);
                }
                if (list.size() == 2) {
                    double dZza4 = zzg.zza(zzhVar.zza(list.get(1)).zze().doubleValue());
                    if (dZza4 < ConfigValue.DOUBLE_DEFAULT_VALUE) {
                        dZzb2 = Math.max(dZzb2 + dZza4, ConfigValue.DOUBLE_DEFAULT_VALUE);
                    } else {
                        dZzb2 = Math.min(dZzb2, dZza4);
                    }
                }
                zzaf zzafVar8 = new zzaf();
                for (int i6 = (int) dMin; i6 < dZzb2; i6++) {
                    zzafVar8.zza(zzafVar.zza(i6));
                }
                return zzafVar8;
            case 17:
                return zza(zzafVar, zzhVar, list, false);
            case 18:
                zzg.zza("reverse", 0, list);
                int iZzb5 = zzafVar.zzb();
                if (iZzb5 != 0) {
                    int i7 = 0;
                    while (i7 < iZzb5 / 2) {
                        if (zzafVar.zzc(i7)) {
                            zzaq zzaqVarZza15 = zzafVar.zza(i7);
                            zzafVar.zzb(i7, null);
                            i = 1;
                            int i8 = (iZzb5 - 1) - i7;
                            if (zzafVar.zzc(i8)) {
                                zzafVar.zzb(i7, zzafVar.zza(i8));
                            }
                            zzafVar.zzb(i8, zzaqVarZza15);
                        } else {
                            i = 1;
                        }
                        i7 += i;
                    }
                }
                return zzafVar;
            case 19:
                zzg.zzc("indexOf", 2, list);
                zzaq zzaqVarZza16 = zzaq.zzc;
                if (list.isEmpty()) {
                    zzhVar2 = zzhVar;
                } else {
                    zzhVar2 = zzhVar;
                    zzaqVarZza16 = zzhVar2.zza(list.get(0));
                }
                if (list.size() > 1) {
                    dZza2 = zzg.zza(zzhVar2.zza(list.get(1)).zze().doubleValue());
                    if (dZza2 >= zzafVar.zzb()) {
                        return new zzai(dValueOf);
                    }
                    d2 = dValueOf;
                    if (dZza2 < ConfigValue.DOUBLE_DEFAULT_VALUE) {
                        dZza2 += zzafVar.zzb();
                    }
                } else {
                    d2 = dValueOf;
                    dZza2 = ConfigValue.DOUBLE_DEFAULT_VALUE;
                }
                Iterator<Integer> itZzg6 = zzafVar.zzg();
                while (itZzg6.hasNext()) {
                    int iIntValue2 = itZzg6.next().intValue();
                    double d3 = iIntValue2;
                    if (d3 >= dZza2 && zzg.zza(zzafVar.zza(iIntValue2), zzaqVarZza16)) {
                        return new zzai(Double.valueOf(d3));
                    }
                }
                return new zzai(d2);
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    private static zzaq zza(zzaf zzafVar, zzh zzhVar, List<zzaq> list, boolean z) {
        zzaq zzaqVarZza;
        zzg.zzb("reduce", 1, list);
        zzg.zzc("reduce", 2, list);
        zzaq zzaqVarZza2 = zzhVar.zza(list.get(0));
        if (!(zzaqVarZza2 instanceof zzal)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            zzaqVarZza = zzhVar.zza(list.get(1));
            if (zzaqVarZza instanceof zzaj) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (zzafVar.zzb() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzaqVarZza = null;
        }
        zzal zzalVar = (zzal) zzaqVarZza2;
        int iZzb = zzafVar.zzb();
        int i = z ? 0 : iZzb - 1;
        int i2 = z ? iZzb - 1 : 0;
        int i3 = z ? 1 : -1;
        if (zzaqVarZza == null) {
            zzaqVarZza = zzafVar.zza(i);
            i += i3;
        }
        while ((i2 - i) * i3 >= 0) {
            if (zzafVar.zzc(i)) {
                zzaqVarZza = zzalVar.zza(zzhVar, Arrays.asList(zzaqVarZza, zzafVar.zza(i), new zzai(Double.valueOf(i)), zzafVar));
                if (zzaqVarZza instanceof zzaj) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i3;
            } else {
                i += i3;
            }
        }
        return zzaqVarZza;
    }
}
