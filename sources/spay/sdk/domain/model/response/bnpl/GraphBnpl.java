package spay.sdk.domain.model.response.bnpl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.U0;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JG\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006%"}, d2 = {"Lspay/sdk/domain/model/response/bnpl/GraphBnpl;", "Landroid/os/Parcelable;", "header", "", "content", "count", "text", "payments", "", "Lspay/sdk/domain/model/response/bnpl/BnplPayment;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "getCount", "getHeader", "getPayments", "()Ljava/util/List;", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GraphBnpl implements Parcelable {
    public static final Parcelable.Creator<GraphBnpl> CREATOR = new Creator();
    private final String content;
    private final String count;
    private final String header;
    private final List<BnplPayment> payments;
    private final String text;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GraphBnpl> {
        @Override // android.os.Parcelable.Creator
        public final GraphBnpl createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList2.add(BnplPayment.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new GraphBnpl(string, string2, string3, string4, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final GraphBnpl[] newArray(int i) {
            return new GraphBnpl[i];
        }
    }

    public GraphBnpl(String header, String content, String str, String str2, List<BnplPayment> list) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(content, "content");
        this.header = header;
        this.content = content;
        this.count = str;
        this.text = str2;
        this.payments = list;
    }

    public static /* synthetic */ GraphBnpl copy$default(GraphBnpl graphBnpl, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = graphBnpl.header;
        }
        if ((i & 2) != 0) {
            str2 = graphBnpl.content;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = graphBnpl.count;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = graphBnpl.text;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            list = graphBnpl.payments;
        }
        return graphBnpl.copy(str, str5, str6, str7, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHeader() {
        return this.header;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCount() {
        return this.count;
    }

    /* renamed from: component4, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final List<BnplPayment> component5() {
        return this.payments;
    }

    public final GraphBnpl copy(String header, String content, String count, String text, List<BnplPayment> payments) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(content, "content");
        return new GraphBnpl(header, content, count, text, payments);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GraphBnpl)) {
            return false;
        }
        GraphBnpl graphBnpl = (GraphBnpl) other;
        return Intrinsics.areEqual(this.header, graphBnpl.header) && Intrinsics.areEqual(this.content, graphBnpl.content) && Intrinsics.areEqual(this.count, graphBnpl.count) && Intrinsics.areEqual(this.text, graphBnpl.text) && Intrinsics.areEqual(this.payments, graphBnpl.payments);
    }

    public final String getContent() {
        return this.content;
    }

    public final String getCount() {
        return this.count;
    }

    public final String getHeader() {
        return this.header;
    }

    public final List<BnplPayment> getPayments() {
        return this.payments;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int iA = AbstractC1553e.a(this.content, this.header.hashCode() * 31, 31);
        String str = this.count;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.text;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<BnplPayment> list = this.payments;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GraphBnpl(header=");
        sb.append(this.header);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(", text=");
        sb.append(this.text);
        sb.append(", payments=");
        return U0.a(sb, this.payments, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.header);
        parcel.writeString(this.content);
        parcel.writeString(this.count);
        parcel.writeString(this.text);
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

    public /* synthetic */ GraphBnpl(String str, String str2, String str3, String str4, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : list);
    }
}
