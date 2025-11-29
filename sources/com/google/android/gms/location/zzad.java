package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.identity.ClientIdentity;

/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
@SafeParcelable.Class(creator = "LocationAvailabilityRequestCreator")
/* loaded from: classes2.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();

    @SafeParcelable.Field(defaultValue = "false", getter = "isBypass", id = 1)
    private final boolean zza;

    @SafeParcelable.Field(getter = "getImpersonation", id = 2)
    private final ClientIdentity zzb;

    @SafeParcelable.Constructor
    zzad(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) ClientIdentity clientIdentity) {
        this.zza = z;
        this.zzb = clientIdentity;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzad)) {
            return false;
        }
        zzad zzadVar = (zzad) obj;
        return this.zza == zzadVar.zza && Objects.equal(this.zzb, zzadVar.zzb);
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocationAvailabilityRequest[");
        if (this.zza) {
            sb.append("bypass, ");
        }
        if (this.zzb != null) {
            sb.append("impersonation=");
            sb.append(this.zzb);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, z);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
