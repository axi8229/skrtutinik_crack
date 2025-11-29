package spay.sdk.data.dto.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.PaymentOrderResponseBody;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b3\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B¥\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÉ\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\b\u0010=\u001a\u00020\u0002H\u0016J\t\u0010>\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006?"}, d2 = {"Lspay/sdk/data/dto/response/PaymentOrderResponseBodyDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/PaymentOrderResponseBody;", "operationId", "", "errorCode", "description", "info", "formUrl", "redirect", "termUrl", "acsUrl", "paReq", "cReq", "threeDSMethodUrl", "threeDSMethodNotificationUrl", "threeDSServerTransId", "threeDSMethodData", "acsRenderingType", "acsSignedContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAcsRenderingType", "()Ljava/lang/String;", "getAcsSignedContent", "getAcsUrl", "getCReq", "getDescription", "getErrorCode", "getFormUrl", "getInfo", "getOperationId", "getPaReq", "getRedirect", "getTermUrl", "getThreeDSMethodData", "getThreeDSMethodNotificationUrl", "getThreeDSMethodUrl", "getThreeDSServerTransId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentOrderResponseBodyDto implements DataDtoInterface<PaymentOrderResponseBody> {

    @SerializedName("acsRenderingType")
    private final String acsRenderingType;

    @SerializedName("acsSignedContent")
    private final String acsSignedContent;

    @SerializedName("acsUrl")
    private final String acsUrl;

    @SerializedName("cReq")
    private final String cReq;

    @SerializedName("description")
    private final String description;

    @SerializedName("errorCode")
    private final String errorCode;

    @SerializedName("formUrl")
    private final String formUrl;

    @SerializedName("info")
    private final String info;

    @SerializedName("operationId")
    private final String operationId;

    @SerializedName("paReq")
    private final String paReq;

    @SerializedName("redirect")
    private final String redirect;

    @SerializedName("termUrl")
    private final String termUrl;

    @SerializedName("threeDSMethodData")
    private final String threeDSMethodData;

    @SerializedName("threeDSMethodNotificationUrl")
    private final String threeDSMethodNotificationUrl;

    @SerializedName("threeDSMethodUrl")
    private final String threeDSMethodUrl;

    @SerializedName("threeDSServerTransId")
    private final String threeDSServerTransId;

    public PaymentOrderResponseBodyDto(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.operationId = str;
        this.errorCode = str2;
        this.description = str3;
        this.info = str4;
        this.formUrl = str5;
        this.redirect = str6;
        this.termUrl = str7;
        this.acsUrl = str8;
        this.paReq = str9;
        this.cReq = str10;
        this.threeDSMethodUrl = str11;
        this.threeDSMethodNotificationUrl = str12;
        this.threeDSServerTransId = str13;
        this.threeDSMethodData = str14;
        this.acsRenderingType = str15;
        this.acsSignedContent = str16;
    }

    /* renamed from: component1, reason: from getter */
    public final String getOperationId() {
        return this.operationId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCReq() {
        return this.cReq;
    }

    /* renamed from: component11, reason: from getter */
    public final String getThreeDSMethodUrl() {
        return this.threeDSMethodUrl;
    }

    /* renamed from: component12, reason: from getter */
    public final String getThreeDSMethodNotificationUrl() {
        return this.threeDSMethodNotificationUrl;
    }

    /* renamed from: component13, reason: from getter */
    public final String getThreeDSServerTransId() {
        return this.threeDSServerTransId;
    }

    /* renamed from: component14, reason: from getter */
    public final String getThreeDSMethodData() {
        return this.threeDSMethodData;
    }

    /* renamed from: component15, reason: from getter */
    public final String getAcsRenderingType() {
        return this.acsRenderingType;
    }

    /* renamed from: component16, reason: from getter */
    public final String getAcsSignedContent() {
        return this.acsSignedContent;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getInfo() {
        return this.info;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFormUrl() {
        return this.formUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRedirect() {
        return this.redirect;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTermUrl() {
        return this.termUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final String getAcsUrl() {
        return this.acsUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPaReq() {
        return this.paReq;
    }

    public final PaymentOrderResponseBodyDto copy(String operationId, String errorCode, String description, String info, String formUrl, String redirect, String termUrl, String acsUrl, String paReq, String cReq, String threeDSMethodUrl, String threeDSMethodNotificationUrl, String threeDSServerTransId, String threeDSMethodData, String acsRenderingType, String acsSignedContent) {
        return new PaymentOrderResponseBodyDto(operationId, errorCode, description, info, formUrl, redirect, termUrl, acsUrl, paReq, cReq, threeDSMethodUrl, threeDSMethodNotificationUrl, threeDSServerTransId, threeDSMethodData, acsRenderingType, acsSignedContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentOrderResponseBodyDto)) {
            return false;
        }
        PaymentOrderResponseBodyDto paymentOrderResponseBodyDto = (PaymentOrderResponseBodyDto) other;
        return Intrinsics.areEqual(this.operationId, paymentOrderResponseBodyDto.operationId) && Intrinsics.areEqual(this.errorCode, paymentOrderResponseBodyDto.errorCode) && Intrinsics.areEqual(this.description, paymentOrderResponseBodyDto.description) && Intrinsics.areEqual(this.info, paymentOrderResponseBodyDto.info) && Intrinsics.areEqual(this.formUrl, paymentOrderResponseBodyDto.formUrl) && Intrinsics.areEqual(this.redirect, paymentOrderResponseBodyDto.redirect) && Intrinsics.areEqual(this.termUrl, paymentOrderResponseBodyDto.termUrl) && Intrinsics.areEqual(this.acsUrl, paymentOrderResponseBodyDto.acsUrl) && Intrinsics.areEqual(this.paReq, paymentOrderResponseBodyDto.paReq) && Intrinsics.areEqual(this.cReq, paymentOrderResponseBodyDto.cReq) && Intrinsics.areEqual(this.threeDSMethodUrl, paymentOrderResponseBodyDto.threeDSMethodUrl) && Intrinsics.areEqual(this.threeDSMethodNotificationUrl, paymentOrderResponseBodyDto.threeDSMethodNotificationUrl) && Intrinsics.areEqual(this.threeDSServerTransId, paymentOrderResponseBodyDto.threeDSServerTransId) && Intrinsics.areEqual(this.threeDSMethodData, paymentOrderResponseBodyDto.threeDSMethodData) && Intrinsics.areEqual(this.acsRenderingType, paymentOrderResponseBodyDto.acsRenderingType) && Intrinsics.areEqual(this.acsSignedContent, paymentOrderResponseBodyDto.acsSignedContent);
    }

    public final String getAcsRenderingType() {
        return this.acsRenderingType;
    }

    public final String getAcsSignedContent() {
        return this.acsSignedContent;
    }

    public final String getAcsUrl() {
        return this.acsUrl;
    }

    public final String getCReq() {
        return this.cReq;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getFormUrl() {
        return this.formUrl;
    }

    public final String getInfo() {
        return this.info;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final String getPaReq() {
        return this.paReq;
    }

    public final String getRedirect() {
        return this.redirect;
    }

    public final String getTermUrl() {
        return this.termUrl;
    }

    public final String getThreeDSMethodData() {
        return this.threeDSMethodData;
    }

    public final String getThreeDSMethodNotificationUrl() {
        return this.threeDSMethodNotificationUrl;
    }

    public final String getThreeDSMethodUrl() {
        return this.threeDSMethodUrl;
    }

    public final String getThreeDSServerTransId() {
        return this.threeDSServerTransId;
    }

    public int hashCode() {
        String str = this.operationId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorCode;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.info;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.formUrl;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.redirect;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.termUrl;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.acsUrl;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.paReq;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.cReq;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.threeDSMethodUrl;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.threeDSMethodNotificationUrl;
        int iHashCode12 = (iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.threeDSServerTransId;
        int iHashCode13 = (iHashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.threeDSMethodData;
        int iHashCode14 = (iHashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.acsRenderingType;
        int iHashCode15 = (iHashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.acsSignedContent;
        return iHashCode15 + (str16 != null ? str16.hashCode() : 0);
    }

    public String toString() {
        return "PaymentOrderResponseBodyDto(operationId=" + this.operationId + ", errorCode=" + this.errorCode + ", description=" + this.description + ", info=" + this.info + ", formUrl=" + this.formUrl + ", redirect=" + this.redirect + ", termUrl=" + this.termUrl + ", acsUrl=" + this.acsUrl + ", paReq=" + this.paReq + ", cReq=" + this.cReq + ", threeDSMethodUrl=" + this.threeDSMethodUrl + ", threeDSMethodNotificationUrl=" + this.threeDSMethodNotificationUrl + ", threeDSServerTransId=" + this.threeDSServerTransId + ", threeDSMethodData=" + this.threeDSMethodData + ", acsRenderingType=" + this.acsRenderingType + ", acsSignedContent=" + this.acsSignedContent + ')';
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public PaymentOrderResponseBody toModel() {
        return new PaymentOrderResponseBody(this.operationId, this.errorCode, this.description, this.info, this.formUrl, this.redirect, this.termUrl, this.acsUrl, this.paReq, this.cReq, this.threeDSMethodUrl, this.threeDSMethodNotificationUrl, this.threeDSServerTransId, this.threeDSMethodData, this.acsRenderingType, this.acsSignedContent);
    }
}
