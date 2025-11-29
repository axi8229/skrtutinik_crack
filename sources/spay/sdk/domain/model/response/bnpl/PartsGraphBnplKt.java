package spay.sdk.domain.model.response.bnpl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toGraphBnpl", "Lspay/sdk/domain/model/response/bnpl/GraphBnpl;", "Lspay/sdk/domain/model/response/bnpl/PartsGraphBnpl;", "SPaySDK_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PartsGraphBnplKt {
    public static final GraphBnpl toGraphBnpl(PartsGraphBnpl partsGraphBnpl) {
        Intrinsics.checkNotNullParameter(partsGraphBnpl, "<this>");
        return new GraphBnpl(partsGraphBnpl.getHeader(), partsGraphBnpl.getContent(), String.valueOf(partsGraphBnpl.getSixPartPay().get(0).getCount()), partsGraphBnpl.getText(), partsGraphBnpl.getSixPartPay().get(0).getPayments());
    }
}
