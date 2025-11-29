package spay.sdk.data.dto.response.paymentToken;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Kg;
import npi.spay.Q1;
import spay.sdk.data.dto.response.DataDtoInterface;
import spay.sdk.domain.model.response.paymentToken.errorResponse.FraudMonCheckResult;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001&B-\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\nHÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011¨\u0006'"}, d2 = {"Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/paymentToken/errorResponse/FraudMonCheckResult;", "Landroid/os/Parcelable;", "actionCode", "", "isClientBlock", "", "confirmMethodFactor", "formParametersResponseBodyDto", "Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto$FormParametersResponseBodyDto;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto$FormParametersResponseBodyDto;)V", "getActionCode", "()Ljava/lang/String;", "getConfirmMethodFactor", "getFormParametersResponseBodyDto", "()Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto$FormParametersResponseBodyDto;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto$FormParametersResponseBodyDto;)Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto;", "describeContents", "", "equals", "other", "", "hashCode", "toModel", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "FormParametersResponseBodyDto", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FraudMonCheckResultResponseBodyDto implements DataDtoInterface<FraudMonCheckResult>, Parcelable {
    public static final Parcelable.Creator<FraudMonCheckResultResponseBodyDto> CREATOR = new Creator();

    @SerializedName("actionCode")
    private final String actionCode;

    @SerializedName("confirmMethodFactor")
    private final String confirmMethodFactor;

    @SerializedName("formParameters")
    private final FormParametersResponseBodyDto formParametersResponseBodyDto;

    @SerializedName("isClientBlock")
    private final Boolean isClientBlock;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FraudMonCheckResultResponseBodyDto> {
        @Override // android.os.Parcelable.Creator
        public final FraudMonCheckResultResponseBodyDto createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new FraudMonCheckResultResponseBodyDto(string, boolValueOf, parcel.readString(), parcel.readInt() != 0 ? FormParametersResponseBodyDto.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final FraudMonCheckResultResponseBodyDto[] newArray(int i) {
            return new FraudMonCheckResultResponseBodyDto[i];
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003BU\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003Ji\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\b\u0010'\u001a\u00020\u0002H\u0016J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020!HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006."}, d2 = {"Lspay/sdk/data/dto/response/paymentToken/FraudMonCheckResultResponseBodyDto$FormParametersResponseBodyDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/paymentToken/errorResponse/FraudMonCheckResult$FormParameters;", "Landroid/os/Parcelable;", "header", "", "text", "textDecline", "buttonConfirmText", "buttonDeclineText", "buttonInformText", "cybercabinetUrlAndroid", "cybercabinetUrlIOS", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonConfirmText", "()Ljava/lang/String;", "getButtonDeclineText", "getButtonInformText", "getCybercabinetUrlAndroid", "getCybercabinetUrlIOS", "getHeader", "getText", "getTextDecline", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toModel", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class FormParametersResponseBodyDto implements DataDtoInterface<FraudMonCheckResult.FormParameters>, Parcelable {
        public static final Parcelable.Creator<FormParametersResponseBodyDto> CREATOR = new Creator();

        @SerializedName("buttonConfirmText")
        private final String buttonConfirmText;

        @SerializedName("buttonDeclineText")
        private final String buttonDeclineText;

        @SerializedName("buttonInformText")
        private final String buttonInformText;

        @SerializedName("cybercabinetUrlAndroid")
        private final String cybercabinetUrlAndroid;

        @SerializedName("cybercabinetUrlIOS")
        private final String cybercabinetUrlIOS;

        @SerializedName("header")
        private final String header;

        @SerializedName("text")
        private final String text;

        @SerializedName("textDecline")
        private final String textDecline;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FormParametersResponseBodyDto> {
            @Override // android.os.Parcelable.Creator
            public final FormParametersResponseBodyDto createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FormParametersResponseBodyDto(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final FormParametersResponseBodyDto[] newArray(int i) {
                return new FormParametersResponseBodyDto[i];
            }
        }

        public FormParametersResponseBodyDto(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
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

        public final FormParametersResponseBodyDto copy(String header, String text, String textDecline, String buttonConfirmText, String buttonDeclineText, String buttonInformText, String cybercabinetUrlAndroid, String cybercabinetUrlIOS) {
            return new FormParametersResponseBodyDto(header, text, textDecline, buttonConfirmText, buttonDeclineText, buttonInformText, cybercabinetUrlAndroid, cybercabinetUrlIOS);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormParametersResponseBodyDto)) {
                return false;
            }
            FormParametersResponseBodyDto formParametersResponseBodyDto = (FormParametersResponseBodyDto) other;
            return Intrinsics.areEqual(this.header, formParametersResponseBodyDto.header) && Intrinsics.areEqual(this.text, formParametersResponseBodyDto.text) && Intrinsics.areEqual(this.textDecline, formParametersResponseBodyDto.textDecline) && Intrinsics.areEqual(this.buttonConfirmText, formParametersResponseBodyDto.buttonConfirmText) && Intrinsics.areEqual(this.buttonDeclineText, formParametersResponseBodyDto.buttonDeclineText) && Intrinsics.areEqual(this.buttonInformText, formParametersResponseBodyDto.buttonInformText) && Intrinsics.areEqual(this.cybercabinetUrlAndroid, formParametersResponseBodyDto.cybercabinetUrlAndroid) && Intrinsics.areEqual(this.cybercabinetUrlIOS, formParametersResponseBodyDto.cybercabinetUrlIOS);
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
            StringBuilder sb = new StringBuilder("FormParametersResponseBodyDto(header=");
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

        @Override // spay.sdk.data.dto.response.DataDtoInterface
        public FraudMonCheckResult.FormParameters toModel() {
            return new FraudMonCheckResult.FormParameters(this.header, this.text, this.textDecline, this.buttonConfirmText, this.buttonDeclineText, this.buttonInformText, this.cybercabinetUrlAndroid, this.cybercabinetUrlIOS);
        }
    }

    public FraudMonCheckResultResponseBodyDto(String str, Boolean bool, String str2, FormParametersResponseBodyDto formParametersResponseBodyDto) {
        this.actionCode = str;
        this.isClientBlock = bool;
        this.confirmMethodFactor = str2;
        this.formParametersResponseBodyDto = formParametersResponseBodyDto;
    }

    public static /* synthetic */ FraudMonCheckResultResponseBodyDto copy$default(FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto, String str, Boolean bool, String str2, FormParametersResponseBodyDto formParametersResponseBodyDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fraudMonCheckResultResponseBodyDto.actionCode;
        }
        if ((i & 2) != 0) {
            bool = fraudMonCheckResultResponseBodyDto.isClientBlock;
        }
        if ((i & 4) != 0) {
            str2 = fraudMonCheckResultResponseBodyDto.confirmMethodFactor;
        }
        if ((i & 8) != 0) {
            formParametersResponseBodyDto = fraudMonCheckResultResponseBodyDto.formParametersResponseBodyDto;
        }
        return fraudMonCheckResultResponseBodyDto.copy(str, bool, str2, formParametersResponseBodyDto);
    }

    /* renamed from: component1, reason: from getter */
    public final String getActionCode() {
        return this.actionCode;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIsClientBlock() {
        return this.isClientBlock;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConfirmMethodFactor() {
        return this.confirmMethodFactor;
    }

    /* renamed from: component4, reason: from getter */
    public final FormParametersResponseBodyDto getFormParametersResponseBodyDto() {
        return this.formParametersResponseBodyDto;
    }

    public final FraudMonCheckResultResponseBodyDto copy(String actionCode, Boolean isClientBlock, String confirmMethodFactor, FormParametersResponseBodyDto formParametersResponseBodyDto) {
        return new FraudMonCheckResultResponseBodyDto(actionCode, isClientBlock, confirmMethodFactor, formParametersResponseBodyDto);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FraudMonCheckResultResponseBodyDto)) {
            return false;
        }
        FraudMonCheckResultResponseBodyDto fraudMonCheckResultResponseBodyDto = (FraudMonCheckResultResponseBodyDto) other;
        return Intrinsics.areEqual(this.actionCode, fraudMonCheckResultResponseBodyDto.actionCode) && Intrinsics.areEqual(this.isClientBlock, fraudMonCheckResultResponseBodyDto.isClientBlock) && Intrinsics.areEqual(this.confirmMethodFactor, fraudMonCheckResultResponseBodyDto.confirmMethodFactor) && Intrinsics.areEqual(this.formParametersResponseBodyDto, fraudMonCheckResultResponseBodyDto.formParametersResponseBodyDto);
    }

    public final String getActionCode() {
        return this.actionCode;
    }

    public final String getConfirmMethodFactor() {
        return this.confirmMethodFactor;
    }

    public final FormParametersResponseBodyDto getFormParametersResponseBodyDto() {
        return this.formParametersResponseBodyDto;
    }

    public int hashCode() {
        String str = this.actionCode;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isClientBlock;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.confirmMethodFactor;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        FormParametersResponseBodyDto formParametersResponseBodyDto = this.formParametersResponseBodyDto;
        return iHashCode3 + (formParametersResponseBodyDto != null ? formParametersResponseBodyDto.hashCode() : 0);
    }

    public final Boolean isClientBlock() {
        return this.isClientBlock;
    }

    public String toString() {
        return "FraudMonCheckResultResponseBodyDto(actionCode=" + this.actionCode + ", isClientBlock=" + this.isClientBlock + ", confirmMethodFactor=" + this.confirmMethodFactor + ", formParametersResponseBodyDto=" + this.formParametersResponseBodyDto + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.actionCode);
        Boolean bool = this.isClientBlock;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.confirmMethodFactor);
        FormParametersResponseBodyDto formParametersResponseBodyDto = this.formParametersResponseBodyDto;
        if (formParametersResponseBodyDto == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            formParametersResponseBodyDto.writeToParcel(parcel, flags);
        }
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public FraudMonCheckResult toModel() {
        FraudMonCheckResult.FormParameters model;
        String str = this.actionCode;
        if (str == null) {
            throw new Kg("actionCode");
        }
        Boolean bool = this.isClientBlock;
        if (bool == null) {
            throw new Kg("isClientBlock");
        }
        boolean zBooleanValue = bool.booleanValue();
        String str2 = this.confirmMethodFactor;
        FormParametersResponseBodyDto formParametersResponseBodyDto = this.formParametersResponseBodyDto;
        if (formParametersResponseBodyDto == null || (model = formParametersResponseBodyDto.toModel()) == null) {
            throw new Kg("formParametersResponseBodyDto");
        }
        return new FraudMonCheckResult(str, zBooleanValue, str2, model);
    }
}
