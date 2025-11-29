package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lcom/sputnik/common/entities/localization/ChangeLanguageBody;", "Landroid/os/Parcelable;", "", "", "titles", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "changeButton", "cancelButton", "<init>", "(Ljava/util/List;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getTitles", "()Ljava/util/List;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getChangeButton", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getCancelButton", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChangeLanguageBody implements Parcelable {
    public static final Parcelable.Creator<ChangeLanguageBody> CREATOR = new Creator();

    @SerializedName("cancel_button")
    private final TextTitle cancelButton;

    @SerializedName("change_button")
    private final TextTitle changeButton;
    private final List<String> titles;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ChangeLanguageBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChangeLanguageBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChangeLanguageBody(parcel.createStringArrayList(), (TextTitle) parcel.readParcelable(ChangeLanguageBody.class.getClassLoader()), (TextTitle) parcel.readParcelable(ChangeLanguageBody.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChangeLanguageBody[] newArray(int i) {
            return new ChangeLanguageBody[i];
        }
    }

    public ChangeLanguageBody() {
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
        if (!(other instanceof ChangeLanguageBody)) {
            return false;
        }
        ChangeLanguageBody changeLanguageBody = (ChangeLanguageBody) other;
        return Intrinsics.areEqual(this.titles, changeLanguageBody.titles) && Intrinsics.areEqual(this.changeButton, changeLanguageBody.changeButton) && Intrinsics.areEqual(this.cancelButton, changeLanguageBody.cancelButton);
    }

    public int hashCode() {
        List<String> list = this.titles;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        TextTitle textTitle = this.changeButton;
        int iHashCode2 = (iHashCode + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        TextTitle textTitle2 = this.cancelButton;
        return iHashCode2 + (textTitle2 != null ? textTitle2.hashCode() : 0);
    }

    public String toString() {
        return "ChangeLanguageBody(titles=" + this.titles + ", changeButton=" + this.changeButton + ", cancelButton=" + this.cancelButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.titles);
        parcel.writeParcelable(this.changeButton, flags);
        parcel.writeParcelable(this.cancelButton, flags);
    }

    public ChangeLanguageBody(List<String> list, TextTitle textTitle, TextTitle textTitle2) {
        this.titles = list;
        this.changeButton = textTitle;
        this.cancelButton = textTitle2;
    }

    public /* synthetic */ ChangeLanguageBody(List list, TextTitle textTitle, TextTitle textTitle2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : textTitle, (i & 4) != 0 ? null : textTitle2);
    }

    public final List<String> getTitles() {
        return this.titles;
    }

    public final TextTitle getChangeButton() {
        return this.changeButton;
    }

    public final TextTitle getCancelButton() {
        return this.cancelButton;
    }
}
