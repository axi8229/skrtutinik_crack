package spay.sdk.domain.model.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.bnpl.ButtonBnpl;
import spay.sdk.domain.model.response.bnpl.PartsGraphBnpl;
import spay.sdk.domain.model.response.bnpl.PartsGraphBnplKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"mapToPaymentPlanBnplResponseBody", "Lspay/sdk/domain/model/response/PaymentPlanBnplResponseBody;", "Lspay/sdk/domain/model/response/PartsPaymentPlanBnplResponseBody;", "SPaySDK_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PartsPaymentPlanBnplResponseBodyKt {
    public static final PaymentPlanBnplResponseBody mapToPaymentPlanBnplResponseBody(PartsPaymentPlanBnplResponseBody partsPaymentPlanBnplResponseBody) {
        Intrinsics.checkNotNullParameter(partsPaymentPlanBnplResponseBody, "<this>");
        ButtonBnpl buttonBnpl = partsPaymentPlanBnplResponseBody.getButtonBnpl() != null ? new ButtonBnpl(partsPaymentPlanBnplResponseBody.getButtonBnpl().getButtonLogo(), partsPaymentPlanBnplResponseBody.getButtonBnpl().getButtonLogoInactive(), partsPaymentPlanBnplResponseBody.getButtonBnpl().getHeader(), partsPaymentPlanBnplResponseBody.getButtonBnpl().getContent()) : null;
        String offerUrl = partsPaymentPlanBnplResponseBody.getOfferUrl();
        String offerText = partsPaymentPlanBnplResponseBody.getOfferText();
        boolean zIsBnplEnabled = partsPaymentPlanBnplResponseBody.isBnplEnabled();
        PartsGraphBnpl graphBnpl = partsPaymentPlanBnplResponseBody.getGraphBnpl();
        return new PaymentPlanBnplResponseBody(buttonBnpl, offerUrl, offerText, zIsBnplEnabled, graphBnpl != null ? PartsGraphBnplKt.toGraphBnpl(graphBnpl) : null);
    }
}
