package com.google.android.gms.internal.identity;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzs;
import com.google.android.gms.location.zzt;

/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
@SafeParcelable.Class(creator = "DeviceOrientationRequestUpdateDataCreator")
/* loaded from: classes2.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();

    @SafeParcelable.Field(defaultValueUnchecked = "DeviceOrientationRequestUpdateData.OPERATION_ADD", id = 1)
    final int zza;

    @SafeParcelable.Field(defaultValueUnchecked = "null", id = 2)
    final zzh zzb;

    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getDeviceOrientationListenerBinder", id = 3, type = "android.os.IBinder")
    final zzt zzc;

    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getFusedLocationProviderCallbackBinder", id = 4, type = "android.os.IBinder")
    final zzr zzd;

    @SafeParcelable.Constructor
    zzj(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) zzh zzhVar, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) IBinder iBinder2) {
        this.zza = i;
        this.zzb = zzhVar;
        zzr zzpVar = null;
        this.zzc = iBinder == null ? null : zzs.zzb(iBinder);
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzpVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzp(iBinder2);
        }
        this.zzd = zzpVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzt zztVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 3, zztVar == null ? null : zztVar.asBinder(), false);
        zzr zzrVar = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 4, zzrVar != null ? zzrVar.asBinder() : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
