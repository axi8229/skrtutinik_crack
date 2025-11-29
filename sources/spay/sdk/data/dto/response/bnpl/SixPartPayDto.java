package spay.sdk.data.dto.response.bnpl;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.U0;
import spay.sdk.data.dto.response.DataDtoInterface;
import spay.sdk.domain.model.response.bnpl.SixPartPay;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lspay/sdk/data/dto/response/bnpl/SixPartPayDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/bnpl/SixPartPay;", "clientCommission", "", "count", "payments", "", "Lspay/sdk/data/dto/response/bnpl/BnplPaymentDto;", "(IILjava/util/List;)V", "getClientCommission", "()I", "getCount", "getPayments", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toModel", "toString", "", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SixPartPayDto implements DataDtoInterface<SixPartPay> {

    @SerializedName("clientCommission")
    private final int clientCommission;

    @SerializedName("count")
    private final int count;

    @SerializedName("payments")
    private final List<BnplPaymentDto> payments;

    public SixPartPayDto(int i, int i2, List<BnplPaymentDto> list) {
        this.clientCommission = i;
        this.count = i2;
        this.payments = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SixPartPayDto copy$default(SixPartPayDto sixPartPayDto, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = sixPartPayDto.clientCommission;
        }
        if ((i3 & 2) != 0) {
            i2 = sixPartPayDto.count;
        }
        if ((i3 & 4) != 0) {
            list = sixPartPayDto.payments;
        }
        return sixPartPayDto.copy(i, i2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getClientCommission() {
        return this.clientCommission;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final List<BnplPaymentDto> component3() {
        return this.payments;
    }

    public final SixPartPayDto copy(int clientCommission, int count, List<BnplPaymentDto> payments) {
        return new SixPartPayDto(clientCommission, count, payments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SixPartPayDto)) {
            return false;
        }
        SixPartPayDto sixPartPayDto = (SixPartPayDto) other;
        return this.clientCommission == sixPartPayDto.clientCommission && this.count == sixPartPayDto.count && Intrinsics.areEqual(this.payments, sixPartPayDto.payments);
    }

    public final int getClientCommission() {
        return this.clientCommission;
    }

    public final int getCount() {
        return this.count;
    }

    public final List<BnplPaymentDto> getPayments() {
        return this.payments;
    }

    public int hashCode() {
        int iHashCode = (Integer.hashCode(this.count) + (Integer.hashCode(this.clientCommission) * 31)) * 31;
        List<BnplPaymentDto> list = this.payments;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SixPartPayDto(clientCommission=");
        sb.append(this.clientCommission);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(", payments=");
        return U0.a(sb, this.payments, ')');
    }

    public /* synthetic */ SixPartPayDto(int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? null : list);
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public SixPartPay toModel() {
        int i = this.clientCommission;
        int i2 = this.count;
        List<BnplPaymentDto> list = this.payments;
        return new SixPartPay(i, i2, list != null ? GraphBnplDtoKt.toModelList(list) : null);
    }
}
