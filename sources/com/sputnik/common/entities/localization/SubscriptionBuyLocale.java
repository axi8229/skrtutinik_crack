package com.sputnik.common.entities.localization;

import android.os.Parcel;
import android.os.Parcelable;
import com.sputnik.common.entities.localization.entities.common.TextTitle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalizationModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/sputnik/common/entities/localization/SubscriptionBuyLocale;", "Landroid/os/Parcelable;", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "navigation", "Lcom/sputnik/common/entities/localization/SubscriptionBuyBody;", "body", "Lcom/sputnik/common/entities/localization/SubscriptionBuyErrors;", "errors", "<init>", "(Lcom/sputnik/common/entities/localization/entities/common/TextTitle;Lcom/sputnik/common/entities/localization/SubscriptionBuyBody;Lcom/sputnik/common/entities/localization/SubscriptionBuyErrors;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "getNavigation", "()Lcom/sputnik/common/entities/localization/entities/common/TextTitle;", "Lcom/sputnik/common/entities/localization/SubscriptionBuyBody;", "getBody", "()Lcom/sputnik/common/entities/localization/SubscriptionBuyBody;", "Lcom/sputnik/common/entities/localization/SubscriptionBuyErrors;", "getErrors", "()Lcom/sputnik/common/entities/localization/SubscriptionBuyErrors;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SubscriptionBuyLocale implements Parcelable {
    public static final Parcelable.Creator<SubscriptionBuyLocale> CREATOR = new Creator();
    private final SubscriptionBuyBody body;
    private final SubscriptionBuyErrors errors;
    private final TextTitle navigation;

    /* compiled from: LocalizationModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionBuyLocale> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubscriptionBuyLocale createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubscriptionBuyLocale((TextTitle) parcel.readParcelable(SubscriptionBuyLocale.class.getClassLoader()), parcel.readInt() == 0 ? null : SubscriptionBuyBody.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? SubscriptionBuyErrors.CREATOR.createFromParcel(parcel) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubscriptionBuyLocale[] newArray(int i) {
            return new SubscriptionBuyLocale[i];
        }
    }

    public SubscriptionBuyLocale() {
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
        if (!(other instanceof SubscriptionBuyLocale)) {
            return false;
        }
        SubscriptionBuyLocale subscriptionBuyLocale = (SubscriptionBuyLocale) other;
        return Intrinsics.areEqual(this.navigation, subscriptionBuyLocale.navigation) && Intrinsics.areEqual(this.body, subscriptionBuyLocale.body) && Intrinsics.areEqual(this.errors, subscriptionBuyLocale.errors);
    }

    public int hashCode() {
        TextTitle textTitle = this.navigation;
        int iHashCode = (textTitle == null ? 0 : textTitle.hashCode()) * 31;
        SubscriptionBuyBody subscriptionBuyBody = this.body;
        int iHashCode2 = (iHashCode + (subscriptionBuyBody == null ? 0 : subscriptionBuyBody.hashCode())) * 31;
        SubscriptionBuyErrors subscriptionBuyErrors = this.errors;
        return iHashCode2 + (subscriptionBuyErrors != null ? subscriptionBuyErrors.hashCode() : 0);
    }

    public String toString() {
        return "SubscriptionBuyLocale(navigation=" + this.navigation + ", body=" + this.body + ", errors=" + this.errors + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.navigation, flags);
        SubscriptionBuyBody subscriptionBuyBody = this.body;
        if (subscriptionBuyBody == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            subscriptionBuyBody.writeToParcel(parcel, flags);
        }
        SubscriptionBuyErrors subscriptionBuyErrors = this.errors;
        if (subscriptionBuyErrors == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            subscriptionBuyErrors.writeToParcel(parcel, flags);
        }
    }

    public SubscriptionBuyLocale(TextTitle textTitle, SubscriptionBuyBody subscriptionBuyBody, SubscriptionBuyErrors subscriptionBuyErrors) {
        this.navigation = textTitle;
        this.body = subscriptionBuyBody;
        this.errors = subscriptionBuyErrors;
    }

    public /* synthetic */ SubscriptionBuyLocale(TextTitle textTitle, SubscriptionBuyBody subscriptionBuyBody, SubscriptionBuyErrors subscriptionBuyErrors, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textTitle, (i & 2) != 0 ? null : subscriptionBuyBody, (i & 4) != 0 ? null : subscriptionBuyErrors);
    }

    public final TextTitle getNavigation() {
        return this.navigation;
    }

    public final SubscriptionBuyBody getBody() {
        return this.body;
    }

    public final SubscriptionBuyErrors getErrors() {
        return this.errors;
    }
}
