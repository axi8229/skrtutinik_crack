package spay.sdk.data.dto.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Q1;
import spay.sdk.domain.model.response.OrderAmount;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lspay/sdk/data/dto/response/OrderAmountDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/OrderAmount;", "amount", "", "currency", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCurrency", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lspay/sdk/data/dto/response/OrderAmountDto;", "equals", "", "other", "", "hashCode", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class OrderAmountDto implements DataDtoInterface<OrderAmount> {

    @SerializedName("amount")
    private final Integer amount;

    @SerializedName("currency")
    private final String currency;

    public OrderAmountDto(Integer num, String str) {
        this.amount = num;
        this.currency = str;
    }

    public static /* synthetic */ OrderAmountDto copy$default(OrderAmountDto orderAmountDto, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = orderAmountDto.amount;
        }
        if ((i & 2) != 0) {
            str = orderAmountDto.currency;
        }
        return orderAmountDto.copy(num, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getAmount() {
        return this.amount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final OrderAmountDto copy(Integer amount, String currency) {
        return new OrderAmountDto(amount, currency);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrderAmountDto)) {
            return false;
        }
        OrderAmountDto orderAmountDto = (OrderAmountDto) other;
        return Intrinsics.areEqual(this.amount, orderAmountDto.amount) && Intrinsics.areEqual(this.currency, orderAmountDto.currency);
    }

    public final Integer getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        Integer num = this.amount;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.currency;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OrderAmountDto(amount=");
        sb.append(this.amount);
        sb.append(", currency=");
        return Q1.a(sb, this.currency, ')');
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public OrderAmount toModel() {
        String str;
        Integer num = this.amount;
        String str2 = this.currency;
        if (str2 != null) {
            Intrinsics.checkNotNullParameter(str2, "<this>");
            str = "₽";
        } else {
            str = null;
        }
        return new OrderAmount(num, str);
    }
}
