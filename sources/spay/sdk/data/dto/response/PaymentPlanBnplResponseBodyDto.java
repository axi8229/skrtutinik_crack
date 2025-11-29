package spay.sdk.data.dto.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Kg;
import spay.sdk.data.dto.response.bnpl.ButtonBnplDto;
import spay.sdk.data.dto.response.bnpl.GraphBnplDto;
import spay.sdk.domain.model.response.PaymentPlanBnplResponseBody;
import spay.sdk.domain.model.response.bnpl.ButtonBnpl;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020\u0002H\u0016J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\b\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006$"}, d2 = {"Lspay/sdk/data/dto/response/PaymentPlanBnplResponseBodyDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/PaymentPlanBnplResponseBody;", "buttonBnpl", "Lspay/sdk/data/dto/response/bnpl/ButtonBnplDto;", "offerUrl", "", "offerText", "isBnplEnabled", "", "graphBnpl", "Lspay/sdk/data/dto/response/bnpl/GraphBnplDto;", "(Lspay/sdk/data/dto/response/bnpl/ButtonBnplDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lspay/sdk/data/dto/response/bnpl/GraphBnplDto;)V", "getButtonBnpl", "()Lspay/sdk/data/dto/response/bnpl/ButtonBnplDto;", "getGraphBnpl", "()Lspay/sdk/data/dto/response/bnpl/GraphBnplDto;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOfferText", "()Ljava/lang/String;", "getOfferUrl", "component1", "component2", "component3", "component4", "component5", "copy", "(Lspay/sdk/data/dto/response/bnpl/ButtonBnplDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lspay/sdk/data/dto/response/bnpl/GraphBnplDto;)Lspay/sdk/data/dto/response/PaymentPlanBnplResponseBodyDto;", "equals", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PaymentPlanBnplResponseBodyDto implements DataDtoInterface<PaymentPlanBnplResponseBody> {

    @SerializedName("buttonBnpl")
    private final ButtonBnplDto buttonBnpl;

    @SerializedName("graphBnpl")
    private final GraphBnplDto graphBnpl;

    @SerializedName("isBnplEnabled")
    private final Boolean isBnplEnabled;

    @SerializedName("offerText")
    private final String offerText;

    @SerializedName("offerUrl")
    private final String offerUrl;

    public PaymentPlanBnplResponseBodyDto(ButtonBnplDto buttonBnplDto, String str, String str2, Boolean bool, GraphBnplDto graphBnplDto) {
        this.buttonBnpl = buttonBnplDto;
        this.offerUrl = str;
        this.offerText = str2;
        this.isBnplEnabled = bool;
        this.graphBnpl = graphBnplDto;
    }

    public static /* synthetic */ PaymentPlanBnplResponseBodyDto copy$default(PaymentPlanBnplResponseBodyDto paymentPlanBnplResponseBodyDto, ButtonBnplDto buttonBnplDto, String str, String str2, Boolean bool, GraphBnplDto graphBnplDto, int i, Object obj) {
        if ((i & 1) != 0) {
            buttonBnplDto = paymentPlanBnplResponseBodyDto.buttonBnpl;
        }
        if ((i & 2) != 0) {
            str = paymentPlanBnplResponseBodyDto.offerUrl;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = paymentPlanBnplResponseBodyDto.offerText;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            bool = paymentPlanBnplResponseBodyDto.isBnplEnabled;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            graphBnplDto = paymentPlanBnplResponseBodyDto.graphBnpl;
        }
        return paymentPlanBnplResponseBodyDto.copy(buttonBnplDto, str3, str4, bool2, graphBnplDto);
    }

    /* renamed from: component1, reason: from getter */
    public final ButtonBnplDto getButtonBnpl() {
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
    public final GraphBnplDto getGraphBnpl() {
        return this.graphBnpl;
    }

    public final PaymentPlanBnplResponseBodyDto copy(ButtonBnplDto buttonBnpl, String offerUrl, String offerText, Boolean isBnplEnabled, GraphBnplDto graphBnpl) {
        return new PaymentPlanBnplResponseBodyDto(buttonBnpl, offerUrl, offerText, isBnplEnabled, graphBnpl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentPlanBnplResponseBodyDto)) {
            return false;
        }
        PaymentPlanBnplResponseBodyDto paymentPlanBnplResponseBodyDto = (PaymentPlanBnplResponseBodyDto) other;
        return Intrinsics.areEqual(this.buttonBnpl, paymentPlanBnplResponseBodyDto.buttonBnpl) && Intrinsics.areEqual(this.offerUrl, paymentPlanBnplResponseBodyDto.offerUrl) && Intrinsics.areEqual(this.offerText, paymentPlanBnplResponseBodyDto.offerText) && Intrinsics.areEqual(this.isBnplEnabled, paymentPlanBnplResponseBodyDto.isBnplEnabled) && Intrinsics.areEqual(this.graphBnpl, paymentPlanBnplResponseBodyDto.graphBnpl);
    }

    public final ButtonBnplDto getButtonBnpl() {
        return this.buttonBnpl;
    }

    public final GraphBnplDto getGraphBnpl() {
        return this.graphBnpl;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final String getOfferUrl() {
        return this.offerUrl;
    }

    public int hashCode() {
        ButtonBnplDto buttonBnplDto = this.buttonBnpl;
        int iHashCode = (buttonBnplDto == null ? 0 : buttonBnplDto.hashCode()) * 31;
        String str = this.offerUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.offerText;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isBnplEnabled;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        GraphBnplDto graphBnplDto = this.graphBnpl;
        return iHashCode4 + (graphBnplDto != null ? graphBnplDto.hashCode() : 0);
    }

    public final Boolean isBnplEnabled() {
        return this.isBnplEnabled;
    }

    public String toString() {
        return "PaymentPlanBnplResponseBodyDto(buttonBnpl=" + this.buttonBnpl + ", offerUrl=" + this.offerUrl + ", offerText=" + this.offerText + ", isBnplEnabled=" + this.isBnplEnabled + ", graphBnpl=" + this.graphBnpl + ')';
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public PaymentPlanBnplResponseBody toModel() {
        ButtonBnplDto buttonBnplDto = this.buttonBnpl;
        ButtonBnpl model = buttonBnplDto != null ? buttonBnplDto.toModel() : null;
        String str = this.offerUrl;
        String str2 = this.offerText;
        Boolean bool = this.isBnplEnabled;
        if (bool == null) {
            throw new Kg("isBnplEnabled");
        }
        boolean zBooleanValue = bool.booleanValue();
        GraphBnplDto graphBnplDto = this.graphBnpl;
        return new PaymentPlanBnplResponseBody(model, str, str2, zBooleanValue, graphBnplDto != null ? graphBnplDto.toModel() : null);
    }
}
