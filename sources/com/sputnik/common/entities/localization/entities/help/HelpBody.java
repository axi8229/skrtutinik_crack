package com.sputnik.common.entities.localization.entities.help;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HelpLocale.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR!\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/sputnik/common/entities/localization/entities/help/HelpBody;", "Landroid/os/Parcelable;", "", "", "titles", "Lcom/sputnik/common/entities/localization/entities/help/ViewFaq;", "viewFaq", "Lcom/sputnik/common/entities/localization/entities/help/ViewSupport;", "viewSupport", "Lcom/sputnik/common/entities/localization/entities/help/ViewIntercomQuestions;", "viewIntercomQuestions", "<init>", "(Ljava/util/List;Lcom/sputnik/common/entities/localization/entities/help/ViewFaq;Lcom/sputnik/common/entities/localization/entities/help/ViewSupport;Lcom/sputnik/common/entities/localization/entities/help/ViewIntercomQuestions;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getTitles", "()Ljava/util/List;", "Lcom/sputnik/common/entities/localization/entities/help/ViewFaq;", "getViewFaq", "()Lcom/sputnik/common/entities/localization/entities/help/ViewFaq;", "Lcom/sputnik/common/entities/localization/entities/help/ViewSupport;", "getViewSupport", "()Lcom/sputnik/common/entities/localization/entities/help/ViewSupport;", "Lcom/sputnik/common/entities/localization/entities/help/ViewIntercomQuestions;", "getViewIntercomQuestions", "()Lcom/sputnik/common/entities/localization/entities/help/ViewIntercomQuestions;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HelpBody implements Parcelable {
    public static final Parcelable.Creator<HelpBody> CREATOR = new Creator();
    private final List<String> titles;

    @SerializedName("view_faq")
    private final ViewFaq viewFaq;

    @SerializedName("intercom_questions")
    private final ViewIntercomQuestions viewIntercomQuestions;

    @SerializedName("app_questions")
    private final ViewSupport viewSupport;

    /* compiled from: HelpLocale.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<HelpBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HelpBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new HelpBody(parcel.createStringArrayList(), parcel.readInt() == 0 ? null : ViewFaq.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : ViewSupport.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ViewIntercomQuestions.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HelpBody[] newArray(int i) {
            return new HelpBody[i];
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
        if (!(other instanceof HelpBody)) {
            return false;
        }
        HelpBody helpBody = (HelpBody) other;
        return Intrinsics.areEqual(this.titles, helpBody.titles) && Intrinsics.areEqual(this.viewFaq, helpBody.viewFaq) && Intrinsics.areEqual(this.viewSupport, helpBody.viewSupport) && Intrinsics.areEqual(this.viewIntercomQuestions, helpBody.viewIntercomQuestions);
    }

    public int hashCode() {
        List<String> list = this.titles;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        ViewFaq viewFaq = this.viewFaq;
        int iHashCode2 = (iHashCode + (viewFaq == null ? 0 : viewFaq.hashCode())) * 31;
        ViewSupport viewSupport = this.viewSupport;
        int iHashCode3 = (iHashCode2 + (viewSupport == null ? 0 : viewSupport.hashCode())) * 31;
        ViewIntercomQuestions viewIntercomQuestions = this.viewIntercomQuestions;
        return iHashCode3 + (viewIntercomQuestions != null ? viewIntercomQuestions.hashCode() : 0);
    }

    public String toString() {
        return "HelpBody(titles=" + this.titles + ", viewFaq=" + this.viewFaq + ", viewSupport=" + this.viewSupport + ", viewIntercomQuestions=" + this.viewIntercomQuestions + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.titles);
        ViewFaq viewFaq = this.viewFaq;
        if (viewFaq == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            viewFaq.writeToParcel(parcel, flags);
        }
        ViewSupport viewSupport = this.viewSupport;
        if (viewSupport == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            viewSupport.writeToParcel(parcel, flags);
        }
        ViewIntercomQuestions viewIntercomQuestions = this.viewIntercomQuestions;
        if (viewIntercomQuestions == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            viewIntercomQuestions.writeToParcel(parcel, flags);
        }
    }

    public HelpBody(List<String> list, ViewFaq viewFaq, ViewSupport viewSupport, ViewIntercomQuestions viewIntercomQuestions) {
        this.titles = list;
        this.viewFaq = viewFaq;
        this.viewSupport = viewSupport;
        this.viewIntercomQuestions = viewIntercomQuestions;
    }

    public final List<String> getTitles() {
        return this.titles;
    }

    public final ViewFaq getViewFaq() {
        return this.viewFaq;
    }

    public final ViewSupport getViewSupport() {
        return this.viewSupport;
    }

    public final ViewIntercomQuestions getViewIntercomQuestions() {
        return this.viewIntercomQuestions;
    }
}
