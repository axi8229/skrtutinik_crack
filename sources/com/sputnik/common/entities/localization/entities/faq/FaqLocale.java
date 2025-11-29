package com.sputnik.common.entities.localization.entities.faq;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FaqLocale.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b!\u0010\u000b¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/entities/faq/FaqLocale;", "Landroid/os/Parcelable;", "", "toolbar", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "Lcom/sputnik/common/entities/localization/entities/faq/FaqEmptyView;", "emptyView", "btnSupport", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/common/entities/localization/entities/faq/FaqEmptyView;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getToolbar", "getTitle", "Lcom/sputnik/common/entities/localization/entities/faq/FaqEmptyView;", "getEmptyView", "()Lcom/sputnik/common/entities/localization/entities/faq/FaqEmptyView;", "getBtnSupport", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FaqLocale implements Parcelable {
    public static final Parcelable.Creator<FaqLocale> CREATOR = new Creator();

    @SerializedName("btn_support")
    private final String btnSupport;

    @SerializedName("view_empty")
    private final FaqEmptyView emptyView;
    private final String title;
    private final String toolbar;

    /* compiled from: FaqLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FaqLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FaqLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FaqLocale(parcel.readString(), parcel.readString(), FaqEmptyView.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FaqLocale[] newArray(int i) {
            return new FaqLocale[i];
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
        if (!(other instanceof FaqLocale)) {
            return false;
        }
        FaqLocale faqLocale = (FaqLocale) other;
        return Intrinsics.areEqual(this.toolbar, faqLocale.toolbar) && Intrinsics.areEqual(this.title, faqLocale.title) && Intrinsics.areEqual(this.emptyView, faqLocale.emptyView) && Intrinsics.areEqual(this.btnSupport, faqLocale.btnSupport);
    }

    public int hashCode() {
        String str = this.toolbar;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.emptyView.hashCode()) * 31;
        String str3 = this.btnSupport;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "FaqLocale(toolbar=" + this.toolbar + ", title=" + this.title + ", emptyView=" + this.emptyView + ", btnSupport=" + this.btnSupport + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.toolbar);
        parcel.writeString(this.title);
        this.emptyView.writeToParcel(parcel, flags);
        parcel.writeString(this.btnSupport);
    }

    public FaqLocale(String str, String str2, FaqEmptyView emptyView, String str3) {
        Intrinsics.checkNotNullParameter(emptyView, "emptyView");
        this.toolbar = str;
        this.title = str2;
        this.emptyView = emptyView;
        this.btnSupport = str3;
    }

    public final String getToolbar() {
        return this.toolbar;
    }

    public final String getTitle() {
        return this.title;
    }

    public final FaqEmptyView getEmptyView() {
        return this.emptyView;
    }
}
