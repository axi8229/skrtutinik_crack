package com.sputnik.common.entities.gorserv;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.common.R$drawable;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GorservFeature.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002 !B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010\r¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/gorserv/GorservFeature;", "Landroid/os/Parcelable;", "", "id", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "body", "", RemoteMessageConst.Notification.ICON, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "getTitle", "getBody", "I", "getIcon", "Companion", "FeatureIds", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GorservFeature implements Parcelable {
    private final String body;
    private final int icon;
    private final String id;
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<GorservFeature> CREATOR = new Creator();

    /* compiled from: GorservFeature.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GorservFeature> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GorservFeature createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GorservFeature(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GorservFeature[] newArray(int i) {
            return new GorservFeature[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GorservFeature)) {
            return false;
        }
        GorservFeature gorservFeature = (GorservFeature) other;
        return Intrinsics.areEqual(this.id, gorservFeature.id) && Intrinsics.areEqual(this.title, gorservFeature.title) && Intrinsics.areEqual(this.body, gorservFeature.body) && this.icon == gorservFeature.icon;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.body;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Integer.hashCode(this.icon);
    }

    public String toString() {
        return "GorservFeature(id=" + this.id + ", title=" + this.title + ", body=" + this.body + ", icon=" + this.icon + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.body);
        parcel.writeInt(this.icon);
    }

    public GorservFeature(String str, String str2, String str3, int i) {
        this.id = str;
        this.title = str2;
        this.body = str3;
        this.icon = i;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: GorservFeature.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/sputnik/common/entities/gorserv/GorservFeature$FeatureIds;", "", "(Ljava/lang/String;I)V", "experience", "warranty", "quality", "price", "insurance", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FeatureIds {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FeatureIds[] $VALUES;
        public static final FeatureIds experience = new FeatureIds("experience", 0);
        public static final FeatureIds warranty = new FeatureIds("warranty", 1);
        public static final FeatureIds quality = new FeatureIds("quality", 2);
        public static final FeatureIds price = new FeatureIds("price", 3);
        public static final FeatureIds insurance = new FeatureIds("insurance", 4);

        private static final /* synthetic */ FeatureIds[] $values() {
            return new FeatureIds[]{experience, warranty, quality, price, insurance};
        }

        public static FeatureIds valueOf(String str) {
            return (FeatureIds) Enum.valueOf(FeatureIds.class, str);
        }

        public static FeatureIds[] values() {
            return (FeatureIds[]) $VALUES.clone();
        }

        private FeatureIds(String str, int i) {
        }

        static {
            FeatureIds[] featureIdsArr$values = $values();
            $VALUES = featureIdsArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(featureIdsArr$values);
        }
    }

    /* compiled from: GorservFeature.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/common/entities/gorserv/GorservFeature$Companion;", "", "()V", "getIconForFeature", "", "feature", "", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getIconForFeature(String feature) {
            Intrinsics.checkNotNullParameter(feature, "feature");
            return Intrinsics.areEqual(feature, FeatureIds.experience.toString()) ? R$drawable.ic_experience : Intrinsics.areEqual(feature, FeatureIds.warranty.toString()) ? R$drawable.ic_warranty : Intrinsics.areEqual(feature, FeatureIds.quality.toString()) ? R$drawable.ic_quality : Intrinsics.areEqual(feature, FeatureIds.price.toString()) ? R$drawable.ic_price : Intrinsics.areEqual(feature, FeatureIds.insurance.toString()) ? R$drawable.ic_insurance : R$drawable.ic_insurance;
        }
    }
}
