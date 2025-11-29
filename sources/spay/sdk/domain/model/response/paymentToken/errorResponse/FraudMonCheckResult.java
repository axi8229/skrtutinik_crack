package spay.sdk.domain.model.response.paymentToken.errorResponse;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001:\u0001!B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f¨\u0006\""}, d2 = {"Lspay/sdk/domain/model/response/paymentToken/errorResponse/FraudMonCheckResult;", "Landroid/os/Parcelable;", "actionCode", "", "isClientBlock", "", "confirmMethodFactor", "formParameters", "Lspay/sdk/domain/model/response/paymentToken/errorResponse/FraudMonCheckResult$FormParameters;", "(Ljava/lang/String;ZLjava/lang/String;Lspay/sdk/domain/model/response/paymentToken/errorResponse/FraudMonCheckResult$FormParameters;)V", "getActionCode", "()Ljava/lang/String;", "getConfirmMethodFactor", "getFormParameters", "()Lspay/sdk/domain/model/response/paymentToken/errorResponse/FraudMonCheckResult$FormParameters;", "()Z", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "FormParameters", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FraudMonCheckResult implements Parcelable {
    public static final Parcelable.Creator<FraudMonCheckResult> CREATOR = new Creator();
    private final String actionCode;
    private final String confirmMethodFactor;
    private final FormParameters formParameters;
    private final boolean isClientBlock;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FraudMonCheckResult> {
        @Override // android.os.Parcelable.Creator
        public final FraudMonCheckResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FraudMonCheckResult(parcel.readString(), parcel.readInt() != 0, parcel.readString(), FormParameters.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final FraudMonCheckResult[] newArray(int i) {
            return new FraudMonCheckResult[i];
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006+"}, d2 = {"Lspay/sdk/domain/model/response/paymentToken/errorResponse/FraudMonCheckResult$FormParameters;", "Landroid/os/Parcelable;", "header", "", "text", "textDecline", "buttonConfirmText", "buttonDeclineText", "buttonInformText", "cybercabinetUrlAndroid", "cybercabinetUrlIOS", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonConfirmText", "()Ljava/lang/String;", "getButtonDeclineText", "getButtonInformText", "getCybercabinetUrlAndroid", "getCybercabinetUrlIOS", "getHeader", "getText", "getTextDecline", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class FormParameters implements Parcelable {
        public static final Parcelable.Creator<FormParameters> CREATOR = new Creator();
        private final String buttonConfirmText;
        private final String buttonDeclineText;
        private final String buttonInformText;
        private final String cybercabinetUrlAndroid;
        private final String cybercabinetUrlIOS;
        private final String header;
        private final String text;
        private final String textDecline;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FormParameters> {
            @Override // android.os.Parcelable.Creator
            public final FormParameters createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FormParameters(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final FormParameters[] newArray(int i) {
                return new FormParameters[i];
            }
        }

        public FormParameters(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.header = str;
            this.text = str2;
            this.textDecline = str3;
            this.buttonConfirmText = str4;
            this.buttonDeclineText = str5;
            this.buttonInformText = str6;
            this.cybercabinetUrlAndroid = str7;
            this.cybercabinetUrlIOS = str8;
        }

        /* renamed from: component1, reason: from getter */
        public final String getHeader() {
            return this.header;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTextDecline() {
            return this.textDecline;
        }

        /* renamed from: component4, reason: from getter */
        public final String getButtonConfirmText() {
            return this.buttonConfirmText;
        }

        /* renamed from: component5, reason: from getter */
        public final String getButtonDeclineText() {
            return this.buttonDeclineText;
        }

        /* renamed from: component6, reason: from getter */
        public final String getButtonInformText() {
            return this.buttonInformText;
        }

        /* renamed from: component7, reason: from getter */
        public final String getCybercabinetUrlAndroid() {
            return this.cybercabinetUrlAndroid;
        }

        /* renamed from: component8, reason: from getter */
        public final String getCybercabinetUrlIOS() {
            return this.cybercabinetUrlIOS;
        }

        public final FormParameters copy(String header, String text, String textDecline, String buttonConfirmText, String buttonDeclineText, String buttonInformText, String cybercabinetUrlAndroid, String cybercabinetUrlIOS) {
            return new FormParameters(header, text, textDecline, buttonConfirmText, buttonDeclineText, buttonInformText, cybercabinetUrlAndroid, cybercabinetUrlIOS);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormParameters)) {
                return false;
            }
            FormParameters formParameters = (FormParameters) other;
            return Intrinsics.areEqual(this.header, formParameters.header) && Intrinsics.areEqual(this.text, formParameters.text) && Intrinsics.areEqual(this.textDecline, formParameters.textDecline) && Intrinsics.areEqual(this.buttonConfirmText, formParameters.buttonConfirmText) && Intrinsics.areEqual(this.buttonDeclineText, formParameters.buttonDeclineText) && Intrinsics.areEqual(this.buttonInformText, formParameters.buttonInformText) && Intrinsics.areEqual(this.cybercabinetUrlAndroid, formParameters.cybercabinetUrlAndroid) && Intrinsics.areEqual(this.cybercabinetUrlIOS, formParameters.cybercabinetUrlIOS);
        }

        public final String getButtonConfirmText() {
            return this.buttonConfirmText;
        }

        public final String getButtonDeclineText() {
            return this.buttonDeclineText;
        }

        public final String getButtonInformText() {
            return this.buttonInformText;
        }

        public final String getCybercabinetUrlAndroid() {
            return this.cybercabinetUrlAndroid;
        }

        public final String getCybercabinetUrlIOS() {
            return this.cybercabinetUrlIOS;
        }

        public final String getHeader() {
            return this.header;
        }

        public final String getText() {
            return this.text;
        }

        public final String getTextDecline() {
            return this.textDecline;
        }

        public int hashCode() {
            String str = this.header;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.text;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.textDecline;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.buttonConfirmText;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.buttonDeclineText;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.buttonInformText;
            int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.cybercabinetUrlAndroid;
            int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.cybercabinetUrlIOS;
            return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("FormParameters(header=");
            sb.append(this.header);
            sb.append(", text=");
            sb.append(this.text);
            sb.append(", textDecline=");
            sb.append(this.textDecline);
            sb.append(", buttonConfirmText=");
            sb.append(this.buttonConfirmText);
            sb.append(", buttonDeclineText=");
            sb.append(this.buttonDeclineText);
            sb.append(", buttonInformText=");
            sb.append(this.buttonInformText);
            sb.append(", cybercabinetUrlAndroid=");
            sb.append(this.cybercabinetUrlAndroid);
            sb.append(", cybercabinetUrlIOS=");
            return Q1.a(sb, this.cybercabinetUrlIOS, ')');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.header);
            parcel.writeString(this.text);
            parcel.writeString(this.textDecline);
            parcel.writeString(this.buttonConfirmText);
            parcel.writeString(this.buttonDeclineText);
            parcel.writeString(this.buttonInformText);
            parcel.writeString(this.cybercabinetUrlAndroid);
            parcel.writeString(this.cybercabinetUrlIOS);
        }
    }

    public FraudMonCheckResult(String actionCode, boolean z, String str, FormParameters formParameters) {
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(formParameters, "formParameters");
        this.actionCode = actionCode;
        this.isClientBlock = z;
        this.confirmMethodFactor = str;
        this.formParameters = formParameters;
    }

    public static /* synthetic */ FraudMonCheckResult copy$default(FraudMonCheckResult fraudMonCheckResult, String str, boolean z, String str2, FormParameters formParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fraudMonCheckResult.actionCode;
        }
        if ((i & 2) != 0) {
            z = fraudMonCheckResult.isClientBlock;
        }
        if ((i & 4) != 0) {
            str2 = fraudMonCheckResult.confirmMethodFactor;
        }
        if ((i & 8) != 0) {
            formParameters = fraudMonCheckResult.formParameters;
        }
        return fraudMonCheckResult.copy(str, z, str2, formParameters);
    }

    /* renamed from: component1, reason: from getter */
    public final String getActionCode() {
        return this.actionCode;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsClientBlock() {
        return this.isClientBlock;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConfirmMethodFactor() {
        return this.confirmMethodFactor;
    }

    /* renamed from: component4, reason: from getter */
    public final FormParameters getFormParameters() {
        return this.formParameters;
    }

    public final FraudMonCheckResult copy(String actionCode, boolean isClientBlock, String confirmMethodFactor, FormParameters formParameters) {
        Intrinsics.checkNotNullParameter(actionCode, "actionCode");
        Intrinsics.checkNotNullParameter(formParameters, "formParameters");
        return new FraudMonCheckResult(actionCode, isClientBlock, confirmMethodFactor, formParameters);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FraudMonCheckResult)) {
            return false;
        }
        FraudMonCheckResult fraudMonCheckResult = (FraudMonCheckResult) other;
        return Intrinsics.areEqual(this.actionCode, fraudMonCheckResult.actionCode) && this.isClientBlock == fraudMonCheckResult.isClientBlock && Intrinsics.areEqual(this.confirmMethodFactor, fraudMonCheckResult.confirmMethodFactor) && Intrinsics.areEqual(this.formParameters, fraudMonCheckResult.formParameters);
    }

    public final String getActionCode() {
        return this.actionCode;
    }

    public final String getConfirmMethodFactor() {
        return this.confirmMethodFactor;
    }

    public final FormParameters getFormParameters() {
        return this.formParameters;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = this.actionCode.hashCode() * 31;
        boolean z = this.isClientBlock;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        String str = this.confirmMethodFactor;
        return this.formParameters.hashCode() + ((i2 + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final boolean isClientBlock() {
        return this.isClientBlock;
    }

    public String toString() {
        return "FraudMonCheckResult(actionCode=" + this.actionCode + ", isClientBlock=" + this.isClientBlock + ", confirmMethodFactor=" + this.confirmMethodFactor + ", formParameters=" + this.formParameters + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.actionCode);
        parcel.writeInt(this.isClientBlock ? 1 : 0);
        parcel.writeString(this.confirmMethodFactor);
        this.formParameters.writeToParcel(parcel, flags);
    }
}
