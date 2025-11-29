package spay.sdk.domain.model.response;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.bnpl.ButtonBnplParts;
import spay.sdk.domain.model.response.bnpl.PartsGraphBnpl;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006&"}, d2 = {"Lspay/sdk/domain/model/response/PartsPaymentPlanBnplResponseBody;", "Landroid/os/Parcelable;", "buttonBnpl", "Lspay/sdk/domain/model/response/bnpl/ButtonBnplParts;", "offerUrl", "", "offerText", "isBnplEnabled", "", "graphBnpl", "Lspay/sdk/domain/model/response/bnpl/PartsGraphBnpl;", "(Lspay/sdk/domain/model/response/bnpl/ButtonBnplParts;Ljava/lang/String;Ljava/lang/String;ZLspay/sdk/domain/model/response/bnpl/PartsGraphBnpl;)V", "getButtonBnpl", "()Lspay/sdk/domain/model/response/bnpl/ButtonBnplParts;", "getGraphBnpl", "()Lspay/sdk/domain/model/response/bnpl/PartsGraphBnpl;", "()Z", "getOfferText", "()Ljava/lang/String;", "getOfferUrl", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PartsPaymentPlanBnplResponseBody implements Parcelable {
    public static final Parcelable.Creator<PartsPaymentPlanBnplResponseBody> CREATOR = new Creator();
    private final ButtonBnplParts buttonBnpl;
    private final PartsGraphBnpl graphBnpl;
    private final boolean isBnplEnabled;
    private final String offerText;
    private final String offerUrl;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PartsPaymentPlanBnplResponseBody> {
        @Override // android.os.Parcelable.Creator
        public final PartsPaymentPlanBnplResponseBody createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PartsPaymentPlanBnplResponseBody(parcel.readInt() == 0 ? null : ButtonBnplParts.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0 ? PartsGraphBnpl.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final PartsPaymentPlanBnplResponseBody[] newArray(int i) {
            return new PartsPaymentPlanBnplResponseBody[i];
        }
    }

    public PartsPaymentPlanBnplResponseBody(ButtonBnplParts buttonBnplParts, String str, String str2, boolean z, PartsGraphBnpl partsGraphBnpl) {
        this.buttonBnpl = buttonBnplParts;
        this.offerUrl = str;
        this.offerText = str2;
        this.isBnplEnabled = z;
        this.graphBnpl = partsGraphBnpl;
    }

    public static /* synthetic */ PartsPaymentPlanBnplResponseBody copy$default(PartsPaymentPlanBnplResponseBody partsPaymentPlanBnplResponseBody, ButtonBnplParts buttonBnplParts, String str, String str2, boolean z, PartsGraphBnpl partsGraphBnpl, int i, Object obj) {
        if ((i & 1) != 0) {
            buttonBnplParts = partsPaymentPlanBnplResponseBody.buttonBnpl;
        }
        if ((i & 2) != 0) {
            str = partsPaymentPlanBnplResponseBody.offerUrl;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = partsPaymentPlanBnplResponseBody.offerText;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            z = partsPaymentPlanBnplResponseBody.isBnplEnabled;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            partsGraphBnpl = partsPaymentPlanBnplResponseBody.graphBnpl;
        }
        return partsPaymentPlanBnplResponseBody.copy(buttonBnplParts, str3, str4, z2, partsGraphBnpl);
    }

    /* renamed from: component1, reason: from getter */
    public final ButtonBnplParts getButtonBnpl() {
        return this.buttonBnpl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOfferUrl() {
        return this.offerUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOfferText() {
        return this.offerText;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsBnplEnabled() {
        return this.isBnplEnabled;
    }

    /* renamed from: component5, reason: from getter */
    public final PartsGraphBnpl getGraphBnpl() {
        return this.graphBnpl;
    }

    public final PartsPaymentPlanBnplResponseBody copy(ButtonBnplParts buttonBnpl, String offerUrl, String offerText, boolean isBnplEnabled, PartsGraphBnpl graphBnpl) {
        return new PartsPaymentPlanBnplResponseBody(buttonBnpl, offerUrl, offerText, isBnplEnabled, graphBnpl);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PartsPaymentPlanBnplResponseBody)) {
            return false;
        }
        PartsPaymentPlanBnplResponseBody partsPaymentPlanBnplResponseBody = (PartsPaymentPlanBnplResponseBody) other;
        return Intrinsics.areEqual(this.buttonBnpl, partsPaymentPlanBnplResponseBody.buttonBnpl) && Intrinsics.areEqual(this.offerUrl, partsPaymentPlanBnplResponseBody.offerUrl) && Intrinsics.areEqual(this.offerText, partsPaymentPlanBnplResponseBody.offerText) && this.isBnplEnabled == partsPaymentPlanBnplResponseBody.isBnplEnabled && Intrinsics.areEqual(this.graphBnpl, partsPaymentPlanBnplResponseBody.graphBnpl);
    }

    public final ButtonBnplParts getButtonBnpl() {
        return this.buttonBnpl;
    }

    public final PartsGraphBnpl getGraphBnpl() {
        return this.graphBnpl;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final String getOfferUrl() {
        return this.offerUrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ButtonBnplParts buttonBnplParts = this.buttonBnpl;
        int iHashCode = (buttonBnplParts == null ? 0 : buttonBnplParts.hashCode()) * 31;
        String str = this.offerUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.offerText;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.isBnplEnabled;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        PartsGraphBnpl partsGraphBnpl = this.graphBnpl;
        return i2 + (partsGraphBnpl != null ? partsGraphBnpl.hashCode() : 0);
    }

    public final boolean isBnplEnabled() {
        return this.isBnplEnabled;
    }

    public String toString() {
        return "PartsPaymentPlanBnplResponseBody(buttonBnpl=" + this.buttonBnpl + ", offerUrl=" + this.offerUrl + ", offerText=" + this.offerText + ", isBnplEnabled=" + this.isBnplEnabled + ", graphBnpl=" + this.graphBnpl + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        ButtonBnplParts buttonBnplParts = this.buttonBnpl;
        if (buttonBnplParts == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            buttonBnplParts.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.offerUrl);
        parcel.writeString(this.offerText);
        parcel.writeInt(this.isBnplEnabled ? 1 : 0);
        PartsGraphBnpl partsGraphBnpl = this.graphBnpl;
        if (partsGraphBnpl == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            partsGraphBnpl.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ PartsPaymentPlanBnplResponseBody(ButtonBnplParts buttonBnplParts, String str, String str2, boolean z, PartsGraphBnpl partsGraphBnpl, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : buttonBnplParts, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, z, (i & 16) != 0 ? null : partsGraphBnpl);
    }
}
