package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/CallLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/CallBody;", "body", "Lcom/sputnik/common/entities/localization/CallLoader;", "stream", "<init>", "(Lcom/sputnik/common/entities/localization/CallBody;Lcom/sputnik/common/entities/localization/CallLoader;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/CallBody;", "getBody", "()Lcom/sputnik/common/entities/localization/CallBody;", "Lcom/sputnik/common/entities/localization/CallLoader;", "getStream", "()Lcom/sputnik/common/entities/localization/CallLoader;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CallLocale implements Parcelable {
    public static final Parcelable.Creator<CallLocale> CREATOR = new Creator();
    private final CallBody body;
    private final CallLoader stream;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CallLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CallLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CallLocale(parcel.readInt() == 0 ? null : CallBody.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? CallLoader.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CallLocale[] newArray(int i) {
            return new CallLocale[i];
        }
    }

    public CallLocale() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallLocale)) {
            return false;
        }
        CallLocale callLocale = (CallLocale) other;
        return Intrinsics.areEqual(this.body, callLocale.body) && Intrinsics.areEqual(this.stream, callLocale.stream);
    }

    public int hashCode() {
        CallBody callBody = this.body;
        int iHashCode = (callBody == null ? 0 : callBody.hashCode()) * 31;
        CallLoader callLoader = this.stream;
        return iHashCode + (callLoader != null ? callLoader.hashCode() : 0);
    }

    public String toString() {
        return "CallLocale(body=" + this.body + ", stream=" + this.stream + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        CallBody callBody = this.body;
        if (callBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            callBody.writeToParcel(parcel, flags);
        }
        CallLoader callLoader = this.stream;
        if (callLoader == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            callLoader.writeToParcel(parcel, flags);
        }
    }

    public CallLocale(CallBody callBody, CallLoader callLoader) {
        this.body = callBody;
        this.stream = callLoader;
    }

    public /* synthetic */ CallLocale(CallBody callBody, CallLoader callLoader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : callBody, (i & 2) != 0 ? null : callLoader);
    }

    public final CallBody getBody() {
        return this.body;
    }

    public final CallLoader getStream() {
        return this.stream;
    }
}
