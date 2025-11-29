package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b.\u0010/R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u00100\u001a\u0004\b1\u0010\u0011¨\u00062"}, d2 = {"Lcom/sputnik/common/entities/localization/VisitsBody;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/VisitsEmptyView;", "emptyView", "Lcom/sputnik/common/entities/localization/VisitsBottomTitle;", "table", "Lcom/sputnik/common/entities/localization/VisitsBottomView;", "bottomView", "Lcom/sputnik/common/entities/localization/PromoView;", "promoView", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "allHistory", "", "viewError", "<init>", "(Lcom/sputnik/common/entities/localization/VisitsEmptyView;Lcom/sputnik/common/entities/localization/VisitsBottomTitle;Lcom/sputnik/common/entities/localization/VisitsBottomView;Lcom/sputnik/common/entities/localization/PromoView;Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/VisitsEmptyView;", "getEmptyView", "()Lcom/sputnik/common/entities/localization/VisitsEmptyView;", "Lcom/sputnik/common/entities/localization/VisitsBottomTitle;", "getTable", "()Lcom/sputnik/common/entities/localization/VisitsBottomTitle;", "Lcom/sputnik/common/entities/localization/VisitsBottomView;", "getBottomView", "()Lcom/sputnik/common/entities/localization/VisitsBottomView;", "Lcom/sputnik/common/entities/localization/PromoView;", "getPromoView", "()Lcom/sputnik/common/entities/localization/PromoView;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getAllHistory", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Ljava/lang/String;", "getViewError", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VisitsBody implements Parcelable {
    public static final Parcelable.Creator<VisitsBody> CREATOR = new Creator();

    @SerializedName("all_history")
    private final TextTitle allHistory;

    @SerializedName("bottom_view")
    private final VisitsBottomView bottomView;

    @SerializedName("empty_view")
    private final VisitsEmptyView emptyView;

    @SerializedName("promo_view")
    private final PromoView promoView;
    private final VisitsBottomTitle table;

    @SerializedName("view_error")
    private final String viewError;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VisitsBody> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VisitsBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VisitsBody(parcel.readInt() == 0 ? null : VisitsEmptyView.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : VisitsBottomTitle.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : VisitsBottomView.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? PromoView.CREATOR.createFromParcel(parcel) : null, (TextTitle) parcel.readParcelable(VisitsBody.class.getClassLoader()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VisitsBody[] newArray(int i) {
            return new VisitsBody[i];
        }
    }

    public VisitsBody() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VisitsBody)) {
            return false;
        }
        VisitsBody visitsBody = (VisitsBody) other;
        return Intrinsics.areEqual(this.emptyView, visitsBody.emptyView) && Intrinsics.areEqual(this.table, visitsBody.table) && Intrinsics.areEqual(this.bottomView, visitsBody.bottomView) && Intrinsics.areEqual(this.promoView, visitsBody.promoView) && Intrinsics.areEqual(this.allHistory, visitsBody.allHistory) && Intrinsics.areEqual(this.viewError, visitsBody.viewError);
    }

    public int hashCode() {
        VisitsEmptyView visitsEmptyView = this.emptyView;
        int iHashCode = (visitsEmptyView == null ? 0 : visitsEmptyView.hashCode()) * 31;
        VisitsBottomTitle visitsBottomTitle = this.table;
        int iHashCode2 = (iHashCode + (visitsBottomTitle == null ? 0 : visitsBottomTitle.hashCode())) * 31;
        VisitsBottomView visitsBottomView = this.bottomView;
        int iHashCode3 = (iHashCode2 + (visitsBottomView == null ? 0 : visitsBottomView.hashCode())) * 31;
        PromoView promoView = this.promoView;
        int iHashCode4 = (iHashCode3 + (promoView == null ? 0 : promoView.hashCode())) * 31;
        TextTitle textTitle = this.allHistory;
        int iHashCode5 = (iHashCode4 + (textTitle == null ? 0 : textTitle.hashCode())) * 31;
        String str = this.viewError;
        return iHashCode5 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "VisitsBody(emptyView=" + this.emptyView + ", table=" + this.table + ", bottomView=" + this.bottomView + ", promoView=" + this.promoView + ", allHistory=" + this.allHistory + ", viewError=" + this.viewError + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        VisitsEmptyView visitsEmptyView = this.emptyView;
        if (visitsEmptyView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            visitsEmptyView.writeToParcel(parcel, flags);
        }
        VisitsBottomTitle visitsBottomTitle = this.table;
        if (visitsBottomTitle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            visitsBottomTitle.writeToParcel(parcel, flags);
        }
        VisitsBottomView visitsBottomView = this.bottomView;
        if (visitsBottomView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            visitsBottomView.writeToParcel(parcel, flags);
        }
        PromoView promoView = this.promoView;
        if (promoView == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            promoView.writeToParcel(parcel, flags);
        }
        parcel.writeParcelable(this.allHistory, flags);
        parcel.writeString(this.viewError);
    }

    public VisitsBody(VisitsEmptyView visitsEmptyView, VisitsBottomTitle visitsBottomTitle, VisitsBottomView visitsBottomView, PromoView promoView, TextTitle textTitle, String str) {
        this.emptyView = visitsEmptyView;
        this.table = visitsBottomTitle;
        this.bottomView = visitsBottomView;
        this.promoView = promoView;
        this.allHistory = textTitle;
        this.viewError = str;
    }

    public /* synthetic */ VisitsBody(VisitsEmptyView visitsEmptyView, VisitsBottomTitle visitsBottomTitle, VisitsBottomView visitsBottomView, PromoView promoView, TextTitle textTitle, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : visitsEmptyView, (i & 2) != 0 ? null : visitsBottomTitle, (i & 4) != 0 ? null : visitsBottomView, (i & 8) != 0 ? null : promoView, (i & 16) != 0 ? null : textTitle, (i & 32) != 0 ? null : str);
    }

    public final VisitsEmptyView getEmptyView() {
        return this.emptyView;
    }

    public final VisitsBottomTitle getTable() {
        return this.table;
    }

    public final VisitsBottomView getBottomView() {
        return this.bottomView;
    }

    public final PromoView getPromoView() {
        return this.promoView;
    }

    public final TextTitle getAllHistory() {
        return this.allHistory;
    }

    public final String getViewError() {
        return this.viewError;
    }
}
