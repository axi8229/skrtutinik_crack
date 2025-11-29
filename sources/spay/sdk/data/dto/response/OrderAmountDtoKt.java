package spay.sdk.data.dto.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.domain.model.response.OrderAmount;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toDto", "Lspay/sdk/data/dto/response/OrderAmountDto;", "Lspay/sdk/domain/model/response/OrderAmount;", "SPaySDK_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OrderAmountDtoKt {
    public static final OrderAmountDto toDto(OrderAmount orderAmount) {
        String str;
        Intrinsics.checkNotNullParameter(orderAmount, "<this>");
        Integer amount = orderAmount.getAmount();
        String currency = orderAmount.getCurrency();
        if (currency != null) {
            Intrinsics.checkNotNullParameter(currency, "<this>");
            str = Intrinsics.areEqual(currency, "₽") ? "643" : "";
        } else {
            str = null;
        }
        return new OrderAmountDto(amount, str);
    }
}
