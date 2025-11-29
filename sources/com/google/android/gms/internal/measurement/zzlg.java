package com.google.android.gms.internal.measurement;

import com.yandex.varioqub.config.model.ConfigValue;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.1.2 */
/* loaded from: classes2.dex */
final class zzlg<T> implements zzlu<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzml.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlc zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzlk zzn;
    private final zzkm zzo;
    private final zzmk<?, ?> zzp;
    private final zzji<?> zzq;
    private final zzkv zzr;

    private static <T> double zza(T t, long j) {
        return ((Double) zzml.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzml.zze(t, j)).floatValue();
    }

    private static int zza(byte[] bArr, int i, int i2, zzms zzmsVar, Class<?> cls, zzij zzijVar) throws IOException {
        switch (zzlf.zza[zzmsVar.ordinal()]) {
            case 1:
                int iZzd = zzig.zzd(bArr, i, zzijVar);
                zzijVar.zzc = Boolean.valueOf(zzijVar.zzb != 0);
                return iZzd;
            case 2:
                return zzig.zza(bArr, i, zzijVar);
            case 3:
                zzijVar.zzc = Double.valueOf(zzig.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzijVar.zzc = Integer.valueOf(zzig.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzijVar.zzc = Long.valueOf(zzig.zzd(bArr, i));
                return i + 8;
            case 8:
                zzijVar.zzc = Float.valueOf(zzig.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZzc = zzig.zzc(bArr, i, zzijVar);
                zzijVar.zzc = Integer.valueOf(zzijVar.zza);
                return iZzc;
            case 12:
            case 13:
                int iZzd2 = zzig.zzd(bArr, i, zzijVar);
                zzijVar.zzc = Long.valueOf(zzijVar.zzb);
                return iZzd2;
            case 14:
                return zzig.zza(zzlq.zza().zza((Class) cls), bArr, i, i2, zzijVar);
            case 15:
                int iZzc2 = zzig.zzc(bArr, i, zzijVar);
                zzijVar.zzc = Integer.valueOf(zziw.zza(zzijVar.zza));
                return iZzc2;
            case 16:
                int iZzd3 = zzig.zzd(bArr, i, zzijVar);
                zzijVar.zzc = Long.valueOf(zziw.zza(zzijVar.zzb));
                return iZzd3;
            case 17:
                return zzig.zzb(bArr, i, zzijVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzlu
    public final int zza(T t) {
        int i;
        int i2;
        int i3;
        int iZza;
        int iZzb;
        int iZzh;
        boolean z;
        int iZzc;
        int iZzd;
        int iZzi;
        int iZzj;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < this.zzc.length) {
            int iZzc2 = zzc(i7);
            int i9 = (267386880 & iZzc2) >>> 20;
            int[] iArr = this.zzc;
            int i10 = iArr[i7];
            int i11 = iArr[i7 + 2];
            int i12 = i11 & i4;
            if (i9 <= 17) {
                if (i12 != i5) {
                    i6 = i12 == i4 ? 0 : unsafe.getInt(t, i12);
                    i5 = i12;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i11 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            long j = iZzc2 & i4;
            if (i9 >= zzjn.zza.zza()) {
                zzjn.zzb.zza();
            }
            switch (i9) {
                case 0:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZza = zzjc.zza(i10, ConfigValue.DOUBLE_DEFAULT_VALUE);
                        i8 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZza = zzjc.zza(i10, 0.0f);
                        i8 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZza = zzjc.zzd(i10, unsafe.getLong(t, j));
                        i8 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZza = zzjc.zzg(i10, unsafe.getLong(t, j));
                        i8 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZza = zzjc.zzg(i10, unsafe.getInt(t, j));
                        i8 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZza = zzjc.zzc(i10, 0L);
                        i8 += iZza;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZza = zzjc.zzf(i10, 0);
                        i8 += iZza;
                        break;
                    }
                    break;
                case 7:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZzb = zzjc.zzb(i10, true);
                        i8 += iZzb;
                    }
                    break;
                case 8:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        Object object = unsafe.getObject(t, j);
                        if (object instanceof zzik) {
                            iZzb = zzjc.zzc(i10, (zzik) object);
                        } else {
                            iZzb = zzjc.zzb(i10, (String) object);
                        }
                        i8 += iZzb;
                    }
                    break;
                case 9:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZzb = zzlw.zza(i10, unsafe.getObject(t, j), (zzlu<?>) zze(i7));
                        i8 += iZzb;
                    }
                    break;
                case 10:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZzb = zzjc.zzc(i10, (zzik) unsafe.getObject(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 11:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZzb = zzjc.zzj(i10, unsafe.getInt(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 12:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZzb = zzjc.zze(i10, unsafe.getInt(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 13:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZzh = zzjc.zzh(i10, 0);
                        i8 += iZzh;
                    }
                    break;
                case 14:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZzb = zzjc.zze(i10, 0L);
                        i8 += iZzb;
                    }
                    break;
                case 15:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZzb = zzjc.zzi(i10, unsafe.getInt(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 16:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZzb = zzjc.zzf(i10, unsafe.getLong(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 17:
                    if (zza((zzlg<T>) t, i7, i, i2, i3)) {
                        iZzb = zzjc.zzb(i10, (zzlc) unsafe.getObject(t, j), zze(i7));
                        i8 += iZzb;
                    }
                    break;
                case 18:
                    iZzb = zzlw.zzd(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzb;
                    break;
                case 19:
                    z = false;
                    iZzc = zzlw.zzc(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 20:
                    z = false;
                    iZzc = zzlw.zzf(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 21:
                    z = false;
                    iZzc = zzlw.zzj(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 22:
                    z = false;
                    iZzc = zzlw.zze(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 23:
                    z = false;
                    iZzc = zzlw.zzd(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 24:
                    z = false;
                    iZzc = zzlw.zzc(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 25:
                    z = false;
                    iZzc = zzlw.zza(i10, (List<?>) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 26:
                    iZzb = zzlw.zzb(i10, (List) unsafe.getObject(t, j));
                    i8 += iZzb;
                    break;
                case 27:
                    iZzb = zzlw.zzb(i10, (List<?>) unsafe.getObject(t, j), (zzlu<?>) zze(i7));
                    i8 += iZzb;
                    break;
                case 28:
                    iZzb = zzlw.zza(i10, (List<zzik>) unsafe.getObject(t, j));
                    i8 += iZzb;
                    break;
                case 29:
                    iZzb = zzlw.zzi(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzb;
                    break;
                case 30:
                    z = false;
                    iZzc = zzlw.zzb(i10, (List<Integer>) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 31:
                    z = false;
                    iZzc = zzlw.zzc(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 32:
                    z = false;
                    iZzc = zzlw.zzd(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 33:
                    z = false;
                    iZzc = zzlw.zzg(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 34:
                    z = false;
                    iZzc = zzlw.zzh(i10, (List) unsafe.getObject(t, j), false);
                    i8 += iZzc;
                    break;
                case 35:
                    iZzd = zzlw.zzd((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 36:
                    iZzd = zzlw.zzc((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 37:
                    iZzd = zzlw.zzf((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 38:
                    iZzd = zzlw.zzj((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 39:
                    iZzd = zzlw.zze((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 40:
                    iZzd = zzlw.zzd((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 41:
                    iZzd = zzlw.zzc((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 42:
                    iZzd = zzlw.zza((List<?>) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 43:
                    iZzd = zzlw.zzi((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 44:
                    iZzd = zzlw.zzb((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 45:
                    iZzd = zzlw.zzc((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 46:
                    iZzd = zzlw.zzd((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 47:
                    iZzd = zzlw.zzg((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 48:
                    iZzd = zzlw.zzh((List) unsafe.getObject(t, j));
                    if (iZzd > 0) {
                        iZzi = zzjc.zzi(i10);
                        iZzj = zzjc.zzj(iZzd);
                        iZzh = iZzi + iZzj + iZzd;
                        i8 += iZzh;
                    }
                    break;
                case 49:
                    iZzb = zzlw.zza(i10, (List<zzlc>) unsafe.getObject(t, j), (zzlu<?>) zze(i7));
                    i8 += iZzb;
                    break;
                case 50:
                    iZzb = this.zzr.zza(i10, unsafe.getObject(t, j), zzf(i7));
                    i8 += iZzb;
                    break;
                case 51:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zza(i10, ConfigValue.DOUBLE_DEFAULT_VALUE);
                        i8 += iZzb;
                    }
                    break;
                case 52:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zza(i10, 0.0f);
                        i8 += iZzb;
                    }
                    break;
                case 53:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zzd(i10, zzd(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 54:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zzg(i10, zzd(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 55:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zzg(i10, zzc(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 56:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zzc(i10, 0L);
                        i8 += iZzb;
                    }
                    break;
                case 57:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzh = zzjc.zzf(i10, 0);
                        i8 += iZzh;
                    }
                    break;
                case 58:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zzb(i10, true);
                        i8 += iZzb;
                    }
                    break;
                case 59:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzik) {
                            iZzb = zzjc.zzc(i10, (zzik) object2);
                        } else {
                            iZzb = zzjc.zzb(i10, (String) object2);
                        }
                        i8 += iZzb;
                    }
                    break;
                case 60:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzlw.zza(i10, unsafe.getObject(t, j), (zzlu<?>) zze(i7));
                        i8 += iZzb;
                    }
                    break;
                case 61:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zzc(i10, (zzik) unsafe.getObject(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 62:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zzj(i10, zzc(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 63:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zze(i10, zzc(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 64:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzh = zzjc.zzh(i10, 0);
                        i8 += iZzh;
                    }
                    break;
                case 65:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zze(i10, 0L);
                        i8 += iZzb;
                    }
                    break;
                case 66:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zzi(i10, zzc(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 67:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zzf(i10, zzd(t, j));
                        i8 += iZzb;
                    }
                    break;
                case 68:
                    if (zzc((zzlg<T>) t, i10, i7)) {
                        iZzb = zzjc.zzb(i10, (zzlc) unsafe.getObject(t, j), zze(i7));
                        i8 += iZzb;
                    }
                    break;
            }
            i7 += 3;
            i5 = i;
            i6 = i2;
            i4 = 1048575;
        }
        int iZza2 = 0;
        zzmk<?, ?> zzmkVar = this.zzp;
        int iZza3 = i8 + zzmkVar.zza((zzmk<?, ?>) zzmkVar.zzd(t));
        if (!this.zzh) {
            return iZza3;
        }
        zzjm<T> zzjmVarZza = this.zzq.zza(t);
        int iZza4 = zzjmVarZza.zza.zza();
        for (int i13 = 0; i13 < iZza4; i13++) {
            Map.Entry entryZza = zzjmVarZza.zza.zza(i13);
            iZza2 += zzjm.zza((zzjo<?>) entryZza.getKey(), entryZza.getValue());
        }
        for (Map.Entry entry : zzjmVarZza.zza.zzb()) {
            iZza2 += zzjm.zza((zzjo<?>) entry.getKey(), entry.getValue());
        }
        return iZza3 + iZza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final int zzb(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzc = zzc(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzc;
            int iHashCode = 37;
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    iZza = zzjv.zza(Double.doubleToLongBits(zzml.zza(t, j)));
                    i2 = i + iZza;
                    break;
                case 1:
                    i = i2 * 53;
                    iZza = Float.floatToIntBits(zzml.zzb(t, j));
                    i2 = i + iZza;
                    break;
                case 2:
                    i = i2 * 53;
                    iZza = zzjv.zza(zzml.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 3:
                    i = i2 * 53;
                    iZza = zzjv.zza(zzml.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 4:
                    i = i2 * 53;
                    iZza = zzml.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 5:
                    i = i2 * 53;
                    iZza = zzjv.zza(zzml.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 6:
                    i = i2 * 53;
                    iZza = zzml.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 7:
                    i = i2 * 53;
                    iZza = zzjv.zza(zzml.zzh(t, j));
                    i2 = i + iZza;
                    break;
                case 8:
                    i = i2 * 53;
                    iZza = ((String) zzml.zze(t, j)).hashCode();
                    i2 = i + iZza;
                    break;
                case 9:
                    Object objZze = zzml.zze(t, j);
                    if (objZze != null) {
                        iHashCode = objZze.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZza = zzml.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 11:
                    i = i2 * 53;
                    iZza = zzml.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 12:
                    i = i2 * 53;
                    iZza = zzml.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 13:
                    i = i2 * 53;
                    iZza = zzml.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 14:
                    i = i2 * 53;
                    iZza = zzjv.zza(zzml.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 15:
                    i = i2 * 53;
                    iZza = zzml.zzc(t, j);
                    i2 = i + iZza;
                    break;
                case 16:
                    i = i2 * 53;
                    iZza = zzjv.zza(zzml.zzd(t, j));
                    i2 = i + iZza;
                    break;
                case 17:
                    Object objZze2 = zzml.zze(t, j);
                    if (objZze2 != null) {
                        iHashCode = objZze2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iZza = zzml.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 50:
                    i = i2 * 53;
                    iZza = zzml.zze(t, j).hashCode();
                    i2 = i + iZza;
                    break;
                case 51:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjv.zza(Double.doubleToLongBits(zza(t, j)));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = Float.floatToIntBits(zzb(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjv.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjv.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjv.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjv.zza(zze(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = ((String) zzml.zze(t, j)).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzml.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzml.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjv.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzc(t, j);
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzjv.zza(zzd(t, j));
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzc((zzlg<T>) t, i4, i3)) {
                        i = i2 * 53;
                        iZza = zzml.zze(t, j).hashCode();
                        i2 = i + iZza;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzp.zzd(t).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzq.zza(t).hashCode() : iHashCode2;
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzml.zze(t, j)).intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:437:0x0a7c, code lost:
    
        throw com.google.android.gms.internal.measurement.zzkb.zzi();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:592:0x094c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0d53 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0cd6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:645:0x093d A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v60, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zza(T r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.measurement.zzij r38) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzij):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzml.zze(t, j)).longValue();
    }

    private final zzjx zzd(int i) {
        return (zzjx) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x038c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T> com.google.android.gms.internal.measurement.zzlg<T> zza(java.lang.Class<T> r32, com.google.android.gms.internal.measurement.zzla r33, com.google.android.gms.internal.measurement.zzlk r34, com.google.android.gms.internal.measurement.zzkm r35, com.google.android.gms.internal.measurement.zzmk<?, ?> r36, com.google.android.gms.internal.measurement.zzji<?> r37, com.google.android.gms.internal.measurement.zzkv r38) {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzla, com.google.android.gms.internal.measurement.zzlk, com.google.android.gms.internal.measurement.zzkm, com.google.android.gms.internal.measurement.zzmk, com.google.android.gms.internal.measurement.zzji, com.google.android.gms.internal.measurement.zzkv):com.google.android.gms.internal.measurement.zzlg");
    }

    private final zzlu zze(int i) {
        int i2 = (i / 3) << 1;
        zzlu zzluVar = (zzlu) this.zzd[i2];
        if (zzluVar != null) {
            return zzluVar;
        }
        zzlu<T> zzluVarZza = zzlq.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzluVarZza;
        return zzluVarZza;
    }

    static zzmj zzc(Object obj) {
        zzjt zzjtVar = (zzjt) obj;
        zzmj zzmjVar = zzjtVar.zzb;
        if (zzmjVar != zzmj.zzc()) {
            return zzmjVar;
        }
        zzmj zzmjVarZzd = zzmj.zzd();
        zzjtVar.zzb = zzmjVarZzd;
        return zzmjVarZzd;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzmk<UT, UB> zzmkVar, Object obj2) {
        zzjx zzjxVarZzd;
        int i2 = this.zzc[i];
        Object objZze = zzml.zze(obj, zzc(i) & 1048575);
        return (objZze == null || (zzjxVarZzd = zzd(i)) == null) ? ub : (UB) zza(i, i2, this.zzr.zze(objZze), zzjxVarZzd, (zzjx) ub, (zzmk<UT, zzjx>) zzmkVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzjx zzjxVar, UB ub, zzmk<UT, UB> zzmkVar, Object obj) {
        zzkt<?, ?> zzktVarZza = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzjxVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzmkVar.zzc(obj);
                }
                zzit zzitVarZzc = zzik.zzc(zzku.zza(zzktVarZza, next.getKey(), next.getValue()));
                try {
                    zzku.zza(zzitVarZzc.zzb(), zzktVarZza, next.getKey(), next.getValue());
                    zzmkVar.zza((zzmk<UT, UB>) ub, i2, zzitVarZzc.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i) {
        zzlu zzluVarZze = zze(i);
        long jZzc = zzc(i) & 1048575;
        if (!zzc((zzlg<T>) t, i)) {
            return zzluVarZze.zza();
        }
        Object object = zzb.getObject(t, jZzc);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzluVarZze.zza();
        if (object != null) {
            zzluVarZze.zza(objZza, object);
        }
        return objZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i, int i2) {
        zzlu zzluVarZze = zze(i2);
        if (!zzc((zzlg<T>) t, i, i2)) {
            return zzluVarZze.zza();
        }
        Object object = zzb.getObject(t, zzc(i2) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzluVarZze.zza();
        if (object != null) {
            zzluVarZze.zza(objZza, object);
        }
        return objZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private zzlg(int[] iArr, Object[] objArr, int i, int i2, zzlc zzlcVar, boolean z, int[] iArr2, int i3, int i4, zzlk zzlkVar, zzkm zzkmVar, zzmk<?, ?> zzmkVar, zzji<?> zzjiVar, zzkv zzkvVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzlcVar instanceof zzjt;
        this.zzh = zzjiVar != null && zzjiVar.zza(zzlcVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = zzlkVar;
        this.zzo = zzkmVar;
        this.zzp = zzmkVar;
        this.zzq = zzjiVar;
        this.zzg = zzlcVar;
        this.zzr = zzkvVar;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    @Override // com.google.android.gms.internal.measurement.zzlu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(T r8) {
        /*
            r7 = this;
            boolean r0 = zzg(r8)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r8 instanceof com.google.android.gms.internal.measurement.zzjt
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r8
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.zzc(r2)
            r0.zza = r1
            r0.zzcm()
        L1a:
            int[] r0 = r7.zzc
            int r0 = r0.length
        L1d:
            if (r1 >= r0) goto L83
            int r2 = r7.zzc(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            long r3 = (long) r3
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r2 = r2 & r5
            int r2 = r2 >>> 20
            r5 = 9
            if (r2 == r5) goto L6d
            r5 = 60
            if (r2 == r5) goto L55
            r5 = 68
            if (r2 == r5) goto L55
            switch(r2) {
                case 17: goto L6d;
                case 18: goto L4f;
                case 19: goto L4f;
                case 20: goto L4f;
                case 21: goto L4f;
                case 22: goto L4f;
                case 23: goto L4f;
                case 24: goto L4f;
                case 25: goto L4f;
                case 26: goto L4f;
                case 27: goto L4f;
                case 28: goto L4f;
                case 29: goto L4f;
                case 30: goto L4f;
                case 31: goto L4f;
                case 32: goto L4f;
                case 33: goto L4f;
                case 34: goto L4f;
                case 35: goto L4f;
                case 36: goto L4f;
                case 37: goto L4f;
                case 38: goto L4f;
                case 39: goto L4f;
                case 40: goto L4f;
                case 41: goto L4f;
                case 42: goto L4f;
                case 43: goto L4f;
                case 44: goto L4f;
                case 45: goto L4f;
                case 46: goto L4f;
                case 47: goto L4f;
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L80
        L3d:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.measurement.zzlg.zzb
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L80
            com.google.android.gms.internal.measurement.zzkv r6 = r7.zzr
            java.lang.Object r5 = r6.zzc(r5)
            r2.putObject(r8, r3, r5)
            goto L80
        L4f:
            com.google.android.gms.internal.measurement.zzkm r2 = r7.zzo
            r2.zzb(r8, r3)
            goto L80
        L55:
            int[] r2 = r7.zzc
            r2 = r2[r1]
            boolean r2 = r7.zzc(r8, r2, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.measurement.zzlu r2 = r7.zze(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.measurement.zzlg.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzd(r3)
            goto L80
        L6d:
            boolean r2 = r7.zzc(r8, r1)
            if (r2 == 0) goto L80
            com.google.android.gms.internal.measurement.zzlu r2 = r7.zze(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.measurement.zzlg.zzb
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.zzd(r3)
        L80:
            int r1 = r1 + 3
            goto L1d
        L83:
            com.google.android.gms.internal.measurement.zzmk<?, ?> r0 = r7.zzp
            r0.zzf(r8)
            boolean r0 = r7.zzh
            if (r0 == 0) goto L91
            com.google.android.gms.internal.measurement.zzji<?> r0 = r7.zzq
            r0.zzc(r8)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zzd(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zza(T t, T t2) {
        zzf(t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza(t, j, zzml.zza(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzb(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzd(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzd(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzc(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzd(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzc(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zzc(t, j, zzml.zzh(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza(t, j, zzml.zze(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza(t, j, zzml.zze(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzc(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzc(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzc(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzd(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzc(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzc((zzlg<T>) t2, i)) {
                        zzml.zza((Object) t, j, zzml.zzd(t2, j));
                        zzb((zzlg<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzo.zza(t, t2, j);
                    break;
                case 50:
                    zzlw.zza(this.zzr, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzc((zzlg<T>) t2, i2, i)) {
                        zzml.zza(t, j, zzml.zze(t2, j));
                        zzb((zzlg<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzc((zzlg<T>) t2, i2, i)) {
                        zzml.zza(t, j, zzml.zze(t2, j));
                        zzb((zzlg<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzlw.zza(this.zzp, t, t2);
        if (this.zzh) {
            zzlw.zza(this.zzq, t, t2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0630 A[Catch: all -> 0x00cb, TryCatch #7 {all -> 0x00cb, blocks: (B:49:0x00c5, B:54:0x00d3, B:166:0x062b, B:168:0x0630, B:169:0x0635, B:65:0x00ff, B:67:0x0114, B:68:0x0125, B:69:0x0136, B:70:0x0147, B:71:0x0158, B:73:0x0162, B:76:0x0169, B:77:0x016e, B:78:0x017b, B:79:0x018c, B:80:0x019a, B:81:0x01ac, B:82:0x01b4, B:83:0x01c6, B:84:0x01d8, B:85:0x01ea, B:86:0x01fc, B:87:0x020e, B:88:0x0220, B:89:0x0232, B:90:0x0244, B:92:0x0254, B:96:0x0275, B:93:0x025e, B:95:0x0266, B:97:0x0286, B:98:0x0298, B:99:0x02a6, B:100:0x02b4, B:101:0x02c2), top: B:194:0x00c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0665 A[LOOP:3: B:181:0x0661->B:183:0x0665, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x063b A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.google.android.gms.internal.measurement.zzlr] */
    @Override // com.google.android.gms.internal.measurement.zzlu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r18, com.google.android.gms.internal.measurement.zzlr r19, com.google.android.gms.internal.measurement.zzjg r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1804
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzlr, com.google.android.gms.internal.measurement.zzjg):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    public final void zza(T t, byte[] bArr, int i, int i2, zzij zzijVar) throws IOException {
        zza((zzlg<T>) t, bArr, i, i2, 0, zzijVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t, T t2, int i) {
        if (zzc((zzlg<T>) t2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzlu zzluVarZze = zze(i);
            if (!zzc((zzlg<T>) t, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzluVarZze.zza();
                    zzluVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((zzlg<T>) t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzluVarZze.zza();
                zzluVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzluVarZze.zza(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc((zzlg<T>) t2, i2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzlu zzluVarZze = zze(i);
            if (!zzc((zzlg<T>) t, i2, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzluVarZze.zza();
                    zzluVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((zzlg<T>) t, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzluVarZze.zza();
                zzluVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzluVarZze.zza(object2, object);
        }
    }

    private final void zza(Object obj, int i, zzlr zzlrVar) throws IOException {
        if (zzg(i)) {
            zzml.zza(obj, i & 1048575, zzlrVar.zzr());
        } else if (this.zzi) {
            zzml.zza(obj, i & 1048575, zzlrVar.zzq());
        } else {
            zzml.zza(obj, i & 1048575, zzlrVar.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int iZzb = zzb(i);
        long j = 1048575 & iZzb;
        if (j == 1048575) {
            return;
        }
        zzml.zza((Object) t, j, (1 << (iZzb >>> 20)) | zzml.zzc(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzml.zza((Object) t, zzb(i2) & 1048575, i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, zzc(i) & 1048575, obj);
        zzb((zzlg<T>) t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, zzc(i2) & 1048575, obj);
        zzb((zzlg<T>) t, i, i2);
    }

    private final <K, V> void zza(zznb zznbVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zznbVar.zza(i, this.zzr.zza(zzf(i2)), this.zzr.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zznb zznbVar) throws IOException {
        if (obj instanceof String) {
            zznbVar.zza(i, (String) obj);
        } else {
            zznbVar.zza(i, (zzik) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:176:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.measurement.zzlu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r24, com.google.android.gms.internal.measurement.zznb r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zza(java.lang.Object, com.google.android.gms.internal.measurement.zznb):void");
    }

    private static <UT, UB> void zza(zzmk<UT, UB> zzmkVar, T t, zznb zznbVar) throws IOException {
        zzmkVar.zzb((zzmk<UT, UB>) zzmkVar.zzd(t), zznbVar);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc((zzlg<T>) t, i) == zzc((zzlg<T>) t2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    @Override // com.google.android.gms.internal.measurement.zzlu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzb(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    private final boolean zzc(T t, int i) {
        int iZzb = zzb(i);
        long j = iZzb & 1048575;
        if (j != 1048575) {
            return (zzml.zzc(t, j) & (1 << (iZzb >>> 20))) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzml.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzml.zzb(t, j2)) != 0;
            case 2:
                return zzml.zzd(t, j2) != 0;
            case 3:
                return zzml.zzd(t, j2) != 0;
            case 4:
                return zzml.zzc(t, j2) != 0;
            case 5:
                return zzml.zzd(t, j2) != 0;
            case 6:
                return zzml.zzc(t, j2) != 0;
            case 7:
                return zzml.zzh(t, j2);
            case 8:
                Object objZze = zzml.zze(t, j2);
                if (objZze instanceof String) {
                    return !((String) objZze).isEmpty();
                }
                if (objZze instanceof zzik) {
                    return !zzik.zza.equals(objZze);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzml.zze(t, j2) != null;
            case 10:
                return !zzik.zza.equals(zzml.zze(t, j2));
            case 11:
                return zzml.zzc(t, j2) != 0;
            case 12:
                return zzml.zzc(t, j2) != 0;
            case 13:
                return zzml.zzc(t, j2) != 0;
            case 14:
                return zzml.zzd(t, j2) != 0;
            case 15:
                return zzml.zzc(t, j2) != 0;
            case 16:
                return zzml.zzd(t, j2) != 0;
            case 17:
                return zzml.zze(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc((zzlg<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzlu] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzlu] */
    @Override // com.google.android.gms.internal.measurement.zzlu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zze(T r18) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlg.zze(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzlu zzluVar) {
        return zzluVar.zze(zzml.zze(obj, i & 1048575));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzjt) {
            return ((zzjt) obj).zzco();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzml.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzml.zze(t, j)).booleanValue();
    }
}
