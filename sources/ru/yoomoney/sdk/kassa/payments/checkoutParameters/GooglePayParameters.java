package ru.yoomoney.sdk.kassa.payments.checkoutParameters;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lru/yoomoney/sdk/kassa/payments/checkoutParameters/GooglePayParameters;", "Landroid/os/Parcelable;", "allowedCardNetworks", "", "Lru/yoomoney/sdk/kassa/payments/checkoutParameters/GooglePayCardNetwork;", "(Ljava/util/Set;)V", "getAllowedCardNetworks", "()Ljava/util/Set;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "library_metricaRealRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"ParcelCreator"})
@Deprecated
/* loaded from: classes5.dex */
public final /* data */ class GooglePayParameters implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<GooglePayParameters> CREATOR = new b();

    @Keep
    private final Set<GooglePayCardNetwork> allowedCardNetworks;

    @Keep
    public GooglePayParameters() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GooglePayParameters copy$default(GooglePayParameters googlePayParameters, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = googlePayParameters.allowedCardNetworks;
        }
        return googlePayParameters.copy(set);
    }

    public final Set<GooglePayCardNetwork> component1() {
        return this.allowedCardNetworks;
    }

    public final GooglePayParameters copy(Set<? extends GooglePayCardNetwork> allowedCardNetworks) {
        Intrinsics.checkNotNullParameter(allowedCardNetworks, "allowedCardNetworks");
        return new GooglePayParameters(allowedCardNetworks);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GooglePayParameters) && Intrinsics.areEqual(this.allowedCardNetworks, ((GooglePayParameters) other).allowedCardNetworks);
    }

    public final Set<GooglePayCardNetwork> getAllowedCardNetworks() {
        return this.allowedCardNetworks;
    }

    public int hashCode() {
        return this.allowedCardNetworks.hashCode();
    }

    public String toString() {
        return "GooglePayParameters(allowedCardNetworks=" + this.allowedCardNetworks + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Set<GooglePayCardNetwork> set = this.allowedCardNetworks;
        parcel.writeInt(set.size());
        Iterator<GooglePayCardNetwork> it = set.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next().name());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Keep
    public GooglePayParameters(Set<? extends GooglePayCardNetwork> allowedCardNetworks) {
        Intrinsics.checkNotNullParameter(allowedCardNetworks, "allowedCardNetworks");
        this.allowedCardNetworks = allowedCardNetworks;
    }

    public /* synthetic */ GooglePayParameters(Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt.setOf((Object[]) new GooglePayCardNetwork[]{GooglePayCardNetwork.AMEX, GooglePayCardNetwork.DISCOVER, GooglePayCardNetwork.JCB, GooglePayCardNetwork.VISA, GooglePayCardNetwork.MASTERCARD}) : set);
    }
}
