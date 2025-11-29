package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TitleWithParam;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/SplashBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "", "loadingText", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "getTitle", "()Lcom/sputnik/common/entities/localization/entities/common/TitleWithParam;", "Ljava/util/List;", "getLoadingText", "()Ljava/util/List;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SplashBody implements Parcelable {
    public static final Parcelable.Creator<SplashBody> CREATOR = new Creator();

    @SerializedName("loading_text")
    private final List<String> loadingText;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final TitleWithParam title;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SplashBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SplashBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SplashBody((TitleWithParam) parcel.readParcelable(SplashBody.class.getClassLoader()), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SplashBody[] newArray(int i) {
            return new SplashBody[i];
        }
    }

    public SplashBody() {
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
        if (!(other instanceof SplashBody)) {
            return false;
        }
        SplashBody splashBody = (SplashBody) other;
        return Intrinsics.areEqual(this.title, splashBody.title) && Intrinsics.areEqual(this.loadingText, splashBody.loadingText);
    }

    public int hashCode() {
        TitleWithParam titleWithParam = this.title;
        int iHashCode = (titleWithParam == null ? 0 : titleWithParam.hashCode()) * 31;
        List<String> list = this.loadingText;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SplashBody(title=" + this.title + ", loadingText=" + this.loadingText + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.title, flags);
        parcel.writeStringList(this.loadingText);
    }

    public SplashBody(TitleWithParam titleWithParam, List<String> list) {
        this.title = titleWithParam;
        this.loadingText = list;
    }

    public /* synthetic */ SplashBody(TitleWithParam titleWithParam, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : titleWithParam, (i & 2) != 0 ? null : list);
    }

    public final TitleWithParam getTitle() {
        return this.title;
    }

    public final List<String> getLoadingText() {
        return this.loadingText;
    }
}
