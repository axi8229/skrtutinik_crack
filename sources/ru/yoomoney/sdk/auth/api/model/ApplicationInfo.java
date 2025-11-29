package ru.yoomoney.sdk.auth.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import flussonic.media.FFmpegMediaMetadataRetriever;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "Landroid/os/Parcelable;", FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE, "", "scopes", "", "Lru/yoomoney/sdk/auth/api/model/Scope;", "(Ljava/lang/String;Ljava/util/List;)V", "getScopes", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ApplicationInfo implements Parcelable {
    public static final Parcelable.Creator<ApplicationInfo> CREATOR = new Creator();

    @SerializedName("scopes")
    private final List<Scope> scopes;

    @SerializedName(FFmpegMediaMetadataRetriever.METADATA_KEY_TITLE)
    private final String title;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ApplicationInfo> {
        @Override // android.os.Parcelable.Creator
        public final ApplicationInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(Scope.CREATOR.createFromParcel(parcel));
            }
            return new ApplicationInfo(string, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final ApplicationInfo[] newArray(int i) {
            return new ApplicationInfo[i];
        }
    }

    public ApplicationInfo(String title, List<Scope> scopes) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        this.title = title;
        this.scopes = scopes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApplicationInfo copy$default(ApplicationInfo applicationInfo, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = applicationInfo.title;
        }
        if ((i & 2) != 0) {
            list = applicationInfo.scopes;
        }
        return applicationInfo.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<Scope> component2() {
        return this.scopes;
    }

    public final ApplicationInfo copy(String title, List<Scope> scopes) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        return new ApplicationInfo(title, scopes);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationInfo)) {
            return false;
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) other;
        return Intrinsics.areEqual(this.title, applicationInfo.title) && Intrinsics.areEqual(this.scopes, applicationInfo.scopes);
    }

    public final List<Scope> getScopes() {
        return this.scopes;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.scopes.hashCode() + (this.title.hashCode() * 31);
    }

    public String toString() {
        return "ApplicationInfo(title=" + this.title + ", scopes=" + this.scopes + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.title);
        List<Scope> list = this.scopes;
        parcel.writeInt(list.size());
        Iterator<Scope> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }
}
