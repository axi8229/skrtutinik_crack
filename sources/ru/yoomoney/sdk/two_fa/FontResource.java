package ru.yoomoney.sdk.two_fa;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Config.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/two_fa/FontResource;", "Landroid/os/Parcelable;", "resId", "", "weight", "(II)V", "getResId", "()I", "getWeight", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FontResource implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<FontResource> CREATOR = new Creator();
    private final int resId;
    private final int weight;

    /* compiled from: Config.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FontResource> {
        @Override // android.os.Parcelable.Creator
        public final FontResource createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FontResource(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final FontResource[] newArray(int i) {
            return new FontResource[i];
        }
    }

    public static /* synthetic */ FontResource copy$default(FontResource fontResource, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = fontResource.resId;
        }
        if ((i3 & 2) != 0) {
            i2 = fontResource.weight;
        }
        return fontResource.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWeight() {
        return this.weight;
    }

    public final FontResource copy(int resId, int weight) {
        return new FontResource(resId, weight);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FontResource)) {
            return false;
        }
        FontResource fontResource = (FontResource) other;
        return this.resId == fontResource.resId && this.weight == fontResource.weight;
    }

    public int hashCode() {
        return (Integer.hashCode(this.resId) * 31) + Integer.hashCode(this.weight);
    }

    public String toString() {
        return "FontResource(resId=" + this.resId + ", weight=" + this.weight + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.resId);
        parcel.writeInt(this.weight);
    }

    public FontResource(int i, int i2) {
        this.resId = i;
        this.weight = i2;
    }

    public final int getResId() {
        return this.resId;
    }

    public final int getWeight() {
        return this.weight;
    }
}
