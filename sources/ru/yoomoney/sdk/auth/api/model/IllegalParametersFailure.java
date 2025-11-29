package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/IllegalParametersFailure;", "Lru/yoomoney/sdk/auth/api/model/Failure;", "parameterNames", "", "", "(Ljava/util/List;)V", "getParameterNames", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class IllegalParametersFailure extends Failure {
    public static final Parcelable.Creator<IllegalParametersFailure> CREATOR = new Creator();
    private final List<String> parameterNames;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<IllegalParametersFailure> {
        @Override // android.os.Parcelable.Creator
        public final IllegalParametersFailure createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IllegalParametersFailure(parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final IllegalParametersFailure[] newArray(int i) {
            return new IllegalParametersFailure[i];
        }
    }

    public IllegalParametersFailure() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IllegalParametersFailure copy$default(IllegalParametersFailure illegalParametersFailure, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = illegalParametersFailure.parameterNames;
        }
        return illegalParametersFailure.copy(list);
    }

    public final List<String> component1() {
        return this.parameterNames;
    }

    public final IllegalParametersFailure copy(List<String> parameterNames) {
        return new IllegalParametersFailure(parameterNames);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof IllegalParametersFailure) && Intrinsics.areEqual(this.parameterNames, ((IllegalParametersFailure) other).parameterNames);
    }

    public final List<String> getParameterNames() {
        return this.parameterNames;
    }

    public int hashCode() {
        List<String> list = this.parameterNames;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "IllegalParametersFailure(parameterNames=" + this.parameterNames + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.parameterNames);
    }

    public IllegalParametersFailure(List<String> list) {
        super(null);
        this.parameterNames = list;
    }

    public /* synthetic */ IllegalParametersFailure(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }
}
