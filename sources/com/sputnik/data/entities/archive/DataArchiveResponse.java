package com.sputnik.data.entities.archive;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataArchiveResponse.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b \u0010\u000b¨\u0006!"}, d2 = {"Lcom/sputnik/data/entities/archive/DataArchiveResponse;", "Landroid/os/Parcelable;", "", "way", "", "Lcom/sputnik/data/entities/archive/DataArchiveItem;", RemoteMessageConst.DATA, CrashHianalyticsData.MESSAGE, "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getWay", "Ljava/util/List;", "getData", "()Ljava/util/List;", "getMessage", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataArchiveResponse implements Parcelable {
    public static final Parcelable.Creator<DataArchiveResponse> CREATOR = new Creator();
    private final List<DataArchiveItem> data;
    private final String message;
    private final String way;

    /* compiled from: DataArchiveResponse.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataArchiveResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataArchiveResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(parcel.readParcelable(DataArchiveResponse.class.getClassLoader()));
            }
            return new DataArchiveResponse(string, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataArchiveResponse[] newArray(int i) {
            return new DataArchiveResponse[i];
        }
    }

    public DataArchiveResponse() {
        this(null, null, null, 7, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataArchiveResponse)) {
            return false;
        }
        DataArchiveResponse dataArchiveResponse = (DataArchiveResponse) other;
        return Intrinsics.areEqual(this.way, dataArchiveResponse.way) && Intrinsics.areEqual(this.data, dataArchiveResponse.data) && Intrinsics.areEqual(this.message, dataArchiveResponse.message);
    }

    public int hashCode() {
        String str = this.way;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.data.hashCode()) * 31;
        String str2 = this.message;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DataArchiveResponse(way=" + this.way + ", data=" + this.data + ", message=" + this.message + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.way);
        List<DataArchiveItem> list = this.data;
        parcel.writeInt(list.size());
        Iterator<DataArchiveItem> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeParcelable(it.next(), flags);
        }
        parcel.writeString(this.message);
    }

    public DataArchiveResponse(String str, List<DataArchiveItem> data, String str2) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.way = str;
        this.data = data;
        this.message = str2;
    }

    public final String getWay() {
        return this.way;
    }

    public /* synthetic */ DataArchiveResponse(String str, List list, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str2);
    }

    public final List<DataArchiveItem> getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }
}
