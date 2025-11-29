package com.sputnik.data.entities.subscriptions.subscriptions;

import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataServiceAppearance.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/sputnik/data/entities/subscriptions/subscriptions/DataServiceAppearance;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "description", "Ljava/lang/String;", "getDescription", "fullDescription", "getFullDescription", "introduction", "getIntroduction", "resume", "getResume", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "getTitle", "badge", "getBadge", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataServiceAppearance {
    private final String badge;

    @SerializedName("description")
    private final String description;

    @SerializedName("full_description")
    private final String fullDescription;

    @SerializedName("introduction")
    private final String introduction;

    @SerializedName("resume")
    private final String resume;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final String title;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataServiceAppearance)) {
            return false;
        }
        DataServiceAppearance dataServiceAppearance = (DataServiceAppearance) other;
        return Intrinsics.areEqual(this.description, dataServiceAppearance.description) && Intrinsics.areEqual(this.fullDescription, dataServiceAppearance.fullDescription) && Intrinsics.areEqual(this.introduction, dataServiceAppearance.introduction) && Intrinsics.areEqual(this.resume, dataServiceAppearance.resume) && Intrinsics.areEqual(this.title, dataServiceAppearance.title) && Intrinsics.areEqual(this.badge, dataServiceAppearance.badge);
    }

    public int hashCode() {
        String str = this.description;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fullDescription;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.introduction;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.resume;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.badge;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "DataServiceAppearance(description=" + this.description + ", fullDescription=" + this.fullDescription + ", introduction=" + this.introduction + ", resume=" + this.resume + ", title=" + this.title + ", badge=" + this.badge + ")";
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFullDescription() {
        return this.fullDescription;
    }

    public final String getIntroduction() {
        return this.introduction;
    }

    public final String getResume() {
        return this.resume;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBadge() {
        return this.badge;
    }
}
