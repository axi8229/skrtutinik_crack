package spay.sdk.domain.model.response.bnpl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.U0;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lspay/sdk/domain/model/response/bnpl/SixPartPay;", "Landroid/os/Parcelable;", "clientCommission", "", "count", "payments", "", "Lspay/sdk/domain/model/response/bnpl/BnplPayment;", "(IILjava/util/List;)V", "getClientCommission", "()I", "getCount", "getPayments", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SixPartPay implements Parcelable {
    public static final Parcelable.Creator<SixPartPay> CREATOR = new Creator();
    private final int clientCommission;
    private final int count;
    private final List<BnplPayment> payments;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SixPartPay> {
        @Override // android.os.Parcelable.Creator
        public final SixPartPay createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i3 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i3);
                for (int i4 = 0; i4 != i3; i4++) {
                    arrayList2.add(BnplPayment.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new SixPartPay(i, i2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final SixPartPay[] newArray(int i) {
            return new SixPartPay[i];
        }
    }

    public SixPartPay(int i, int i2, List<BnplPayment> list) {
        this.clientCommission = i;
        this.count = i2;
        this.payments = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SixPartPay copy$default(SixPartPay sixPartPay, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = sixPartPay.clientCommission;
        }
        if ((i3 & 2) != 0) {
            i2 = sixPartPay.count;
        }
        if ((i3 & 4) != 0) {
            list = sixPartPay.payments;
        }
        return sixPartPay.copy(i, i2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getClientCommission() {
        return this.clientCommission;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final List<BnplPayment> component3() {
        return this.payments;
    }

    public final SixPartPay copy(int clientCommission, int count, List<BnplPayment> payments) {
        return new SixPartPay(clientCommission, count, payments);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SixPartPay)) {
            return false;
        }
        SixPartPay sixPartPay = (SixPartPay) other;
        return this.clientCommission == sixPartPay.clientCommission && this.count == sixPartPay.count && Intrinsics.areEqual(this.payments, sixPartPay.payments);
    }

    public final int getClientCommission() {
        return this.clientCommission;
    }

    public final int getCount() {
        return this.count;
    }

    public final List<BnplPayment> getPayments() {
        return this.payments;
    }

    public int hashCode() {
        int iHashCode = (Integer.hashCode(this.count) + (Integer.hashCode(this.clientCommission) * 31)) * 31;
        List<BnplPayment> list = this.payments;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SixPartPay(clientCommission=");
        sb.append(this.clientCommission);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(", payments=");
        return U0.a(sb, this.payments, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.clientCommission);
        parcel.writeInt(this.count);
        List<BnplPayment> list = this.payments;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<BnplPayment> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ SixPartPay(int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? null : list);
    }
}
