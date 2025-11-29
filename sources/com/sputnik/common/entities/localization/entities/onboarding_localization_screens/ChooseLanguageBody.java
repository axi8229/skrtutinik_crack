package com.sputnik.common.entities.localization.entities.onboarding_localization_screens;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChooseLanguageLocale.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ChooseLanguageBody;", "Landroid/os/Parcelable;", "", "", "titles", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ChooseLanguageReadyButton;", "readyButton", "<init>", "(Ljava/util/List;Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ChooseLanguageReadyButton;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getTitles", "()Ljava/util/List;", "Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ChooseLanguageReadyButton;", "getReadyButton", "()Lcom/sputnik/common/entities/localization/entities/onboarding_localization_screens/ChooseLanguageReadyButton;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChooseLanguageBody implements Parcelable {
    public static final Parcelable.Creator<ChooseLanguageBody> CREATOR = new Creator();

    @SerializedName("ready_button")
    private final ChooseLanguageReadyButton readyButton;
    private final List<String> titles;

    /* compiled from: ChooseLanguageLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ChooseLanguageBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChooseLanguageBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChooseLanguageBody(parcel.createStringArrayList(), ChooseLanguageReadyButton.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ChooseLanguageBody[] newArray(int i) {
            return new ChooseLanguageBody[i];
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
        if (!(other instanceof ChooseLanguageBody)) {
            return false;
        }
        ChooseLanguageBody chooseLanguageBody = (ChooseLanguageBody) other;
        return Intrinsics.areEqual(this.titles, chooseLanguageBody.titles) && Intrinsics.areEqual(this.readyButton, chooseLanguageBody.readyButton);
    }

    public int hashCode() {
        return (this.titles.hashCode() * 31) + this.readyButton.hashCode();
    }

    public String toString() {
        return "ChooseLanguageBody(titles=" + this.titles + ", readyButton=" + this.readyButton + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.titles);
        this.readyButton.writeToParcel(parcel, flags);
    }

    public ChooseLanguageBody(List<String> titles, ChooseLanguageReadyButton readyButton) {
        Intrinsics.checkNotNullParameter(titles, "titles");
        Intrinsics.checkNotNullParameter(readyButton, "readyButton");
        this.titles = titles;
        this.readyButton = readyButton;
    }

    public final List<String> getTitles() {
        return this.titles;
    }

    public final ChooseLanguageReadyButton getReadyButton() {
        return this.readyButton;
    }
}
