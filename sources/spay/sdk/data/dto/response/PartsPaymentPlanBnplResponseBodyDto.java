package spay.sdk.data.dto.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Kg;
import spay.sdk.data.dto.response.bnpl.ButtonBnplPartsDto;
import spay.sdk.data.dto.response.bnpl.PartsGraphBnplDto;
import spay.sdk.domain.model.response.PartsPaymentPlanBnplResponseBody;
import spay.sdk.domain.model.response.bnpl.ButtonBnplParts;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020\u0002H\u0016J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\b\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006$"}, d2 = {"Lspay/sdk/data/dto/response/PartsPaymentPlanBnplResponseBodyDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/PartsPaymentPlanBnplResponseBody;", "buttonBnpl", "Lspay/sdk/data/dto/response/bnpl/ButtonBnplPartsDto;", "offerUrl", "", "offerText", "isBnplEnabled", "", "graphBnpl", "Lspay/sdk/data/dto/response/bnpl/PartsGraphBnplDto;", "(Lspay/sdk/data/dto/response/bnpl/ButtonBnplPartsDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lspay/sdk/data/dto/response/bnpl/PartsGraphBnplDto;)V", "getButtonBnpl", "()Lspay/sdk/data/dto/response/bnpl/ButtonBnplPartsDto;", "getGraphBnpl", "()Lspay/sdk/data/dto/response/bnpl/PartsGraphBnplDto;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOfferText", "()Ljava/lang/String;", "getOfferUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Lspay/sdk/data/dto/response/bnpl/ButtonBnplPartsDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lspay/sdk/data/dto/response/bnpl/PartsGraphBnplDto;)Lspay/sdk/data/dto/response/PartsPaymentPlanBnplResponseBodyDto;", "equals", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PartsPaymentPlanBnplResponseBodyDto implements DataDtoInterface<PartsPaymentPlanBnplResponseBody> {

    @SerializedName("buttonBnpl")
    private final ButtonBnplPartsDto buttonBnpl;

    @SerializedName("graphBnpl")
    private final PartsGraphBnplDto graphBnpl;

    @SerializedName("isBnplEnabled")
    private final Boolean isBnplEnabled;

    @SerializedName("offerText")
    private final String offerText;

    @SerializedName("offerUrl")
    private final String offerUrl;

    public PartsPaymentPlanBnplResponseBodyDto(ButtonBnplPartsDto buttonBnplPartsDto, String str, String str2, Boolean bool, PartsGraphBnplDto partsGraphBnplDto) {
        this.buttonBnpl = buttonBnplPartsDto;
        this.offerUrl = str;
        this.offerText = str2;
        this.isBnplEnabled = bool;
        this.graphBnpl = partsGraphBnplDto;
    }

    public static /* synthetic */ PartsPaymentPlanBnplResponseBodyDto copy$default(PartsPaymentPlanBnplResponseBodyDto partsPaymentPlanBnplResponseBodyDto, ButtonBnplPartsDto buttonBnplPartsDto, String str, String str2, Boolean bool, PartsGraphBnplDto partsGraphBnplDto, int i, Object obj) {
        if ((i & 1) != 0) {
            buttonBnplPartsDto = partsPaymentPlanBnplResponseBodyDto.buttonBnpl;
        }
        if ((i & 2) != 0) {
            str = partsPaymentPlanBnplResponseBodyDto.offerUrl;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = partsPaymentPlanBnplResponseBodyDto.offerText;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            bool = partsPaymentPlanBnplResponseBodyDto.isBnplEnabled;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            partsGraphBnplDto = partsPaymentPlanBnplResponseBodyDto.graphBnpl;
        }
        return partsPaymentPlanBnplResponseBodyDto.copy(buttonBnplPartsDto, str3, str4, bool2, partsGraphBnplDto);
    }

    /* renamed from: component1, reason: from getter */
    public final ButtonBnplPartsDto getButtonBnpl() {
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
    public final Boolean getIsBnplEnabled() {
        return this.isBnplEnabled;
    }

    /* renamed from: component5, reason: from getter */
    public final PartsGraphBnplDto getGraphBnpl() {
        return this.graphBnpl;
    }

    public final PartsPaymentPlanBnplResponseBodyDto copy(ButtonBnplPartsDto buttonBnpl, String offerUrl, String offerText, Boolean isBnplEnabled, PartsGraphBnplDto graphBnpl) {
        return new PartsPaymentPlanBnplResponseBodyDto(buttonBnpl, offerUrl, offerText, isBnplEnabled, graphBnpl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PartsPaymentPlanBnplResponseBodyDto)) {
            return false;
        }
        PartsPaymentPlanBnplResponseBodyDto partsPaymentPlanBnplResponseBodyDto = (PartsPaymentPlanBnplResponseBodyDto) other;
        return Intrinsics.areEqual(this.buttonBnpl, partsPaymentPlanBnplResponseBodyDto.buttonBnpl) && Intrinsics.areEqual(this.offerUrl, partsPaymentPlanBnplResponseBodyDto.offerUrl) && Intrinsics.areEqual(this.offerText, partsPaymentPlanBnplResponseBodyDto.offerText) && Intrinsics.areEqual(this.isBnplEnabled, partsPaymentPlanBnplResponseBodyDto.isBnplEnabled) && Intrinsics.areEqual(this.graphBnpl, partsPaymentPlanBnplResponseBodyDto.graphBnpl);
    }

    public final ButtonBnplPartsDto getButtonBnpl() {
        return this.buttonBnpl;
    }

    public final PartsGraphBnplDto getGraphBnpl() {
        return this.graphBnpl;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final String getOfferUrl() {
        return this.offerUrl;
    }

    public int hashCode() {
        ButtonBnplPartsDto buttonBnplPartsDto = this.buttonBnpl;
        int iHashCode = (buttonBnplPartsDto == null ? 0 : buttonBnplPartsDto.hashCode()) * 31;
        String str = this.offerUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.offerText;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isBnplEnabled;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        PartsGraphBnplDto partsGraphBnplDto = this.graphBnpl;
        return iHashCode4 + (partsGraphBnplDto != null ? partsGraphBnplDto.hashCode() : 0);
    }

    public final Boolean isBnplEnabled() {
        return this.isBnplEnabled;
    }

    public String toString() {
        return "PartsPaymentPlanBnplResponseBodyDto(buttonBnpl=" + this.buttonBnpl + ", offerUrl=" + this.offerUrl + ", offerText=" + this.offerText + ", isBnplEnabled=" + this.isBnplEnabled + ", graphBnpl=" + this.graphBnpl + ')';
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public PartsPaymentPlanBnplResponseBody toModel() {
        ButtonBnplPartsDto buttonBnplPartsDto = this.buttonBnpl;
        ButtonBnplParts model = buttonBnplPartsDto != null ? buttonBnplPartsDto.toModel() : null;
        String str = this.offerUrl;
        String str2 = this.offerText;
        Boolean bool = this.isBnplEnabled;
        if (bool == null) {
            throw new Kg("isBnplEnabled");
        }
        boolean zBooleanValue = bool.booleanValue();
        PartsGraphBnplDto partsGraphBnplDto = this.graphBnpl;
        return new PartsPaymentPlanBnplResponseBody(model, str, str2, zBooleanValue, partsGraphBnplDto != null ? partsGraphBnplDto.toModel() : null);
    }
}
